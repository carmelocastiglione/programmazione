import java.util.Scanner;

/**
 * Programma con menu per la piattaforma e-learning (non testato da JUnit).
 * Menu interattivo con le seguenti opzioni:
 *   1) Aggiungi docente
 *   2) Aggiungi corso
 *   3) Aggiungi studente
 *   4) Iscrivi studente a corso
 *   5) Registra voto
 *   6) Visualizza statistiche
 *   7) Stampa piattaforma
 *   0) Esci
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        GestorePiattaforma piattaforma = new GestorePiattaforma();
        int scelta;

        do {
            System.out.println("\n=== PIATTAFORMA E-LEARNING ===");
            System.out.println("1) Aggiungi docente");
            System.out.println("2) Aggiungi corso");
            System.out.println("3) Aggiungi studente");
            System.out.println("4) Iscrivi studente a corso");
            System.out.println("5) Registra voto");
            System.out.println("6) Visualizza statistiche");
            System.out.println("7) Stampa piattaforma");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();
            in.nextLine();

            try {
                switch (scelta) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = in.nextLine();
                        System.out.print("Cognome: ");
                        String cognome = in.nextLine();
                        System.out.print("Email: ");
                        String email = in.nextLine();
                        System.out.print("Specializzazione: ");
                        String spec = in.nextLine();
                        Docente d = new Docente(nome, cognome, email, spec);
                        piattaforma.aggiungiDocente(d);
                        System.out.println("Docente aggiunto!");
                        break;

                    case 2:
                        System.out.print("Codice corso: ");
                        String cod = in.nextLine();
                        System.out.print("Nome corso: ");
                        String nomeCor = in.nextLine();
                        System.out.print("Email docente: ");
                        String emailDoc = in.nextLine();
                        Docente docente = null;
                        for (Docente doc : piattaforma.getDocenti()) {
                            if (doc.getEmail().equals(emailDoc)) {
                                docente = doc;
                                break;
                            }
                        }
                        if (docente == null) {
                            System.out.println("Docente non trovato!");
                        } else {
                            System.out.print("Descrizione: ");
                            String desc = in.nextLine();
                            Corso c = new Corso(cod, nomeCor, docente, desc);
                            piattaforma.aggiungiCorso(c);
                            System.out.println("Corso aggiunto!");
                        }
                        break;

                    case 3:
                        System.out.print("Nome: ");
                        String nomeS = in.nextLine();
                        System.out.print("Cognome: ");
                        String cognomeS = in.nextLine();
                        System.out.print("Email: ");
                        String emailS = in.nextLine();
                        System.out.print("Matricola: ");
                        String matr = in.nextLine();
                        Studente s = new Studente(nomeS, cognomeS, emailS, matr);
                        piattaforma.aggiungiStudente(s);
                        System.out.println("Studente aggiunto!");
                        break;

                    case 4:
                        System.out.print("Matricola studente: ");
                        String matrIscrizione = in.nextLine();
                        System.out.print("Codice corso: ");
                        String codIscrizione = in.nextLine();
                        Studente studIscrizione = piattaforma.cercaStudente(matrIscrizione);
                        Corso corsoIscrizione = piattaforma.cercaCorso(codIscrizione);
                        studIscrizione.iscrivi(corsoIscrizione);
                        System.out.println("Studente iscritto al corso!");
                        break;

                    case 5:
                        System.out.print("Matricola studente: ");
                        String matrVoto = in.nextLine();
                        System.out.print("Voto (0-30): ");
                        int voto = in.nextInt();
                        Studente studVoto = piattaforma.cercaStudente(matrVoto);
                        studVoto.valuta(voto);
                        System.out.println("Voto registrato!");
                        break;

                    case 6:
                        System.out.println("Studente con media migliore: " + 
                            piattaforma.studenteConMediaMigliore());
                        System.out.print("Codice corso per media: ");
                        String codMedia = in.nextLine();
                        System.out.println("Media corso: " + 
                            String.format("%.2f", piattaforma.mediaCorso(codMedia)));
                        break;

                    case 7:
                        System.out.println(piattaforma);
                        break;

                    case 0:
                        System.out.println("Arrivederci!");
                        break;

                    default:
                        System.out.println("Scelta non valida!");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } while (scelta != 0);

        in.close();
    }
}
