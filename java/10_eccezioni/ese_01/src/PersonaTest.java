import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Persona")
public class PersonaTest {

    @Test
    @DisplayName("Test costruttore con email valida")
    public void testConstructorValidEmail() throws EmailNonValidaException {
        Docente d = new Docente("Mario", "Rossi", "mario@example.com", "Informatica");
        assertEquals("Mario", d.getNome());
        assertEquals("Rossi", d.getCognome());
        assertEquals("mario@example.com", d.getEmail());
    }

    @Test
    @DisplayName("Test costruttore con email non valida (senza @)")
    public void testConstructorInvalidEmail() {
        assertThrows(EmailNonValidaException.class, () -> {
            new Docente("Mario", "Rossi", "mario.example.com", "Informatica");
        });
    }

    @Test
    @DisplayName("Test costruttore con email null")
    public void testConstructorEmailNull() {
        assertThrows(EmailNonValidaException.class, () -> {
            new Docente("Mario", "Rossi", null, "Informatica");
        });
    }

    @Test
    @DisplayName("Test setter email valida")
    public void testSetterValidEmail() throws EmailNonValidaException {
        Docente d = new Docente("Mario", "Rossi", "mario@example.com", "Informatica");
        d.setEmail("mario.rossi@example.com");
        assertEquals("mario.rossi@example.com", d.getEmail());
    }

    @Test
    @DisplayName("Test setter email non valida")
    public void testSetterInvalidEmail() throws EmailNonValidaException {
        Docente d = new Docente("Mario", "Rossi", "mario@example.com", "Informatica");
        assertThrows(EmailNonValidaException.class, () -> {
            d.setEmail("invalid.email");
        });
    }

    @Test
    @DisplayName("Test getter nome e cognome")
    public void testGetters() throws EmailNonValidaException {
        Docente d = new Docente("Mario", "Rossi", "mario@example.com", "Informatica");
        assertEquals("Mario", d.getNome());
        assertEquals("Rossi", d.getCognome());
    }

    @Test
    @DisplayName("Test toString")
    public void testToString() throws EmailNonValidaException {
        Docente d = new Docente("Mario", "Rossi", "mario@example.com", "Informatica");
        String result = d.toString();
        assertTrue(result.contains("Mario"));
        assertTrue(result.contains("Rossi"));
        assertTrue(result.contains("mario@example.com"));
    }
}
