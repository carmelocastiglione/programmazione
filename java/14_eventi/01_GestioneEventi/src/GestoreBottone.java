import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class GestoreBottone implements ActionListener {

    private JTextArea textArea;
    
        public GestoreBottone(JTextArea textArea) {
            this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // getActionCommand() restituisce il testo del pulsante
        // o la stringa impostata da .setActionCommand()
        String pulsante = e.getActionCommand(); 
        if (pulsante.equals("btn1")) {
            textArea.append("Hai premuto il pulsante " + pulsante + "\n");
        }
        if (pulsante.equals("btn2")) {
            textArea.append("Hai premuto il pulsante " + pulsante + "\n");
        }
    }

}
