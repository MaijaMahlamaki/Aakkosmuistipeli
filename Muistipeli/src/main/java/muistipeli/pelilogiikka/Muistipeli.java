package muistipeli.pelilogiikka;

import java.util.ArrayList;
import muistipeli.pelaaja.Pelaaja;

/**
 * Luokka tarjoaa metodeja varsinaiseen pelilogiikkaan: pelin aloittamiseen,
 * parien tarkistamiseen ja pisteiden kirjaamiseen sekä pelin päättymisen
 * tarkistamiseen.
 *
 */
public class Muistipeli {

    private Pelaaja pelaaja;
    private Pelilauta pelilauta;
    private int parienLkm;

    public Muistipeli(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.pelilauta = new Pelilauta();
        parienLkm = 8;

    }

    /**
     * Metodi aloittaa uuden pelin kutsumalla pelilautaolion metodia uusiPeli(),
     * jolla luodaan pelilauta kortteineen.
     *
     * @see muistipeli.pelilogiikka.Pelilauta#uusiPeli()
     */
    public void aloitaPeli() {
        pelilauta.uusiPeli();
        pelaaja.nollaaPisteet();

    }

    /**
     * Metodi tarkistaa ovatko käännetyt kortit parit vai ei. Parametreina ovat
     * käännettyjen korttien indeksit. Palauttaa true, mikäli löytyi pari,
     * muutoin false. Poistaa löytyneet parit ja tällöin myös vähentää parien
     * lukumäärää yhdellä. Kirjaa pelaajan pisteet.
     *
     * @param kortti1 käännetyn kortin indeksi.
     * @param kortti2 käännetyn kortin indeksi.
     *
     * @return true jos pari löytyi, false jos paria ei löytynyt.
     *
     * @see muistipeli.pelilogiikka.Pelilauta#kortinKirjain(int)
     * @see muistipeli.pelilogiikka.Pelilauta#poistaKortit(int, int)
     * @see muistipeli.pelaaja.Pelaaja#kirjaaPisteet(int)
     *
     */
    public boolean kaannaKortit(int kortti1, int kortti2) {
        if (this.pelilauta.kortinKirjain(kortti1).equals("x")
                && this.pelilauta.kortinKirjain(kortti2).equals("x")
                || !this.pelilauta.kortinKirjain(kortti1).equals(this.pelilauta.kortinKirjain(kortti2))) {
            this.pelaaja.kirjaaPisteet(-1);
            return false;

        } else {
            this.pelaaja.kirjaaPisteet(2);
            this.pelilauta.poistaKortit(kortti1, kortti2);
            this.parienLkm--;
            return true;
        }

    }

    /**
     * Metodi "näyttää" pelaajalle käännetyt kortit eli palauttaa sellaisenaan
     * käyttökelpoisen merkkijonoesityksen, jota voi hyödyntää
     * käyttöliittymässä.
     *
     * @param kortti1 näytettävän kortin indeksi.
     * @param kortti2 näytettävän kortin indeksi.
     *
     * @return korttien merkkijonoesitys.
     *
     * @see muistipeli.pelilogiikka.Pelilauta#kortinKirjain(int).
     *     
*/
    public String naytaKortit(int kortti1, int kortti2) {
        String kortit = this.pelilauta.kortinKirjain(kortti1)
                + " ja " + this.pelilauta.kortinKirjain(kortti2);

        return kortit;

    }

    /**
     * Metodi kirjaa pelaajan pisteet.
     *
     * @param pisteet pelaajalle kirjattavat pisteet: 2 parista tai -1 hudista.
     *
     * @see muistipeli.pelaaja.Pelaaja#kirjaaPisteet(int)
     *
     */
    public void kirjaaPisteet(int pisteet) {
        this.pelaaja.kirjaaPisteet(pisteet);
    }

    /**
     * Metodi palauttaa pelaajan pisteet. Pisteet näkyvät koko pelin ajan
     * käyttöliittymässä.
     *
     * @return pelaajan yhteispistemäärä
     * @see muistipeli.pelaaja.Pelaaja#getPisteet()
     *
     */
    public int getPisteet() {
        return pelaaja.getPisteet();
    }

    /**
     * Metodi tarkistaa, onko peli loppu. Jos kaikki parit ovat löytyneet eli
     * parien lukumäärä on nolla, metodi palauttaa true, muutoin false.
     *
     * @return true jos peli on loppu, false jos peli on kesken.
     */
    public boolean peliLoppu() {
        if (parienLkm == 0) {
            pelaaja.lisaaKierros();
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa pelilaudalla jäljellä olevien korttien lukumäärän.
     * Metodia tarvitaan vain tekstikäyttöliittymän kanssa, sillä graafisessa
     * käyttöliittymässä jäljellä olevien korttien lukumäärä on nähtävillä koko
     * ajan.
     *
     * @return jäljellä olevien korttien lukumäärä
     *
     * @see muistipeli.pelilogiikka.Pelilauta#korttienLkm()
     */
    public int korttienLkm() {
        return pelilauta.korttienLkm();
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    public int getParienLkm() {
        return parienLkm;
    }

}
