package muistipeli.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Compiler.command;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelilogiikka.Muistipeli;
import muistipeli.pelilogiikka.Pelilauta;

/**
 * Luokka kuuntelee graafisen käyttöliittymän tapahtumia sekä välittää viestejä
 * käyttäjältä pelilogiikalle ja pelilogiikalta takaisin käyttäjälle. Kuuntelija
 * osaa aloittaa uuden pelin edellisen perään, jos pelaaja klikkaa "Aloita uusi
 * peli" -painiketta.
 *
 */
public class Kuuntelija implements ActionListener {

    private JButton nappi1;
    private JButton nappi2;
    private ArrayList<JButton> napit;
    private int ekaKortti;
    private int tokaKortti;
    private String ekaKirjain;
    private String tokaKirjain;
    private int klikkaukset;
    private JTextArea teksti;
    private JButton pelaajanLisays;
    private JTextField pelaajanNimi;
    private JPanel ylaosa;
    private Muistipeli muistipeli;
    private Pelaaja pelaaja;
    private JButton uusiPeli;
    private boolean huti;

    /**
     * Kuuntelija saa konstruktorin parametreinä paneelin yläosan ja siihen
     * kuuluvat elementit; tekstikentän, nimensyöttöön tarkoitetun kentän,
     * pelaajan lisäysnapin, sekä liudan korttinappeja. Konstruktorissa
     * alustetaan myös uuden pelin aloittamiseen tarkoitettu nappi ja ArrayList,
     * johon napit kerätään pelin aikana, jotta ne saadaan uuden pelin
     * aloituksen yhteydessä asetettua jälleen painettaviksi kätevästi.
     *
     * @param teksti infoaa käyttäjää
     * @param pelaajanLisays lisää pelaajan
     * @param pelaajanNimi plaaja kirjoittaa nimensä kenttään
     * @param ylaosa ylapaneeli, jossa näytetään käyttäjälle tietoa
     * @param napit korttinapit
     */
    public Kuuntelija(JTextArea teksti, JButton pelaajanLisays, JTextField pelaajanNimi, JPanel ylaosa, ArrayList napit) {
        this.teksti = teksti;
        this.pelaajanLisays = pelaajanLisays;
        this.pelaajanNimi = pelaajanNimi;
        this.ylaosa = ylaosa;
        this.uusiPeli = new JButton("Uusi peli");
        this.napit = new ArrayList<>();
        this.huti = false;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        JButton nappi = (JButton) ae.getSource();
        int painettu = Integer.parseInt(nappi.getActionCommand());

        if (painettu == 101) {
            ylaosa.setLayout(new GridLayout(1, 1));
            ylaosa.remove(uusiPeli);
            ylaosa.remove(pelaajanNimi);
            ylaosa.remove(pelaajanLisays);

            muistipeli = new Muistipeli(pelaaja);
            muistipeli.aloitaPeli();

            for (JButton b : this.napit) {
                b.setText("");
                b.setEnabled(true);
                b.setBackground(Color.PINK);
            }
            teksti.setText("Pelaaja: " + pelaaja.getNimi()
                    + "\nPisteet: " + pelaaja.getPisteet()
                    + "\n\nAloita peli valitsemalla kaksi korttia.");

        } else if (painettu == 100) {

            pelaaja = new Pelaaja(pelaajanNimi.getText());
            muistipeli = new Muistipeli(pelaaja);
            muistipeli.aloitaPeli();
            ylaosa.remove(pelaajanNimi);
            ylaosa.remove(pelaajanLisays);
            teksti.setText("Pelaaja: " + pelaaja.getNimi()
                    + "\nPisteet: " + pelaaja.getPisteet()
                    + "\n\nAloita peli valitsemalla kaksi korttia.");

        } else {

            klikkaukset++;

            if (klikkaukset == 1) {
                

                if (huti) {
                    nappi1.setText("");
                    nappi2.setText("");
                    nappi1.setBackground(Color.PINK);
                    nappi2.setBackground(Color.PINK);
                }

                huti = false;

                ekaKortti = Integer.parseInt(ae.getActionCommand());
                Object source = ae.getSource();
                if (source instanceof JButton) {
                    JButton b = (JButton) source;
                    nappi1 = b;
                    nappi1.setEnabled(false);
                    nappi1.setText(muistipeli.naytaKortti(ekaKortti));
                    nappi.setBackground(Color.GREEN);
                }

            }
            if (klikkaukset == 2) {

                tokaKortti = Integer.parseInt(ae.getActionCommand());

                Object source = ae.getSource();
                if (source instanceof JButton) {
                    JButton b = (JButton) source;
                    nappi2 = b;
                    nappi2.setEnabled(false);
                    nappi2.setText(muistipeli.naytaKortti(tokaKortti));
                    nappi2.setBackground(Color.GREEN);
                }

                ekaKirjain = muistipeli.naytaKortti(ekaKortti);
                tokaKirjain = muistipeli.naytaKortti(tokaKortti);
                String kortit = muistipeli.naytaKortit(ekaKortti, tokaKortti);

                if (muistipeli.kaannaKortit(ekaKortti, tokaKortti) == true) {

                    nappi1.setEnabled(false);
                    nappi1.setText(ekaKirjain);
                    nappi1.setBackground(Color.GRAY);
                    napit.add(nappi1);
                    nappi2.setEnabled(false);
                    nappi2.setText(tokaKirjain);
                    nappi2.setBackground(Color.GRAY);
                    napit.add(nappi2);
                    teksti.setText("Pelaaja:" + pelaaja.getNimi()
                            + "\nPisteet: " + pelaaja.getPisteet()
                            + "\n\nLöydetyt kirjaimet: \n"
                            + kortit + "\n\n"
                            + "Onneksi olkoon, löysit parin!");

                } else {
                    teksti.setText("Pelaaja:" + pelaaja.getNimi()
                            + "\nPisteet: " + pelaaja.getPisteet()
                            + "\n\nLöydetyt kirjaimet: \n"
                            + muistipeli.naytaKortit(ekaKortti, tokaKortti)
                            + "\n\n"
                            + "Harmi, paria ei löytynyt ja sait yhden miinuspisteen.");
                    huti = true;
                    nappi1.setEnabled(true);
                    nappi2.setEnabled(true);
                }

                klikkaukset = 0;

                if (muistipeli.peliLoppu()) {
                    ylaosa.setLayout(new GridLayout(2, 1));
                    ylaosa.add(teksti);
                    ylaosa.add(uusiPeli);
                    teksti.setText(pelaaja.loppuViesti());
                    uusiPeli.addActionListener(this);
                    uusiPeli.setActionCommand("101");
                    uusiPeli.setVisible(true);

                }
            }

        }
    }
}
