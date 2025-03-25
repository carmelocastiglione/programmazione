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
        if (action.equals("info")) {
            JOptionPane.showMessageDialog(
                container, 
                "Questo programma permette di inserire nome e cognome", 
                "Info",
                JOptionPane.PLAIN_MESSAGE);
        }
        if (action.equals("reset")) {
            campoCognome.setText("");
            campoNome.setText("");
        }
        if (action.equals("insert")) {
            String data = JOptionPane.showInputDialog(container, "Inserisci cognome e nome", "Inserisci valori", JOptionPane.YES_NO_CANCEL_OPTION);
            String[] splittedData = data.split(" ");
            campoCognome.setText(splittedData[0]);
            campoNome.setText(splittedData[1]);
        }
        if (action.equals("esci")) {
            int response = JOptionPane.showConfirmDialog(container, "Vuoi uscire?", "Finestra di uscita", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

}
