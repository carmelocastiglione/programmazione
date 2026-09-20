import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Numero> list = generateArray(10);
        printArray(list);
        bubbleSort(list);
        printArray(list);
    }

    private static ArrayList<Numero> generateArray(int size) {
        ArrayList<Numero> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = (int) (Math.random() * 1000);
            list.add(new Numero(num));
        }
        return list;
    }

    private static void printArray(ArrayList<Numero> list) {
        for (Numero numero : list) {
            System.out.println(list.indexOf(numero) + ". " + numero.getNumero());
        }
    }

    private static void bubbleSort(ArrayList<Numero> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // Scambio gli elementi adiacenti se non sono in ordine
                if (list.get(j).getNumero() > list.get(j + 1).getNumero()) {
                    Numero temp = list.get(j);
                    // in caso di array statico
                    // list[j] = list[j + 1];
                    // list[j + 1] = temp;
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            } 
            // Togliere i commenti per visualizzare tutti i passaggi
            //System.out.println("Passo " + i + ": confronto " + key.getNumero());
            //printArray(list);
        }
    }
}

