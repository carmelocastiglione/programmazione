/* Le LinkedList sono simili alle ArrayList, ma sono implementate come liste doppiamente collegate. 
 * Questo significa che ogni elemento della lista contiene un riferimento all'elemento precedente e a quello successivo, permettendo inserimenti e rimozioni efficienti in qualsiasi punto della lista. 
 * Tuttavia, l'accesso agli elementi tramite indice è meno efficiente rispetto alle ArrayList, poiché richiede la scansione della lista dall'inizio o dalla fine fino a raggiungere l'elemento desiderato. 
 * In sintesi, le LinkedList sono ideali quando si effettuano frequenti inserimenti e rimozioni di elementi (manipolazioni), mentre le ArrayList sono più efficienti per l'accesso diretto agli elementi.
 */
import java.util.Iterator;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Giocatore> giocatori = new LinkedList<Giocatore>();
        // Aggiunta dei giocatori alla lista
        giocatori.add(new Giocatore("Diego Armando Maradona"));
        giocatori.add(new Giocatore("Lionel Messi"));
        giocatori.add(new Giocatore("Cristiano Ronaldo"));
        
        // Inserimento di un giocatore in una posizione specifica
        giocatori.add(1, new Giocatore("Zinedine Zidane"));

        // Stampo tutti gli elementi della lista (con foreach)
        for (Giocatore giocatore : giocatori) {
            System.out.println(giocatore);
        }
        System.out.println("----");

        // Stampo tutti gli elementi della lista (con iterator)
        Iterator<Giocatore> iterator = giocatori.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----");

        // Ottengo il secondo elemento della lista (l'indice, come negli array, parte da 0)
        // giocatori.get(1) è simile a giocatori[1] negli array
        System.out.println(giocatori.get(1));

        // Numero di elementi nella lista
        System.out.println("Numero di elementi nella lista: " + giocatori.size());

        // Stampo tutti gli elementi della lista (con semplice for)
        for (int i = 0; i < giocatori.size(); i++) {
            System.out.println(giocatori.get(i));
        }
        System.out.println("----");

        // Sostituisco il terzo elemento della lista (attenzione, può generare IndexOutOfBoundsException se l'indice non esiste)
        giocatori.set(2, new Giocatore("Roberto Baggio"));
        System.out.println(giocatori.get(2));

        Giocatore giocatoreDaRimuovere = null;
        // Eliminazione di un elemento dalla lista
        for (Giocatore giocatore : giocatori) {
            if (giocatore.getNome().equals("Roberto Baggio")) {
                giocatoreDaRimuovere = giocatore;
                giocatori.remove(giocatore);
                System.out.println("Rimosso: " + giocatoreDaRimuovere);
                break;
            }
        }

        // Posso eliminare un elemento ad un indice specifico (attenzione, può generare IndexOutOfBoundsException se l'indice non esiste)
        giocatori.remove(0);

        // Controllo se la lista contiene un elemento specifico
        System.out.println(giocatori.contains(giocatoreDaRimuovere));

        // Ottengo l'indice di un elemento nella lista (-1 se non esiste)
        System.out.println(giocatori.indexOf(giocatoreDaRimuovere));

        // Le LinkedList in Java permettono di aggiungere, rimuovere e accedere agli elementi in modo efficiente, specialmente quando si lavora con grandi quantità di dati. Sono meno efficienti nell'accesso diretto agli elementi rispetto agli array o agli ArrayList. I seguenti metodi sono tipici delle LinkedList:
        // - addFirst(E e)
        // - addLast(E e)
        // - removeFirst()
        // - removeLast()
        // - getFirst()
        // - getLast()

        giocatori.addFirst(new Giocatore("Francesco Totti"));
        giocatori.addLast(new Giocatore("Paolo Maldini"));
        System.out.println("Primo elemento: " + giocatori.getFirst());
        System.out.println("Ultimo elemento: " + giocatori.getLast());
        giocatori.removeFirst();
        giocatori.removeLast();
        System.out.println("Dopo rimozione, primo elemento: " + (giocatori.isEmpty() ? "Nessuno" : giocatori.getFirst()));
        System.out.println("Dopo rimozione, ultimo elemento: " + (giocatori.isEmpty() ? "Nessuno" : giocatori.getLast()));

        // Pulizia della lista
        giocatori.clear();
        System.out.println(giocatori.isEmpty());

    }
}