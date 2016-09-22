#Aiheen kuvaus ja rakenne

**Aihe:** Aakkosmuistipeli: tarkoituksena on toteuttaa muistipeli, jossa etsittävinä pareina
ovat kirjainparit. Pelaaja voi testata ja harjoittaa muistiaan pelin avulla.

**Käyttäjät:** Pelaaja

**Käyttäjien toiminnot:**

* Pelaaja kääntää pelilaudan kortteja klikkaamalla niitä kaksi kerrallaan.
* Mikäli pelaaja ei onnistu löytämään paria, kortit "sulkeutuvat" ja hän yrittää uudelleen.  
* Mikäli pelaaja onnistuu löytämään parin, kortit muuttuvat harmaiksi ja 
pelaaja saa pisteet niistä.
* Pelaaja voi seurata pisteitään pelatessaan. Pistelaskun toteutus voisi mennä niin, että 
parin löytämisestä saisi kaksi pistettä ja väärän parin kääntämisestä yhden miinuspisteen.
* Kun pelaaja on löytänyt kaikki parit, peli päättyy ja pelaaja saa nähdä pisteensä näytöllä.
* Halutessaan pelaaja voi aloittaa uuden pelin edellisen päätyttyä.
* Jos pelaaja pelaa saman session aikana useamman pelin, hän voi tarkastella niiden pisteitä
kootusti (pisteet eivät kuitenkaan tallennu pysyvästi, vaan ne katoavat, kun peli suljetaan).

##Rakenne ja toiminta

**Luokkakaavio**

![luokkakaavio](http://yuml.me/b3310b22)

Tällä hetkellä peli toimii alkeellisesti graafisella käyttöliittymällä.

Kun peli alkaa, pelaaja näkee näytön yläreunassa ohjeet.
Kun pelaaja klikkaa kahta korttia, yläreunan näkymässä näkyy mitkä kortit hän avasi
ja onnistuiko löytämään parit vai ei. Jos parit eivät löytyneet, peli jatkuu.
Jos taas parit löytyivät, kyseiset kortit muuttuvat harmaiksi, eikä niitä voi enää klikata.
Seuraavaksi toteutusvuorossa ovat pistelasku, pelaajan nimen kirjoittaminen näytölle niin,
että se ja pisteet näkyvät koko pelin ajan, sekä uuden pelin aloittaminen edellisen perään.
