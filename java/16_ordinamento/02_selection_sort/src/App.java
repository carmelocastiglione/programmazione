import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Numero> list = generateArray(10);
        printArray(list);
        selectionSort(list);
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

    private static void selectionSort(ArrayList<Numero> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // Cerco il minimo nel vettore 
            int min_index = i;
            Numero temp;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getNumero() < list.get(min_index).getNumero()) {
                    min_index = j;
                }
            }
            // Una volta che trovo il minimo, lo scambio con l'elemento selezionato
            temp = list.get(min_index);
            // in caso di array statico:
            // array[min_index] = array[i];
            // array[i] = temp;
            list.set(min_index, list.get(i));
            list.set(i, temp);

            // Togliere i commenti per visualizzare tutti i passaggi
            //System.out.println("Passo " + i + ": confronto " + key.getNumero());
            //printArray(list);
        }
    }
}
