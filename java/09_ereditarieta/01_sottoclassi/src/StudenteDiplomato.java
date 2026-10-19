/**
 * StudenteDiplomato
 */
public class StudenteDiplomato  extends Studente {
    // Questa classe rappresenta uno studente diplomato, estendendo la classe Studente e ne eredita gli attributi.
    private int votoDiploma;

    public StudenteDiplomato(String nome, String cognome, String scuola, int votoDiploma) {
        /* 
         * Chiamata al costruttore della superclasse Studente:
         * Viene utilizzata la parola chiave super per chiamare il costruttore della superclasse Studente
         */ 
        super(nome, cognome, scuola);
        this.votoDiploma = votoDiploma;
    }

    // La sottoclasse eredita tutti i metodi della sujperclasse, implemento solamente i metodi relativi al voto di diploma.
    public int getVotoDiploma() {
        return votoDiploma;
    }

    public void setVotoDiploma(int votoDiploma) {
        this.votoDiploma = votoDiploma;
    }

    @Override
    public String toString() {
        return super.toString() + ", Voto Diploma: " + votoDiploma;
    }
}
