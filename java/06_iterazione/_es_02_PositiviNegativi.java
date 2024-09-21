import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * _es_02_PositiviNegativi
 */
public class _es_02_PositiviNegativi {

    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        String riga;
        int numero, negativi = 0, positivi = 0;
        System.out.println("Inserisci un numero, 0 per terminare");
        do {
            try {
                riga = tastiera.readLine();
            } catch (IOException e) {
                System.err.println("Errore in lettura");
                return;
            }
            numero = Integer.valueOf(riga);
            if (numero < 0) {
                negativi++;
            }
            if (numero > 0) {
                positivi++;
            }
        } while (numero != 0);   
        System.out.println("Positivi: " + positivi);
        System.out.println("Negativi: " + negativi);
    }
}