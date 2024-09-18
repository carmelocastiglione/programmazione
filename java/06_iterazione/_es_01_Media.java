import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _es_01_Media {
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        double totale = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("Inserisci un voto: ");
            try {
                String lettura = tastiera.readLine();
                Double numero = Double.valueOf(lettura);
                totale = totale + numero;
            } catch (Exception e) {
                System.err.println("Errore in lettura");
                return;
            }
        }
        double media = totale / 3;
        System.out.println("La media dei tre numeri è: " + media);
    }
}