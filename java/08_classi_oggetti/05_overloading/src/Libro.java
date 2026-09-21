/**
 * Libro
 */
public class Libro {
    private String titolo = "I promessi sposi";
    private String autore = "Alessandro Manzoni";
    private String annoPubblicazione = "1840";
    private boolean prestato = false;
    private String presoInPrestitoDa = null;

    // Overloading del metodo presta: uno senza parametri e uno con il nome della persona che prende in prestito il libro
    public void presta() {
        this.prestato = true;
        this.presoInPrestitoDa = null;
    }

    public void presta(String nome) {
        this.prestato = true;
        this.presoInPrestitoDa = nome;
    }

    @Override
    public String toString() {
        return "Libro [titolo=" + titolo + ", autore=" + autore + ", annoPubblicazione=" + annoPubblicazione
                + ", prestato=" + prestato + ", presoInPrestitoDa=" + presoInPrestitoDa + "]";
    }
}
