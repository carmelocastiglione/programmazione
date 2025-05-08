import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Numero> list = generateArray(1000);
        printArray(list);
        int index = linearSearch(list, 10);
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

    private static ArrayList<Numero> generateArray(int size) {
        ArrayList<Numero> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = (int) (Math.random() * 1000);
            list.add(new Numero(num));
        }
        return list;
    }

    private static int linearSearch(ArrayList<Numero> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumero() == n) {
                return i;
            }
        }
        return -1;
    }
}
