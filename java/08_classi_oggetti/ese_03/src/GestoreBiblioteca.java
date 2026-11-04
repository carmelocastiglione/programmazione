/**
 * Gestisce libri e prestiti usando vettori (niente ArrayList).
 * I libri occupano le prime numLibri posizioni, i prestiti le prime numPrestiti.
 */
public class GestoreBiblioteca {

    /** Multa in euro per ogni giorno di ritardo. */
    public static final double MULTA_GIORNALIERA = 0.5;

    // TODO: dichiara i vettori di Libro e di Prestito, i due contatori e l'incasso delle multe

    /** Crea una biblioteca con le capacità massime indicate (libri e prestiti attivi). */
    public GestoreBiblioteca(int capacitaLibri, int capacitaPrestiti) {
        // TODO
    }

    public int getNumLibri() {
        return 0; // TODO
    }

    public int getNumPrestiti() {
        return 0; // TODO
    }

    /** Aggiunge il libro in coda. Restituisce false se non c'è posto o se l'ISBN è già presente. */
    public boolean aggiungi(Libro libro) {
        return false; // TODO
    }

    /** Restituisce il libro con l'ISBN indicato, null se non esiste. */
    public Libro cerca(String isbn) {
        return null; // TODO
    }

    /**
     * Overloading: restituisce un vettore (di dimensione esatta) con i libri il cui numero
     * di copie DISPONIBILI è compreso tra minCopie e maxCopie (estremi inclusi).
     * Se non ce ne sono restituisce un vettore di lunghezza 0.
     */
    public Libro[] cerca(int minCopie, int maxCopie) {
        return null; // TODO
    }

    /**
     * Registra un prestito di durata prevista "giorni" e aggiorna il libro.
     * Restituisce false (senza modifiche) se: il libro non esiste, non ci sono copie
     * disponibili, giorni <= 0, il vettore dei prestiti è pieno, oppure lo stesso utente
     * ha già in prestito quel libro.
     */
    public boolean presta(String isbn, String utente, int giorni) {
        return false; // TODO
    }

    /**
     * Chiude il prestito (isbn, utente), rimettendo la copia in biblioteca ed eliminando
     * il prestito dal vettore (gli elementi successivi scalano a sinistra).
     * Restituisce la multa: MULTA_GIORNALIERA * (giorniEffettivi - giorniPrevisti) se
     * giorniEffettivi supera i giorni previsti, altrimenti 0. La multa va sommata all'incasso.
     * Restituisce -1 (senza modifiche) se il prestito non esiste o se giorniEffettivi <= 0.
     */
    public double restituisci(String isbn, String utente, int giorniEffettivi) {
        return 0; // TODO
    }

    /**
     * Elimina il libro dal catalogo solo se tutte le sue copie sono in biblioteca.
     * Restituisce false se il libro non esiste o ha copie in prestito.
     */
    public boolean rimuovi(String isbn) {
        return false; // TODO
    }

    /** Somma delle multe riscosse con le restituzioni. */
    public double incassoMulte() {
        return 0; // TODO
    }

    /** Libro con più prestiti storici (numPrestiti), null se il catalogo è vuoto. */
    public Libro libroPiuRichiesto() {
        return null; // TODO
    }

    /** Numero di libri con 0 copie disponibili. */
    public int contaLibriEsauriti() {
        return 0; // TODO
    }

    /** Vettore (di dimensione esatta) con gli ISBN dei prestiti attivi dell'utente. */
    public String[] prestitiUtente(String utente) {
        return null; // TODO
    }

    /** Una riga per libro (usa il toString di Libro), ognuna terminata da "\n". */
    @Override
    public String toString() {
        return null; // TODO
    }
}
