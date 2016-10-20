#Aiheen kuvaus ja rakenne

**Aihe:** Aakkosmuistipeli: tarkoituksena on toteuttaa muistipeli, jossa etsittävinä pareina
ovat kirjainparit. Pelaaja voi testata ja harjoittaa muistiaan pelin avulla.

**Käyttäjät:** Pelaaja

**Käyttäjien toiminnot:**

* Pelaaja aloittaa pelin lukemalla ohjeet.
* Pelaaja kirjoittamaa nimensä sille tarkoitettuun kenttään.
* Pelaaja klikkaa "Aloita peli" -painiketta ja muistipeli alkaa.
* Pelaaja kääntää pelilaudan kortteja klikkaamalla niitä kaksi kerrallaan.
Paneelin yläosasta pelaaja näkee, mitkä kortit hän löysi ja löytykö pari vai ei.
* Mikäli pelaaja ei onnistu löytämään paria, hän saa yhden miinuspisteen ja yrittää uudelleen.  
* Mikäli pelaaja onnistuu löytämään parin, kortit muuttuvat harmaiksi (niitä ei voi enää klikata) 
ja pelaaja saa kaksi pistettä.
* Pelaaja voi seurata pisteitään pelatessaan paneelin yläreunasta. Pistelasku toimii niin, että 
parin löytämisestä saa kaksi pistettä ja väärän parin kääntämisestä yhden miinuspisteen. 
Jaossa on myös bonuspisteitä - joka kerta, kun pelaaja löytää kaksi paria peräkkäin, hän 
ansaitsee kaksi bonuspistettä. Laskuri ei nollaannu kahden parin jälkeen, vaan jos pelaaja 
löytää vielä kolmannenkin parin, hän saa jälleen kaksi bonuspistettä jne.
* Kun pelaaja on löytänyt kaikki parit, peli päättyy ja pelaaja saa nähdä pisteensä näytöllä.
Peli päätösviestissä pelaaja saa myös sanallisen arvion taidoistaan kyseisellä kierroksella.
* Halutessaan pelaaja voi aloittaa uuden pelin edellisen päätyttyä klikkaamalla 
"Uusi peli"-painiketta.
* Jos pelaaja pelaa saman session aikana useamman pelin, hänelle ilmoitetaan jokaisen kierroksen 
päätteeksi paneelin yläreunassa, montako kierrosta pelaaja on pelannut, paljonko pisteitä hän
on kerännyt kaikilla kierroksilla yhteensä ja mikä on kierrosten pisteiden keskiarvo
(pisteet eivät kuitenkaan tallennu pysyvästi, vaan ne katoavat, kun peli suljetaan).

##Pelin toiminta ja rakenne

Peli toimii graafisella käyttöliittymällä.
Kun peli käynnistyy, näytön yläreunaan ilmestyy ohjeet ja kenttä, johon pelaaja syöttää nimensä.
Kun pelaaja on syöttänyt nimensä ja klikannut "Aloita peli" -painiketta, peli voi alkaa.
Yläreunan infolaatikossa pelaaja näkee koko pelin ajan nimensä ja pisteensä.

Kun pelaaja klikkaa kahta korttia, tapahtumakuuntelija välittää pelilogiikalle viestin, mitä
kortteja klikattiin, ja pelilogiikka tarkistaa, löytyikö parit vai ei ja kirjaa pisteet pelaajalle sen mukaan 
(pari +2, huti -1).
Pelilogiikka tarkistaa myös mahdolliset bonuspisteet. Pelaajalle  kirjataan kaksi bonuspistettä, jos pelaaja 
on löytänyt parit peräkkäin, eli mikäli nyt annetut pisteet ja edelliset pisteet ovat molemmat kakkosia. 
Pelilogiikka  palauttaa viestin kuuntelijalle, löytyikö parit vai ei, ja mitkä kortit käännettiin.
Yläreunan näkymässä näytetään pelaajalle, mitkä kortit hän avasi ja onnistuiko hän löytämään parit vai ei.
Jos parit löytyivät, kyseiset kortit muuttuvat harmaiksi, eikä niitä voi enää klikata.

Tapahtumakuuntelija tarkistaa jokaisen kahden kortin klikkauksen jälkeen pelilogiikalta, joko peli on päättynyt.
Mikäli kaikki parit on löydetty, pelilogiikka palauttaa true ja tapahtumakuuntelija asettaa yläreunan 
infolaatikkoon pelilogiikassa pisteiden mukaan räätälöidyn loppuviestin, sekä koosteen pelatuista kierroksista.
Kuuntelija asettaa myös "Aloita uusi peli" -painikkeen yläreunan infolaatikkoon, jota klikkaamalla pelaaja voi
aloittaa uuden pelin. Uusi peli aloitetaan siis  tapahtumakuuntelijaan oliomuuttujaksi talletetulla pelaajalla,
eikä pelaajan tarvitse enää kirjoittaa nimeään uudestaan.
Kun pelejä pelataan useita peräkkäin, pelilogiikka pitää kirjaa pelatuista kierroksista; niiden lukumäärästä,
yhteispisteistä ja kierrosten pisteiden keskiarvosta. 

Ohjelman rakenne on sellainen, että graafinen käyttöliittymäluokka tuntee vain kuuntelijan, muttei muita luokkia. 
Kuuntelija taas on yhteydessä pelaajaluokkaan, jossa hoidetaan kaikki pistelasku ja muodostetaan pelaajalle loppuviesti.
Lisäksi kuuntelija hyödyntää muistipelin metodeja pelin aloittamiseen ja lopettamiseen sekä korttien tarkistukseen 
ja niiden näyttämiseen pelaajalle. Koska pelaaja voi pelata monta peliä peräkkäin, yhtä pelaajaoliota kohden 
voi olla monta muistipelioliota. Siten myös yhtä kuuntelijaoliota kohden voi olla monta muistipelioliota.
Ainoastaan muistipeliluokka tuntee pelilautaluokan, jossa luodaan peliä varten sekoitettu korttilista. 
Vastaavasti ainoastaan pelilautaluokka tuntee korttiluokan, jonka olioista korttilista luodaan.

**Luokkakaavio**

![luokkakaavio](http://yuml.me/1c0f24d5)

**Sekvenssikaavioita**

![Pelin aloitus](https://github.com/MaijaMahlamaki/Aakkosmuistipeli/blob/master/Dokumentaatio/sekvenssikaaviot/pelinAloitus.jpg)
![Korttien kääntäminen, ei paria](https://github.com/MaijaMahlamaki/Aakkosmuistipeli/blob/master/Dokumentaatio/sekvenssikaaviot/korttienKaantaminen1.jpg)
![Korttien kääntäminen, pari löytyi](https://github.com/MaijaMahlamaki/Aakkosmuistipeli/blob/master/Dokumentaatio/sekvenssikaaviot/korttienKaantaminen2.jpg)
