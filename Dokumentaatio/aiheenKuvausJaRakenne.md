#Aiheen kuvaus ja rakenne

**Aihe:** Aakkosmuistipeli: tarkoituksena on toteuttaa muistipeli, jossa etsittävinä pareina
ovat kirjainparit. Pelaaja voi testata ja harjoittaa muistiaan pelin avulla.

**Käyttäjät:** Pelaaja

**Käyttäjien toiminnot:**

* Pelaaja kääntää pelilaudan kortteja klikkaamalla niitä kaksi kerrallaan.
* Mikäli pelaaja ei onnistu löytämään paria, kortit "sulkeutuvat" ja hän yrittää uudelleen.  
* Mikäli pelaaja onnistuu löytämään parin, kortit katoavat/muuttuvat harmaiksi tms. ja 
pelaaja saa pisteet niistä.
* Pelaaja voi seurata pisteitään pelatessaan. Pistelaskun toteutus voisi mennä niin, että 
parin löytämisestä saisi kaksi pistettä ja väärän parin kääntämisestä yhden miinuspisteen.
* Kun pelaaja on löytänyt kaikki parit, peli päättyy ja pelaaja saa nähdä pisteensä näytöllä.
* Halutessaan pelaaja voi aloittaa uuden pelin edellisen päätyttyä.
* Jos pelaaja pelaa saman session aikana useamman pelin, hän voi tarkastella niiden pisteitä
kootusti (pisteet eivät kuitenkaan tallennu pysyvästi, vaan ne katoavat, kun peli suljetaan).

![luokkakaavio](http://yuml.me/0f6b295f "Luokkakaavio")
