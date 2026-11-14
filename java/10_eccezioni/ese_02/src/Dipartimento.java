/**
 * Classe che gestisce un dipartimento con i suoi dipendenti.
 */
public class Dipartimento {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore del dipartimento.
     * @param nome Nome del dipartimento
     * @param budget Budget del dipartimento
     */
    public Dipartimento(String nome, double budget) {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Da completare");
    }

    public double getBudget() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setBudget(double budget) {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Aggiunge un dipendente al dipartimento.
     * @param d Dipendente da aggiungere
     * @throws CapacitaDipartimentoEsceduriException se il dipartimento è pieno
     * @throws MatricolaGiaEsisteException se la matricola esiste già
     */
    public void aggiungiDipendente(Dipendente d) 
            throws CapacitaDipartimentoEsceduriException, MatricolaGiaEsisteException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Cerca un dipendente per matricola.
     * @param matricola Matricola del dipendente
     * @return Il dipendente se trovato
     * @throws DipendentNonTrovatoException se non trovato
     */
    public Dipendente cercaDipendente(String matricola) throws DipendentNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Rimuove un dipendente dal dipartimento.
     * @param matricola Matricola del dipendente da rimuovere
     * @throws DipendentNonTrovatoException se non trovato
     */
    public void removiDipendente(String matricola) throws DipendentNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    public Dipendente[] getDipendenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getNumDipendenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Calcola lo stipendio medio del dipartimento.
     * @return Media degli stipendi
     * @throws DipendentNonTrovatoException se nessun dipendente
     */
    public double stipendioMediaDipartimento() throws DipendentNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Calcola il costo totale del dipartimento.
     * @return Somma di tutti gli stipendi
     * @throws DipendentNonTrovatoException se nessun dipendente
     */
    public double costiDipartimento() throws DipendentNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Conta il numero di operai nel dipartimento.
     * @return Numero di operai
     */
    public int operaiDipartimento() {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Conta il numero di impiegati nel dipartimento.
     * @return Numero di impiegati
     */
    public int impiegatiDipartimento() {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Conta il numero di dirigenti nel dipartimento.
     * @return Numero di dirigenti
     */
    public int dirigentiDipartimento() {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Trova il dipendente con lo stipendio più alto.
     * @return Il dipendente più pagato
     * @throws DipendentNonTrovatoException se nessun dipendente
     */
    public Dipendente getDipendentePiuPagato() throws DipendentNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
