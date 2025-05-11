import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Numero> list = generateArray(10);
        printArray(list);
        insertionSort(list);
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

    private static void insertionSort(ArrayList<Numero> list) {
        //Numero key;
        // inizio dal secondo elemento perché assumiamo che il primo sia già ordinato
        // e lo confronto con gli elementi precedenti
        for (int i = 1; i < list.size(); i++) {
            Numero key = list.get(i);
            int j = i - 1;

            // Confronta key con ogni elemento alla sua sinistra finche'  non si trova 
            // un elemento piu'  piccolo o uguale
            while (j >= 0 && key.getNumero() < list.get(j).getNumero()) {
                list.set(j + 1, list.get(j));
                // se fosse stato un array, avremmo dovuto usare list[j + 1] = list[j];
                j--;
            }
            // se fosse stato un array, avremmo dovuto usare list[j + 1] = key;
            list.set(j + 1, key);

            // Togliere i commenti per visualizzare tutti i passaggi
            //System.out.println("Passo " + i + ": confronto " + key.getNumero());
            //printArray(list);
        }
    }
}
