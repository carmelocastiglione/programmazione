import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _03_InputNumerico {
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        System.out.print("Inserisci un numero: ");
        try {
            String lettura = tastiera.readLine();
            int num = Integer.valueOf(lettura).intValue();
            System.out.println(num);
        } catch (Exception e) {
            System.err.println("Errore lettura numero");
            return;
        }
    }
}
