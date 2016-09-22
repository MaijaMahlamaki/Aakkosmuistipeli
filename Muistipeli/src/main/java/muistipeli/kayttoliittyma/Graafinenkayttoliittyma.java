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
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private ActionListener kuuntelija;
    private Muistipeli muistipeli;

    public Graafinenkayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Aakkosmuistipeli");
        frame.setPreferredSize(new Dimension(900, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.muistipeli = new Muistipeli(new Pelaaja("pelaaja"));
        muistipeli.aloitaPeli();

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {

        JPanel peli = new JPanel();
        JTextArea teksti = new JTextArea("Tervetuloa pelaamaan muistipeliä!\n\n"
                + "Ohjeet: Valitse kaksi korttia kerrallaan.\n"
                + "Mikäli löydät parin, saat kaksi pistettä.\n"
                + "Jos paria ei löytynyt, saat yhden miinuspisteen.\n");

        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        container.add(teksti, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        /*Tässä luodaan pelilauta: kortteja on 16. 
         Kortit luodaan yksitellen niin, että jokaisessa napissa on teksti x, 
         mutta action command on luku väliltä 0-15. 
         Kirjaimet on talletettu pelilaudan arraylistiin, ja parien tarkistus 
         tapahtuu sitä kautta, ja napeissa on action commandina korttia vastaava 
         indeksi. Parien tarkistus tapahtuu pelilogiikassa.
         */
        JButton k0 = new JButton("X");
        k0.setActionCommand("0");
        JButton k1 = new JButton("X");
        k1.setActionCommand("1");
        JButton k2 = new JButton("X");
        k2.setActionCommand("2");
        JButton k3 = new JButton("X");
        k3.setActionCommand("3");
        JButton k4 = new JButton("X");
        k4.setActionCommand("4");
        JButton k5 = new JButton("X");
        k5.setActionCommand("5");
        JButton k6 = new JButton("X");
        k6.setActionCommand("6");
        JButton k7 = new JButton("X");
        k7.setActionCommand("7");
        JButton k8 = new JButton("X");
        k8.setActionCommand("8");
        JButton k9 = new JButton("X");
        k9.setActionCommand("9");
        JButton k10 = new JButton("X");
        k10.setActionCommand("10");
        JButton k11 = new JButton("X");
        k11.setActionCommand("11");
        JButton k12 = new JButton("X");
        k12.setActionCommand("12");
        JButton k13 = new JButton("X");
        k13.setActionCommand("13");
        JButton k14 = new JButton("X");
        k14.setActionCommand("14");
        JButton k15 = new JButton("X");
        k15.setActionCommand("15");

        kuuntelija = new Kuuntelija(muistipeli, teksti, k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15);

        k0.addActionListener(kuuntelija);
        k1.addActionListener(kuuntelija);
        k2.addActionListener(kuuntelija);
        k3.addActionListener(kuuntelija);
        k4.addActionListener(kuuntelija);
        k5.addActionListener(kuuntelija);
        k6.addActionListener(kuuntelija);
        k7.addActionListener(kuuntelija);
        k8.addActionListener(kuuntelija);
        k9.addActionListener(kuuntelija);
        k10.addActionListener(kuuntelija);
        k11.addActionListener(kuuntelija);
        k12.addActionListener(kuuntelija);
        k13.addActionListener(kuuntelija);
        k14.addActionListener(kuuntelija);
        k15.addActionListener(kuuntelija);

        panel.add(k0);
        panel.add(k1);
        panel.add(k2);
        panel.add(k3);
        panel.add(k4);
        panel.add(k5);
        panel.add(k6);
        panel.add(k7);
        panel.add(k8);
        panel.add(k9);
        panel.add(k10);
        panel.add(k11);
        panel.add(k12);
        panel.add(k13);
        panel.add(k14);
        panel.add(k15);

        container.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }

}
