public class App {
    public static void main(String[] args) throws Exception {
        // Dipendente è una classe astratta e non può essere istanziata direttamente
        // Dipendente d = new Dipendente();
        Giocatore g = new Giocatore("Mario Rossi");
        System.out.println("Stipendio del giocatore: " + g.calcolaStipendio());
        // Staff è una classe astratta e non può essere istanziata direttamente
        // Staff staff = new Staff();
        Allenatore a = new Allenatore("Luigi Bianchi");
        System.out.println("Stipendio dell'allenatore: " + a.calcolaStipendio());
        Preparatore p = new Preparatore("Carlo Verdi");
        System.out.println("Stipendio del preparatore: " + p.calcolaStipendio());
    }
}
