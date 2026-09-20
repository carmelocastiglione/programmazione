import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class GestoreBottone implements ActionListener {

    private DefaultListModel<Servizio> listModel;
    private JTextField textFieldServizio;
    private JTextField textFieldCosto;

    public GestoreBottone(DefaultListModel<Servizio> listModel, JTextField textFieldServizio, JTextField textFieldCosto) {
        this.listModel = listModel;
        this.textFieldServizio = textFieldServizio;
        this.textFieldCosto = textFieldCosto;
    }

    @Override
            public void actionPerformed(ActionEvent e) {
                Servizio s = new Servizio(textFieldServizio.getText(), Double.parseDouble(textFieldCosto.getText()));
                listModel.addElement(s);
            }

}
