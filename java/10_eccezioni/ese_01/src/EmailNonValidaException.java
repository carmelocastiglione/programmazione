/**
 * Eccezione lanciata quando un'email non è valida
 * (non contiene @ o è vuota).
 */
public class EmailNonValidaException extends Exception {
    public EmailNonValidaException(String messaggio) {
        super(messaggio);
    }
}
