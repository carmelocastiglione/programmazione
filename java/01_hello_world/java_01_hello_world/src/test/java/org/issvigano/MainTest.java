package org.issvigano;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;
    
    @BeforeEach
    public void setUp() {
        // Salva l'output standard originale
        standardOut = System.out;
        // Crea uno stream per catturare l'output
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @AfterEach
    public void tearDown() {
        // Ripristina l'output standard
        System.setOut(standardOut);
    }
    
    @Test
    public void testMainPrintsHelloWorld() {
        // Arrange & Act
        String[] args = {};
        Main.main(args);
        
        // Assert
        String output = outputStreamCaptor.toString().trim();
        assertEquals("Hello world!", output);
    }
    
    @Test
    public void testMainOutputNotEmpty() {
        // Arrange & Act
        String[] args = {};
        Main.main(args);
        
        // Assert
        String output = outputStreamCaptor.toString();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }
    
    @Test
    public void testMainWithArgsIgnoresInput() {
        // Arrange & Act
        String[] args = {"arg1", "arg2", "arg3"};
        Main.main(args);
        
        // Assert
        String output = outputStreamCaptor.toString().trim();
        assertEquals("Hello world!", output);
    }
}
