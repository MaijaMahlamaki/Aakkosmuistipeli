package muistipeli.pelaaja;

import java.text.DecimalFormat;

/**
 * Luokka tarjoaa metodeita pelaajan pisteiden laskemiseen ja pelin päätyttyä
 * ilmestyvään viestiin.
 *
 */
public class Pelaaja {

    private String nimi;
    private int pisteet;
    private int edellisetPisteet;
    private int bonuspisteet;
    private int kierrokset;
    private int yhteispisteet;
    private double keskiarvo;

    /**
     * Pelaaja saa konstruktorin parametrina pelaajan nimen. Konstruktorissa
     * asetetaan pisteet, bonuspisteet, kierrokset, yhteispisteet ja kierrosten
     * pisteiden keskiarvo alkamaan nollasta.
     *
     * @param nimi pelaajan nimi
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.bonuspisteet = 0;
        this.kierrokset = 0;
        this.yhteispisteet = 0;
        this.keskiarvo = 0.0;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    /**
     * Pistelaskumetodi huolehtii pelaajan pisteiden kirjaamisesta. Pistelasku
     * menee niin, että löydetystä parista saa kaksi pistettä. Jos paria ei
     * löytynyt, pelaaja saa miinuspisteen. Kahden parin löytämisestä peräkkäin
     * saa kaksi bonuspistettä. Metodi päivittää aina samalla myös pelien
     * yhteispisteet, jotta pelaajalle voidaan näyttää pelin lopuksi tämän ja
     * mahdollisten aiempien pelien yhteispisteet ja pistekeskiarvo.
     *
     * @param pisteet muistipelin välittämä pistemäärä, joka on joko 2 parin
     * löytämisestä tai -1 hudista.
     *
     */
    public void kirjaaPisteet(int pisteet) {

        if (edellisetPisteet == 2 && pisteet == 2) {
            this.pisteet = this.pisteet + 2;
            this.bonuspisteet = this.bonuspisteet + 2;
            this.yhteispisteet = this.yhteispisteet + 2 + 2;

        } else {

            this.pisteet = this.pisteet + pisteet;
            this.yhteispisteet = this.yhteispisteet + pisteet;
        }
        edellisetPisteet = pisteet;
    }

    /**
     * Metodi palauttaa pelaajan pelin aikana keräämien bonuspisteiden määrän.
     *
     * @return bonuspisteet
     */
    public int bonuspisteet() {

        return bonuspisteet;
    }

    /**
     * Metodissa määritellään viesti, jonka pelaaja saa pelin lopussa. Viesti
     * vaihtelee sen mukaan, kuinka hyvin pelaaja pärjäsi pelissä eli kerättyjen
     * pisteiden ja bonuspisteiden mukaan.
     *
     * @return kierroksen pisteiden mukaan räätälöity viesti
     */
    public String loppuViesti() {
        String viesti = "";

        if (pisteet > 4 && bonuspisteet > 4) {
            viesti = "Huikea suoritus " + nimi + ", olet varsinainen muistiguru!"
                    + "\nKeräsit " + pisteet
                    + " pistettä ja " + bonuspisteet
                    + " bonuspistettä!"
                    + "\nLoistavaa!"
                    + "\nPelatut kierrokset: " + kierrokset
                    + "\nYhteispisteet: " + yhteispisteet
                    + "\nPisteiden keskiarvo: " + keskiArvo();
        } else if (pisteet > 2 && bonuspisteet > 2) {
            viesti = "Hieno suoritus " + nimi + ", olet varsin etevä muistaja!"
                    + "\nKeräsit " + pisteet
                    + " pistettä ja " + bonuspisteet
                    + " bonuspistettä! Loistavaa!"
                    + "\nPelatut kierrokset: " + kierrokset
                    + "\nYhteispisteet: " + yhteispisteet
                    + "\nPisteiden keskiarvo: " + keskiArvo();
        } else if (pisteet < 0 && bonuspisteet > 2) {
            viesti = "Hyvä " + nimi + ", löysit kaikki parit!"
                    + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, sait yhteensä "
                    + pisteet + " pistettä, mutta keräsit kuitenkin " + bonuspisteet + " bonuspistettä."
                    + "\nPelatut kierrokset: " + kierrokset
                    + "\nYhteispisteet: " + yhteispisteet
                    + "\nPisteiden keskiarvo: " + keskiArvo();
        } else if (pisteet < 0 && bonuspisteet == 2) {
            viesti = "Hyvä " + nimi + ", löysit kaikki parit!"
                    + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, sait yhteensä "
                    + pisteet + " pistettä ja "
                    + bonuspisteet + " bonuspistettä."
                    + "\nParempi onni ensi kerralla, eikun treenailemaan lisää!"
                    + "\nPelatut kierrokset: " + kierrokset
                    + "\nYhteispisteet: " + yhteispisteet
                    + "\nPisteiden keskiarvo: " + keskiArvo();
        }

        return viesti;

    }

    /**
     * Metodi lisaa pelaajalle yhden pelikierroksen, jotta pelaajalle voidaan
     * ilmoittaa pelin lopuksi, montako kierrosta hän on pelannut ja laskea
     * kaikkien pelien pistekeskiarvo.
     */
    public void lisaaKierros() {
        this.kierrokset = this.kierrokset + 1;
    }

    /**
     * Metodi palauttaa pelaajan pelaamien kierrosten lukumäärän.
     *
     * @return kierrosten lukumäärä
     */
    public int kierrokset() {
        return this.kierrokset;
    }

    /**
     * Metodi palauttaa kaikkien pelaajan pelaamien kierrosten pisteiden summan.
     *
     * @return yhteispisteet
     */
    public int yhteisPisteet() {
        return yhteispisteet;
    }

    /**
     * Metodi laskee yhteispisteiden ja kierrosten lukumäärän perusteella
     * pelattujen kierrosten pistekeskiarvon.
     *
     * @return keskiarvo
     */
    public double keskiArvo() {
        this.keskiarvo = (double) this.yhteispisteet / this.kierrokset;
        return keskiarvo;
    }

    /**
     * Metodilla nollataan pisteet kierrosten välillä, jotta seuraavan
     * kierroksen pistelasku aloitetaan aina nollasta sekä normaaleilla että
     * bonuspisteillä.
     */
    public void nollaaPisteet() {
        this.pisteet = 0;
        this.bonuspisteet = 0;
    }
}
