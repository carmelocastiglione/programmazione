public class Doctor extends Patient {
    private int badge;
    private String specializzazione;

    public Doctor(String nome, String cognome, String codiceFiscale, int badge, String specializzazione) {
        super(nome, cognome, codiceFiscale);
        this.badge = badge;
        this.specializzazione = specializzazione;
    }

    public int getBadge() {
        return badge;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }
    
}
