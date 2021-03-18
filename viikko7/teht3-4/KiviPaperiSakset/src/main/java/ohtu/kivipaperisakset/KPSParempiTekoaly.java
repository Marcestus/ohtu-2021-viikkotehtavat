package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    
    @Override
    protected String toisenSiirto() {
        String toisenSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokonevastuksen siirto: " + "\n" + toisenSiirto);
        return toisenSiirto;
    }
}
