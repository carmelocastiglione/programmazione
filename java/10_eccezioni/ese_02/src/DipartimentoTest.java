import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Dipartimento")
public class DipartimentoTest {

    @Test
    @DisplayName("Test costruttore dipartimento")
    public void testConstructor() {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        assertEquals("Informatica", dip.getNome());
        assertEquals(50000.0, dip.getBudget());
        assertEquals(0, dip.getNumDipendenti());
    }

    @Test
    @DisplayName("Test aggiunta operaio")
    public void testAggiunzioneOperaio() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        assertEquals(1, dip.getNumDipendenti());
    }

    @Test
    @DisplayName("Test aggiunta impiegato")
    public void testAggiunzioneImpiegato() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        dip.aggiungiDipendente(imp);
        assertEquals(1, dip.getNumDipendenti());
    }

    @Test
    @DisplayName("Test aggiunta dirigente")
    public void testAggiunzioneDirigente() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        dip.aggiungiDipendente(dir);
        assertEquals(1, dip.getNumDipendenti());
    }

    @Test
    @DisplayName("Test matricola duplicata")
    public void testMatricolaDuplicata() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op1 = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        Operaio op2 = new Operaio("Luigi", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op1);
        assertThrows(MatricolaGiaEsisteException.class, () -> {
            dip.aggiungiDipendente(op2);
        });
    }

    @Test
    @DisplayName("Test cerca dipendente trovato")
    public void testCercaDipendentetrovato() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        Dipendente trovato = dip.cercaDipendente("OP001");
        assertEquals("Mario", trovato.getNome());
    }

    @Test
    @DisplayName("Test cerca dipendente non trovato")
    public void testCercaDipendenteNonTrovato() {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        assertThrows(DipendenteNonTrovatoException.class, () -> {
            dip.cercaDipendente("OP999");
        });
    }

    @Test
    @DisplayName("Test rimozione dipendente")
    public void testRimozioneDipendente() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        assertEquals(1, dip.getNumDipendenti());
        dip.removiDipendente("OP001");
        assertEquals(0, dip.getNumDipendenti());
    }

    @Test
    @DisplayName("Test rimozione dipendente non trovato")
    public void testRimozioneDipendenteNonTrovato() {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        assertThrows(DipendenteNonTrovatoException.class, () -> {
            dip.removiDipendente("OP999");
        });
    }

    @Test
    @DisplayName("Test stipendio medio dipartimento")
    public void testStipendioMedia() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        dip.aggiungiDipendente(op);
        dip.aggiungiDipendente(imp);
        double media = dip.stipendioMediaDipartimento();
        assertTrue(media > 0);
    }

    @Test
    @DisplayName("Test costi dipartimento")
    public void testCostiDipartimento() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        double costi = dip.costiDipartimento();
        assertTrue(costi > 0);
    }

    @Test
    @DisplayName("Test conteggio operai")
    public void testConteggioOperai() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        assertEquals(1, dip.operaiDipartimento());
    }

    @Test
    @DisplayName("Test conteggio impiegati")
    public void testConteggioImpiegati() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Impiegato imp = new Impiegato("Laura", "Bianchi", "IMP001", 1500.0, 30000.0, 1000.0);
        dip.aggiungiDipendente(imp);
        assertEquals(1, dip.impiegatiDipartimento());
    }

    @Test
    @DisplayName("Test conteggio dirigenti")
    public void testConteggioDirigenti() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        dip.aggiungiDipendente(dir);
        assertEquals(1, dip.dirigentiDipartimento());
    }

    @Test
    @DisplayName("Test dipendente più pagato")
    public void testDipendentePiuPagato() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        Dirigente dir = new Dirigente("Giuseppe", "Verdi", "DIR001", 2000.0, 20, 10.0);
        dip.aggiungiDipendente(op);
        dip.aggiungiDipendente(dir);
        Dipendente piuPagato = dip.getDipendentePiuPagato();
        assertEquals("DIR001", piuPagato.getMatricola());
    }

    @Test
    @DisplayName("Test get array dipendenti")
    public void testGetDipendenti() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        Dipendente[] dipendenti = dip.getDipendenti();
        assertEquals(1, dipendenti.length);
    }

    @Test
    @DisplayName("Test toString dipartimento")
    public void testToString() throws Exception {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        Operaio op = new Operaio("Mario", "Rossi", "OP001", 1600.0, 40, 15.0);
        dip.aggiungiDipendente(op);
        String result = dip.toString();
        assertTrue(result.contains("Informatica"));
        assertTrue(result.contains("Dipendenti totali: 1"));
    }

    @Test
    @DisplayName("Test setter budget")
    public void testSetterBudget() {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        dip.setBudget(75000.0);
        assertEquals(75000.0, dip.getBudget());
    }

    @Test
    @DisplayName("Test media dipartimento vuoto")
    public void testMediaDipartimentoVuoto() {
        Dipartimento dip = new Dipartimento("Informatica", 50000.0);
        assertThrows(DipendenteNonTrovatoException.class, () -> {
            dip.stipendioMediaDipartimento();
        });
    }
}
