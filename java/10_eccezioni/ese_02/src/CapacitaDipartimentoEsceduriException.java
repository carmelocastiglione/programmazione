/**
 * Eccezione lanciata quando la capacità massima del dipartimento è stata raggiunta.
 */
public class CapacitaDipartimentoEsceduriException extends Exception {
    public CapacitaDipartimentoEsceduriException(String messaggio) {
        super(messaggio);
    }
}
