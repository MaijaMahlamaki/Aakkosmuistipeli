/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.util.Scanner;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelilogiikka.Muistipeli;
import muistipeli.pelilogiikka.Pelilauta;

/**
 *
 * @author mahlamai
 */
public class Kayttoliittyma {

    private Scanner lukija;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;

    }

    public void kaynnista() {
        System.out.println("Tervetuloa pelaamaan aakkosmuistipeliä!");
        System.out.println("\nSäännöt:\n"
                + "Aluksi pelilaudalla on yhteensä 16 korttia.\n"
                + "Saat avata kortteja kaksi kerrallaan. Jos löydät parit, saat 2 pistettä.\n"
                + "Jos avaamasi kortit eivät ole parit, saat yhden miinuspisteen.\n");
        System.out.println("Eiköhän aloiteta! \n"
                + "Kerro ensin kuka pelaa eli kirjoita nimesi: ");

        String nimi = lukija.nextLine();
        Pelaaja pelaaja = new Pelaaja(nimi);
        Muistipeli muistipeli = new Muistipeli(pelaaja);
        muistipeli.aloitaPeli();

        //Nyt pelilauta on valmis ja voimme aloittaa pelin
        //Kysytään luupissa aina kaksi lukua ja tallennetaan ne, 
        //tarkistetaan tuliko parit ja jatketaan taas kysymällä kaksi lukua
        //Luuppi päättyy kun kortit loppuvat ja silloin julkistetaan pelaajan pisteet
        System.out.println("\nKiitos!");

        while (true) {
            if (muistipeli.korttienLkm() == 0) {
                System.out.println("Hienoa työtä " + pelaaja.getNimi() + ", löysit kaikki parit ja peli päättyi!\n"
                        + "Pisteitä keräsit kokonaisuudessaan " + pelaaja.getPisteet() + ".");
                break;
            }
            System.out.println("\nKortteja on pelilaudalla yhteensä " + muistipeli.korttienLkm() + ".\n"
                    + "Valitse luku väliltä 0-" + (muistipeli.korttienLkm() - 1) + ": ");
            String luku1 = lukija.nextLine();
            System.out.print("Hyvä! Valitse vielä toinen luku väliltä 0-" + (muistipeli.korttienLkm() - 1) + "\n");
            String luku2 = lukija.nextLine();

            System.out.println("");
            int eka = Integer.parseInt(luku1);
            int toka = Integer.parseInt(luku2);

            System.out.println(muistipeli.naytaKortit(eka, toka));

            if (muistipeli.kaannaKortit(eka, toka)) {
                System.out.println("Onneksi olkoon, löysit parin! Ansaitsit kaksi pistettä!\n\n");
            } else {
                System.out.println("Harmi, paria ei löytynyt eli sait yhden miinuspisteen!\n\n");
            }

        }
    }

}
