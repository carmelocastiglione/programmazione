/**
 * Classe che rappresenta un Impiegato.
 * Estende Dipendente e implementa Calcolabile.
 */
public class Impiegato extends Dipendente implements Calcolabile {
    private double ral;
    private double bonus;

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
        this.ral = ral;
        this.bonus = bonus;
    }

    @Override
    public String getTipo() {
        return "Impiegato";
    }

    public double getRal() {
        return ral;
    }

    public void setRal(double ral) {
        this.ral = ral;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) throws StipendioNegativoException {
        if (bonus < 0) {
            throw new StipendioNegativoException("Bonus non valido: " + bonus);
        }
        this.bonus = bonus;
    }

    @Override
    public double calcolaStipendio() {
        return (ral / 12.0) + bonus;
    }

    @Override
    public double calcolaTasse() {
        return calcolaStipendio() * 0.23;
    }

    @Override
    public double getNettoStipendio() {
        return calcolaStipendio() - calcolaTasse();
    }

    @Override
    public String toString() {
        return super.toString() + " - RAL: €" + String.format("%.2f", ral)
            + " - Bonus: €" + String.format("%.2f", bonus)
            + " - Stipendio calcolato: €" + String.format("%.2f", calcolaStipendio())
            + " - Netto: €" + String.format("%.2f", getNettoStipendio());
    }
}
