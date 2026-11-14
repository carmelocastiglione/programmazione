import java.util.Scanner;

/**
 * Programma con menu per la gestione dipendenti (non testato da JUnit).
 * Menu interattivo con le seguenti opzioni:
 *   1) Crea dipartimento
 *   2) Aggiungi operaio
 *   3) Aggiungi impiegato
 *   4) Aggiungi dirigente
 *   5) Cerca dipendente
 *   6) Visualizza statistiche dipartimento
 *   7) Stampa dipartimento
 *   0) Esci
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Dipartimento dipartimento = null;
        int scelta;

        do {
            System.out.println("\n=== GESTIONE DIPENDENTI AZIENDALI ===");
            System.out.println("1) Crea dipartimento");
            System.out.println("2) Aggiungi operaio");
            System.out.println("3) Aggiungi impiegato");
            System.out.println("4) Aggiungi dirigente");
            System.out.println("5) Cerca dipendente");
            System.out.println("6) Visualizza statistiche dipartimento");
            System.out.println("7) Stampa dipartimento");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();
            in.nextLine();

            try {
                switch (scelta) {
                    case 1:
                        System.out.print("Nome dipartimento: ");
                        String nomeDip = in.nextLine();
                        System.out.print("Budget: ");
                        double budget = in.nextDouble();
                        dipartimento = new Dipartimento(nomeDip, budget);
                        System.out.println("Dipartimento creato!");
                        break;

                    case 2:
                        if (dipartimento == null) {
                            System.out.println("Crea prima un dipartimento!");
                        } else {
                            System.out.print("Nome: ");
                            String nome = in.nextLine();
                            System.out.print("Cognome: ");
                            String cognome = in.nextLine();
                            System.out.print("Matricola: ");
                            String matr = in.nextLine();
                            System.out.print("Stipendio base: ");
                            double stipBase = in.nextDouble();
                            System.out.print("Ore settimanali (max 40): ");
                            int ore = in.nextInt();
                            System.out.print("Costo orario: ");
                            double costoOr = in.nextDouble();
                            Operaio op = new Operaio(nome, cognome, matr, stipBase, ore, costoOr);
                            dipartimento.aggiungiDipendente(op);
                            System.out.println("Operaio aggiunto!");
                        }
                        break;

                    case 3:
                        if (dipartimento == null) {
                            System.out.println("Crea prima un dipartimento!");
                        } else {
                            System.out.print("Nome: ");
                            String nomeI = in.nextLine();
                            System.out.print("Cognome: ");
                            String cognomeI = in.nextLine();
                            System.out.print("Matricola: ");
                            String matrI = in.nextLine();
                            System.out.print("Stipendio base: ");
                            double stipBaseI = in.nextDouble();
                            System.out.print("RAL: ");
                            double ral = in.nextDouble();
                            System.out.print("Bonus: ");
                            double bonus = in.nextDouble();
                            Impiegato imp = new Impiegato(nomeI, cognomeI, matrI, stipBaseI, ral, bonus);
                            dipartimento.aggiungiDipendente(imp);
                            System.out.println("Impiegato aggiunto!");
                        }
                        break;

                    case 4:
                        if (dipartimento == null) {
                            System.out.println("Crea prima un dipartimento!");
                        } else {
                            System.out.print("Nome: ");
                            String nomeD = in.nextLine();
                            System.out.print("Cognome: ");
                            String cognomeD = in.nextLine();
                            System.out.print("Matricola: ");
                            String matrD = in.nextLine();
                            System.out.print("Stipendio base: ");
                            double stipBaseD = in.nextDouble();
                            System.out.print("Presenze (max 20): ");
                            int presenze = in.nextInt();
                            System.out.print("Percentuale bonus annuale: ");
                            double perBonus = in.nextDouble();
                            Dirigente dir = new Dirigente(nomeD, cognomeD, matrD, stipBaseD, presenze, perBonus);
                            dipartimento.aggiungiDipendente(dir);
                            System.out.println("Dirigente aggiunto!");
                        }
                        break;

                    case 5:
                        if (dipartimento == null) {
                            System.out.println("Crea prima un dipartimento!");
                        } else {
                            System.out.print("Matricola: ");
                            String matrRic = in.nextLine();
                            Dipendente trovato = dipartimento.cercaDipendente(matrRic);
                            System.out.println(trovato);
                        }
                        break;

                    case 6:
                        if (dipartimento == null) {
                            System.out.println("Crea prima un dipartimento!");
                        } else {
                            System.out.println("Stipendio medio: €" + String.format("%.2f", 
                                dipartimento.stipendioMediaDipartimento()));
                            System.out.println("Costo totale: €" + String.format("%.2f", 
                                dipartimento.costiDipartimento()));
                            System.out.println("Dipendente più pagato: " + 
                                dipartimento.getDipendentePiuPagato().getNome() + " " +
                                dipartimento.getDipendentePiuPagato().getCognome());
                        }
                        break;

                    case 7:
                        if (dipartimento == null) {
                            System.out.println("Crea prima un dipartimento!");
                        } else {
                            System.out.println(dipartimento);
                        }
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
