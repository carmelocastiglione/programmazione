/**
 * Classe che rappresenta un Docente.
 * Estende Persona.
 */
public class Docente extends Persona {
    private String specializzazione;
    private Corso[] corsiTenuti;
    private int numCorsi;

    private static final int MAX_CORSI = 5;

    /**
     * Costruttore del docente.
     * @param nome Nome del docente
     * @param cognome Cognome del docente
     * @param email Email del docente
     * @param specializzazione Specializzazione del docente
     * @throws EmailNonValidaException se email non è valida
     */
    public Docente(String nome, String cognome, String email, String specializzazione) 
            throws EmailNonValidaException {
        super(nome, cognome, email);
        this.specializzazione = specializzazione;
        this.corsiTenuti = new Corso[MAX_CORSI];
        this.numCorsi = 0;
    }

    @Override
    public String getTipo() {
        return "Docente";
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    /**
     * Aggiunge un corso tenuto dal docente.
     * @param c Corso da aggiungere
     */
    public void aggiungiCorso(Corso c) {
        if (numCorsi < MAX_CORSI) {
            corsiTenuti[numCorsi++] = c;
        }
    }

    public Corso[] getCorsiTenuti() {
        Corso[] result = new Corso[numCorsi];
        System.arraycopy(corsiTenuti, 0, result, 0, numCorsi);
        return result;
    }

    public int getNumCorsi() {
        return numCorsi;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nome='" + getNome() + '\'' +
                ", cognome='" + getCognome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", specializzazione='" + specializzazione + '\'' +
                ", corsiTenuti=" + numCorsi +
                '}';
    }
}
