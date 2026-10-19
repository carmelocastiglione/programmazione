public class GestoreParcheggio {
    private Veicolo[] veicoli;
    private int numVeicoli;
    private double incassoTotale;

    public GestoreParcheggio(int capacita) {
        veicoli = new Veicolo[capacita];
        numVeicoli = 0;
        incassoTotale = 0;
    }

    public int getNumVeicoli() { return numVeicoli; }

    public boolean parcheggia(Veicolo veicolo) {
        if (numVeicoli == veicoli.length || cerca(veicolo.getTarga()) != null) return false;
        veicoli[numVeicoli++] = veicolo;
        return true;
    }

    public Veicolo cerca(String targa) {
        for (int i = 0; i < numVeicoli; i++) {
            if (veicoli[i].getTarga().equals(targa)) return veicoli[i];
        }
        return null;
    }

    public Veicolo[] cerca(double min, double max) {
        int n = 0;
        for (int i = 0; i < numVeicoli; i++) {
            if (veicoli[i].getTariffaOraria() >= min && veicoli[i].getTariffaOraria() <= max) n++;
        }
        Veicolo[] risultati = new Veicolo[n];
        int k = 0;
        for (int i = 0; i < numVeicoli; i++) {
            if (veicoli[i].getTariffaOraria() >= min && veicoli[i].getTariffaOraria() <= max) {
                risultati[k++] = veicoli[i];
            }
        }
        return risultati;
    }

    public boolean uscita(String targa, int ore) {
        Veicolo veicolo = cerca(targa);
        if (veicolo == null || ore <= 0) return false;
        incassoTotale += veicolo.getTariffaOraria() * ore;
        for (int i = 0; i < numVeicoli; i++) {
            if (veicoli[i] == veicolo) {
                for (int j = i; j < numVeicoli - 1; j++) veicoli[j] = veicoli[j + 1];
                veicoli[--numVeicoli] = null;
                return true;
            }
        }
        return false;
    }

    public double incassoTotale() { return incassoTotale; }

    public Veicolo veicoloPiuCostoso() {
        if (numVeicoli == 0) return null;
        Veicolo massimo = veicoli[0];
        for (int i = 1; i < numVeicoli; i++) {
            if (veicoli[i].getTariffaOraria() > massimo.getTariffaOraria()) massimo = veicoli[i];
        }
        return massimo;
    }

    public int contaSottoTariffa(double soglia) {
        int conteggio = 0;
        for (int i = 0; i < numVeicoli; i++) {
            if (veicoli[i].getTariffaOraria() < soglia) conteggio++;
        }
        return conteggio;
    }

    public String[] targheParcheggiate() {
        String[] targhe = new String[numVeicoli];
        for (int i = 0; i < numVeicoli; i++) targhe[i] = veicoli[i].getTarga();
        return targhe;
    }

    @Override
    public String toString() {
        String risultato = "";
        for (int i = 0; i < numVeicoli; i++) risultato += veicoli[i] + "\n";
        return risultato;
    }
}
