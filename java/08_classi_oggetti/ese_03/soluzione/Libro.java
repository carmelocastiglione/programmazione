public class Libro {
    private String isbn;
    private String titolo;
    private int copieTotali;
    private int copieDisponibili;
    private int numPrestiti;

    public Libro(String isbn, String titolo, int copieTotali) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.copieTotali = copieTotali;
        this.copieDisponibili = copieTotali;
        this.numPrestiti = 0;
    }

    public Libro(String isbn, String titolo) {
        this(isbn, titolo, 1);
    }

    public String getIsbn() { return isbn; }

    public String getTitolo() { return titolo; }

    public int getCopieTotali() { return copieTotali; }

    public int getCopieDisponibili() { return copieDisponibili; }

    public int getNumPrestiti() { return numPrestiti; }

    public void setCopieTotali(int copieTotali) {
        int inPrestito = this.copieTotali - copieDisponibili;
        if (copieTotali < 1 || copieTotali < inPrestito) return;
        this.copieTotali = copieTotali;
        this.copieDisponibili = copieTotali - inPrestito;
    }

    public boolean presta() {
        if (copieDisponibili == 0) return false;
        copieDisponibili--;
        numPrestiti++;
        return true;
    }

    public boolean restituisci() {
        if (copieDisponibili == copieTotali) return false;
        copieDisponibili++;
        return true;
    }

    @Override
    public String toString() {
        return "[" + isbn + "] " + titolo + " | copie: " + copieDisponibili + "/" + copieTotali
                + " | prestiti: " + numPrestiti;
    }
}
