public class GestoreMagazzino {
    private Prodotto[] prodotti;
    private int numProdotti;

    public GestoreMagazzino(int capacita) {
        prodotti = new Prodotto[capacita];
        numProdotti = 0;
    }

    public int getNumProdotti() { return numProdotti; }

    public boolean aggiungi(Prodotto p) {
        if (numProdotti == prodotti.length || cerca(p.getCodice()) != null) return false;
        prodotti[numProdotti++] = p;
        return true;
    }

    public Prodotto cerca(String codice) {
        for (int i = 0; i < numProdotti; i++) {
            if (prodotti[i].getCodice().equals(codice)) return prodotti[i];
        }
        return null;
    }

    public Prodotto[] cerca(double min, double max) {
        int n = 0;
        for (int i = 0; i < numProdotti; i++) {
            if (prodotti[i].getPrezzo() >= min && prodotti[i].getPrezzo() <= max) n++;
        }
        Prodotto[] r = new Prodotto[n];
        int k = 0;
        for (int i = 0; i < numProdotti; i++) {
            if (prodotti[i].getPrezzo() >= min && prodotti[i].getPrezzo() <= max) r[k++] = prodotti[i];
        }
        return r;
    }

    public boolean carica(String codice, int quantita) {
        Prodotto p = cerca(codice);
        if (p == null || quantita <= 0) return false;
        p.setQuantita(p.getQuantita() + quantita);
        return true;
    }

    public boolean scarica(String codice, int quantita) {
        Prodotto p = cerca(codice);
        if (p == null || quantita <= 0 || p.getQuantita() < quantita) return false;
        p.setQuantita(p.getQuantita() - quantita);
        return true;
    }

    public boolean rimuovi(String codice) {
        for (int i = 0; i < numProdotti; i++) {
            if (prodotti[i].getCodice().equals(codice)) {
                for (int j = i; j < numProdotti - 1; j++) prodotti[j] = prodotti[j + 1];
                prodotti[--numProdotti] = null;
                return true;
            }
        }
        return false;
    }

    public double valoreTotale() {
        double tot = 0;
        for (int i = 0; i < numProdotti; i++) tot += prodotti[i].getPrezzo() * prodotti[i].getQuantita();
        return tot;
    }

    public Prodotto piuCostoso() {
        if (numProdotti == 0) return null;
        Prodotto max = prodotti[0];
        for (int i = 1; i < numProdotti; i++) {
            if (prodotti[i].getPrezzo() > max.getPrezzo()) max = prodotti[i];
        }
        return max;
    }

    public int contaSottoScorta(int soglia) {
        int c = 0;
        for (int i = 0; i < numProdotti; i++) if (prodotti[i].getQuantita() < soglia) c++;
        return c;
    }

    public String[] nomiProdotti() {
        String[] nomi = new String[numProdotti];
        for (int i = 0; i < numProdotti; i++) nomi[i] = prodotti[i].getNome();
        return nomi;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numProdotti; i++) s += prodotti[i] + "\n";
        return s;
    }
}
