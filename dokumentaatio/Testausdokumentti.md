# Testausdokumentti

Ohjelmaa on testatty yksikkötestein JUnitilla. Testikattavuus raportti voidaan luoda Jacoco liittänäisellä.

## Ykiskkötestaus

### CalculatorTest
Calculator luokka totetuttaa kaikki laskimen operaatiot. Nämä on kaikki testattu mukaanlukien nollalla jaot. 

### CalculatorMemoryTest
CalculatorMemory toiminnallisuuden, jolle Calculator luokkaa voidaan käyttää suoraviivaisemmin käyttöliityymästä muistin avulla. Muistiin voidaan asettaa seuraava operaatio, tyhjentää ja suorittaa se. Nämä on testattu.

### CalculatorDAOTest
CalculatorDAO luokka tarjoaa ominaisuudet tietokannan käyttöä varten. Laskujen haku, poisto ja lisäys on testattu. 
