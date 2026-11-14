/**
 * Eccezione lanciata quando la capacità massima di un corso è stata raggiunta.
 */
public class CapacitaCorsoEsauritaException extends Exception {
    public CapacitaCorsoEsauritaException(String messaggio) {
        super(messaggio);
    }
}
