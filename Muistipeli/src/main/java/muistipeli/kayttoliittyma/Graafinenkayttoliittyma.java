package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
         Kortit luodaan yksitellen niin, että jokaisessa kortissa/napissa 
         action command on luku väliltä 0-15, joka toimii kortin indeksinä. 
         Kutakin indeksiä vastaavat kirjaimet on talletettu pelilaudan 
         arraylistiin ja parien tarkistus tapahtuu pelilogiikassa.       
         */
        ArrayList<JButton> napit = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton();
            button.setActionCommand(Integer.toString(i));
            napit.add(button);

        }

        kuuntelija = new Kuuntelija(teksti, pelaajanLisays, nimi, ylaosa, napit);

        for (JButton button : napit) {
            button.addActionListener(kuuntelija);

            button.setFont(new Font("Arial", Font.PLAIN, 40));
            button.setBackground(Color.PINK);
            panel.add(button);
        }

        nimi.addActionListener(kuuntelija);
        pelaajanLisays.addActionListener(kuuntelija);

        container.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }

}
