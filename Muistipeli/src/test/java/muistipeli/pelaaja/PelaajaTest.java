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

}
