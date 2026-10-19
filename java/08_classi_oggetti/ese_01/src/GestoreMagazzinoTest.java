import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestoreMagazzinoTest {

    private GestoreMagazzino g;

    @BeforeEach
    void setUp() {
        g = new GestoreMagazzino(4);
        g.aggiungi(new Prodotto("P001", "Penna", 1.5, 10));
        g.aggiungi(new Prodotto("P002", "Quaderno", 3.0, 4));
        g.aggiungi(new Prodotto("P003", "Zaino", 40.0, 2));
    }

    // ---- Parte B: aggiungi / cerca ----

    @Test
    void aggiungiIncrementaIlNumeroDiProdotti() {
        assertEquals(3, g.getNumProdotti());
        assertTrue(g.aggiungi(new Prodotto("P004", "Gomma", 0.5, 20)));
        assertEquals(4, g.getNumProdotti());
    }

    @Test
    void aggiungiFallisceSeMagazzinoPieno() {
        g.aggiungi(new Prodotto("P004", "Gomma", 0.5, 20));
        assertFalse(g.aggiungi(new Prodotto("P005", "Righello", 1.0, 5)));
        assertEquals(4, g.getNumProdotti());
    }

    @Test
    void aggiungiFallisceSeCodiceDuplicato() {
        assertFalse(g.aggiungi(new Prodotto("P001", "Altra penna", 2.0, 1)));
        assertEquals(3, g.getNumProdotti());
    }

    @Test
    void cercaPerCodice() {
        Prodotto p = g.cerca("P002");
        assertNotNull(p);
        assertEquals("Quaderno", p.getNome());
    }

    @Test
    void cercaCodiceInesistenteRestituisceNull() {
        assertNull(g.cerca("XXXX"));
    }

    @Test
    void cercaNonTrovaOltreIProdottiInseriti() {
        GestoreMagazzino vuoto = new GestoreMagazzino(5);
        assertNull(vuoto.cerca("P001"));
    }

    @Test
    void cercaPerFasciaDiPrezzo() {
        Prodotto[] r = g.cerca(1.5, 3.0);
        assertEquals(2, r.length);
        assertEquals("P001", r[0].getCodice());
        assertEquals("P002", r[1].getCodice());
    }

    @Test
    void cercaPerFasciaDiPrezzoSenzaRisultati() {
        Prodotto[] r = g.cerca(100, 200);
        assertNotNull(r);
        assertEquals(0, r.length);
    }

    // ---- Parte B: carica / scarica / rimuovi ----

    @Test
    void caricaAumentaLaGiacenza() {
        assertTrue(g.carica("P001", 5));
        assertEquals(15, g.cerca("P001").getQuantita());
    }

    @Test
    void caricaNonValido() {
        assertFalse(g.carica("XXXX", 5));
        assertFalse(g.carica("P001", 0));
        assertFalse(g.carica("P001", -2));
        assertEquals(10, g.cerca("P001").getQuantita());
    }

    @Test
    void scaricaDiminuisceLaGiacenza() {
        assertTrue(g.scarica("P001", 10));
        assertEquals(0, g.cerca("P001").getQuantita());
    }

    @Test
    void scaricaConGiacenzaInsufficiente() {
        assertFalse(g.scarica("P003", 3));
        assertEquals(2, g.cerca("P003").getQuantita());
    }

    @Test
    void scaricaNonValido() {
        assertFalse(g.scarica("XXXX", 1));
        assertFalse(g.scarica("P001", 0));
        assertFalse(g.scarica("P001", -1));
    }

    @Test
    void rimuoviMantieneCompattoIlVettore() {
        assertTrue(g.rimuovi("P001"));
        assertEquals(2, g.getNumProdotti());
        assertNull(g.cerca("P001"));
        assertNotNull(g.cerca("P002"));
        assertNotNull(g.cerca("P003"));
    }

    @Test
    void rimuoviUltimoEInesistente() {
        assertTrue(g.rimuovi("P003"));
        assertEquals(2, g.getNumProdotti());
        assertFalse(g.rimuovi("XXXX"));
        assertEquals(2, g.getNumProdotti());
    }

    @Test
    void dopoRimozioneSiPuoAggiungereDiNuovo() {
        g.aggiungi(new Prodotto("P004", "Gomma", 0.5, 20));
        g.rimuovi("P002");
        assertTrue(g.aggiungi(new Prodotto("P005", "Righello", 1.0, 5)));
        assertEquals(4, g.getNumProdotti());
    }

    // ---- Parte C: statistiche, toString ----

    @Test
    void valoreTotale() {
        // 1.5*10 + 3.0*4 + 40.0*2 = 107
        assertEquals(107.0, g.valoreTotale(), 0.0001);
    }

    @Test
    void valoreTotaleMagazzinoVuoto() {
        assertEquals(0.0, new GestoreMagazzino(3).valoreTotale(), 0.0001);
    }

    @Test
    void piuCostoso() {
        assertEquals("P003", g.piuCostoso().getCodice());
    }

    @Test
    void piuCostosoMagazzinoVuoto() {
        assertNull(new GestoreMagazzino(3).piuCostoso());
    }

    @Test
    void contaSottoScorta() {
        assertEquals(2, g.contaSottoScorta(5));   // P002 (4) e P003 (2)
        assertEquals(0, g.contaSottoScorta(2));   // stretto: 2 non e' < 2
        assertEquals(3, g.contaSottoScorta(100));
    }

    @Test
    void nomiProdotti() {
        assertArrayEquals(new String[] { "Penna", "Quaderno", "Zaino" }, g.nomiProdotti());
        g.rimuovi("P001");
        assertArrayEquals(new String[] { "Quaderno", "Zaino" }, g.nomiProdotti());
    }

    @Test
    void nomiProdottiMagazzinoVuoto() {
        assertEquals(0, new GestoreMagazzino(3).nomiProdotti().length);
    }

    @Test
    void toStringUnaRigaPerProdotto() {
        String atteso = "[P001] Penna | prezzo: 1.5 | quantita: 10\n"
                + "[P002] Quaderno | prezzo: 3.0 | quantita: 4\n"
                + "[P003] Zaino | prezzo: 40.0 | quantita: 2\n";
        assertEquals(atteso, g.toString());
    }
}
