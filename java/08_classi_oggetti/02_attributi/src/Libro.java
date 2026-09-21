/**
 * Libro
 */
public class Libro {
    /**
     * Attributi della classe Libro
     * A differenza dell'esempio precedente, questi attributi sono privati.
     * Questo significa che non possono essere direttamente accessibili dall'esterno della classe.
     * Per accedere a questi attributi dall'esterno della classe, sarà necessario utilizzare metodi getter e setter (che vedremo in seguito).
     * Gli attributi possono avere tre modalità di accesso:
     * 1. public: accessibile da qualsiasi classe.
     * 2. private: accessibile solo all'interno della classe stessa.
     * 3. protected: accessibile all'interno della classe stessa e dalle sottoclassi.
     * Questo meccanismo è noto come incapsulamento e permette di proteggere i dati all'interno della classe (information hiding).
     */
    private String titolo;
    private String autore;
    private int annoPubblicazione;
}
