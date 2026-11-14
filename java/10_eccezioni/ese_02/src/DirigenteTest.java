import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Dirigente")
public class DirigenteTest {

    @Test
    @DisplayName("Test costruttore dirigente valido")
    public void testConstructorValido() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        assertEquals("Giuseppe", dir.getNome());
        assertEquals("DIR001", dir.getMatricola());
        assertEquals("Dirigente", dir.getTipo());
    }

    @Test
    @DisplayName("Test costruttore dirigente stipendio negativo")
    public void testConstructorStipendioNegativo() {
        assertThrows(StipendioNegativoException.class, () -> {
            new Dirigente("Giuseppe", "Verdi", "DIR001", -2000.0, 20, 10.0);
        });
    }

    @Test
    @DisplayName("Test costruttore dirigente presenze non valide")
    public void testConstructorPresenzeNonValide() {
        assertThrows(OreNonValidaException.class, () -> {
            new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 25, 10.0);
        });
    }

    @Test
    @DisplayName("Test calcolo stipendio dirigente")
    public void testCalcoloStipendio() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        double stipendio = dir.calcolaStipendio();
        double expected = (2000.0 * 1.5) + (2000.0 * 10.0 / 100.0 / 12.0);
        assertEquals(expected, stipendio, 0.01);
    }

    @Test
    @DisplayName("Test calcolo tasse dirigente")
    public void testCalcoloTasse() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        double tasse = dir.calcolaTasse();
        double stipendio = dir.calcolaStipendio();
        assertEquals(stipendio * 0.30, tasse);
    }

    @Test
    @DisplayName("Test calcolo netto stipendio dirigente")
    public void testGetNettoStipendio() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        double netto = dir.getNettoStipendio();
        double stipendio = dir.calcolaStipendio();
        assertEquals(stipendio * 0.70, netto);
    }

    @Test
    @DisplayName("Test modifica presenze valide")
    public void testSetPresenzeValide() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        dir.setPresenze(15);
        assertEquals(15, dir.getPresenze());
    }

    @Test
    @DisplayName("Test modifica presenze non valide")
    public void testSetPresenzeNonValide() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        assertThrows(OreNonValidaException.class, () -> {
            dir.setPresenze(30);
        });
    }

    @Test
    @DisplayName("Test getter percentuale bonus")
    public void testGetPercentualeBonus() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 15.0);
        assertEquals(15.0, dir.getPercentualeBonusAnnuale());
    }

    @Test
    @DisplayName("Test toString dirigente")
    public void testToString() throws StipendioNegativoException, OreNonValidaException {
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        String result = dir.toString();
        assertTrue(result.contains("Dirigente"));
        assertTrue(result.contains("DIR001"));
    }
}
