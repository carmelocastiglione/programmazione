public class App {
    public static void main(String[] args) throws Exception {
        // Creo un oggetto della classe Libro
        Libro libro = new Libro();
        libro.titolo = "Il Nome della Rosa";
        libro.autore = "Umberto Eco";
        libro.annoPubblicazione = 1980;
        System.out.println("Titolo: " + libro.titolo);
        System.out.println("Autore: " + libro.autore);
        System.out.println("Anno di Pubblicazione: " + libro.annoPubblicazione);

        // Creo un altro oggetto della classe Libro, sovrascrivendo il riferimento precedente
        // L'oggetto precedente viene sovrascritto e non è più accessibile
        // La memoria occupata dall'oggetto precedente sarà liberata dal garbage collector
        libro = new Libro();
        libro.titolo = "1984";
        libro.autore = "George Orwell";
        libro.annoPubblicazione = 1949;
        System.out.println("Titolo: " + libro.titolo);
        System.out.println("Autore: " + libro.autore);
        System.out.println("Anno di Pubblicazione: " + libro.annoPubblicazione);

        // Gli oggetti possono avere attributi preimpostati
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Nome della Biblioteca: " + biblioteca.nome);
        // Posso anche modificare l'attributo preimpostato se necessario
        biblioteca.nome = "Biblioteca Comunale";
        System.out.println("Nome della Biblioteca aggiornato: " + biblioteca.nome);
    }
}
