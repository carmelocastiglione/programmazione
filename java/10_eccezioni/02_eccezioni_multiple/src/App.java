import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        String filename = "example.txt";
        try {
            // Questa istruzione potrebbe generare un FileNotFoundException
            Scanner in = new Scanner(new File(filename));
            // Questa istruzione potrebbe generare un NoSuchElementException
            String input = in.next();
            // Questa istruzione potrebbe generare un NumberFormatException
            int value = Integer.parseInt(input);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("No such element: " + e.getMessage());
        }
        System.out.println("Program finished.");
    }
}
