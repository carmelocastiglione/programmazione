public class _02_Matrice {
    public static void main(String[] args) {
        int matrice[][] = new int[3][3];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                matrice[i][j] = (int) (Math.random() * 10);
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Trasposta");
        int trasposta[][] = new int[3][3];
        for (int i = 0; i < trasposta.length; i++) {
            for (int j = 0; j < trasposta.length; j++) {
                trasposta[i][j] = matrice[j][i];
                System.out.print(trasposta[i][j] + " ");
            }
            System.out.println();
        }
    }
}
