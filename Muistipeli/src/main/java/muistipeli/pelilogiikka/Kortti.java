package muistipeli.pelilogiikka;

/**
 * Luokka määrittelee korttiolion, johon liittyy aina tietty kirjain.
 *
 */
public class Kortti {

    private String kirjain;

    public Kortti(String kirjain) {
        this.kirjain = kirjain;
    }

    public String getKirjain() {
        return this.kirjain;
    }

}
