public class App {
    public static void main(String[] args) throws Exception {
        Libro libro = new Libro();
        // Non possiamo accedere direttamente agli attributi privati della classe Libro.
        // libro.titolo = "Il Nome della Rosa";
        // libro.autore = "Umberto Eco";
        // libro.annoPubblicazione = 1980;

        // Per risolvere questo problema, dovremmo utilizzare metodi getter e setter nella classe Libro.
    }
}
