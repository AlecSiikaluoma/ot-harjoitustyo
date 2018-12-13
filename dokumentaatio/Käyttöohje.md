# Käyttöohje

Ohjelman voi käynnistää jar tiedostolla. Tiedosto siajaitsee projektin juuressa, jos lataat koko projektin Githubista. Jos otat releasen, sijoita "Otlaskin.jar" tilalle .jar tiedoston sijainti.

```
java -jar Otlaskin.jar
```

Tämän jälkeen aukeaa näkymä laskemista. Laskimeen voi syöttää nyt lukuja. Laskimella tehdään yksi operaatio kerrallaan. Esimerkiksi kun syöttää luvun ja tämän jälkeen operaation ja vielä lopuksi lisättävän numeron, niin laskin automaattisesi suorittaa laskutoimenpiteen. Se tunnistaa siis, että on oikea laskea lopputulos. Tähän saatun lopputulokseen voi sitten lisätä uuden operaation ja toistaa saman. 

Napin "+/-" avulla voi käntää luvun merkin.

Napit +, -, x ja / toteuttavat perinteiset perus operaatiot.

Napilla "=" suoritetaan operaatio, joka on syötetty kenttään. Voi sisältää vain yhden operaation kerrallaan, jos on lisätty jo yksi operaatio ja tämän jälkeen yritetään suorittaa toinen operaatio, niin ohjelma suorittaa ensin ensimmäisen operaation ja lisää automaattisesti toisen operaation tuloksen perää. Tämän jälkeen käyttäjä voi syöttää halutun arvon. 

Napilla "." voi lisätä desimaaleita. 

Laskimen sivupalkkiin ilmestyy kaikki äskeiset operaatiot ja niiden lopputulokset. Klikkaamalla operaatiota voidaan ottaa lopputulos laskimen kenttään ja manipuloida sitä.

Laskimen historian voi nollatta ala rivillä olevasta näppäimestä "clear".
