package dev.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Main Class Tests")
public class MainTest {

    @Test
    @DisplayName("Main class should be instantiable")
    void testMainInstantiation() {
        Main main = new Main();
        assertNotNull(main);
    }

    @Test
    @DisplayName("Main class should have main method")
    void testMainMethodExists() {
        try {
            Main.class.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("Main method not found in Main class");
        }
    }

    @Test
    @DisplayName("Main should print 'Hello world!'")
    void testMainOutput() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        
        Main.main(new String[]{});
        
        System.setOut(standardOut);
        
        assertEquals("Hello world!" + System.lineSeparator(), outputStreamCaptor.toString());
    }
}
