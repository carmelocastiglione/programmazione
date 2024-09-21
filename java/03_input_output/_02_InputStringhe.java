import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_InputStringhe {
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        System.out.print("Inserisci una stringa: ");
        try {
            String name = tastiera.readLine();
            System.out.println(name);
        } catch (IOException e) {
            System.err.println("Errore lettura file");
        }
    }
}
