/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelilogiikka;

/**
 *Luokka määrittelee korttiolion, johon liittyy aina tietty kirjain.
 * 
 */
public class Kortti {

    private String kirjain;

    public Kortti(String kirjain) {
        this.kirjain = kirjain;
    }

    public String getKirjain() {
        return this.kirjain;
    }

}
