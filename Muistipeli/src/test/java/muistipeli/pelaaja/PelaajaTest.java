package muistipeli.pelaaja;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 *
 */
public class PelaajaTest {

    private Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("Pekka");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimiiOikein() {

        String odotettuNimi = "Pekka";
        String nimi = pelaaja.getNimi();
        int odotettuPistesaldo = 0;
        int pisteSaldo = pelaaja.getPisteet();

        assertEquals(odotettuNimi, nimi);
        assertEquals(odotettuPistesaldo, pisteSaldo);

    }

    @Test
    public void getNimiToimii() {
        Pelaaja matti = new Pelaaja("Matti");
        String odotettuNimi = "Matti";
        String nimi = matti.getNimi();

        assertEquals(odotettuNimi, nimi);
    }

    @Test
    public void kirjaaPisteetToimiiLuvullaKaksi() {
        pelaaja.kirjaaPisteet(2);

        assertEquals(2, pelaaja.getPisteet());

    }

    @Test
    public void kirjaaPisteetToimiiLuvullaMiinusYksi() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);

        assertEquals(-5, pelaaja.getPisteet());
    }

    @Test
    public void kirjaaPisteetToimiiMolemmillaLuvuilla() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);

        assertEquals(4, pelaaja.getPisteet());

    }

    @Test
    public void kirjaaPisteetKirjaaBonusPisteetKahdellaPerakkaisellaParilla() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);

        assertEquals(6, pelaaja.getPisteet());

    }

    @Test
    public void kirjaaPisteetKirjaaBonusPisteetUseallaPerakkaisellaParilla() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);

        assertEquals(14, pelaaja.getPisteet());

    }

    @Test
    public void kirjaaPisteetKirjaaBonusPisteetOikeinJosValissaOnMiinus() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);

        assertEquals(11, pelaaja.getPisteet());

    }

    @Test
    public void bonusPisteidenSummaPalautetaanOikeinJosNolla() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);

        assertEquals(0, pelaaja.bonuspisteet());

    }

    @Test
    public void bonusPisteidenSummaPalautetaanOikeinJosKaksi() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);

        assertEquals(2, pelaaja.bonuspisteet());

    }

    @Test
    public void bonusPisteidenSummaPalautetaanOikeinJosSuuri() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);

        assertEquals(8, pelaaja.bonuspisteet());

    }

    @Test
    public void loppuViestiOikeaKunPisteetYliNollaJaBonusta() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);

        String odotettu = "Huikea suoritus Pekka, olet varsinainen muistiguru!"
                + "\nKeräsit bonuspisteitä 14 ja lopullinen pistesaldosi on 30 pistettä!"
                + "\nLoistavaa!";

        assertEquals(odotettu, pelaaja.loppuViesti());

    }

    @Test
    public void loppuViestiOikeaKunPisteetYliNollaMuttaEiBonusta() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);

        String odotettu = "Hieno suoritus Pekka, olet varsin etevä muistaja!"
                + "\nBonuspisteet jäivät tällä kertaa saamatta."
                + "\nKeräsit siitä huolimatta kuitenkin 8 pistettä! Loistavaa!";

        assertEquals(odotettu, pelaaja.loppuViesti());

    }

    @Test
    public void loppuViestiOikeaKunPisteetAlleNollaMuttaBonusta() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);

        String odotettu = "Hyvä Pekka, löysit kaikki parit!"
                + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, "
                + "sait yhteensä -1 pistettä."
                + "\nKeräsit kuitenkin hienot 2 bonuspistettä!";

        assertEquals(odotettu, pelaaja.loppuViesti());

    }

    @Test
    public void loppuViestiOikeaKunPisteetAlleNollaEikäBonusta() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);

        String odotettu = "Hyvä Pekka, löysit kaikki parit!"
                + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, "
                + "sait yhteensä -4 pistettä."
                + "\nParempi onni ensi kerralla, eikun treenailemaan lisää!";

        assertEquals(odotettu, pelaaja.loppuViesti());

    }
}
