package ohtu.kivipaperisakset;


import java.util.Scanner;

public abstract class KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static KiviPaperiSakset luoPeli(String peliTapa) {
        if (peliTapa.equals("a")) {
            return new KPSPelaajaVsPelaaja();
        } else if (peliTapa.equals("b")) {
            return new KPSTekoaly();
        } else {
            return new KPSParempiTekoaly();
        }
    }
    
    // tämä on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
           tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
           System.out.println(tuomari);
           System.out.println();
           
           ekanSiirto = ensimmaisenSiirto();
           tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}