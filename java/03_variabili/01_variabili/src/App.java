public class App {
    public static void main(String[] args) throws Exception {
        // int: numeri interi
        int intero = 4;
        System.out.println(intero);

        // double: numeri con la virgola a doppia precisione
        double conVirgola = 4.5;
        System.out.println(conVirgola);

        // float: numeri con la virgola a singola precisione
        float singolaPrecisione = 3.0f;
        System.out.println(singolaPrecisione);

        // char: singolo carattere
        char lettera = 'N';
        System.out.println(lettera);

        // String: sequenza di caratteri
        String testo = "Ciao";
        System.out.println(testo);

        // Concatenazione di stringhe
        String concatenata = testo + " " + lettera;
        System.out.println(concatenata);

        // Concatenazione di stringa e numero
        String concatenataConNumero = testo + " " + intero;
        System.out.println(concatenataConNumero);

        // boolean: vero o falso
        boolean vero = true;
        System.out.println(vero);

        // Costanti: valori che non cambiano
        final double PI_GRECO = 3.14;
        System.out.println(PI_GRECO);

        // Errore: non è possibile modificare una costante
        // PI_GRECO = 3.14159; 

        // Somma di un intero e un double
        double risultato = intero + conVirgola;
        System.out.println(risultato);
        
        // Dichiarazione multiple variabili dello stesso tipo
        int a = 1, b = 2, c = 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // Assegnazione multipla dello stesso valore
        int x, y, z;
        x = y = z = 5;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
