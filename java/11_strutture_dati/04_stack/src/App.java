/*
 * La pila (stack) è un esempio di implementazione di una struttura dati LIFO (Last In, First Out) 
 * Gli elementi vengono inseriti e rimossi dalla cima della pila.
 * La pila è utile quando è necessario gestire elementi in ordine inverso rispetto a quello di arrivo, come nelle operazioni di annullamento o nei calcoli con espressioni.
 * Viene implementata tramite LinkedList con i metodi push (per aggiungere elementi) e pop (per rimuovere e restituire l'ultimo elemento)
 */

import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> browserHistory = new LinkedList<String>();
        
        // Aggiunta di elementi alla pila. Push aggiunge un elemento in cima alla pila (ultimo ad entrare, primo ad uscire)
        browserHistory.push("https://www.google.com");
        browserHistory.push("https://www.github.com");
        browserHistory.push("https://www.chatgpt.com");

        // Stampa degli elementi ancora nella pila
        System.out.println("Elementi ancora nella pila: " + browserHistory.size());
        for (String url : browserHistory) {
            System.out.println(url);
        }

        // Rimozione dell'ultimo elemento inserito nella pila (pop = rimuove e restituisce l'ultimo elemento). Ritorna null se la pila è vuota (è safe)
        String ultimoUrlVisitato = browserHistory.pop();
        System.out.println("Ultimo URL visitato, torno indietro: " + ultimoUrlVisitato);

        // Stampa degli elementi ancora nella pila
        System.out.println("Elementi ancora nella pila: " + browserHistory.size());
        for (String url : browserHistory) {
            System.out.println(url);
        }

        // Visualizzazione del prossimo elemento senza rimuoverlo dalla pila (peek = restituisce l'ultimo elemento senza rimuoverlo)
        System.out.println("Prossimo URL da rimuovere: " + browserHistory.peek());
    }
}