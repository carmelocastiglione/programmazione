/**
 * Film
 */
public class Film {
    private String titolo;
    private String regista;
    private int anno;

    public Film(String titolo, String regista, int anno) {
        this.titolo = titolo;
        this.regista = regista;
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titolo='" + titolo + '\'' +
                ", regista='" + regista + '\'' +
                ", anno=" + anno +
                '}';
    }
}
