package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        
        this.tulosEnnenKomentoa = sovellus.tulos();
        
        sovellus.nollaa();
        
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        
        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + this.tulosEnnenKomentoa);
        
        sovellus.setTulos(this.tulosEnnenKomentoa);
    }
    
}
