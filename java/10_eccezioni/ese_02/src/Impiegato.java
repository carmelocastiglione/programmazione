/**
 * Classe che rappresenta un Impiegato.
 * Estende Dipendente e implementa Calcolabile.
 */
public class Impiegato extends Dipendente implements Calcolabile {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore dell'impiegato.
     * @param nome Nome dell'impiegato
     * @param cognome Cognome dell'impiegato
     * @param matricola Matricola dell'impiegato
     * @param stipendioBase Stipendio base
     * @param ral Retribuzione Annuale Lorda
     * @param bonus Bonus dell'impiegato
     * @throws StipendioNegativoException se lo stipendio base non è valido
     */
    public Impiegato(String nome, String cognome, String matricola, double stipendioBase,
                     double ral, double bonus) throws StipendioNegativoException {
        super(nome, cognome, matricola, stipendioBase);
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String getTipo() {
        throw new UnsupportedOperationException("Da completare");
    }

    public double getRal() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setRal(double ral) {
        throw new UnsupportedOperationException("Da completare");
    }

    public double getBonus() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setBonus(double bonus) throws StipendioNegativoException {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public double calcolaStipendio() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public double calcolaTasse() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public double getNettoStipendio() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
