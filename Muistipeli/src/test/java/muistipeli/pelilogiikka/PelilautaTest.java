/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelilogiikka;

import java.util.ArrayList;
import muistipeli.pelaaja.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author mahlamai
 */
public class PelilautaTest {

    private Pelilauta pelilauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pelilauta = new Pelilauta();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getKirjainToimiiOikein() {
        pelilauta.luoKortit();

        assertEquals("a", pelilauta.kortinKirjain(0));
        assertEquals("h", pelilauta.kortinKirjain(15));

    }

    @Test
    public void korttienLkmToimiiOikeinTaydellaPelilaudalla() {
        pelilauta.luoKortit();

        assertEquals(16, pelilauta.korttienLkm());

    }

    @Test
    public void korttienLkmToimiiOikeinPoistonJalkeen() {
        pelilauta.luoKortit();

        pelilauta.poistaKortit(0, 1);
        assertEquals(16, pelilauta.korttienLkm());


    }

    @Test
    public void korttienPoistoPoistaaPelilaudaltaOikeatKortit() {
        pelilauta.luoKortit();

        pelilauta.poistaKortit(0, 1);
        assertEquals("x", pelilauta.kortinKirjain(0));
        assertEquals("x", pelilauta.kortinKirjain(1));

    }
}
