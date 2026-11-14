/**
 * Eccezione lanciata quando la capacità massima del dipartimento è stata raggiunta.
 */
public class CapacitaDipartimentoEsauritaException extends Exception {
    public CapacitaDipartimentoEsauritaException(String messaggio) {
        super(messaggio);
    }
}
