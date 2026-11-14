import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test GestorePiattaforma")
public class GestorePiattaformaTest {

    @Test
    @DisplayName("Test aggiunta docente")
    public void testAggiunzioneDocente() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        assertEquals(1, gp.getNumDocenti());
    }

    @Test
    @DisplayName("Test aggiunta corso")
    public void testAggiunzioneCorso() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        gp.aggiungiCorso(c);
        assertEquals(1, gp.getNumCorsi());
    }

    @Test
    @DisplayName("Test aggiunta studente")
    public void testAggiunzioneStudente() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        gp.aggiungiStudente(s);
        assertEquals(1, gp.getNumStudenti());
    }

    @Test
    @DisplayName("Test cerca corso trovato")
    public void testCercaCorsoTrovato() throws EmailNonValidaException, CorsoNonTrovatoException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        gp.aggiungiCorso(c);
        Corso trovato = gp.cercaCorso("M001");
        assertEquals("Calcolo", trovato.getNome());
    }

    @Test
    @DisplayName("Test cerca corso non trovato")
    public void testCercaCorsoNonTrovato() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        assertThrows(CorsoNonTrovatoException.class, () -> {
            gp.cercaCorso("M999");
        });
    }

    @Test
    @DisplayName("Test cerca studente trovato")
    public void testCercaStudenteTrovato() throws EmailNonValidaException, CorsoNonTrovatoException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        gp.aggiungiStudente(s);
        Studente trovato = gp.cercaStudente("MAT001");
        assertEquals("Marco", trovato.getNome());
    }

    @Test
    @DisplayName("Test cerca studente non trovato")
    public void testCercaStudenteNonTrovato() {
        GestorePiattaforma gp = new GestorePiattaforma();
        assertThrows(CorsoNonTrovatoException.class, () -> {
            gp.cercaStudente("MAT999");
        });
    }

    @Test
    @DisplayName("Test studente con media migliore")
    public void testStudenteConMediaMigliore() throws Exception {
        GestorePiattaforma gp = new GestorePiattaforma();
        Studente s1 = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        Studente s2 = new Studente("Luca", "Rossi", "luca@example.com", "MAT002");
        gp.aggiungiStudente(s1);
        gp.aggiungiStudente(s2);
        
        s1.valuta(20);
        s2.valuta(30);
        
        Studente migliore = gp.studenteConMediaMigliore();
        assertEquals("MAT002", migliore.getMatricola());
    }

    @Test
    @DisplayName("Test media corso")
    public void testMediaCorso() throws Exception {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        gp.aggiungiCorso(c);
        
        Studente s1 = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        Studente s2 = new Studente("Luca", "Rossi", "luca@example.com", "MAT002");
        gp.aggiungiStudente(s1);
        gp.aggiungiStudente(s2);
        
        s1.iscrivi(c);
        s2.iscrivi(c);
        
        s1.valuta(20);
        s2.valuta(30);
        
        double media = gp.mediaCorso("M001");
        assertEquals(25.0, media);
    }

    @Test
    @DisplayName("Test media corso non trovato")
    public void testMediaCorsoNonTrovato() {
        GestorePiattaforma gp = new GestorePiattaforma();
        assertThrows(CorsoNonTrovatoException.class, () -> {
            gp.mediaCorso("M999");
        });
    }

    @Test
    @DisplayName("Test studente con media migliore nessun studente")
    public void testStudenteMediaMiglioreNessuno() {
        GestorePiattaforma gp = new GestorePiattaforma();
        assertThrows(CorsoNonTrovatoException.class, () -> {
            gp.studenteConMediaMigliore();
        });
    }

    @Test
    @DisplayName("Test get array corsi")
    public void testGetCorsi() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        Corso c = new Corso("M001", "Calcolo", d, "Corso");
        gp.aggiungiCorso(c);
        Corso[] corsi = gp.getCorsi();
        assertEquals(1, corsi.length);
        assertEquals("M001", corsi[0].getCodice());
    }

    @Test
    @DisplayName("Test get array studenti")
    public void testGetStudenti() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        gp.aggiungiStudente(s);
        Studente[] studenti = gp.getStudenti();
        assertEquals(1, studenti.length);
        assertEquals("MAT001", studenti[0].getMatricola());
    }

    @Test
    @DisplayName("Test get array docenti")
    public void testGetDocenti() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        Docente[] docenti = gp.getDocenti();
        assertEquals(1, docenti.length);
        assertEquals("Prof", docenti[0].getNome());
    }

    @Test
    @DisplayName("Test toString piattaforma")
    public void testToString() throws EmailNonValidaException {
        GestorePiattaforma gp = new GestorePiattaforma();
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        gp.aggiungiDocente(d);
        String result = gp.toString();
        assertTrue(result.contains("PIATTAFORMA E-LEARNING"));
        assertTrue(result.contains("Docenti: 1"));
    }
}
