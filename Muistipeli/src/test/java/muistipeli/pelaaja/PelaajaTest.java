package muistipeli.pelaaja;

import muistipeli.pelilogiikka.Muistipeli;
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
        pelaaja.lisaaKierros();

        String odotettu = "Huikea suoritus Pekka, olet varsinainen muistiguru!"
                + "\nKeräsit bonuspisteitä 14 ja lopullinen pistesaldosi on 30 pistettä!"
                + "\nLoistavaa!"
                + "\nPelatut kierrokset: 1"
                + "\nYhteispisteet: 30"
                + "\nPisteiden keskiarvo: 30.0";

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
        pelaaja.lisaaKierros();

        String odotettu = "Hieno suoritus Pekka, olet varsin etevä muistaja!"
                + "\nBonuspisteet jäivät tällä kertaa saamatta."
                + "\nKeräsit siitä huolimatta kuitenkin 8 pistettä! Loistavaa!"
                + "\nPelatut kierrokset: 1"
                + "\nYhteispisteet: 8"
                + "\nPisteiden keskiarvo: 8.0";

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
        pelaaja.lisaaKierros();

        String odotettu = "Hyvä Pekka, löysit kaikki parit!"
                + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, "
                + "sait yhteensä -1 pistettä."
                + "\nKeräsit kuitenkin hienot 2 bonuspistettä!"
                + "\nPelatut kierrokset: 1"
                + "\nYhteispisteet: -1"
                + "\nPisteiden keskiarvo: -1.0";

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
        pelaaja.lisaaKierros();

        String odotettu = "Hyvä Pekka, löysit kaikki parit!"
                + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, "
                + "sait yhteensä -4 pistettä."
                + "\nParempi onni ensi kerralla, eikun treenailemaan lisää!"
                + "\nPelatut kierrokset: 1"
                + "\nYhteispisteet: -4"
                + "\nPisteiden keskiarvo: -4.0";
        assertEquals(odotettu, pelaaja.loppuViesti());

    }
    
    
    @Test       
    public void kierroksetAlussaNolla() {
        assertEquals(0, pelaaja.kierrokset());
    }
    
    @Test       
    public void pisteetAlussaNolla() {
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test       
    public void bonusPisteetAlussaNolla() {
        assertEquals(0, pelaaja.bonuspisteet());
    }
    
    @Test       
    public void yhteisPisteetAlussaNolla() {
        assertEquals(0, pelaaja.yhteisPisteet());
    }
    
    @Test
    public void kierroksenLisaysLisaaYhden() {
        this.pelaaja.lisaaKierros();
        
         assertEquals(1, pelaaja.kierrokset());
        
    }
    
    @Test
    public void kierroksenLisaysLisaaKaksi() {
        this.pelaaja.lisaaKierros();
        this.pelaaja.lisaaKierros();
        
         assertEquals(2, pelaaja.kierrokset());
        
    }
    
    @Test
    public void kierroksenLisaysLisaaMontaKierrostaOikein() {
        this.pelaaja.lisaaKierros();
        this.pelaaja.lisaaKierros();
        this.pelaaja.lisaaKierros();
        this.pelaaja.lisaaKierros();
        this.pelaaja.lisaaKierros();
        this.pelaaja.lisaaKierros();
        
         assertEquals(6, pelaaja.kierrokset());
        
    }
    
    @Test
    public void yhteisPisteetKahdestaPelistaLasketaanOikeinKunSummaNegatiivinen() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        
        Muistipeli peli = new Muistipeli(pelaaja);
        
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        
         assertEquals(-10, pelaaja.yhteisPisteet());
        
    }
    
    @Test
    public void yhteisPisteetKahdestaPelistaLasketaanOikeinKunSummaNolla() {
        
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        
        pelaaja.nollaaPisteet();
        
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        
         assertEquals(0, pelaaja.yhteisPisteet());
        
    }
    
    @Test
    public void yhteisPisteetKahdestaPelistaLasketaanOikeinKunSummaPositiivinen() {
        
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        
        pelaaja.nollaaPisteet();
        
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        
         assertEquals(11, pelaaja.yhteisPisteet());
        
    }
    
    @Test
    public void keskiArvoToimiiNegatiivisillaLuvuilla() {
        
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.lisaaKierros();
        pelaaja.lisaaKierros();
        pelaaja.lisaaKierros();
       
        
        assertEquals(-2.0, pelaaja.keskiArvo(), 0.1);
        
    }
    
    @Test
    public void keskiArvoToimiiNollalla() {
        
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        
        pelaaja.lisaaKierros();
        pelaaja.lisaaKierros();
        
         assertEquals(0.0, pelaaja.keskiArvo(), 0.1);
        
    }
    
    @Test
    public void keskiArvoToimiiPositiivisillaLuvuilla() {
        
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
       
        pelaaja.lisaaKierros();
        pelaaja.lisaaKierros();
        
         assertEquals(3.5, pelaaja.keskiArvo(), 0.1);
        
    }
    
    @Test 
        
    public void pisteidenNollausToimiiNegatiivisillaLuvuilla() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        
        pelaaja.nollaaPisteet();
        
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test 
        
    public void pisteidenNollausEiMuutaPisteitaJosPisteitaNolla() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        
        pelaaja.nollaaPisteet();
        
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test 
        
    public void pisteidenNollausToimiiPositiivisillaLuvuilla() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        
        pelaaja.nollaaPisteet();
        
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test 
        
    public void pisteidenNollausNollaaBonuspisteet() {
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(2);
        
        pelaaja.nollaaPisteet();
        
        assertEquals(0, pelaaja.bonuspisteet());
    }
    
    @Test 
        
    public void pisteidenNollausEiMuutaMitaanJosBonusPisteitaNolla() {
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(-1);
        pelaaja.kirjaaPisteet(2);
        
        pelaaja.nollaaPisteet();
        
        assertEquals(0, pelaaja.bonuspisteet());
    }
    
    
}
