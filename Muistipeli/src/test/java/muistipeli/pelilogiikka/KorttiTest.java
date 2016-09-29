package muistipeli.pelilogiikka;

import muistipeli.pelaaja.Pelaaja;
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
public class KorttiTest {

    private Kortti kortti;

    public KorttiTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.kortti = new Kortti("a");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertEquals("a", kortti.getKirjain());
    }

    @Test
    public void getKirjainPalauttaaOikeanKirjaimen() {
        assertEquals("a", kortti.getKirjain());
    }

}
