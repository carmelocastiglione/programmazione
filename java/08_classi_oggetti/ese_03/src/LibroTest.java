import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LibroTest {

    @Test
    void costruttoreCompletoEGetter() {
        Libro libro = new Libro("978-1", "Dune", 3);
        assertEquals("978-1", libro.getIsbn());
        assertEquals("Dune", libro.getTitolo());
        assertEquals(3, libro.getCopieTotali());
        assertEquals(3, libro.getCopieDisponibili());
        assertEquals(0, libro.getNumPrestiti());
    }

    @Test
    void costruttoreSenzaCopieHaUnaCopia() {
        Libro libro = new Libro("978-2", "Emma");
        assertEquals(1, libro.getCopieTotali());
        assertEquals(1, libro.getCopieDisponibili());
        assertEquals(0, libro.getNumPrestiti());
    }

    @Test
    void prestaAggiornaDisponibiliEPrestiti() {
        Libro libro = new Libro("978-1", "Dune", 2);
        assertTrue(libro.presta());
        assertEquals(1, libro.getCopieDisponibili());
        assertEquals(1, libro.getNumPrestiti());
        assertEquals(2, libro.getCopieTotali());
    }

    @Test
    void prestaFallisceSeNonCiSonoCopie() {
        Libro libro = new Libro("978-2", "Emma");
        assertTrue(libro.presta());
        assertFalse(libro.presta());
        assertEquals(0, libro.getCopieDisponibili());
        assertEquals(1, libro.getNumPrestiti());
    }

    @Test
    void restituisciRimetteLaCopia() {
        Libro libro = new Libro("978-1", "Dune", 2);
        libro.presta();
        assertTrue(libro.restituisci());
        assertEquals(2, libro.getCopieDisponibili());
        assertEquals(1, libro.getNumPrestiti());
    }

    @Test
    void restituisciFallisceSeTutteLeCopieSonoPresenti() {
        Libro libro = new Libro("978-1", "Dune", 2);
        assertFalse(libro.restituisci());
        assertEquals(2, libro.getCopieDisponibili());
    }

    @Test
    void setCopieTotaliValidoAdeguaLeDisponibili() {
        Libro libro = new Libro("978-1", "Dune", 3);
        libro.presta();
        libro.setCopieTotali(5);
        assertEquals(5, libro.getCopieTotali());
        assertEquals(4, libro.getCopieDisponibili());
    }

    @Test
    void setCopieTotaliNonValidoVieneIgnorato() {
        Libro libro = new Libro("978-1", "Dune", 3);
        libro.presta();
        libro.presta();
        libro.setCopieTotali(0);
        assertEquals(3, libro.getCopieTotali());
        libro.setCopieTotali(1);
        assertEquals(3, libro.getCopieTotali());
        assertEquals(1, libro.getCopieDisponibili());
        libro.setCopieTotali(2);
        assertEquals(2, libro.getCopieTotali());
        assertEquals(0, libro.getCopieDisponibili());
    }

    @Test
    void toStringFormatoRichiesto() {
        Libro libro = new Libro("978-1", "Dune", 3);
        libro.presta();
        assertEquals("[978-1] Dune | copie: 2/3 | prestiti: 1", libro.toString());
    }
}
