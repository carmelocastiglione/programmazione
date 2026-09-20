import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> listaStringhe = new LinkedList<String>();
        listaStringhe.add("Marco");
        listaStringhe.add("Luca");
        listaStringhe.add("Veronica");
        listaStringhe.add("Anna");
        System.out.println("----------");
        for (String string : listaStringhe) {
            System.out.println(string);
        }
        listaStringhe.sort(null);
        System.out.println("----------");
        for (String string : listaStringhe) {
            System.out.println(string);
        }
        LinkedList<String> reversedListaStringhe = listaStringhe.reversed();
        System.out.println("----------");
        for (String string : reversedListaStringhe) {
            System.out.println(string);
        }



        LinkedList<Integer> listaInteri = new LinkedList<Integer>();
        listaInteri.add(4);
        listaInteri.add(7);
        listaInteri.add(2);
        listaInteri.add(1);
        System.out.println("----------");
        for (Integer integer : listaInteri) {
            System.out.println(integer);
        }
        listaInteri.sort(null);
        System.out.println("----------");
        for (Integer integer : listaInteri) {
            System.out.println(integer);
        }
        LinkedList<Integer> reversedListaInteri = listaInteri.reversed();
        System.out.println("----------");
        for (Integer integer : reversedListaInteri) {
            System.out.println(integer);
        }



        LinkedList<Persona> listaPersone = new LinkedList<Persona>();
        Persona p1 = new Persona("Marco", "Brambilla", 23);
        Persona p2 = new Persona("Luca", "Rossi", 21);
        Persona p3 = new Persona("Luca", "Colombo", 19);
        Persona p4 = new Persona("Carlo", "Berlusconi", 26);
        listaPersone.add(p1);
        listaPersone.add(p2);
        listaPersone.add(p3);
        listaPersone.add(p4);
        System.out.println("----------");
        for (Persona persona : listaPersone) {
            System.out.println(persona);
        }
        listaPersone.sort(null);
        System.out.println("----------");
        for (Persona persona : listaPersone) {
            System.out.println(persona);
        }
        LinkedList<Persona> reversedListaPersone = listaPersone.reversed();
        System.out.println("----------");
        for (Persona persona : reversedListaPersone) {
            System.out.println(persona);
        }
    }
}
