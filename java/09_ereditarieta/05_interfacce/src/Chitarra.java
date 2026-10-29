/**
 * Chitarra
 */

// Esempio di ereditarietà multipla tramite interfacce
public class Chitarra implements StrumentoMusicale, StrumentoACorde {

    @Override
    public void suona() {
        System.out.println("La chitarra sta suonando");
    }
    
    @Override
    public void numeroCorde() {
        System.out.println("La chitarra ha 6 corde");
    }

}
