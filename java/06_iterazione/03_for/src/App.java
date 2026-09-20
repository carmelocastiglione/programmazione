public class App {
    public static void main(String[] args) throws Exception {
        // Ciclo for
        for (int i = 0; i < 10; i++) {
            System.out.println("Iterazione: " + i);
        }

        // Ciclo for annidato
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i: " + i + ", j: " + j);
            }
        }

        // For each loop (si usa per iterare su tutti gli elementi di un array o di una collezione senza usare un indice)
        String[] array = {"A", "B", "C"};
        for (String elemento : array) {
            System.out.println("Elemento: " + elemento);
        }
    }
}
