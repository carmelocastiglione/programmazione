public class App {
    public static void main(String[] args) throws Exception {
        // Ciclo do/while
        int i = 0;
        do {
            System.out.println("Iterazione: " + i);
            i++;
        } while (i < 5);

        // Ciclo do/while infinito (interrotto con break)
        int j = 0;
        do {
            System.out.println("Iterazione infinita: " + j);
            j++;
            if (j >= 5) {
                break;
            }
        } while (true);

        // Ciclo do/while con condizione inizialmente falsa
        int k = 10;
        do {
            System.out.println("Iterazione con condizione inizialmente falsa: " + k);
            k++;
        } while (k < 5);
    }
}
