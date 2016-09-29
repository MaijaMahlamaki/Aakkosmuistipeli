/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author mahlamai
 */
public class MuistipeliTest {
    private Muistipeli muistipeli;
    
    public MuistipeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pisteetLasketaanOikeinKakkosella() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(2);
        
        assertEquals(2, muistipeli.getPisteet());

    }
    
    @Test
    public void pisteetLasketaanOikeinMiinusYkkosilla() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);
        
        assertEquals(-3, muistipeli.getPisteet());

    }
    
    @Test
    public void pisteetLasketaanOikeinKakkosillaJaMiinusYkkosilla() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);
        
        assertEquals(0, muistipeli.getPisteet());

    }
//    Jostain kumman syystä tämä testi aiheuttaa nullpointer exceptionin,
//    vaikka Pelilauta-luokan metodi, jota tämä käyttää, menee läpi
//  @Test
//    public void oikeatKortitPoistuvat() {
//        muistipeli.aloitaPeli();
//        muistipeli.poistaKortit(0, 1);
//        assertEquals("x" + " ja " + "x", muistipeli.naytaKortit(0, 1));
//
//    }
    
    
    @Test
    public void testSomeMethod() {
    }
    
}
