import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GestoreLista implements ListSelectionListener {

    private DefaultListModel<Servizio> listModel;

    public GestoreLista(DefaultListModel<Servizio> listModel) {
        this.listModel = listModel;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            JList<Servizio> list = (JList<Servizio>) e.getSource();
            int selezionato = list.getSelectedIndex();
            Servizio s = listModel.getElementAt(selezionato);
            System.out.println("Selezionato: " + selezionato);
            System.out.println(s);
        }
    }

}
