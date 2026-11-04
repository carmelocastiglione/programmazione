public class GestoreBiblioteca {
    public static final double MULTA_GIORNALIERA = 0.5;

    private Libro[] libri;
    private int numLibri;
    private Prestito[] prestiti;
    private int numPrestiti;
    private double incassoMulte;

    public GestoreBiblioteca(int capacitaLibri, int capacitaPrestiti) {
        libri = new Libro[capacitaLibri];
        prestiti = new Prestito[capacitaPrestiti];
        numLibri = 0;
        numPrestiti = 0;
        incassoMulte = 0;
    }

    public int getNumLibri() { return numLibri; }

    public int getNumPrestiti() { return numPrestiti; }

    public boolean aggiungi(Libro libro) {
        if (numLibri == libri.length || cerca(libro.getIsbn()) != null) return false;
        libri[numLibri++] = libro;
        return true;
    }

    public Libro cerca(String isbn) {
        for (int i = 0; i < numLibri; i++) {
            if (libri[i].getIsbn().equals(isbn)) return libri[i];
        }
        return null;
    }

    public Libro[] cerca(int minCopie, int maxCopie) {
        int n = 0;
        for (int i = 0; i < numLibri; i++) {
            int c = libri[i].getCopieDisponibili();
            if (c >= minCopie && c <= maxCopie) n++;
        }
        Libro[] risultati = new Libro[n];
        int k = 0;
        for (int i = 0; i < numLibri; i++) {
            int c = libri[i].getCopieDisponibili();
            if (c >= minCopie && c <= maxCopie) risultati[k++] = libri[i];
        }
        return risultati;
    }

    private int indicePrestito(String isbn, String utente) {
        for (int i = 0; i < numPrestiti; i++) {
            if (prestiti[i].getIsbn().equals(isbn) && prestiti[i].getUtente().equals(utente)) return i;
        }
        return -1;
    }

    public boolean presta(String isbn, String utente, int giorni) {
        Libro libro = cerca(isbn);
        if (libro == null || giorni <= 0 || numPrestiti == prestiti.length
                || indicePrestito(isbn, utente) != -1) return false;
        if (!libro.presta()) return false;
        prestiti[numPrestiti++] = new Prestito(isbn, utente, giorni);
        return true;
    }

    public double restituisci(String isbn, String utente, int giorniEffettivi) {
        int i = indicePrestito(isbn, utente);
        if (i == -1 || giorniEffettivi <= 0) return -1;
        double multa = 0;
        int ritardo = giorniEffettivi - prestiti[i].getGiorniPrevisti();
        if (ritardo > 0) multa = ritardo * MULTA_GIORNALIERA;
        cerca(isbn).restituisci();
        for (int j = i; j < numPrestiti - 1; j++) prestiti[j] = prestiti[j + 1];
        prestiti[--numPrestiti] = null;
        incassoMulte += multa;
        return multa;
    }

    public boolean rimuovi(String isbn) {
        for (int i = 0; i < numLibri; i++) {
            if (libri[i].getIsbn().equals(isbn)) {
                if (libri[i].getCopieDisponibili() != libri[i].getCopieTotali()) return false;
                for (int j = i; j < numLibri - 1; j++) libri[j] = libri[j + 1];
                libri[--numLibri] = null;
                return true;
            }
        }
        return false;
    }

    public double incassoMulte() { return incassoMulte; }

    public Libro libroPiuRichiesto() {
        if (numLibri == 0) return null;
        Libro max = libri[0];
        for (int i = 1; i < numLibri; i++) {
            if (libri[i].getNumPrestiti() > max.getNumPrestiti()) max = libri[i];
        }
        return max;
    }

    public int contaLibriEsauriti() {
        int c = 0;
        for (int i = 0; i < numLibri; i++) if (libri[i].getCopieDisponibili() == 0) c++;
        return c;
    }

    public String[] prestitiUtente(String utente) {
        int n = 0;
        for (int i = 0; i < numPrestiti; i++) if (prestiti[i].getUtente().equals(utente)) n++;
        String[] isbn = new String[n];
        int k = 0;
        for (int i = 0; i < numPrestiti; i++) {
            if (prestiti[i].getUtente().equals(utente)) isbn[k++] = prestiti[i].getIsbn();
        }
        return isbn;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numLibri; i++) s += libri[i] + "\n";
        return s;
    }
}
