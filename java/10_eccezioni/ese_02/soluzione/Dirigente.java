/**
 * Classe che rappresenta un Dirigente.
 * Estende Dipendente e implementa Calcolabile.
 */
public class Dirigente extends Dipendente implements Calcolabile {
    private int presenze;
    private double percentualeBonusAnnuale;

    /**
     * Costruttore del dirigente.
     * @param nome Nome del dirigente
     * @param cognome Cognome del dirigente
     * @param matricola Matricola del dirigente
     * @param stipendioBase Stipendio base
     * @param presenze Giorni di presenza al mese (max 20)
     * @param percentualeBonusAnnuale Percentuale bonus annuale (5-30%)
     * @throws StipendioNegativoException se lo stipendio base non è valido
     * @throws OreNonValidaException se le presenze non sono valide
     */
    public Dirigente(String nome, String cognome, String matricola, double stipendioBase,
                    int presenze, double percentualeBonusAnnuale) 
            throws StipendioNegativoException, OreNonValidaException {
        super(nome, cognome, matricola, stipendioBase);
        if (presenze <= 0 || presenze > 20) {
            throw new OreNonValidaException("Presenze non valide: " + presenze);
        }
        this.presenze = presenze;
        this.percentualeBonusAnnuale = percentualeBonusAnnuale;
    }

    @Override
    public String getTipo() {
        return "Dirigente";
    }

    public int getPresenze() {
        return presenze;
    }

    public void setPresenze(int presenze) throws OreNonValidaException {
        if (presenze <= 0 || presenze > 20) {
            throw new OreNonValidaException("Presenze non valide: " + presenze);
        }
        this.presenze = presenze;
    }

    public double getPercentualeBonusAnnuale() {
        return percentualeBonusAnnuale;
    }

    @Override
    public double calcolaStipendio() {
        double stipendioMensile = (getStipendioBase() * 1.5);
        double bonusMensile = (getStipendioBase() * percentualeBonusAnnuale / 100.0) / 12.0;
        return stipendioMensile + bonusMensile;
    }

    @Override
    public double calcolaTasse() {
        return calcolaStipendio() * 0.30;
    }

    @Override
    public double getNettoStipendio() {
        return calcolaStipendio() - calcolaTasse();
    }

    @Override
    public String toString() {
        return super.toString() + " - Presenze: " + presenze 
            + " - Bonus annuale: " + String.format("%.1f", percentualeBonusAnnuale) + "%"
            + " - Stipendio calcolato: €" + String.format("%.2f", calcolaStipendio())
            + " - Netto: €" + String.format("%.2f", getNettoStipendio());
    }
}
