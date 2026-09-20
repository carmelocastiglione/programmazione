public class App {
    public static void main(String[] args) throws Exception {
        // Ciclo while
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        // Ciclo infinito (verrà interrotto con break)
        int j = 0;
        while (true) {
            System.out.println(j);
            j++;
            if (j == 5) {
                break;
            }
        }

        // Ciclo mai eseguito
        int k = 0;
        while (k < 0) {
            System.out.println("Questa frase non verrà mai stampata");
            k++;
        }
    }
}
