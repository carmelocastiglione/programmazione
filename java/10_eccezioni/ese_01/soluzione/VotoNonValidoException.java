/**
 * Eccezione lanciata quando un voto non è valido
 * (non è compreso tra 0 e 30).
 */
public class VotoNonValidoException extends Exception {
    public VotoNonValidoException(String messaggio) {
        super(messaggio);
    }
}
