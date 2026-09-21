/**
 * Libro
 */
public class Libro {
    private String titolo = "I Promessi Sposi";
    private String autore = "Alessandro Manzoni";
    private int annoPubblicazione = 1840;
    
    @Override
    public String toString() {
        return "Libro [titolo=" + titolo + ", autore=" + autore + ", annoPubblicazione=" + annoPubblicazione + "]";
    }
}
