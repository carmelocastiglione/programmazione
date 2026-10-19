import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestoreParcheggioTest {

    private GestoreParcheggio parcheggio;

    @BeforeEach
    void setUp() {
        parcheggio = new GestoreParcheggio(4);
        parcheggio.parcheggia(new Veicolo("AB123CD", "Fiat Panda", 2.0));
        parcheggio.parcheggia(new Veicolo("EF456GH", "Toyota Yaris", 3.0));
        parcheggio.parcheggia(new Veicolo("IL789MN", "BMW Serie 1", 5.0));
    }

    @Test
    void parcheggiaIncrementaIlNumeroDiVeicoli() {
        assertEquals(3, parcheggio.getNumVeicoli());
        assertTrue(parcheggio.parcheggia(new Veicolo("OP012QR", "Ford Fiesta", 2.5)));
        assertEquals(4, parcheggio.getNumVeicoli());
    }

    @Test
    void parcheggiaFallisceSePieno() {
        parcheggio.parcheggia(new Veicolo("OP012QR", "Ford Fiesta", 2.5));
        assertFalse(parcheggio.parcheggia(new Veicolo("ST345UV", "Audi A3", 4.0)));
        assertEquals(4, parcheggio.getNumVeicoli());
    }

    @Test
    void parcheggiaFallisceSeTargaDuplicata() {
        assertFalse(parcheggio.parcheggia(new Veicolo("AB123CD", "Altro modello", 2.0)));
        assertEquals(3, parcheggio.getNumVeicoli());
    }

    @Test
    void cercaPerTarga() {
        Veicolo veicolo = parcheggio.cerca("EF456GH");
        assertNotNull(veicolo);
        assertEquals("Toyota Yaris", veicolo.getModello());
    }

    @Test
    void cercaTargaInesistenteRestituisceNull() {
        assertNull(parcheggio.cerca("ZZ999ZZ"));
    }

    @Test
    void cercaNonTrovaInUnParcheggioVuoto() {
        assertNull(new GestoreParcheggio(5).cerca("AB123CD"));
    }

    @Test
    void cercaPerFasciaDiTariffa() {
        Veicolo[] risultati = parcheggio.cerca(2.0, 3.0);
        assertEquals(2, risultati.length);
        assertEquals("AB123CD", risultati[0].getTarga());
        assertEquals("EF456GH", risultati[1].getTarga());
    }

    @Test
    void cercaPerFasciaDiTariffaSenzaRisultati() {
        Veicolo[] risultati = parcheggio.cerca(10, 20);
        assertNotNull(risultati);
        assertEquals(0, risultati.length);
    }

    @Test
    void uscitaLiberaIlPostoERegistraIncasso() {
        assertTrue(parcheggio.uscita("AB123CD", 3));
        assertNull(parcheggio.cerca("AB123CD"));
        assertEquals(2, parcheggio.getNumVeicoli());
        assertEquals(6.0, parcheggio.incassoTotale(), 0.0001);
    }

    @Test
    void uscitaFallisceSeTargaInesistente() {
        assertFalse(parcheggio.uscita("ZZ999ZZ", 2));
        assertEquals(3, parcheggio.getNumVeicoli());
        assertEquals(0.0, parcheggio.incassoTotale(), 0.0001);
    }

    @Test
    void uscitaFallisceSeOreNonPositive() {
        assertFalse(parcheggio.uscita("AB123CD", 0));
        assertFalse(parcheggio.uscita("AB123CD", -1));
        assertNotNull(parcheggio.cerca("AB123CD"));
        assertEquals(3, parcheggio.getNumVeicoli());
        assertEquals(0.0, parcheggio.incassoTotale(), 0.0001);
    }

    @Test
    void incassoAccumulaPiuUscite() {
        assertTrue(parcheggio.uscita("AB123CD", 2));
        assertTrue(parcheggio.uscita("EF456GH", 4));
        assertEquals(16.0, parcheggio.incassoTotale(), 0.0001);
    }

    @Test
    void veicoloPiuCostoso() {
        assertEquals("IL789MN", parcheggio.veicoloPiuCostoso().getTarga());
    }

    @Test
    void veicoloPiuCostosoParcheggioVuoto() {
        assertNull(new GestoreParcheggio(3).veicoloPiuCostoso());
    }

    @Test
    void contaSottoTariffa() {
        assertEquals(2, parcheggio.contaSottoTariffa(4.0));
        assertEquals(0, parcheggio.contaSottoTariffa(2.0));
        assertEquals(3, parcheggio.contaSottoTariffa(10.0));
    }

    @Test
    void targheParcheggiate() {
        assertArrayEquals(new String[] { "AB123CD", "EF456GH", "IL789MN" },
                parcheggio.targheParcheggiate());
        parcheggio.uscita("AB123CD", 1);
        assertArrayEquals(new String[] { "EF456GH", "IL789MN" }, parcheggio.targheParcheggiate());
    }

    @Test
    void targheParcheggiateParcheggioVuoto() {
        assertEquals(0, new GestoreParcheggio(3).targheParcheggiate().length);
    }

    @Test
    void toStringUnaRigaPerVeicolo() {
        String atteso = "[AB123CD] Fiat Panda | tariffa oraria: 2.0\n"
                + "[EF456GH] Toyota Yaris | tariffa oraria: 3.0\n"
                + "[IL789MN] BMW Serie 1 | tariffa oraria: 5.0\n";
        assertEquals(atteso, parcheggio.toString());
    }
}
