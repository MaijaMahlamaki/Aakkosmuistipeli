/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelilogiikka;

import java.util.ArrayList;
import muistipeli.pelaaja.Pelaaja;

/**
 *
 * @author mahlamai
 */
public class Muistipeli {

    private Pelaaja pelaaja;
    private Pelilauta pelilauta;

    public Muistipeli(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.pelilauta = new Pelilauta();
    }

    public void aloitaPeli() {
        pelilauta.uusiPeli();

    }

    //Metodi palauttaa pelilaudan korttien lukumäärän
    public int korttienLkm() {
        return pelilauta.korttienLkm();
    }

    //Parametreina käännettävien korttien indeksit, ja metodi palauttaa true, mikäli löytyi pari
    public boolean kaannaKortit(int kortti1, int kortti2) {
        if (this.pelilauta.kortinKirjain(kortti1).equals("x")
                && this.pelilauta.kortinKirjain(kortti2).equals("x")
                || !this.pelilauta.kortinKirjain(kortti1).equals(this.pelilauta.kortinKirjain(kortti2))) {
            this.pelaaja.kirjaaPisteet(-1);
            return false;

        } else {
            this.pelaaja.kirjaaPisteet(2);
            this.pelilauta.poistaKortit(kortti1, kortti2);
            return true;
        }

    }

    //Metodi kertoo, mitkä kortit avattiin, jotta ne voi näyttää palaajalle
    public String naytaKortit(int kortti1, int kortti2) {
        String kortit = this.pelilauta.kortinKirjain(kortti1)
                + " ja " + this.pelilauta.kortinKirjain(kortti2);

        return kortit;

    }

    //Apumetodi pelaajan pisteiden kirjaamiseen
    public void kirjaaPisteet(int pisteet) {
        this.pelaaja.kirjaaPisteet(pisteet);
    }

    //Apumetodi pelaajan lopullisen pistesaldon näyttämiseen
    public void getPisteet(Pelaaja pelaaja) {
        pelaaja.getPisteet();
    }

    //Parin löytymisen yhteydessä käytettävä apumetodi: 
    //korttien poistaminen pelilaudalta
    public void poistaKortit(int kortti1, int kortti2) {
        this.pelilauta.poistaKortit(kortti1, kortti2);
    }

    public ArrayList getKortit() {
        ArrayList<Kortti> kortit = this.pelilauta.getKortit();
        return kortit;
    }

}
