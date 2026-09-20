public class App {
    public static void main(String[] args) throws Exception {
        // Lunghezza di una stringa
        String testo = "Ciao, mondo!";
        int lunghezza = testo.length();
        System.out.println("La lunghezza della stringa è: " + lunghezza);

        // Trasformare la stringa in maiuscolo
        String maiuscolo = testo.toUpperCase();
        System.out.println("La stringa in maiuscolo è: " + maiuscolo);

        // Trasformare la stringa in minuscolo
        String minuscolo = testo.toLowerCase();
        System.out.println("La stringa in minuscolo è: " + minuscolo);

        // Trovare un carattere specifico nella stringa
        char carattere = 'o';
        int indice = testo.indexOf(carattere);
        System.out.println("Il carattere '" + carattere + "' si trova all'indice: " + indice);

        // Trovare il carattere in un indice specifico
        char carattereSpecifico = testo.charAt(4);
        System.out.println("Il carattere all'indice 4 è: " + carattereSpecifico);

        // Comparare due stringhe
        String altraStringa = "Ciao, mondo!";
        boolean uguali = testo.equals(altraStringa);
        System.out.println("Le due stringhe sono uguali? " + uguali);

        // Rimuovere gli spazi iniziali e finali
        String testoConSpazi = "   " + testo + "   ";
        System.out.println("La stringa con spazi iniziali e finali è: '" + testoConSpazi + "'");
        String testoTrimmed = testoConSpazi.trim();
        System.out.println("La stringa senza spazi iniziali e finali è: '" + testoTrimmed + "'");

        // Caratteri di escape
        String stringaConEscape = "Ciao, \"mondo\"!";
        System.out.println("La stringa con caratteri di escape è: " + stringaConEscape);

        // Puoi trovare altri metodi utili qui: https://www.w3schools.com/java/java_ref_string.asp
    }
}
