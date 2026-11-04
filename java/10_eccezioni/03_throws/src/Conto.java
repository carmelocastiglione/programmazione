/**
 * Conto
 */
import java.util.Scanner;

public class Conto {
    private double saldo = 500;

    public void effettuaPrelievo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci l'importo da prelevare: ");
        // Questa istruzione potrebbe generare un'eccezione se l'input non è un numero valido
        double importo = scanner.nextDouble();
        scanner.close();
        if (importo <= saldo) {
            saldo = saldo - importo;
            System.out.println("Prelievo effettuato. Saldo rimanente: " + saldo);
        } else {
            // Lancia un'eccezione se il saldo non è sufficiente
            throw new InsufficientFundsException("Saldo insufficiente.");
        }
    }
}
