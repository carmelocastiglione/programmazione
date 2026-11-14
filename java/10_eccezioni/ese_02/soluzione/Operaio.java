/**
 * Classe che rappresenta un Operaio.
 * Estende Dipendente e implementa Calcolabile.
 */
public class Operaio extends Dipendente implements Calcolabile {
    private int oreSettimanali;
    private double costoOrario;

    /**
     * Costruttore dell'operaio.
     * @param nome Nome dell'operaio
     * @param cognome Cognome dell'operaio
     * @param matricola Matricola dell'operaio
     * @param stipendioBase Stipendio base
     * @param oreSettimanali Ore di lavoro settimanali (max 40)
     * @param costoOrario Costo orario
     * @throws StipendioNegativoException se lo stipendio base non è valido
     * @throws OreNonValidaException se le ore settimanali non sono valide
     */
    public Operaio(String nome, String cognome, String matricola, double stipendioBase,
                   int oreSettimanali, double costoOrario) 
            throws StipendioNegativoException, OreNonValidaException {
        super(nome, cognome, matricola, stipendioBase);
        if (oreSettimanali <= 0 || oreSettimanali > 40) {
            throw new OreNonValidaException("Ore settimanali non valide: " + oreSettimanali);
        }
        this.oreSettimanali = oreSettimanali;
        this.costoOrario = costoOrario;
    }

    @Override
    public String getTipo() {
        return "Operaio";
    }

    public int getOreSettimanali() {
        return oreSettimanali;
    }

    public void setOreSettimanali(int oreSettimanali) throws OreNonValidaException {
        if (oreSettimanali <= 0 || oreSettimanali > 40) {
            throw new OreNonValidaException("Ore settimanali non valide: " + oreSettimanali);
        }
        this.oreSettimanali = oreSettimanali;
    }

    public double getCostoOrario() {
        return costoOrario;
    }

    @Override
    public double calcolaStipendio() {
        double stipendioMensile = getStipendioBase();
        return (stipendioMensile / 160) * oreSettimanali;
    }

    @Override
    public double calcolaTasse() {
        return calcolaStipendio() * 0.20;
    }

    @Override
    public double getNettoStipendio() {
        return calcolaStipendio() - calcolaTasse();
    }

    @Override
    public String toString() {
        return super.toString() + " - Ore settimanali: " + oreSettimanali 
            + " - Stipendio calcolato: €" + String.format("%.2f", calcolaStipendio())
            + " - Netto: €" + String.format("%.2f", getNettoStipendio());
    }
}
