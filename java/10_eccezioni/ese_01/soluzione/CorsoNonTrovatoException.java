/**
 * Eccezione lanciata quando un corso non è trovato.
 */
public class CorsoNonTrovatoException extends Exception {
    public CorsoNonTrovatoException(String messaggio) {
        super(messaggio);
    }
}
