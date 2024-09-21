import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        String riga;
        Calcolatrice calcolatrice = new Calcolatrice();
        System.err.println("Inserisci due numeri");
        riga = tastiera.readLine();
        int num1 = Integer.valueOf(riga);
        riga = tastiera.readLine();
        int num2 = Integer.valueOf(riga);
        int somma = calcolatrice.addizione(num1, num2);
        System.out.println("Somma: " + somma);

    }
}
