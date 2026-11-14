/**
 * Eccezione lanciata quando uno stipendio non è valido (negativo o zero).
 */
public class StipendioNegativoException extends Exception {
    public StipendioNegativoException(String messaggio) {
        super(messaggio);
    }
}
