/**
 * Gestisce i veicoli parcheggiati usando un vettore (niente ArrayList).
 * I veicoli occupano le prime numVeicoli posizioni del vettore a capacità fissa.
 */
public class GestoreParcheggio {

    // TODO: dichiara il vettore di Veicolo, numVeicoli e l'incasso totale

    /** Crea un parcheggio con la capacità massima indicata. */
    public GestoreParcheggio(int capacita) {
        // TODO
    }

    public int getNumVeicoli() {
        return 0; // TODO
    }

    /**
     * Parcheggia il veicolo in coda.
     * Restituisce false se il parcheggio è pieno o se la targa è già presente.
     */
    public boolean parcheggia(Veicolo veicolo) {
        return false; // TODO
    }

    /** Restituisce il veicolo con la targa indicata, null se non è parcheggiato. */
    public Veicolo cerca(String targa) {
        return null; // TODO
    }

    /**
     * Overloading: restituisce un vettore (di dimensione esatta) con i veicoli
     * la cui tariffa oraria è compresa tra min e max (estremi inclusi).
     * Se non ce ne sono restituisce un vettore di lunghezza 0.
     */
    public Veicolo[] cerca(double min, double max) {
        return null; // TODO
    }

    /**
     * Registra l'uscita, aggiorna l'incasso con tariffa oraria * ore e libera il posto.
     * Restituisce false se la targa non è parcheggiata o se ore <= 0.
     */
    public boolean uscita(String targa, int ore) {
        return false; // TODO
    }

    /** Somma degli incassi registrati con le uscite. */
    public double incassoTotale() {
        return 0; // TODO
    }

    /** Veicolo parcheggiato con la tariffa oraria più alta, null se il parcheggio è vuoto. */
    public Veicolo veicoloPiuCostoso() {
        return null; // TODO
    }

    /** Numero di veicoli parcheggiati con tariffa strettamente minore della soglia. */
    public int contaSottoTariffa(double soglia) {
        return 0; // TODO
    }

    /** Vettore (di dimensione esatta) con le targhe nell'ordine di parcheggio. */
    public String[] targheParcheggiate() {
        return null; // TODO
    }

    /** Una riga per veicolo (usa il toString di Veicolo), ognuna terminata da "\n". */
    @Override
    public String toString() {
        return null; // TODO
    }
}
