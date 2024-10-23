import java.util.Vector;

public class App {
    public static void main(String[] args) throws Exception {
        Vector<Integer> vector = new Vector<Integer>();
        // Vector vector = new Vector(5);
        // Vector vector = new Vector(5);
        // Vector vector = new Vector(5, 2);
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }
        System.out.println();
        vector.removeElementAt(1);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }

    }
}
