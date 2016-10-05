package muistipeli.kayttoliittyma;

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
 * käyttäjältä pelilogiikalle ja pelilogiikalta takaisin käyttäjälle.
 *
 */
public class Kuuntelija implements ActionListener {
    
    private JButton nappi1;
    private JButton nappi2;
    private ArrayList<JButton> napit;
    private int ekaKortti;
    private int tokaKortti;
    private int klikkaukset;
    private JTextArea teksti;
    private JButton pelaajanLisays;
    private JTextField pelaajanNimi;
    private JPanel ylaosa;
    private Muistipeli muistipeli;
    private Pelaaja pelaaja;
    private JButton uusiPeli;
    
    public Kuuntelija(JTextArea teksti, JButton pelaajanLisays, JTextField pelaajanNimi, JPanel ylaosa, JButton k0, JButton k1, JButton k2, JButton k3, JButton k4, JButton k5, JButton k6, JButton k7, JButton k8, JButton k9, JButton k10, JButton k11, JButton k12, JButton k13, JButton k14, JButton k15) {
        this.teksti = teksti;
        this.pelaajanLisays = pelaajanLisays;
        this.pelaajanNimi = pelaajanNimi;
        this.ylaosa = ylaosa;
        this.uusiPeli = new JButton("Aloita uusi Peli");
        this.napit = new ArrayList<>();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        JButton nappi = (JButton) ae.getSource();
        int painettu = Integer.parseInt(nappi.getActionCommand());
        
        if (painettu == 101) {
            ylaosa.setLayout(new GridLayout(1,1));
            ylaosa.remove(uusiPeli);
            ylaosa.remove(pelaajanNimi);
            ylaosa.remove(pelaajanLisays);
            
            muistipeli = new Muistipeli(pelaaja);
            muistipeli.aloitaPeli();
            
                      
            for (JButton n : this.napit) {
                n.setEnabled(true);
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
                ekaKortti = Integer.parseInt(ae.getActionCommand());
                Object source = ae.getSource();
                if (source instanceof JButton) {
                    JButton b = (JButton) source;
                    nappi1 = b;
                }
                
            }
            if (klikkaukset == 2) {
                
                tokaKortti = Integer.parseInt(ae.getActionCommand());
                
                Object source = ae.getSource();
                if (source instanceof JButton) {
                    JButton b = (JButton) source;
                    nappi2 = b;
                }
                
                String kortit = muistipeli.naytaKortit(ekaKortti, tokaKortti);
                
                if (muistipeli.kaannaKortit(ekaKortti, tokaKortti) == true) {
                    
                    nappi1.setEnabled(false);
                    napit.add(nappi1);
                    nappi1.setText("");
                    nappi2.setEnabled(false);
                    napit.add(nappi2);
                    nappi2.setText("");
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
