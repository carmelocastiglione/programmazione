/**
 * Eccezione lanciata quando un dipendente non è trovato.
 */
public class DipendenteNonTrovatoException extends Exception {
    public DipendenteNonTrovatoException(String messaggio) {
        super(messaggio);
    }
}
