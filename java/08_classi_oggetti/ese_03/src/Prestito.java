/**
 * Un prestito attivo.
 * Attributi: isbn (String), utente (String), giorniPrevisti (int).
 */
public class Prestito {

    // TODO: dichiara gli attributi privati

    /** Costruttore completo. */
    public Prestito(String isbn, String utente, int giorniPrevisti) {
        // TODO
    }

    /** Costruttore (overloading): durata standard di 14 giorni. */
    public Prestito(String isbn, String utente) {
        // TODO
    }

    public String getIsbn() {
        return null; // TODO
    }

    public String getUtente() {
        return null; // TODO
    }

    public int getGiorniPrevisti() {
        return 0; // TODO
    }

    /** Imposta i giorni previsti solo se sono maggiori di 0, altrimenti non modifica nulla. */
    public void setGiorniPrevisti(int giorniPrevisti) {
        // TODO
    }

    /**
     * Formato richiesto (esempio): mario ha in prestito 978-1 per 14 giorni
     */
    @Override
    public String toString() {
        return null; // TODO
    }
}
