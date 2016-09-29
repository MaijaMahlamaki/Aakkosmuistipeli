/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.pelaaja;

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
    public void getPisteetToimiiMolemmillaLuvuilla() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);

        assertEquals(4, pelaaja.getPisteet());

    }

}
