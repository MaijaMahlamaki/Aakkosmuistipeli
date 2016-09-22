/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelilogiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mahlamai
 */
public class Pelilauta {

    private ArrayList<Kortti> kortit;

    public Pelilauta() {
        this.kortit = new ArrayList<Kortti>();
    }

    public void uusiPeli() {
        luoKortit();
        Collections.shuffle(this.kortit);
    }

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

    public String kortinKirjain(int index) {
        Object k = this.kortit.get(index);
        Kortti kortti = (Kortti) k;
        String kirjain = (String) kortti.getKirjain();
        return kirjain;
    }

    public void poistaKortit(int kortti1, int kortti2) {
        this.kortit.set(kortti1, new Kortti("x"));
        this.kortit.set(kortti2, new Kortti("x"));
    }

    public int korttienLkm() {
        return this.kortit.size();
    }

    public ArrayList getKortit() {
        return this.kortit;
    }

}
