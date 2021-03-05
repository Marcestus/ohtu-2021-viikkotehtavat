package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        
        this.tulosEnnenKomentoa = sovellus.tulos();
        
        try {
            sovellus.plus(Integer.parseInt(syotekentta.getText()));
        } catch (Exception e) {
            System.out.println("Lukua ei syötetty!");
        }    
        
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
