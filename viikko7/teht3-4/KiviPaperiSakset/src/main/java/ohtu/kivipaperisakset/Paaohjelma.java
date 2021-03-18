package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            tulostaKomennot();

            String vastaus = scanner.nextLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            if (vastaus.endsWith("a")) {
                KiviPaperiSakset.luoPeli("a").pelaa();
            } else if (vastaus.endsWith("b")) {
                KiviPaperiSakset.luoPeli("b").pelaa();
            } else if (vastaus.endsWith("c")) {
                KiviPaperiSakset.luoPeli("c").pelaa();
            } else {
                break;
            }
        }
    }
    
    public static void tulostaKomennot() {
        System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
    }
}
