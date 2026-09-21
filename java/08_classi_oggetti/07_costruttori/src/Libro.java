/**
 * Libro
 */
public class Libro {
    private String titolo;
    private String autore;
    private int annoPubblicazione;

    // Costruttore di default
    public Libro() {
        this.titolo = "";
        this.autore = "";
        this.annoPubblicazione = 0;
    }

    // Costruttore con parametri
    public Libro(String titolo, String autore, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString() {
        return "Libro [titolo=" + titolo + ", autore=" + autore + ", annoPubblicazione=" + annoPubblicazione + "]";
    }
}
