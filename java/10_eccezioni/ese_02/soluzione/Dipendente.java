/**
 * Classe astratta che rappresenta un Dipendente.
 */
public abstract class Dipendente {
    private String nome;
    private String cognome;
    private String matricola;
    private double stipendioBase;

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
        if (stipendioBase <= 0) {
            throw new StipendioNegativoException("Stipendio base non valido: " + stipendioBase);
        }
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.stipendioBase = stipendioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }

    public void setStipendioBase(double stipendioBase) throws StipendioNegativoException {
        if (stipendioBase <= 0) {
            throw new StipendioNegativoException("Stipendio base non valido: " + stipendioBase);
        }
        this.stipendioBase = stipendioBase;
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
        return getTipo() + " - " + nome + " " + cognome + " (" + matricola + ") - Stipendio base: €" 
            + String.format("%.2f", stipendioBase);
    }
}
