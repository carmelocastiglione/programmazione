/**
 * Eccezione lanciata quando una matricola esiste già.
 */
public class MatricolaGiaEsisteException extends Exception {
    public MatricolaGiaEsisteException(String messaggio) {
        super(messaggio);
    }
}
