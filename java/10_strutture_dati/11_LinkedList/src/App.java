import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Mercedes");
        list.add("Audi");
        list.add("BMW");
        list.add("Fiat");
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println(list.contains("BMW"));
    }
}
