#Aiheen kuvaus ja rakenne

**Aihe:** Aakkosmuistipeli: tarkoituksena on toteuttaa muistipeli, jossa etsittävinä pareina
ovat kirjainparit. Pelaaja voi testata ja harjoittaa muistiaan pelin avulla.

**Käyttäjät:** Pelaaja

**Käyttäjien toiminnot:**

* Pelaaja kääntää pelilaudan kortteja klikkaamalla niitä kaksi kerrallaan.
* Mikäli pelaaja ei onnistu löytämään paria, kortit "sulkeutuvat" ja hän yrittää uudelleen.  
* Mikäli pelaaja onnistuu löytämään parin, kortit muuttuvat harmaiksi ja 
pelaaja saa pisteet niistä.
* Pelaaja voi seurata pisteitään pelatessaan. Pistelasku toimii niin, että 
parin löytämisestä saa kaksi pistettä ja väärän parin kääntämisestä yhden miinuspisteen. 
Jaossa on myös bonuspisteitä - joka kerta, kun pelaaja löytää kaksi paria peräkkäin, hän 
ansaitsee kaksi bonuspistettä. Laskuri ei nollaannu kahden parin jälkeen, vaan jos pelaaja 
löytää vielä kolmannenkin parin, hän saa jälleen kaksi bonuspistettä jne.
* Kun pelaaja on löytänyt kaikki parit, peli päättyy ja pelaaja saa nähdä pisteensä näytöllä.
Peli päätösviestissä pelaaja saa myös sanallisen arvion taidoistaan.
* Halutessaan pelaaja voi aloittaa uuden pelin edellisen päätyttyä.
* Jos pelaaja pelaa saman session aikana useamman pelin, hän voi tarkastella niiden pisteitä
kootusti (pisteet eivät kuitenkaan tallennu pysyvästi, vaan ne katoavat, kun peli suljetaan).

##Rakenne ja toiminta

**Luokkakaavio**

![luokkakaavio](http://yuml.me/b3310b22)

Tällä hetkellä peli toimii alkeellisesti graafisella käyttöliittymällä.

Kun peli alkaa, pelaaja näkee näytön yläreunassa ohjeet ja kentän, johon hän saa syöttää nimensä.
Kun pelaaja on syöttänyt nimensä ja klikannut "Aloita peli" -painiketta, peli alkaa.
Kun pelaaja klikkaa kahta korttia, yläreunan näkymässä näkyy mitkä kortit hän avasi
ja onnistuiko löytämään parit vai ei. Jos parit eivät löytyneet, kortit sulkeutuvat.
Jos taas parit löytyivät, kyseiset kortit muuttuvat harmaiksi, eikä niitä voi enää klikata.
Yläreunan infolaatikossa pelaaja näkee koko ajan myös nimensä ja pisteensä.
Kun pelaaja on löytänyt kaikki parit, hän näkee infolaatikossa pisteensä, sekä lyhyen sanallisen
arvion suorituksestaan.

Seuraavaksi tarkoituksena on toteuttaa uuden pelin aloittaminen edellisen perään ja 
laajennus pistelaskuun niin, että käyttäjä voi seurata kehittymistään.
