/**
 * Eccezione lanciata quando la capacità massima di un corso è stata raggiunta.
 */
public class CapacitaCorsoEsceduriException extends Exception {
    public CapacitaCorsoEsceduriException(String messaggio) {
        super(messaggio);
    }
}
