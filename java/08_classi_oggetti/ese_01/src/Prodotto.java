/**
 * Un prodotto del magazzino.
 * Attributi: codice (String), nome (String), prezzo (double), quantita (int).
 */
public class Prodotto {

    // TODO: dichiara gli attributi privati

    /** Costruttore completo. */
    public Prodotto(String codice, String nome, double prezzo, int quantita) {
        // TODO
    }

    /** Costruttore (overloading): la quantita iniziale e' 0. */
    public Prodotto(String codice, String nome, double prezzo) {
        // TODO
    }

    public String getCodice() {
        return null; // TODO
    }

    public String getNome() {
        return null; // TODO
    }

    public double getPrezzo() {
        return 0; // TODO
    }

    public int getQuantita() {
        return 0; // TODO
    }

    /** Imposta il prezzo solo se e' maggiore di 0, altrimenti non modifica nulla. */
    public void setPrezzo(double prezzo) {
        // TODO
    }

    /** Imposta la quantita solo se e' >= 0, altrimenti non modifica nulla. */
    public void setQuantita(int quantita) {
        // TODO
    }

    /**
     * Formato richiesto (esempio): [P001] Penna | prezzo: 1.5 | quantita: 10
     */
    @Override
    public String toString() {
        return null; // TODO
    }
}
