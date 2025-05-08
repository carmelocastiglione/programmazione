import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Numero> list = generateSortedArray(10);
        printArray(list);
        int index = binarySearch(list, 30);
        if (index != -1) {
            System.out.println("Trovato all'indice: " + index);
        } else {
            System.out.println("Non trovato");
        }
    }

    private static void printArray(ArrayList<Numero> list) {
        for (Numero numero : list) {
            System.out.println(list.indexOf(numero) + ". " + numero.getNumero());
        }
    }

    private static ArrayList<Numero> generateSortedArray(int size) {
        ArrayList<Numero> list = new ArrayList<>();
        int min = 0;
        for (int i = 0; i < size; i++) {
            int num = min + (int) (Math.random() * 10);
            min = num;
            list.add(new Numero(num));
        }
        return list;
    }

    private static int binarySearch(ArrayList<Numero> list, int n) {
        int low = 0;
        int high = list.size() - 1;
        // Cerco il numero al centro del vettore
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).getNumero() == n) {
                return mid;
            }
            if (list.get(mid).getNumero() < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }
}
