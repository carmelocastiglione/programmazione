public class App {
    public static void main(String[] args) throws Exception {
        String stringa1 = "Python";
        String stringa2 = "Java";
        String stringa3 = "C";
        String stringa4 = "Rust";
        List list = new List();
        list.add(stringa1);
        list.add(stringa2);
        list.add(stringa3);
        list.add(stringa4);
        list.print();
        if (list.contains("Python")) {
            System.out.println("Contiene l'elemento");
        } else {
            System.out.println("Non contiene l'elemento");
        }
        list.remove("Python");
        list.print();
        if (list.contains("Python")) {
            System.out.println("Contiene l'elemento");
        } else {
            System.out.println("Non contiene l'elemento");
        }
    }
}
