/**
 * Classe astratta che rappresenta un Dipendente.
 */
public abstract class Dipendente {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore del dipendente.
     * @param nome Nome del dipendente
     * @param cognome Cognome del dipendente
     * @param matricola Matricola del dipendente
     * @param stipendioBase Stipendio base (deve essere > 0)
     * @throws StipendioNegativoException se lo stipendio base non è valido
     */
    public Dipendente(String nome, String cognome, String matricola, double stipendioBase) 
            throws StipendioNegativoException {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setNome(String nome) {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getCognome() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setCognome(String cognome) {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getMatricola() {
        throw new UnsupportedOperationException("Da completare");
    }

    public double getStipendioBase() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setStipendioBase(double stipendioBase) throws StipendioNegativoException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Metodo astratto che restituisce il tipo di dipendente.
     * @return "Operaio", "Impiegato" o "Dirigente"
     */
    public abstract String getTipo();

    /**
     * Metodo astratto per calcolare lo stipendio.
     * @return Lo stipendio calcolato
     */
    public abstract double calcolaStipendio();

    /**
     * Calcola le tasse sullo stipendio (da implementare nelle sottoclassi tramite interfaccia).
     * @return Le tasse calcolate
     */
    public abstract double calcolaTasse();

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
