# Ot-harjoitustyö #

Projektissa toteutetaan yksinkertainen laskin käyttäen Javaa ja Java FMXL. Laskin projekti sijaitsee kansiossa Otlaskin.

[Käyttöohje](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/Käyttöohje.md)

[Testausdokumentaatio](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/Testausdokumentti.md)

[Määrittelydokumentaatio](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/Maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

## Releaset

[Loppupalautus](https://github.com/AlecSiikaluoma/ot-harjoitustyo/releases/tag/1.0)

## Komentorivitoiminnot

### Testaus

Testit voi suorittaa komennolla

Ensin menemällä projekti kansiion

```
cd Otlaskin
mvn test
```

Testikattavuusraportit luodaan komennolla

```
mvn jacoco:report
```

### Jar generointi

Komennolla
```
mvn package
```
generoidaan suoritettava Jar tiedosto kansioon /target. Jar tiedostostaja generoituu kaksi oikea on "Otlaskin-1.0-SNAPSHOT-jar-with-dependencies.jar".

### Javadoc

JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/Otlaskin/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```



