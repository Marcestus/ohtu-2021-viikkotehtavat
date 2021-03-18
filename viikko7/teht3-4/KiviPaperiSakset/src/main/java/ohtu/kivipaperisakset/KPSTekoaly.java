package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    Tekoaly tekoaly = new Tekoaly();
    
    @Override
    protected String toisenSiirto() {
        String toisenSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokonevastuksen siirto: " + "\n" + toisenSiirto);
        return toisenSiirto;
    }
}