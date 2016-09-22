/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelilogiikka.Kortti;
import muistipeli.pelilogiikka.Muistipeli;
import muistipeli.pelilogiikka.Pelilauta;

/**
 *
 * @author mahlamai
 */
public class Graafinenkayttoliittyma implements Runnable {

    private JFrame frame;
    private HashMap kortit;

    public Graafinenkayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Aakkosmuistipeli");
        frame.setPreferredSize(new Dimension(900, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        JPanel teksti = new JPanel();
        teksti.add(new JTextArea("Tervetuloa pelaamaan muistipeliä!\n\n"
                + "Ohjeet: Valitse kaksi korttia kerrallaan.\n"
                + "Mikäli löydät parin, saat kaksi pistettä.\n"
                + "Jos paria ei löytynyt, saat yhden miinuspisteen.\n\n"
                + "Pelaaja: nimi, pistetilanne: 0"));
        
   
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        container.add(teksti, BorderLayout.NORTH);
        container.add(luoValikko());
    }
        
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(4,4));

        /*Tässä luodaan pelilauta: kortteja on 16. 
        Miten kortteihin saisi linkitettyä kortin indeksin?
        Sen avulla tarkastetaan pelilogiikan kautta, tuliko pari vai ei
        */
        Muistipeli muistipeli = new Muistipeli(new Pelaaja("pelaaja"));
        muistipeli.aloitaPeli();

        for (int i = 0; i < 16; i++) {
            JButton kortti = new JButton("x");
            panel.add(kortti);
        }
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
