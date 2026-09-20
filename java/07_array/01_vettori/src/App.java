public class App {
    public static void main(String[] args) throws Exception {
        // Dichiarazione e inizializzazione in momenti diversi
        // In C: int vett[5], qui invece si crea un oggetto con la parola chiave 'new'
        int[] vett = new int[5];
        vett[0] = 6;
        vett[1] = 7;
        vett[2] = 8;
        vett[3] = 9;
        vett[4] = 10;
        for (int i = 0; i < vett.length; i++) {
            System.out.println(vett[i]);
        }

        // Dichiarazione e inizializzazione di un vettore di interi
        int[] vettore = {1, 2, 3, 4, 5};
        for (int i = 0; i < vettore.length; i++) {
            System.out.println(vettore[i]);
        }

        // Vettore di stringhe
        String[] vettoreStringhe = {"uno", "due", "tre", "quattro", "cinque"};
        for (int i = 0; i < vettoreStringhe.length; i++) {
            System.out.println(vettoreStringhe[i]);
        }

        // Uso di for-each
        for (int elemento : vettore) {
            System.out.println(elemento);
        }
        for (String elemento : vettoreStringhe) {
            System.out.println(elemento);
        }
    }
}
