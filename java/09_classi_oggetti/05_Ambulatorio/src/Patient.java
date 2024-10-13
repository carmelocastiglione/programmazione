public class Patient {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int badgeMedico;

    public Patient(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.badgeMedico = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public int getMedico() {
        return badgeMedico;
    }

    public void setBadgeMedico(int badgeMedico) {
        this.badgeMedico = badgeMedico;
    }

}
