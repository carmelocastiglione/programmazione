/**
 * Classe che rappresenta un Dirigente.
 * Estende Dipendente e implementa Calcolabile.
 */
public class Dirigente extends Dipendente implements Calcolabile {
    // TODO: dichiara gli attributi richiesti nel README.

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
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String getTipo() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getPresenze() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setPresenze(int presenze) throws OreNonValidaException {
        throw new UnsupportedOperationException("Da completare");
    }

    public double getPercentualeBonusAnnuale() {
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
