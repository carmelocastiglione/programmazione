public class Prestito {
    private String isbn;
    private String utente;
    private int giorniPrevisti;

    public Prestito(String isbn, String utente, int giorniPrevisti) {
        this.isbn = isbn;
        this.utente = utente;
        this.giorniPrevisti = giorniPrevisti;
    }

    public Prestito(String isbn, String utente) {
        this(isbn, utente, 14);
    }

    public String getIsbn() { return isbn; }

    public String getUtente() { return utente; }

    public int getGiorniPrevisti() { return giorniPrevisti; }

    public void setGiorniPrevisti(int giorniPrevisti) {
        if (giorniPrevisti > 0) this.giorniPrevisti = giorniPrevisti;
    }

    @Override
    public String toString() {
        return utente + " ha in prestito " + isbn + " per " + giorniPrevisti + " giorni";
    }
}
