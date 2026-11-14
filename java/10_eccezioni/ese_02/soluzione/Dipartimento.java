/**
 * Classe che gestisce un dipartimento con i suoi dipendenti.
 */
public class Dipartimento {
    private String nome;
    private Dipendente[] dipendenti;
    private int numDipendenti;
    private double budget;

    private static final int MAX_DIPENDENTI = 100;

    /**
     * Costruttore del dipartimento.
     * @param nome Nome del dipartimento
     * @param budget Budget del dipartimento
     */
    public Dipartimento(String nome, double budget) {
        this.nome = nome;
        this.budget = budget;
        this.dipendenti = new Dipendente[MAX_DIPENDENTI];
        this.numDipendenti = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * Aggiunge un dipendente al dipartimento.
     * @param d Dipendente da aggiungere
     * @throws CapacitaDipartimentoEsauritaException se il dipartimento è pieno
     * @throws MatricolaGiaEsisteException se la matricola esiste già
     */
    public void aggiungiDipendente(Dipendente d) 
            throws CapacitaDipartimentoEsauritaException, MatricolaGiaEsisteException {
        // Controlla se la matricola esiste già
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i].getMatricola().equals(d.getMatricola())) {
                throw new MatricolaGiaEsisteException("Matricola " + d.getMatricola() + " già esiste");
            }
        }
        // Controlla capacità
        if (numDipendenti >= MAX_DIPENDENTI) {
            throw new CapacitaDipartimentoEsauritaException("Dipartimento " + nome + " è pieno");
        }
        dipendenti[numDipendenti++] = d;
    }

    /**
     * Cerca un dipendente per matricola.
     * @param matricola Matricola del dipendente
     * @return Il dipendente se trovato
     * @throws DipendenteNonTrovatoException se non trovato
     */
    public Dipendente cercaDipendente(String matricola) throws DipendenteNonTrovatoException {
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i].getMatricola().equals(matricola)) {
                return dipendenti[i];
            }
        }
        throw new DipendenteNonTrovatoException("Dipendente con matricola " + matricola + " non trovato");
    }

    /**
     * Rimuove un dipendente dal dipartimento.
     * @param matricola Matricola del dipendente da rimuovere
     * @throws DipendenteNonTrovatoException se non trovato
     */
    public void removiDipendente(String matricola) throws DipendenteNonTrovatoException {
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i].getMatricola().equals(matricola)) {
                dipendenti[i] = dipendenti[numDipendenti - 1];
                dipendenti[numDipendenti - 1] = null;
                numDipendenti--;
                return;
            }
        }
        throw new DipendenteNonTrovatoException("Dipendente con matricola " + matricola + " non trovato");
    }

    public Dipendente[] getDipendenti() {
        Dipendente[] result = new Dipendente[numDipendenti];
        System.arraycopy(dipendenti, 0, result, 0, numDipendenti);
        return result;
    }

    public int getNumDipendenti() {
        return numDipendenti;
    }

    /**
     * Calcola lo stipendio medio del dipartimento.
     * @return Media degli stipendi
     * @throws DipendenteNonTrovatoException se nessun dipendente
     */
    public double stipendioMediaDipartimento() throws DipendenteNonTrovatoException {
        if (numDipendenti == 0) {
            throw new DipendenteNonTrovatoException("Nessun dipendente nel dipartimento");
        }
        double somma = 0;
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i] instanceof Calcolabile) {
                somma += ((Calcolabile) dipendenti[i]).calcolaStipendio();
            }
        }
        return somma / numDipendenti;
    }

    /**
     * Calcola il costo totale del dipartimento.
     * @return Somma di tutti gli stipendi
     * @throws DipendenteNonTrovatoException se nessun dipendente
     */
    public double costiDipartimento() throws DipendenteNonTrovatoException {
        if (numDipendenti == 0) {
            throw new DipendenteNonTrovatoException("Nessun dipendente nel dipartimento");
        }
        double somma = 0;
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i] instanceof Calcolabile) {
                somma += ((Calcolabile) dipendenti[i]).calcolaStipendio();
            }
        }
        return somma;
    }

    /**
     * Conta il numero di operai nel dipartimento.
     * @return Numero di operai
     */
    public int operaiDipartimento() {
        int count = 0;
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i] instanceof Operaio) {
                count++;
            }
        }
        return count;
    }

    /**
     * Conta il numero di impiegati nel dipartimento.
     * @return Numero di impiegati
     */
    public int impiegatiDipartimento() {
        int count = 0;
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i] instanceof Impiegato) {
                count++;
            }
        }
        return count;
    }

    /**
     * Conta il numero di dirigenti nel dipartimento.
     * @return Numero di dirigenti
     */
    public int dirigentiDipartimento() {
        int count = 0;
        for (int i = 0; i < numDipendenti; i++) {
            if (dipendenti[i] instanceof Dirigente) {
                count++;
            }
        }
        return count;
    }

    /**
     * Trova il dipendente con lo stipendio più alto.
     * @return Il dipendente più pagato
     * @throws DipendenteNonTrovatoException se nessun dipendente
     */
    public Dipendente getDipendentePiuPagato() throws DipendenteNonTrovatoException {
        if (numDipendenti == 0) {
            throw new DipendenteNonTrovatoException("Nessun dipendente nel dipartimento");
        }
        Dipendente max = dipendenti[0];
        double stipendioMax = 0;
        if (max instanceof Calcolabile) {
            stipendioMax = ((Calcolabile) max).calcolaStipendio();
        }
        for (int i = 1; i < numDipendenti; i++) {
            if (dipendenti[i] instanceof Calcolabile) {
                double stipendio = ((Calcolabile) dipendenti[i]).calcolaStipendio();
                if (stipendio > stipendioMax) {
                    stipendioMax = stipendio;
                    max = dipendenti[i];
                }
            }
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DIPARTIMENTO: ").append(nome).append(" ===\n");
        sb.append("Budget: €").append(String.format("%.2f", budget)).append("\n");
        sb.append("Dipendenti totali: ").append(numDipendenti).append("\n");
        sb.append("  - Operai: ").append(operaiDipartimento()).append("\n");
        sb.append("  - Impiegati: ").append(impiegatiDipartimento()).append("\n");
        sb.append("  - Dirigenti: ").append(dirigentiDipartimento()).append("\n");
        sb.append("--- Elenco Dipendenti ---\n");
        for (int i = 0; i < numDipendenti; i++) {
            sb.append(dipendenti[i]).append("\n");
        }
        return sb.toString();
    }
}
