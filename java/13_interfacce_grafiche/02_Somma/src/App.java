import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Calcolatrice");
        JPanel panel = new JPanel();

        JLabel addendo1 = new JLabel("Addendo 1");
        panel.add(addendo1);
        JTextField addendo1Field = new JTextField(10);
        panel.add(addendo1Field);
        

        JLabel addendo2 = new JLabel("Addendo 2");
        panel.add(addendo2);
        JTextField addendo2Field = new JTextField(10);
        panel.add(addendo2Field);

        JButton button = new JButton("Somma");
        button.setPreferredSize(new Dimension(150, 20));
        panel.add(button);

        JLabel risultato = new JLabel("Risultato");
        panel.add(risultato);
        JTextField risultatoField = new JTextField(10);
        panel.add(risultatoField);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!addendo1Field.getText().isEmpty() && !addendo2Field.getText().isEmpty()) {
                    try {
                        int a = Integer.parseInt(addendo1Field.getText());
                        int b = Integer.parseInt(addendo2Field.getText());
                        int somma = a + b;
                        risultatoField.setText(Integer.toString(somma));
                    } catch (Exception exception) {
                        System.err.println("Inserire numeri interi");
                    }
                }
                
            }
        });

        Container container = frame.getContentPane();
        container.add(panel);
        frame.setSize(200, 200);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);    
    }
}
