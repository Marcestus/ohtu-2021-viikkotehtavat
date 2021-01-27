package ohtu.verkkokauppa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements Pankki_Interface {

    private static Pankki instanssi;

    /*
    public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    }
    */
    
    private Kirjanpito kirjanpito;

    /*
    public Pankki() {
        kirjanpito = Kirjanpito.getInstance();
    }
    */

    @Autowired
    public Pankki(Kirjanpito kirjanpito) {
        this.kirjanpito = new Kirjanpito();
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}