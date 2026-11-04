/**
 * Un libro della biblioteca.
 * Attributi: isbn (String), titolo (String), copieTotali (int),
 * copieDisponibili (int), numPrestiti (int, contatore storico dei prestiti).
 */
public class Libro {

    // TODO: dichiara gli attributi privati

    /** Costruttore completo: all'inizio tutte le copie sono disponibili e i prestiti sono 0. */
    public Libro(String isbn, String titolo, int copieTotali) {
        // TODO
    }

    /** Costruttore (overloading): il libro ha una sola copia. */
    public Libro(String isbn, String titolo) {
        // TODO
    }

    public String getIsbn() {
        return null; // TODO
    }

    public String getTitolo() {
        return null; // TODO
    }

    public int getCopieTotali() {
        return 0; // TODO
    }

    public int getCopieDisponibili() {
        return 0; // TODO
    }

    public int getNumPrestiti() {
        return 0; // TODO
    }

    /**
     * Imposta le copie totali solo se il valore è >= 1 e non è inferiore alle copie
     * attualmente in prestito, altrimenti non modifica nulla.
     * Le copie disponibili si adeguano (totali - copie in prestito).
     */
    public void setCopieTotali(int copieTotali) {
        // TODO
    }

    /**
     * Presta una copia: diminuisce le disponibili e aumenta numPrestiti.
     * Restituisce false (senza modifiche) se non ci sono copie disponibili.
     */
    public boolean presta() {
        return false; // TODO
    }

    /**
     * Rientra una copia: aumenta le disponibili.
     * Restituisce false (senza modifiche) se tutte le copie sono già in biblioteca.
     */
    public boolean restituisci() {
        return false; // TODO
    }

    /**
     * Formato richiesto (esempio): [978-1] Dune | copie: 2/3 | prestiti: 5
     */
    @Override
    public String toString() {
        return null; // TODO
    }
}
