/*
 * La coda (queue) è un esempio di implementazione di una struttura dati FIFO (First In, First Out) 
 * Gli elementi vengono inseriti alla fine della coda e rimossi dall'inizio.
 * La coda è utile quando è necessario gestire elementi in ordine di arrivo, come nelle code di stampa o nelle code di processi.
 * Viene implementata tramite LinkedList con i metodi add (per aggiungere elementi) e poll (per rimuovere e restituire il primo elemento)
 */

import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> personeInCoda = new LinkedList<String>();
        
        // Aggiunta di persone alla coda
        personeInCoda.add("Signora Maria");
        personeInCoda.add("Avvocato Bianchi");
        personeInCoda.add("Dottoressa Rossi");

        // Stampa delle persone ancora in coda
        System.out.println("Persone ancora in coda: " + personeInCoda.size());
        for (String persona : personeInCoda) {
            System.out.println(persona);
        }

        // Rimozione della prima persona in coda (poll = rimuove e restituisce il primo elemento). Ritorna null se la coda è vuota (è safe)
        String personaServita = personeInCoda.poll();
        System.out.println("Persona servita: " + personaServita);

        // Stampa delle persone ancora in coda
        System.out.println("Persone ancora in coda: " + personeInCoda.size());
        for (String persona : personeInCoda) {
            System.out.println(persona);
        }

        // Visualizzazione del prossimo elemento senza rimuoverlo dalla coda (peek = restituisce il primo elemento senza rimuoverlo)
        System.out.println("Prossima persona in coda: " + personeInCoda.peek());
    }
}
