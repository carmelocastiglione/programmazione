/**
 * Un arraylist è un array che può crescere dinamicamente e contiene oggetti dello stesso tipo che sono accessibili tramite indice.
 * ArrayList è una classe che implementa l'interfaccia List, che a sua volta fa parte delle Collection.
 * Interfacce | Classi principali               | Descrizione
 * List       | ArrayList, LinkedList           | Collezione ordinata di elementi
 * Set        | HashSet, TreeSet, LinkedHashSet | Collezione di elementi unici
 * Map        | HashMap, TreeMap, LinkedHashMap | Collezione di coppie chiave-valore
 * Per l'interfaccia List, le implementazioni principali sono ArrayList e LinkedList. ArrayList è basata su array dinamici, mentre LinkedList è basata su nodi collegati.
 * Una List si usa quando:
 * - si vuole mantenere l'ordine degli elementi
 * - si vogliono avere elementi duplicati
 * - si vuole avere accesso tramite indice.
 * Una List si differenzia da un array per:
 * - la dimensione può crescere dinamicamente
 * - è più flessibile di un array tradizionale, ma può essere meno efficiente in termini di prestazioni.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        // Creazione di una lista di automobili
        // un ArrayList permette di memorizzare un lista di oggetti dello stesso tipo, funziona anche con il polimorfismo (Veicoli -> Auto, Moto)
        // Per creare una lista di int, char, double, ecc. si usano le classi wrapper (Integer, Character, Double, ecc.) perché ArrayList non supporta i tipi primitivi direttamente.
        ArrayList<Alunno> alunni = new ArrayList<Alunno>();
        ArrayList<Integer> numeri = new ArrayList<Integer>(); // esempio di lista di interi usando la classe wrapper Integer

        // Aggiungere oggetti alla lista
        alunni.add(new Alunno("Mario"));
        alunni.add(new Alunno("Luigi"));
        alunni.add(new Alunno("Peach"));
        // Si può anche aggiungere un elemento in una posizione specifica (attenzione, può causare un IndexOutOfBoundsException)
        alunni.add(1, new Alunno("Bowser"));

        // Stampo tutti gli elementi della lista (con foreach)
        for (Alunno alunno : alunni) {
            System.out.println(alunno);
        }
        System.out.println("----");

        // Stampo tutti gli elementi della lista (con iterator)
        Iterator<Alunno> iterator = alunni.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----");

        // Ottengo il secondo elemento della lista (l'indice, come negli array, parte da 0)
        // alunni.get(1) è simile ad alunni[1] negli array tradizionali
        System.out.println(alunni.get(1));

        // Numero di elementi nella lista
        System.out.println("Numero di elementi nella lista: " + alunni.size());

        // Stampo tutti gli elementi della lista (con semplice for)
        for (int i = 0; i < alunni.size(); i++) {
            System.out.println(alunni.get(i));
        }
        System.out.println("----");

        // Sostituisco il terzo elemento della lista (attenzione, può generare IndexOutOfBoundsException se l'indice non esiste)
        alunni.set(2, new Alunno("Yoshi"));
        System.out.println(alunni.get(2));

        Alunno alunnoDaRimuovere = null;
        // Eliminazione di un elemento dalla lista
        for (Alunno alunno : alunni) {
            if (alunno.getNome().equals("Luigi")) {
                alunnoDaRimuovere = alunno;
                alunni.remove(alunno);
                System.out.println("Rimosso: " + alunnoDaRimuovere);
                break;
            }
        }

        // Posso eliminare un elemento ad un indice specifico (attenzione, può generare IndexOutOfBoundsException se l'indice non esiste)
        alunni.remove(0);

        // Controllo se la lista contiene un elemento specifico
        System.out.println(alunni.contains(alunnoDaRimuovere));

        // Ottengo l'indice di un elemento nella lista (-1 se non esiste)
        System.out.println(alunni.indexOf(alunnoDaRimuovere));

        // Pulizia della lista
        alunni.clear();
        System.out.println(alunni.isEmpty());

    }
}
