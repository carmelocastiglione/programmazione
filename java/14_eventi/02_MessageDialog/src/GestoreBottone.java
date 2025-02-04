import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestoreBottone implements ActionListener {

    private JTextField campoCognome;
    private JTextField campoNome;
    private Container container;
        
    public GestoreBottone(Container container, JTextField campoCognome, JTextField campoNome) {
        this.container = container;
        this.campoCognome= campoCognome;
        this.campoNome = campoNome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("ok")) {
            String cognome = campoCognome.getText();
            String nome = campoNome.getText();
            if (cognome.isEmpty() || nome.isEmpty()) {
                JOptionPane.showMessageDialog(
                    container, 
                    "I dati sono obbligatori", 
                    "Attenzione",
                    JOptionPane.WARNING_MESSAGE);     
            } else {
                JOptionPane.showMessageDialog(
                    container, 
                    "Dati inseriti: " + cognome + " " + nome, 
                    "Conferma",
                    JOptionPane.INFORMATION_MESSAGE);   
            }
        }
        if (action.equals("reset")) {
            campoCognome.setText("");
            campoNome.setText("");
        }
    }

}
