import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Docente")
public class DocenteTest {

    @Test
    @DisplayName("Test costruttore docente")
    public void testConstructor() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        assertEquals("Prof", d.getNome());
        assertEquals("Nero", d.getCognome());
        assertEquals("Matematica", d.getSpecializzazione());
        assertEquals("Docente", d.getTipo());
    }

    @Test
    @DisplayName("Test getter specializzazione")
    public void testGetSpecializzazione() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Informatica");
        assertEquals("Informatica", d.getSpecializzazione());
    }

    @Test
    @DisplayName("Test aggiunta corso a docente")
    public void testAggiuntaCorso() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso di calcolo");
        Corso[] corsi = d.getCorsiTenuti();
        assertEquals(1, corsi.length);
        assertEquals("M001", corsi[0].getCodice());
    }

    @Test
    @DisplayName("Test aggiunta multipli corsi")
    public void testAggiuntaMultipliCorsi() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c1 = new Corso("M001", "Calcolo", d, "Calcolo");
        Corso c2 = new Corso("M002", "Algebra", d, "Algebra");
        Corso[] corsi = d.getCorsiTenuti();
        assertEquals(2, corsi.length);
    }

    @Test
    @DisplayName("Test numero corsi")
    public void testGetNumCorsi() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        assertEquals(0, d.getNumCorsi());
        Corso c = new Corso("M001", "Calcolo", d, "Calcolo");
        assertEquals(1, d.getNumCorsi());
    }

    @Test
    @DisplayName("Test toString docente")
    public void testToString() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        String result = d.toString();
        assertTrue(result.contains("Prof"));
        assertTrue(result.contains("Nero"));
        assertTrue(result.contains("Matematica"));
    }

    @Test
    @DisplayName("Test email non valida docente")
    public void testEmailNonValida() {
        assertThrows(EmailNonValidaException.class, () -> {
            new Docente("Prof", "Nero", "prof.example", "Matematica");
        });
    }
}
