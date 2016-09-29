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
    public void pelinAloitusLuoOikeanMaaranKortteja() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.aloitaPeli();

        assertEquals(16, muistipeli.korttienLkm());

    }

    @Test
    public void kaannaKortitPalauttaaTrueJosPariLoytyi() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();

        assertEquals(true, muistipeli.kaannaKortit(0, 8));

    }

    @Test
    public void kaannaKortitPalauttaaFalseJosPariaEiLoytynyt() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();

        assertEquals(false, muistipeli.kaannaKortit(0, 1));

    }

    @Test
    public void kaannaKortitPalauttaaFalseJosParitJoLoydetty() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);

        assertEquals(false, muistipeli.kaannaKortit(0, 8));

    }

    @Test
    public void kaannaKortitVahentaaParienLkmJosPariLoytyi() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);

        assertEquals(7, muistipeli.getParienLkm());

    }

    @Test
    public void kaannaKortitVahentaaParienLkmJosUseaPariLoytyi() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);
        muistipeli.kaannaKortit(1, 9);
        muistipeli.kaannaKortit(2, 10);

        assertEquals(5, muistipeli.getParienLkm());

    }

    @Test
    public void kaannaKortitEiVahennaParienLkmJosPariaEiLoytynyt() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 1);

        assertEquals(8, muistipeli.getParienLkm());

    }

    @Test
    public void kaannaKortitVahentaaParienLkmOikeinUseallaKaannolla() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);
        muistipeli.kaannaKortit(1, 5);
        muistipeli.kaannaKortit(1, 9);
        muistipeli.kaannaKortit(2, 13);
        muistipeli.kaannaKortit(2, 10);

        assertEquals(5, muistipeli.getParienLkm());

    }

    @Test
    public void kaannaKortitPoistaaOikeatKortit() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);
        muistipeli.kaannaKortit(1, 9);

        assertEquals("x", muistipeli.getPelilauta().kortinKirjain(0));
        assertEquals("x", muistipeli.getPelilauta().kortinKirjain(8));
        assertEquals("x", muistipeli.getPelilauta().kortinKirjain(1));
        assertEquals("x", muistipeli.getPelilauta().kortinKirjain(9));

    }

    @Test
    public void kaannaKortitKirjaaPisteenParista() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);

        assertEquals(2, muistipeli.getPisteet());
    }

    @Test
    public void kaannaKortitKirjaaMiinusPisteenHudista() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 1);

        assertEquals(-1, muistipeli.getPisteet());
    }

    @Test
    public void kaannaKortitKirjaaBonusPisteet2p() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8); //+2
        muistipeli.kaannaKortit(1, 9); //+2 +2

        assertEquals(6, muistipeli.getPisteet());
    }

    @Test
    public void kaannaKortitKirjaaBonusPisteetKunBonusPisteitaUseita() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8); //+2
        muistipeli.kaannaKortit(1, 9); //+2 +2
        muistipeli.kaannaKortit(2, 10); // +2 +2
        muistipeli.kaannaKortit(3, 11); //+2 +2

        assertEquals(14, muistipeli.getPisteet());
    }

    @Test
    public void kaannaKortitKirjaaBonusPisteetKunMiinusPisteitaJaBonusPisteitaUseita() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8); //+2
        muistipeli.kaannaKortit(1, 9); //+2 +2
        muistipeli.kaannaKortit(8, 14); //-1
        muistipeli.kaannaKortit(2, 10); //+2
        muistipeli.kaannaKortit(3, 11);//+2 +2

        assertEquals(11, muistipeli.getPisteet());
    }

    @Test
    public void naytaKortitNayttaaParinOikein() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();

        assertEquals("a ja a", muistipeli.naytaKortit(0, 8));
    }

    @Test
    public void naytaKortitNayttaaEriParisetKortitOikein() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();

        assertEquals("a ja b", muistipeli.naytaKortit(0, 1));
    }

    @Test
    public void naytaKortitNayttaaJoLoydetynParinOikein() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);

        assertEquals("x ja x", muistipeli.naytaKortit(0, 8));
    }

    @Test
    public void kirjaaPisteetKirjaaOikeinKakkosella() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(2);

        assertEquals(2, muistipeli.getPisteet());

    }

    @Test
    public void kirjaaPisteetKirjaaOikeinMiinusYkkosilla() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);

        assertEquals(-3, muistipeli.getPisteet());

    }

    @Test
    public void kirjaaPisteetKirjaaOikeinKakkosillaJaMiinusYkkosilla() {
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

    @Test
    public void kirjaaPisteetKirjaaOikeinBonusPisteetKun2p() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(2);

        assertEquals(6, muistipeli.getPisteet());

    }

    @Test
    public void kirjaaPisteetKirjaaOikeinBonusPisteetKunUseita() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(2);

        assertEquals(14, muistipeli.getPisteet());

    }

    @Test
    public void bonusPisteetLisataanKokonaispisteisiinOikeinKunUseitaJaMiinusta() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(-1);
        muistipeli.kirjaaPisteet(2);
        muistipeli.kirjaaPisteet(2);

        assertEquals(10, muistipeli.getPisteet());

    }

    @Test
    public void peliLoppuPalauttaaFalseJosPeliKesken() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(1, 2);
        muistipeli.kaannaKortit(8, 5);

        assertEquals(false, muistipeli.peliLoppu());

    }

    @Test
    public void peliLoppuPalauttaaTrueJosKaikkiParitLoydetty() {
        Pelaaja P = new Pelaaja("P");
        muistipeli = new Muistipeli(P);
        muistipeli.getPelilauta().luoKortit();
        muistipeli.kaannaKortit(0, 8);
        muistipeli.kaannaKortit(1, 9);
        muistipeli.kaannaKortit(2, 10);
        muistipeli.kaannaKortit(3, 11);
        muistipeli.kaannaKortit(4, 12);
        muistipeli.kaannaKortit(5, 13);
        muistipeli.kaannaKortit(6, 14);
        muistipeli.kaannaKortit(7, 15);

        assertEquals(true, muistipeli.peliLoppu());

    }

}
