import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Corso")
public class CorsoTest {

    @Test
    @DisplayName("Test costruttore corso")
    public void testConstructor() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso di calcolo");
        assertEquals("M001", c.getCodice());
        assertEquals("Calcolo", c.getNome());
        assertEquals("Corso di calcolo", c.getDescrizione());
        assertEquals("Prof", c.getDocente().getNome());
    }

    @Test
    @DisplayName("Test getter capacita")
    public void testGetCapacita() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        assertEquals(30, c.getCapacita());
    }

    @Test
    @DisplayName("Test aggiunta studente a corso")
    public void testAggiunzioneStudente() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.iscrivi(c);
        assertEquals(1, c.getNumStudenti());
    }

    @Test
    @DisplayName("Test numero studenti")
    public void testGetNumStudenti() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        assertEquals(0, c.getNumStudenti());
    }

    @Test
    @DisplayName("Test capacita corso escedurita")
    public void testCapacitaEscedurita() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        
        for (int i = 0; i < 30; i++) {
            Studente s = new Studente("Stud" + i, "Cognome", "email" + i + "@example.com", "MAT" + i);
            s.iscrivi(c);
        }
        
        Studente sUltimo = new Studente("Extra", "Cognome", "extra@example.com", "EXTRA");
        assertThrows(CapacitaCorsoEsceduriException.class, () -> {
            sUltimo.iscrivi(c);
        });
    }

    @Test
    @DisplayName("Test cerca studente non trovato")
    public void testCercaStudenteNonTrovato() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        assertThrows(CorsoNonTrovatoException.class, () -> {
            c.cercaStudente("MAT999");
        });
    }

    @Test
    @DisplayName("Test cerca studente trovato")
    public void testCercaStudenteTrovato() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.iscrivi(c);
        Studente trovato = c.cercaStudente("MAT001");
        assertEquals("Marco", trovato.getNome());
    }

    @Test
    @DisplayName("Test rimozione studente")
    public void testRimozioneStudente() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.iscrivi(c);
        assertEquals(1, c.getNumStudenti());
        c.rimuoviStudente("MAT001");
        assertEquals(0, c.getNumStudenti());
    }

    @Test
    @DisplayName("Test rimozione studente non trovato")
    public void testRimozioneStudenteNonTrovato() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        assertThrows(CorsoNonTrovatoException.class, () -> {
            c.rimuoviStudente("MAT999");
        });
    }

    @Test
    @DisplayName("Test toString corso")
    public void testToString() throws EmailNonValidaException {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        String result = c.toString();
        assertTrue(result.contains("M001"));
        assertTrue(result.contains("Calcolo"));
    }

    @Test
    @DisplayName("Test getStudenti restituisce copia")
    public void testGetStudentiCopia() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.iscrivi(c);
        Studente[] stud1 = c.getStudenti();
        Studente[] stud2 = c.getStudenti();
        assertEquals(stud1[0].getMatricola(), stud2[0].getMatricola());
    }
}
