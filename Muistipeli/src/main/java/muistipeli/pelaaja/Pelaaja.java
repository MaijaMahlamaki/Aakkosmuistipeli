package muistipeli.pelaaja;

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

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.bonuspisteet = 0;
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
     * saa kaksi bonuspistettä.
     *
     * @param pisteet muistipelin välittämä pistemäärä, joka on joko 2 parin
     * löytämisestä tai -1 hudista.
     *
     */
    public void kirjaaPisteet(int pisteet) {

        if (edellisetPisteet == 2 && pisteet == 2) {
            this.pisteet = this.pisteet + pisteet + 2;
            this.bonuspisteet = this.bonuspisteet + 2;

        } else {

            this.pisteet = this.pisteet + pisteet;
        }
        edellisetPisteet = pisteet;
    }

    /**
     * Metodi palauttaa pelaajan pelin aikana keräämien bonuspisteiden määrän.
     *
     */
    public int bonuspisteet() {

        return bonuspisteet;
    }

    /**
     * Metodissa määritellään viesti, jonka pelaaja saa pelin lopussa. Viesti
     * vaihtelee sen mukaan, kuinka hyvin pelaaja pärjäsi pelissä eli kerättyjen
     * pisteiden ja bonuspisteiden mukaan.
     *
     * @return
     */
    public String loppuViesti() {
        String viesti = "";

        if (pisteet > 0 && bonuspisteet > 0) {
            viesti = "Huikea suoritus " + nimi + ", olet varsinainen muistiguru!"
                    + "\nKeräsit bonuspisteitä " + bonuspisteet
                    + " ja lopullinen pistesaldosi on " + pisteet
                    + " pistettä!"
                    + "\nLoistavaa!";
        }
        if (pisteet > 0 && bonuspisteet == 0) {
            viesti = "Hieno suoritus " + nimi + ", olet varsin etevä muistaja!"
                    + "\nBonuspisteet jäivät tällä kertaa saamatta."
                    + "\nKeräsit siitä huolimatta kuitenkin " + pisteet
                    + " pistettä! Loistavaa!";
        }
        if (pisteet <= 0 && bonuspisteet > 0) {
            viesti = "Hyvä " + nimi + ", löysit kaikki parit!"
                    + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, sait yhteensä "
                    + pisteet + " pistettä."
                    + "\nKeräsit kuitenkin hienot " + bonuspisteet
                    + " bonuspistettä!";
        }
        if (pisteet <= 0 && bonuspisteet == 0) {
            viesti = "Hyvä " + nimi + ", löysit kaikki parit!"
                    + "\nPistesaldosi ei tällä kertaa ihan yltänyt plussan puolelle, sait yhteensä "
                    + pisteet + " pistettä."
                    + "\nParempi onni ensi kerralla, eikun treenailemaan lisää!";
        }

        return viesti;

    }

}
