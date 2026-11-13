/*
 * Un HashSet è una struttura dati che implementa l'interfaccia Set in Java.
 * Le strutture dati che implementano l'interfaccia Set non permettono elementi duplicati. Le principali sono:
 * 
 * - HashSet
 * - LinkedHashSet
 * - TreeSet
 * 
 * Rispetto alle List:
 * - Non permettono elementi duplicati
 * - Non garantiscono un ordine specifico degli elementi (tranne LinkedHashSet e TreeSet)
 * - Non è possibile accedere agli elementi tramite indice
 * 
 * Un HashSet è una collezione che non permette elementi duplicati e non garantisce un ordine specifico.
 * Viene spesso utilizzato quando si vuole garantire l'unicità degli elementi in una collezione.
 */

import java.util.HashSet;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        // Creo due oggetti Film
        Film film = new Film("Inception", "Christopher Nolan", 2010);
        Film film2 = new Film("The Dark Knight", "Christopher Nolan", 2008);
        Film film3 = new Film("Interstellar", "Christopher Nolan", 2014);
        Film film4 = new Film("Dunkirk", "Christopher Nolan", 2017);

        // Creo un HashSet per contenere i film
        HashSet<Film> listaFilm = new HashSet<Film>();
        // Aggiungo un elemento all'HashSet
        listaFilm.add(film);
        // Provo ad aggiungere di nuovo lo stesso film, non verrà aggiunto perché è già presente nell'HashSet. Si può verificare con un if che controlla il valore di ritorno del metodo add (che ritorna true se l'elemento è stato aggiunto, false altrimenti)
        // Esempio:
        if (!listaFilm.add(film)) {
            System.out.println("Il film " + film.getTitolo() + " non è stato aggiunto perché è già presente nell'HashSet.");
        }
        // Aggiungo gli altri film all'HashSet
        listaFilm.add(film2);
        listaFilm.add(film3);
        listaFilm.add(film4);

        // Numero di elementi nell'HashSet
        System.out.println("Numero di film nell'HashSet: " + listaFilm.size());

        // Itero su tutti gli elementi dell'HashSet (con ciclo for-each)
        for (Film f : listaFilm) {
            System.out.println("Film nell'HashSet: " + f.getTitolo());
        }
        System.out.println("-------------");

        // Non posso iterare con un ciclo for poiché gli elementi di un HashSet non hanno un indice.

        // Itero su tutti gli elementi dell'HashSet (con iterator)
        Iterator<Film> iterator = listaFilm.iterator();
        while (iterator.hasNext()) {
            System.out.println("Film nell'HashSet (iterator): " + iterator.next().getTitolo());
        }
        System.out.println("-------------");

        // Controllo se l'HashSet contiene un elemento
        if (listaFilm.contains(film)) {
            System.out.println("L'HashSet contiene il film: " + film.getTitolo());
        } else {
            System.out.println("L'HashSet non contiene il film: " + film.getTitolo());
        }

        // Tolgo un elemento dall'HashSet
        if (listaFilm.remove(film)) {
            System.out.println("Il film " + film.getTitolo() + " è stato rimosso dall'HashSet.");
        } else {
            System.out.println("Il film " + film.getTitolo() + " non era presente nell'HashSet.");
        }

        // Pulisco l'HashSet
        listaFilm.clear();

        // Controllo se l'HashSet è vuoto dopo averlo pulito
        if (listaFilm.isEmpty()) {
            System.out.println("L'HashSet è vuoto.");
        }
    }
}
