import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestoreBibliotecaTest {

    private GestoreBiblioteca biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new GestoreBiblioteca(4, 3);
        biblioteca.aggiungi(new Libro("978-1", "Dune", 3));
        biblioteca.aggiungi(new Libro("978-2", "Emma", 1));
        biblioteca.aggiungi(new Libro("978-3", "Ulisse", 2));
    }

    @Test
    void aggiungiIncrementaIlNumeroDiLibri() {
        assertEquals(3, biblioteca.getNumLibri());
        assertTrue(biblioteca.aggiungi(new Libro("978-4", "Odissea")));
        assertEquals(4, biblioteca.getNumLibri());
    }

    @Test
    void aggiungiFallisceSePieno() {
        biblioteca.aggiungi(new Libro("978-4", "Odissea"));
        assertFalse(biblioteca.aggiungi(new Libro("978-5", "Iliade")));
        assertEquals(4, biblioteca.getNumLibri());
    }

    @Test
    void aggiungiFallisceSeIsbnDuplicato() {
        assertFalse(biblioteca.aggiungi(new Libro("978-2", "Altro titolo")));
        assertEquals(3, biblioteca.getNumLibri());
    }

    @Test
    void cercaPerIsbn() {
        Libro libro = biblioteca.cerca("978-3");
        assertNotNull(libro);
        assertEquals("Ulisse", libro.getTitolo());
    }

    @Test
    void cercaIsbnInesistenteRestituisceNull() {
        assertNull(biblioteca.cerca("000"));
    }

    @Test
    void cercaPerCopieDisponibiliIncludeGliEstremi() {
        Libro[] trovati = biblioteca.cerca(2, 3);
        assertEquals(2, trovati.length);
        assertEquals("978-1", trovati[0].getIsbn());
        assertEquals("978-3", trovati[1].getIsbn());
    }

    @Test
    void cercaPerCopieSenzaRisultatiRestituisceVettoreVuoto() {
        Libro[] trovati = biblioteca.cerca(10, 20);
        assertNotNull(trovati);
        assertEquals(0, trovati.length);
    }

    @Test
    void prestaRegistraIlPrestitoEAggiornaIlLibro() {
        assertTrue(biblioteca.presta("978-1", "mario", 7));
        assertEquals(1, biblioteca.getNumPrestiti());
        assertEquals(2, biblioteca.cerca("978-1").getCopieDisponibili());
        assertEquals(1, biblioteca.cerca("978-1").getNumPrestiti());
    }

    @Test
    void prestaFallisceSeLibroInesistente() {
        assertFalse(biblioteca.presta("000", "mario", 7));
        assertEquals(0, biblioteca.getNumPrestiti());
    }

    @Test
    void prestaFallisceSeGiorniNonValidi() {
        assertFalse(biblioteca.presta("978-1", "mario", 0));
        assertFalse(biblioteca.presta("978-1", "mario", -5));
        assertEquals(0, biblioteca.getNumPrestiti());
        assertEquals(3, biblioteca.cerca("978-1").getCopieDisponibili());
    }

    @Test
    void prestaFallisceSeNonCiSonoCopie() {
        assertTrue(biblioteca.presta("978-2", "mario", 7));
        assertFalse(biblioteca.presta("978-2", "anna", 7));
        assertEquals(1, biblioteca.getNumPrestiti());
    }

    @Test
    void prestaFallisceSeStessoUtenteHaGiaIlLibro() {
        assertTrue(biblioteca.presta("978-1", "mario", 7));
        assertFalse(biblioteca.presta("978-1", "mario", 7));
        assertEquals(1, biblioteca.getNumPrestiti());
        assertEquals(2, biblioteca.cerca("978-1").getCopieDisponibili());
    }

    @Test
    void prestaFallisceSeVettorePrestitiPieno() {
        assertTrue(biblioteca.presta("978-1", "mario", 7));
        assertTrue(biblioteca.presta("978-1", "anna", 7));
        assertTrue(biblioteca.presta("978-3", "mario", 7));
        assertFalse(biblioteca.presta("978-1", "luca", 7));
        assertEquals(3, biblioteca.getNumPrestiti());
        assertEquals(1, biblioteca.cerca("978-1").getCopieDisponibili());
    }

    @Test
    void restituisciInTempoNonHaMulta() {
        biblioteca.presta("978-1", "mario", 7);
        assertEquals(0, biblioteca.restituisci("978-1", "mario", 7), 0.0001);
        assertEquals(0, biblioteca.getNumPrestiti());
        assertEquals(3, biblioteca.cerca("978-1").getCopieDisponibili());
        assertEquals(0, biblioteca.incassoMulte(), 0.0001);
    }

    @Test
    void restituisciInRitardoCalcolaLaMulta() {
        biblioteca.presta("978-1", "mario", 7);
        assertEquals(2.0, biblioteca.restituisci("978-1", "mario", 11), 0.0001);
        assertEquals(2.0, biblioteca.incassoMulte(), 0.0001);
    }

    @Test
    void multeSiSommano() {
        biblioteca.presta("978-1", "mario", 7);
        biblioteca.presta("978-3", "anna", 5);
        biblioteca.restituisci("978-1", "mario", 9);
        biblioteca.restituisci("978-3", "anna", 6);
        assertEquals(1.5, biblioteca.incassoMulte(), 0.0001);
    }

    @Test
    void restituisciPrestitoInesistenteRestituisceMenoUno() {
        biblioteca.presta("978-1", "mario", 7);
        assertEquals(-1, biblioteca.restituisci("978-1", "anna", 7), 0.0001);
        assertEquals(-1, biblioteca.restituisci("978-2", "mario", 7), 0.0001);
        assertEquals(1, biblioteca.getNumPrestiti());
    }

    @Test
    void restituisciGiorniNonValidiNonModificaNulla() {
        biblioteca.presta("978-1", "mario", 7);
        assertEquals(-1, biblioteca.restituisci("978-1", "mario", 0), 0.0001);
        assertEquals(1, biblioteca.getNumPrestiti());
        assertEquals(2, biblioteca.cerca("978-1").getCopieDisponibili());
    }

    @Test
    void restituisciMantieneGliAltriPrestitiInOrdine() {
        biblioteca.presta("978-1", "mario", 7);
        biblioteca.presta("978-2", "mario", 7);
        biblioteca.presta("978-3", "mario", 7);
        biblioteca.restituisci("978-2", "mario", 7);
        String[] isbn = biblioteca.prestitiUtente("mario");
        assertEquals(2, isbn.length);
        assertEquals("978-1", isbn[0]);
        assertEquals("978-3", isbn[1]);
    }

    @Test
    void restituisciLiberaPostoNelVettorePrestiti() {
        biblioteca.presta("978-1", "mario", 7);
        biblioteca.presta("978-1", "anna", 7);
        biblioteca.presta("978-3", "mario", 7);
        biblioteca.restituisci("978-1", "anna", 7);
        assertTrue(biblioteca.presta("978-1", "luca", 7));
    }

    @Test
    void rimuoviLibroSenzaPrestiti() {
        assertTrue(biblioteca.rimuovi("978-2"));
        assertEquals(2, biblioteca.getNumLibri());
        assertNull(biblioteca.cerca("978-2"));
        assertNotNull(biblioteca.cerca("978-3"));
    }

    @Test
    void rimuoviFallisceSeCiSonoCopieInPrestito() {
        biblioteca.presta("978-1", "mario", 7);
        assertFalse(biblioteca.rimuovi("978-1"));
        assertEquals(3, biblioteca.getNumLibri());
    }

    @Test
    void rimuoviFallisceSeInesistente() {
        assertFalse(biblioteca.rimuovi("000"));
        assertEquals(3, biblioteca.getNumLibri());
    }

    @Test
    void libroPiuRichiesto() {
        biblioteca.presta("978-1", "mario", 7);
        biblioteca.restituisci("978-1", "mario", 7);
        biblioteca.presta("978-3", "mario", 7);
        biblioteca.presta("978-3", "anna", 7);
        assertEquals("978-3", biblioteca.libroPiuRichiesto().getIsbn());
    }

    @Test
    void libroPiuRichiestoSuCatalogoVuotoRestituisceNull() {
        assertNull(new GestoreBiblioteca(3, 3).libroPiuRichiesto());
    }

    @Test
    void contaLibriEsauriti() {
        assertEquals(0, biblioteca.contaLibriEsauriti());
        biblioteca.presta("978-2", "mario", 7);
        assertEquals(1, biblioteca.contaLibriEsauriti());
        biblioteca.presta("978-3", "mario", 7);
        biblioteca.presta("978-3", "anna", 7);
        assertEquals(2, biblioteca.contaLibriEsauriti());
    }

    @Test
    void prestitiUtente() {
        biblioteca.presta("978-1", "mario", 7);
        biblioteca.presta("978-2", "anna", 7);
        biblioteca.presta("978-3", "mario", 7);
        String[] isbn = biblioteca.prestitiUtente("mario");
        assertEquals(2, isbn.length);
        assertEquals("978-1", isbn[0]);
        assertEquals("978-3", isbn[1]);
    }

    @Test
    void prestitiUtenteSenzaPrestitiRestituisceVettoreVuoto() {
        String[] isbn = biblioteca.prestitiUtente("nessuno");
        assertNotNull(isbn);
        assertEquals(0, isbn.length);
    }

    @Test
    void toStringUnaRigaPerLibro() {
        biblioteca.presta("978-1", "mario", 7);
        String atteso = "[978-1] Dune | copie: 2/3 | prestiti: 1\n"
                + "[978-2] Emma | copie: 1/1 | prestiti: 0\n"
                + "[978-3] Ulisse | copie: 2/2 | prestiti: 0\n";
        assertEquals(atteso, biblioteca.toString());
    }

    @Test
    void toStringCatalogoVuoto() {
        assertEquals("", new GestoreBiblioteca(3, 3).toString());
    }
}
