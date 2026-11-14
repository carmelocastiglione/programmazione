import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Studente")
public class StudenteTest {

    @Test
    @DisplayName("Test costruttore studente")
    public void testConstructor() throws EmailNonValidaException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        assertEquals("Marco", s.getNome());
        assertEquals("MAT001", s.getMatricola());
        assertEquals("Studente", s.getTipo());
    }

    @Test
    @DisplayName("Test costruttore studente con email non valida")
    public void testConstructorInvalidEmail() {
        assertThrows(EmailNonValidaException.class, () -> {
            new Studente("Marco", "Bianchi", "marco.example.com", "MAT001");
        });
    }

    @Test
    @DisplayName("Test aggiunta singolo voto")
    public void testAggiuntaVoto() throws EmailNonValidaException, VotoNonValidoException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.valuta(25);
        int[] voti = s.getVoti();
        assertEquals(1, voti.length);
        assertEquals(25, voti[0]);
    }

    @Test
    @DisplayName("Test aggiunta voto non valido (negativo)")
    public void testVotoNegativo() throws EmailNonValidaException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        assertThrows(VotoNonValidoException.class, () -> {
            s.valuta(-1);
        });
    }

    @Test
    @DisplayName("Test aggiunta voto non valido (>30)")
    public void testVotoTroppoAlto() throws EmailNonValidaException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        assertThrows(VotoNonValidoException.class, () -> {
            s.valuta(31);
        });
    }

    @Test
    @DisplayName("Test calcolo media con un voto")
    public void testMediaUnVoto() throws EmailNonValidaException, VotoNonValidoException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.valuta(20);
        assertEquals(20.0, s.getMedia());
    }

    @Test
    @DisplayName("Test calcolo media con più voti")
    public void testMediaPiuVoti() throws EmailNonValidaException, VotoNonValidoException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.valuta(20);
        s.valuta(25);
        s.valuta(30);
        assertEquals(25.0, s.getMedia());
    }

    @Test
    @DisplayName("Test media studente senza voti")
    public void testMediaSenzaVoti() throws EmailNonValidaException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        assertEquals(0.0, s.getMedia());
    }

    @Test
    @DisplayName("Test iscrizione a corso valida")
    public void testIscrizioneCorsoValida() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso di calcolo");
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        
        s.iscrivi(c);
        Corso[] corsi = s.getCorsiIscritti();
        assertEquals(1, corsi.length);
        assertEquals("M001", corsi[0].getCodice());
    }

    @Test
    @DisplayName("Test iscrizione a corso duplicato")
    public void testIscrizioneDuplicata() throws Exception {
        Docente d = new Docente("Prof", "Nero", "prof@example.com", "Matematica");
        Corso c = new Corso("M001", "Calcolo", d, "Corso di calcolo");
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        
        s.iscrivi(c);
        assertThrows(StudenteGiaIscrittoException.class, () -> {
            s.iscrivi(c);
        });
    }

    @Test
    @DisplayName("Test getVoti restituisce copia")
    public void testGetVotiCopia() throws EmailNonValidaException, VotoNonValidoException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        s.valuta(20);
        int[] voti1 = s.getVoti();
        int[] voti2 = s.getVoti();
        voti1[0] = 99;
        assertEquals(20, voti2[0]);
    }

    @Test
    @DisplayName("Test toString studente")
    public void testToString() throws EmailNonValidaException {
        Studente s = new Studente("Marco", "Bianchi", "marco@example.com", "MAT001");
        String result = s.toString();
        assertTrue(result.contains("MAT001"));
        assertTrue(result.contains("Marco"));
    }
}
