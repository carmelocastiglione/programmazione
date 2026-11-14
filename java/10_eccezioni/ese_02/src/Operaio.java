/**
 * Classe che rappresenta un Operaio.
 * Estende Dipendente e implementa Calcolabile.
 */
public class Operaio extends Dipendente implements Calcolabile {
    // TODO: dichiara gli attributi richiesti nel README.

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
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String getTipo() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getOreSettimanali() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setOreSettimanali(int oreSettimanali) throws OreNonValidaException {
        throw new UnsupportedOperationException("Da completare");
    }

    public double getCostoOrario() {
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
