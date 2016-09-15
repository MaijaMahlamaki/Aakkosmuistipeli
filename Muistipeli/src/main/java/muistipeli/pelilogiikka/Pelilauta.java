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

    private ArrayList kortit;

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

    public String getKirjain(int index) {
        Kortti kortti = (Kortti) this.kortit.get(index);
        return kortti.getKirjain();
    }

    public void poistaKortit(int kortti1, int kortti2) {
        if (kortti1 > kortti2) {
            this.kortit.remove(kortti1);
            this.kortit.remove(kortti2);
        } else {
            this.kortit.remove(kortti2);
            this.kortit.remove(kortti1);
        }

    }

    public int korttienLkm() {
        return this.kortit.size();
    }

}
