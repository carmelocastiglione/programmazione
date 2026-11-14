import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Impiegato")
public class ImpiegatoTest {

    @Test
    @DisplayName("Test costruttore impiegato valido")
    public void testConstructorValido() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        assertEquals("Laura", imp.getNome());
        assertEquals("IMP001", imp.getMatricola());
        assertEquals("Impiegato", imp.getTipo());
    }

    @Test
    @DisplayName("Test costruttore impiegato stipendio negativo")
    public void testConstructorStipendioNegativo() {
        assertThrows(StipendioNegativoException.class, () -> {
            new Impiegato("Laura", "Bianchi", "IMP001", -1000.0, 30000.0, 1000.0);
        });
    }

    @Test
    @DisplayName("Test calcolo stipendio impiegato")
    public void testCalcoloStipendio() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        double stipendio = imp.calcolaStipendio();
        assertEquals((30000.0 / 12.0) + 1000.0, stipendio);
    }

    @Test
    @DisplayName("Test calcolo tasse impiegato")
    public void testCalcoloTasse() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        double tasse = imp.calcolaTasse();
        double stipendio = imp.calcolaStipendio();
        assertEquals(stipendio * 0.23, tasse);
    }

    @Test
    @DisplayName("Test calcolo netto stipendio impiegato")
    public void testGetNettoStipendio() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        double netto = imp.getNettoStipendio();
        double stipendio = imp.calcolaStipendio();
        assertEquals(stipendio * 0.77, netto);
    }

    @Test
    @DisplayName("Test modifica bonus valido")
    public void testSetBonusValido() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        imp.setBonus(2000.0);
        assertEquals(2000.0, imp.getBonus());
    }

    @Test
    @DisplayName("Test modifica bonus negativo")
    public void testSetBonusNegativo() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        assertThrows(StipendioNegativoException.class, () -> {
            imp.setBonus(-500.0);
        });
    }

    @Test
    @DisplayName("Test modifica RAL")
    public void testSetRal() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        imp.setRal(35000.0);
        assertEquals(35000.0, imp.getRal());
    }

    @Test
    @DisplayName("Test getter bonus")
    public void testGetBonus() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1500.0);
        assertEquals(1500.0, imp.getBonus());
    }

    @Test
    @DisplayName("Test toString impiegato")
    public void testToString() throws StipendioNegativoException {
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        String result = imp.toString();
        assertTrue(result.contains("Impiegato"));
        assertTrue(result.contains("IMP001"));
    }
}
