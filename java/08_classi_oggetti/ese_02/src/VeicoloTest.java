import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VeicoloTest {

    @Test
    void costruttoreCompletoEGetter() {
        Veicolo veicolo = new Veicolo("AB123CD", "Fiat Panda", 2.5);
        assertEquals("AB123CD", veicolo.getTarga());
        assertEquals("Fiat Panda", veicolo.getModello());
        assertEquals(2.5, veicolo.getTariffaOraria(), 0.0001);
    }

    @Test
    void costruttoreSenzaTariffa() {
        Veicolo veicolo = new Veicolo("EF456GH", "Toyota Yaris");
        assertEquals("EF456GH", veicolo.getTarga());
        assertEquals("Toyota Yaris", veicolo.getModello());
        assertEquals(2.0, veicolo.getTariffaOraria(), 0.0001);
    }

    @Test
    void setTariffaOrariaValida() {
        Veicolo veicolo = new Veicolo("AB123CD", "Fiat Panda", 2.5);
        veicolo.setTariffaOraria(3.0);
        assertEquals(3.0, veicolo.getTariffaOraria(), 0.0001);
    }

    @Test
    void setTariffaNonValidaVieneIgnorata() {
        Veicolo veicolo = new Veicolo("AB123CD", "Fiat Panda", 2.5);
        veicolo.setTariffaOraria(0);
        assertEquals(2.5, veicolo.getTariffaOraria(), 0.0001);
        veicolo.setTariffaOraria(-3);
        assertEquals(2.5, veicolo.getTariffaOraria(), 0.0001);
    }

    @Test
    void toStringFormatoRichiesto() {
        Veicolo veicolo = new Veicolo("AB123CD", "Fiat Panda", 2.5);
        assertEquals("[AB123CD] Fiat Panda | tariffa oraria: 2.5", veicolo.toString());
    }
}
