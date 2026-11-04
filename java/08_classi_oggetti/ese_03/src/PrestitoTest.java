import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrestitoTest {

    @Test
    void costruttoreCompletoEGetter() {
        Prestito prestito = new Prestito("978-1", "mario", 7);
        assertEquals("978-1", prestito.getIsbn());
        assertEquals("mario", prestito.getUtente());
        assertEquals(7, prestito.getGiorniPrevisti());
    }

    @Test
    void costruttoreSenzaGiorniUsaQuattordici() {
        Prestito prestito = new Prestito("978-2", "anna");
        assertEquals("978-2", prestito.getIsbn());
        assertEquals("anna", prestito.getUtente());
        assertEquals(14, prestito.getGiorniPrevisti());
    }

    @Test
    void setGiorniPrevistiValido() {
        Prestito prestito = new Prestito("978-1", "mario", 7);
        prestito.setGiorniPrevisti(10);
        assertEquals(10, prestito.getGiorniPrevisti());
    }

    @Test
    void setGiorniPrevistiNonValidoVieneIgnorato() {
        Prestito prestito = new Prestito("978-1", "mario", 7);
        prestito.setGiorniPrevisti(0);
        assertEquals(7, prestito.getGiorniPrevisti());
        prestito.setGiorniPrevisti(-2);
        assertEquals(7, prestito.getGiorniPrevisti());
    }

    @Test
    void toStringFormatoRichiesto() {
        Prestito prestito = new Prestito("978-1", "mario", 14);
        assertEquals("mario ha in prestito 978-1 per 14 giorni", prestito.toString());
    }
}
