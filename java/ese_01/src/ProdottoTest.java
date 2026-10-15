import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProdottoTest {

    @Test
    void costruttoreCompletoEGetter() {
        Prodotto p = new Prodotto("P001", "Penna", 1.5, 10);
        assertEquals("P001", p.getCodice());
        assertEquals("Penna", p.getNome());
        assertEquals(1.5, p.getPrezzo(), 0.0001);
        assertEquals(10, p.getQuantita());
    }

    @Test
    void costruttoreSenzaQuantita() {
        Prodotto p = new Prodotto("P002", "Quaderno", 2.0);
        assertEquals("P002", p.getCodice());
        assertEquals(2.0, p.getPrezzo(), 0.0001);
        assertEquals(0, p.getQuantita());
    }

    @Test
    void setPrezzoValido() {
        Prodotto p = new Prodotto("P001", "Penna", 1.5, 10);
        p.setPrezzo(2.5);
        assertEquals(2.5, p.getPrezzo(), 0.0001);
    }

    @Test
    void setPrezzoNonValidoVieneIgnorato() {
        Prodotto p = new Prodotto("P001", "Penna", 1.5, 10);
        p.setPrezzo(0);
        assertEquals(1.5, p.getPrezzo(), 0.0001);
        p.setPrezzo(-3);
        assertEquals(1.5, p.getPrezzo(), 0.0001);
    }

    @Test
    void setQuantita() {
        Prodotto p = new Prodotto("P001", "Penna", 1.5, 10);
        p.setQuantita(0);
        assertEquals(0, p.getQuantita());
        p.setQuantita(7);
        assertEquals(7, p.getQuantita());
        p.setQuantita(-1);
        assertEquals(7, p.getQuantita());
    }

    @Test
    void toStringFormatoRichiesto() {
        Prodotto p = new Prodotto("P001", "Penna", 1.5, 10);
        assertEquals("[P001] Penna | prezzo: 1.5 | quantita: 10", p.toString());
    }
}
