/**
 * Gestisce un insieme di prodotti usando un vettore (niente ArrayList).
 * Il vettore ha capacita fissa; i prodotti occupano le prime numProdotti posizioni.
 */
public class GestoreMagazzino {

    // TODO: dichiara il vettore di Prodotto e il contatore numProdotti

    /** Crea un magazzino con la capacita massima indicata. */
    public GestoreMagazzino(int capacita) {
        // TODO
    }

    public int getNumProdotti() {
        return 0; // TODO
    }

    /**
     * Aggiunge il prodotto in coda.
     * Restituisce false se il magazzino e' pieno o se esiste gia' un prodotto con lo stesso codice.
     */
    public boolean aggiungi(Prodotto p) {
        return false; // TODO
    }

    /** Restituisce il prodotto con il codice indicato, null se non esiste. */
    public Prodotto cerca(String codice) {
        return null; // TODO
    }

    /**
     * Overloading: restituisce un vettore (di dimensione esatta) con i prodotti
     * il cui prezzo e' compreso tra min e max (estremi inclusi).
     * Se non ce ne sono restituisce un vettore di lunghezza 0.
     */
    public Prodotto[] cerca(double min, double max) {
        return null; // TODO
    }

    /** Aumenta la quantita del prodotto. Restituisce false se non esiste o se quantita <= 0. */
    public boolean carica(String codice, int quantita) {
        return false; // TODO
    }

    /**
     * Diminuisce la quantita del prodotto.
     * Restituisce false se non esiste, se quantita <= 0 o se la giacenza non e' sufficiente
     * (in tal caso la giacenza non cambia).
     */
    public boolean scarica(String codice, int quantita) {
        return false; // TODO
    }

    /** Rimuove il prodotto mantenendo compatto il vettore. Restituisce false se non esiste. */
    public boolean rimuovi(String codice) {
        return false; // TODO
    }

    /** Somma di prezzo * quantita di tutti i prodotti. */
    public double valoreTotale() {
        return 0; // TODO
    }

    /** Prodotto con il prezzo piu' alto, null se il magazzino e' vuoto. */
    public Prodotto piuCostoso() {
        return null; // TODO
    }

    /** Numero di prodotti con quantita strettamente minore della soglia. */
    public int contaSottoScorta(int soglia) {
        return 0; // TODO
    }

    /** Vettore (di dimensione esatta) con i nomi di tutti i prodotti, nello stesso ordine del magazzino. */
    public String[] nomiProdotti() {
        return null; // TODO
    }

    /** Una riga per prodotto (usa il toString di Prodotto), ognuna terminata da "\n". */
    @Override
    public String toString() {
        return null; // TODO
    }
}
