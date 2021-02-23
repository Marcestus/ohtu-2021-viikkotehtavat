
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = luoJoukko(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti negatiivinen");
        }
        ljono = luoJoukko(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti tai kasvatuskoko negatiivinen");
        }
        ljono = luoJoukko(kapasiteetti, kasvatuskoko);
    }
    
    public int[] luoJoukko(int kapasiteetti, int kasvatuskoko) {
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
        return ljono;
    }

    public boolean lisaaLukuJoukkoon(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluukoLukuJoJoukkoon(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                kasvataTaulukonKokoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluukoLukuJoJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }
    
    public void kasvataTaulukonKokoa() {
        int[] taulukkoOld = ljono.clone();
        ljono = new int[alkioidenLkm + kasvatuskoko];
        for (int i = 0; i < taulukkoOld.length; i++) {
            ljono[i] = taulukkoOld[i];
        }
    }

    public boolean poistaLukuJoukostaJosSeKuuluuSiihen(int luku) {
        int poistettuLuku = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                poistettuLuku = i;
                ljono[poistettuLuku] = 0;
                siirraLuvutEteenpain(poistettuLuku);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }
    
    public void siirraLuvutEteenpain(int poistettuLuku) {
        int apu = -1;
        for (int i = poistettuLuku; i < alkioidenLkm - 1; i++) {
            apu = ljono[i];
            ljono[i] = ljono[i + 1];
            ljono[i + 1] = apu;
        }
    }

    public int joukonKoko() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String joukkoStringina = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                joukkoStringina += ljono[i];
                joukkoStringina += ", ";
            }
            joukkoStringina += ljono[alkioidenLkm - 1];
            joukkoStringina += "}";
            return joukkoStringina;
        }
    }

    public int[] toIntArray() {
        int[] alkiotTaulukossa = new int[alkioidenLkm];
        for (int i = 0; i < alkiotTaulukossa.length; i++) {
            alkiotTaulukossa[i] = ljono[i];
        }
        return alkiotTaulukossa;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aAlkiotTaulukossa = a.toIntArray();
        int[] bAlkiotTaulukossa = b.toIntArray();
        for (int i = 0; i < aAlkiotTaulukossa.length; i++) {
            yhdisteJoukko.lisaaLukuJoukkoon(aAlkiotTaulukossa[i]);
        }
        for (int i = 0; i < bAlkiotTaulukossa.length; i++) {
            yhdisteJoukko.lisaaLukuJoukkoon(bAlkiotTaulukossa[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aAlkiotTaulukossa = a.toIntArray();
        int[] bAlkiotTaulukossa = b.toIntArray();
        for (int i = 0; i < aAlkiotTaulukossa.length; i++) {
            for (int j = 0; j < bAlkiotTaulukossa.length; j++) {
                if (aAlkiotTaulukossa[i] == bAlkiotTaulukossa[j]) {
                    leikkausJoukko.lisaaLukuJoukkoon(bAlkiotTaulukossa[j]);
                }
            }
        }
        return leikkausJoukko;

    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aAlkiotTaulukossa = a.toIntArray();
        int[] bAlkiotTaulukossa = b.toIntArray();
        for (int i = 0; i < aAlkiotTaulukossa.length; i++) {
            erotusJoukko.lisaaLukuJoukkoon(aAlkiotTaulukossa[i]);
        }
        for (int i = 0; i < bAlkiotTaulukossa.length; i++) {
            erotusJoukko.poistaLukuJoukostaJosSeKuuluuSiihen(bAlkiotTaulukossa[i]);
        }
 
        return erotusJoukko;
    }
}
