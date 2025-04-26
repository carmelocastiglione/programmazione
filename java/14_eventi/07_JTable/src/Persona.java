
public class Persona {
    private String nome;
    private String cognome;
    private String hobby;
    private int anni;
    private boolean check;

    public Persona(String nome, String cognome, String hobby, int anni, boolean check) {
        this.nome = nome;
        this.cognome = cognome;
        this.hobby = hobby;
        this.anni = anni;
        this.check = check;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", cognome=" + cognome + ", hobby=" + hobby + ", anni=" + anni + ", check="
                + check + "]";
    }

    
}
