# Ot-harjoitustyö #

Projektissa toteutetaan yksinkertainen laskin käyttäen Javaa ja Java FMXL. Laskin projekti sijaitsee kansiossa Otlasking.

[Määrittelydokumentaatio](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/Maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

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
generoidaan suoritettava Jar tiedosto kansioon /target

### Javadoc

JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

## Laskarit 

### Viikko 1 ###

[gitlog.tx](https://github.com/AlecSiikaluoma/ot-harjoitustyo/blob/master/laskarit/viikko1/gitlog.txt)

### Viikko 2

[Tehtävät 2](https://github.com/AlecSiikaluoma/ot-harjoitustyo/tree/master/laskarit/viikko2)

### Viikko 3

[Tehtävät 3](https://github.com/AlecSiikaluoma/ot-harjoitustyo/tree/master/laskarit/viikko3)


