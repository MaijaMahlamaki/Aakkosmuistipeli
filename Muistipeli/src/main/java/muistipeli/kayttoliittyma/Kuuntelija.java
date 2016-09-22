/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Compiler.command;
import javax.swing.JButton;
import javax.swing.JTextArea;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelilogiikka.Muistipeli;
import muistipeli.pelilogiikka.Pelilauta;

/**
 *
 * @author mahlamai
 */
public class Kuuntelija implements ActionListener {

    private JButton kortti1;
    private JButton kortti2;
    private int ekaKortti;
    private int tokaKortti;
    private int klikkaukset;
    private Muistipeli muistipeli;
    private JTextArea teksti;

    public Kuuntelija(Muistipeli peli, JTextArea teksti, JButton k0, JButton k1, JButton k2, JButton k3, JButton k4, JButton k5, JButton k6, JButton k7, JButton k8, JButton k9, JButton k10, JButton k11, JButton k12, JButton k13, JButton k14, JButton k15) {
        this.muistipeli = peli;
        this.teksti = teksti;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        klikkaukset++;

        if (klikkaukset == 1) {
            ekaKortti = Integer.parseInt(ae.getActionCommand());
            Object source = ae.getSource();
            if (source instanceof JButton) {
                JButton b = (JButton) source;
                kortti1 = b;
            }

        }
        if (klikkaukset == 2) {

            tokaKortti = Integer.parseInt(ae.getActionCommand());

            Object source = ae.getSource();
            if (source instanceof JButton) {
                JButton b = (JButton) source;
                kortti2 = b;
            }

            String kortit = muistipeli.naytaKortit(ekaKortti, ekaKortti);
            
            if (muistipeli.kaannaKortit(ekaKortti, tokaKortti) == true) {

                kortti1.setEnabled(false);
                kortti1.setText("");
                kortti2.setEnabled(false);
                kortti2.setText("");
                teksti.setText("Löydetyt kirjaimet: \n"
                        + kortit + "\n"
                        + "Onneksi olkoon, löysit parin ja ansaitsit kaksi pistettä!");

            } else {
                teksti.setText("Löydetyt kirjaimet: \n"
                        + muistipeli.naytaKortit(ekaKortti, tokaKortti)
                        + "\n"
                        + "Harmi, paria ei löytynyt ja sait yhden miinuspisteen.");
            }
            klikkaukset = 0;
        }

    }
}
