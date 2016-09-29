/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelilogiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 *Luokka tarjoaa pelilautaan ja kortteihin liittyviä metodeita.
 * Pelilauta koostuu listasta korttiolioita.
 *
 */
public class Pelilauta {

    private ArrayList<Kortti> kortit;

    public Pelilauta() {
        this.kortit = new ArrayList<Kortti>();
    }

/**
 * Metodi aloittaa uuden pelin luomalla kortit 
 * ja sekoittamalla niiden järjestyksen.
 */
    public void uusiPeli() {
        luoKortit();
        Collections.shuffle(this.kortit);
    }

/**
* Metodissa luodaan pelilaudan kortit ja lisätään ne korttilistaan.
* Kortteja on aina kaksi kohti jokaista kirjainta a-h.
* Näin muodostuu 16 paria, joista syntyy 4x4-kokoinen pelilauta.
*/
    public void luoKortit() {
        this.kortit.add(new Kortti("a"));
        this.kortit.add(new Kortti("b"));
        this.kortit.add(new Kortti("c"));
        this.kortit.add(new Kortti("d"));
        this.kortit.add(new Kortti("e"));
        this.kortit.add(new Kortti("f"));
        this.kortit.add(new Kortti("g"));
        this.kortit.add(new Kortti("h"));

        this.kortit.add(new Kortti("a"));
        this.kortit.add(new Kortti("b"));
        this.kortit.add(new Kortti("c"));
        this.kortit.add(new Kortti("d"));
        this.kortit.add(new Kortti("e"));
        this.kortit.add(new Kortti("f"));
        this.kortit.add(new Kortti("g"));
        this.kortit.add(new Kortti("h"));

    }

/**
 * Metodi palauttaa indeksiä vastaavan kortin kirjaimen korttilistasta.
 * Pelilaudan korteilla on graafisessa käyttöliittymässä vain indeksit
 * ja tietoa kortin kirjaimesta säilytetään korttilistassa 
 * eli käännetyn kortin kirjain noudetaan listasta tällä metodilla. 
 * 
 * @param index käännetyn kortin indeksi.
 * 
 * @return korttiin liittyvä kirjain
 */    
    public String kortinKirjain(int index) {
        Object k = this.kortit.get(index);
        Kortti kortti = (Kortti) k;
        String kirjain = (String) kortti.getKirjain();
        return kirjain;
    }
    
/**
 * Metodi poistaa parametrina annetut kortit pelilaudalta.
 * Poistaminen tapahtuu muuttamalla kyseisen kortin kirjain kirjaimeksi x 
 * (sillä poistaminen listalta sekoittaisi indeksit ja 
 * korttien sijainnin pelilaudalla).
 * 
 * @param kortti1 poistettavan kortin indeksi.
 * @param kortti2 poistettavan kortin indeksi.
 */

    public void poistaKortit(int kortti1, int kortti2) {
        this.kortit.set(kortti1, new Kortti("x"));
        this.kortit.set(kortti2, new Kortti("x"));
    }

    
/**
*Metodi kertoo tekstikäyttöliittymää käytettäessä
* pelilaudalla olevien korttien lukumäärän. 
* Graafisessa käyttöliittymässä korttien lukumäärää pelilaudalla ei ole
* tarvetta mainita, koska se on näkyvissä.
* 
* @return pelilaudalla jäljellä olevien korttien lukumäärä.
*/
    public int korttienLkm() {
        return this.kortit.size();
    }
    

    public ArrayList getKortit() {
        return this.kortit;
    }

}
