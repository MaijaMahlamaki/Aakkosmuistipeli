package muistipeli;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.Graafinenkayttoliittyma;
import muistipeli.kayttoliittyma.Kayttoliittyma;

public class Main {

    /**
     * Main.
     *
     * @param args main
     */
    
    public static void main(String[] args) {

        Graafinenkayttoliittyma gkayttis = new Graafinenkayttoliittyma();
        SwingUtilities.invokeLater(gkayttis);

        /*Tekstikäyttöliittymä:
         Scanner lukija = new Scanner(System.in);
         Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
         kayttis.kaynnista();
         */
    }

}
