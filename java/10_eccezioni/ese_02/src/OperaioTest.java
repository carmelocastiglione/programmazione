import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Operaio")
public class OperaioTest {

    @Test
    @DisplayName("Test costruttore operaio valido")
    public void testConstructorValido() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1500.0, 40, 15.0);
        assertEquals("Mario", op.getNome());
        assertEquals("OP001", op.getMatricola());
        assertEquals("Operaio", op.getTipo());
    }

    @Test
    @DisplayName("Test costruttore operaio stipendio negativo")
    public void testConstructorStipendioNegativo() {
        assertThrows(StipendioNegativoException.class, () -> {
            new Operaio("Mario", "Rossi", "OP001", -1000.0, 40, 15.0);
        });
    }

    @Test
    @DisplayName("Test costruttore operaio ore non valide")
    public void testConstructorOreNonValide() {
        assertThrows(OreNonValidaException.class, () -> {
            new Operaio("Mario", "Rossi", "OP001", 1500.0, 50, 15.0);
        });
    }

    @Test
    @DisplayName("Test calcolo stipendio operaio")
    public void testCalcoloStipendio() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        double stipendio = op.calcolaStipendio();
        assertEquals((1600.0 / 160) * 40, stipendio);
    }

    @Test
    @DisplayName("Test calcolo tasse operaio")
    public void testCalcoloTasse() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        double tasse = op.calcolaTasse();
        double stipendio = op.calcolaStipendio();
        assertEquals(stipendio * 0.20, tasse);
    }

    @Test
    @DisplayName("Test calcolo netto stipendio operaio")
    public void testGetNettoStipendio() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        double netto = op.getNettoStipendio();
        double stipendio = op.calcolaStipendio();
        assertEquals(stipendio * 0.80, netto);
    }

    @Test
    @DisplayName("Test modifica ore settimanali valide")
    public void testSetOreValide() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        op.setOreSettimanali(30);
        assertEquals(30, op.getOreSettimanali());
    }

    @Test
    @DisplayName("Test modifica ore settimanali non valide")
    public void testSetOreNonValide() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        assertThrows(OreNonValidaException.class, () -> {
            op.setOreSettimanali(50);
        });
    }

    @Test
    @DisplayName("Test toString operaio")
    public void testToString() throws StipendioNegativoException, OreNonValidaException {
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        String result = op.toString();
        assertTrue(result.contains("Operaio"));
        assertTrue(result.contains("OP001"));
    }
}
