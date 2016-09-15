/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelaaja;

/**
 *
 * @author mahlamai
 */
public class Pelaaja {
    private String nimi;
    private int pisteet;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return pisteet;
    }
    
    public void kirjaaPisteet(int pisteet) {
        this.pisteet = this.pisteet + pisteet;
    }
    
    
}
