# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen toiminnallisuus on jaoteltu kolmeen pakettiin:
- dao
- domain
- ui

Ohjelman arkkitehtuuri on helpoin kuvata käymällä läpi jokainen pakkaus yksitellen.

## DAO pakkaus - tiedon tallennus

Dao pakkaus toteuttaa rajapinnan tietokannalle. Tämän kautta voimme manipuloida tietokannassa olevaa dataa. Tietokanta toiminnallisuuden eriyttäminen suoraviivaistaa testausta ja ohjelman koodin selkeyttä. Voimme muualla koodissa alustaa "dao" olion ja hoitaa tämän kautta tietokanta toiminnalisuuden. Dao pakkauksen sisältämät luokat noudattavat Data Access Object -sunnittelumallia eli nykyinen dao luokka voidaan korvata helposti toisella tallennus mahdollisuudella toteuttamalla CalculatorDao rajapinnan metodit. 

### "calculator" -taulu
Taulu sisältää seuraavat kentät:
```
  - id
  - value1
  - value2
  - result
  - operation
```

Id on tallennetun operaation uniikki tunniste. Value1 ja value2 ovat operaatiossa käytetyt arvot. Result on lopputulos kun operaatio suoritetaan näillä arvoilla. Operaatio on itse operaatiot Stringinä. 

## Domain pakkaus - sovelluslogiikka 

Domain toetuttaa itse sovelluslogiikan. Se sisältää luokan laskimelle, laskimen muistille ja suoritetuille/suoritettavalle operaatiolle esitysmuodon.

Calculator on sovelluksen logiikan kannalta pääluokka. Sitä luodessa annetaan paramtetriksi DAO olio, jonka kautta sovellus tallentaa tietoa pysyvään sijaintiin. Sovelluksen tallennusmuoto voidaan näin muuttaa helposti antamalla eri DAO olio.

Calculator luo myös oman CalculatorMemory olion, jonka avulla se voi pitää kirjaa siitä mikä operaatio tällä hetkellä odottaa suoritusta. CalculatorMemory luokkaa ei tämän vaiheen toteutuksessa missä suoritetaan kerralla vain yksi operaatio välttämättä tarvitsi. Jatkoa varten kuitenkin operaatioita voi olla useampia ja ne voitaisiin säilyttää tässä luokassa esim. listalla. Kun operaatioita on monia muistissa on hyvä eriyttää tämä muisti varsinaisesta Calculator luokasta. 

## Ui pakkaus - käyttöliittymmä

Ui sisältää käyttöliittymän toiminnallisuuden. Tänne on toteutettu CalculatorController, joka hoitaa käyttöliittymän toiminnallisuutta. Esimerkiksi tekstin syöttökentän Stringien parsimis operaatiot on totetutettu tänne.

CalculatorController luokassa siis ikään kuin käytetään vain Calculator oliota. Ne ovat siis täysin eristyksissä ja voisimme periaattessa luoda tarvittaessa uuden käyttöliittymän tekemättä muutoksia Domain tai Dao pakkauksiin. Tämä myös suoraviivaistaa testausta.

Koodauksen yksinkeraistamisen vuoksi myös koko ohjelman Main metodi on tässä pakkauksessa. Main liittä controllerin käyttöliittyymän ulkoasu tiedostoon sekä luo yhteyden tietokantaan.

## Päätoiminnallisuus

### Operaation suoritus

<img src="https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/Laskutoimitus%20muistilla_%205%2B4.png" />

Kun käyttäjä ensin painaa nappia 5. Tämän jälkeen nappia + ja lopuksi 4. Tapahtuu kaavion kuvailemat metodi kutsut. Tässä näkyy miten CalculatorMemory hoitaa käyttöliityymän kanssa laskujärjestyksen hallinnnoinin ja Calculator luokalle siirtyy vastuu vasta kun itse operaatio suoritetaan tai tilaa muutetaan. 

## Parannuksia

- Ohjelman käynnistämistä olisi syytä siistiä. Tällä hetkellä se tapahtuu Ui pakkauksessa Main tiedostossa. Ainakin tietokannan taulun alustamisen voisi siirtää muualle.

