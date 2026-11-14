/**
 * Eccezione lanciata quando un dipendente non è trovato.
 */
public class DipendentNonTrovatoException extends Exception {
    public DipendentNonTrovatoException(String messaggio) {
        super(messaggio);
    }
}
