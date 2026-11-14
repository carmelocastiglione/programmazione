/**
 * Eccezione lanciata quando il numero di ore di lavoro non è valido.
 */
public class OreNonValidaException extends Exception {
    public OreNonValidaException(String messaggio) {
        super(messaggio);
    }
}
