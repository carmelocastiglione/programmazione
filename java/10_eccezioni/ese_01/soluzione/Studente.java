/**
 * Classe che rappresenta uno Studente.
 * Estende Persona e implementa Partecipante.
 */
public class Studente extends Persona implements Partecipante {
    private String matricola;
    private int[] voti;
    private int numVoti;
    private Corso[] corsiIscritti;
    private int numCorsi;

    private static final int MAX_VOTI = 50;
    private static final int MAX_CORSI = 10;

    /**
     * Costruttore dello studente.
     * @param nome Nome dello studente
     * @param cognome Cognome dello studente
     * @param email Email dello studente
     * @param matricola Matricola dello studente
     * @throws EmailNonValidaException se email non è valida
     */
    public Studente(String nome, String cognome, String email, String matricola) 
            throws EmailNonValidaException {
        super(nome, cognome, email);
        this.matricola = matricola;
        this.voti = new int[MAX_VOTI];
        this.numVoti = 0;
        this.corsiIscritti = new Corso[MAX_CORSI];
        this.numCorsi = 0;
    }

    @Override
    public String getTipo() {
        return "Studente";
    }

    public String getMatricola() {
        return matricola;
    }

    @Override
    public void iscrivi(Corso c) throws StudenteGiaIscrittoException, CapacitaCorsoEsceduriException {
        // Controlla se già iscritto
        for (int i = 0; i < numCorsi; i++) {
            if (corsiIscritti[i].getCodice().equals(c.getCodice())) {
                throw new StudenteGiaIscrittoException(
                    "Studente " + matricola + " già iscritto al corso " + c.getCodice());
            }
        }
        // Controlla capacità
        if (numCorsi >= MAX_CORSI) {
            throw new StudenteGiaIscrittoException(
                "Studente " + matricola + " ha raggiunto il massimo numero di corsi");
        }
        // Aggiunge il corso (il corso aggiungerà lo studente)
        c.iscrittiStudente(this);
        corsiIscritti[numCorsi++] = c;
    }

    @Override
    public void valuta(int voto) throws VotoNonValidoException {
        if (voto < 0 || voto > 30) {
            throw new VotoNonValidoException("Voto non valido: " + voto + " (deve essere 0-30)");
        }
        if (numVoti >= MAX_VOTI) {
            throw new VotoNonValidoException("Numero massimo di voti raggiunto");
        }
        voti[numVoti++] = voto;
    }

    @Override
    public int[] getVoti() {
        int[] result = new int[numVoti];
        System.arraycopy(voti, 0, result, 0, numVoti);
        return result;
    }

    @Override
    public double getMedia() {
        if (numVoti == 0) {
            return 0.0;
        }
        int somma = 0;
        for (int i = 0; i < numVoti; i++) {
            somma += voti[i];
        }
        return (double) somma / numVoti;
    }

    public Corso[] getCorsiIscritti() {
        Corso[] result = new Corso[numCorsi];
        System.arraycopy(corsiIscritti, 0, result, 0, numCorsi);
        return result;
    }

    public int getNumCorsi() {
        return numCorsi;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola='" + matricola + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cognome='" + getCognome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", numVoti=" + numVoti +
                ", media=" + String.format("%.2f", getMedia()) +
                ", corsi=" + numCorsi +
                '}';
    }
}
