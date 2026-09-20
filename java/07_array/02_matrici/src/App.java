public class App {
    public static void main(String[] args) throws Exception {
        // Matrici
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // Stampa della matrice
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        // Uso del for-each per stampare la matrice
        for (int[] riga : matrice) {
            for (int elemento : riga) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
