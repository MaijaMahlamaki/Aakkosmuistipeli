package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
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
 * Luokka kokoaa graafisen käyttöliittymän muistipelille. Käyttöliittymän
 * ylälaidassa on infoa käyttäjälle näyttävä paneeli ja sen alla 4x4 pelilauta,
 * joka koostuu korteista.
 *
 */
public class Graafinenkayttoliittyma implements Runnable {

    private JFrame frame;
    private ActionListener kuuntelija;

    /**
     * Graafisen käyttöliittymän konstruktori.
     */
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

        JPanel peli = new JPanel();

        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        JPanel ylaosa = new JPanel(new GridLayout(1, 3));

        container.add(ylaosa, BorderLayout.NORTH);

        JTextArea teksti = new JTextArea("Tervetuloa pelaamaan muistipeliä!"
                + "\nAloita kirjoittamalla nimesi viereiseen kenttään"
                + "\nja klikkaa sitten aloituspainiketta."
                + "\n\nPelin kulku:"
                + "\nValitse kaksi korttia kerrallaan."
                + "\nJos löydät parin, saat kaksi pistettä."
                + "\nJos et, saat yhden miinuspisteen."
                + "\nJos onnistut löytämään kaksi paria peräkkäin,"
                + "\nsaat kaksi bonuspistettä!");
        JTextField nimi = new JTextField();
        JButton pelaajanLisays = new JButton("Aloita peli");
        pelaajanLisays.setActionCommand("100");

        ylaosa.add(teksti);
        ylaosa.add(nimi);
        ylaosa.add(pelaajanLisays);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        /*Alla luodaan pelilauta, jossa kortteja on 16. 
         Kortit luodaan yksitellen niin, että jokaisessa kortissa/napissa on 
         käyttäjälle näkyvä teksti x, mutta action command on luku väliltä 0-15. 
         Napeissa on action commandina korttia vastaava 
         indeksi. Kutakin indeksiä vastaavat kirjaimet on talletettu pelilaudan 
         arraylistiin ja parien tarkistus tapahtuu pelilogiikassa.       
         */        
        
        
//        for (int i = 0; i < 15; i++) {
//            JButton button = new JButton();
//            button.setActionCommand(Integer.toString(i));
//            kuuntelija = new Kuuntelija(teksti, pelaajanLisays, nimi, ylaosa, button);
//            button.addActionListener(kuuntelija);
//            panel.add(button);
//            
//        }
        ArrayList<JButton> napit = new ArrayList<>();
        
        JButton k0 = new JButton("");
        k0.setActionCommand("0");
        napit.add(k0);
        JButton k1 = new JButton("");
        k1.setActionCommand("1");
        napit.add(k1);
        JButton k2 = new JButton("");
        k2.setActionCommand("2");
        napit.add(k2);
        JButton k3 = new JButton("");
        k3.setActionCommand("3");
        napit.add(k3);
        JButton k4 = new JButton("");
        k4.setActionCommand("4");
        napit.add(k4);
        JButton k5 = new JButton("");
        k5.setActionCommand("5");
        napit.add(k5);
        JButton k6 = new JButton("");
        k6.setActionCommand("6");
        napit.add(k6);
        JButton k7 = new JButton("");
        k7.setActionCommand("7");
        napit.add(k7);
        JButton k8 = new JButton("");
        k8.setActionCommand("8");
        napit.add(k8);
        JButton k9 = new JButton("");
        k9.setActionCommand("9");
        napit.add(k9);
        JButton k10 = new JButton("");
        k10.setActionCommand("10");
        napit.add(k10);
        JButton k11 = new JButton("");
        k11.setActionCommand("11");
        napit.add(k11);
        JButton k12 = new JButton("");
        k12.setActionCommand("12");
        napit.add(k12);
        JButton k13 = new JButton("");
        k13.setActionCommand("13");
        napit.add(k13);
        JButton k14 = new JButton("");
        k14.setActionCommand("14");
        napit.add(k14);
        JButton k15 = new JButton("");
        k15.setActionCommand("15");
        napit.add(k15);

        kuuntelija = new Kuuntelija(teksti, pelaajanLisays, nimi, ylaosa, k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15);

       
        for (JButton button : napit) {
            button.addActionListener(kuuntelija);
            panel.add(button);
            button.setFont(new Font("Arial", Font.PLAIN, 40));
            button.setBackground(Color.PINK);
        }


        nimi.addActionListener(kuuntelija);
        pelaajanLisays.addActionListener(kuuntelija);


        container.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }

}
