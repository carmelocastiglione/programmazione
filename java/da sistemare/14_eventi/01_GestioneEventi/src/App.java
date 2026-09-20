import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;

public class App {
    public static void main(String[] args) throws Exception {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("My App");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new GestoreFinestra(frame));
        frame.setLayout(new BorderLayout());
        addComponentsToPane(frame.getContentPane());        
        frame.setSize(450, 300);
        frame.setVisible(true);
    }

    public static void addComponentsToPane(Container pane) {
         
        JButton button1 = new JButton("Superiore");
        button1.setActionCommand("btn1");
        button1.setName("test");
        pane.add(button1, BorderLayout.PAGE_START);

        JTextArea textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        pane.add(textArea, BorderLayout.CENTER);

        JButton button2 = new JButton("Inferiore");
        button2.setActionCommand("btn2");
        pane.add(button2, BorderLayout.PAGE_END);

        button1.addActionListener(new GestoreBottone(textArea));
        button2.addActionListener(new GestoreBottone(textArea));
        
    }
}
