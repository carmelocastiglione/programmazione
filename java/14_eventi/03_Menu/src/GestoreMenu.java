import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GestoreMenu implements ActionListener {

    JFrame frame = new JFrame();

    public GestoreMenu(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label = null;
        Component[] components = frame.getContentPane().getComponents();
        for (Component component : components) {
            if (component.getName().equals("panel")) {
                JPanel panel = (JPanel) component;
                Component[] componentsPanel = panel.getComponents();
                for (Component componentPanel : componentsPanel) {
                    if (componentPanel.getName().equals("label")) {
                        label = (JLabel) componentPanel;
                    }
                }
            }
        }
        JMenuItem item = (JMenuItem) e.getSource();
        String s = item.getText();
        switch (s) {
            case "Nuovo":
                label.setText("Hai cliccato su Nuovo");
                break;
            case "Apri":
                label.setText("Hai cliccato su Apri");
                break;
            case "Esci":
                System.exit(0);
                break;
            case "Informazioni":
                mostraInfo();                     
                break;
            default:
                System.err.println("Evento non previsto");
                break;
        }
    }

    private void mostraInfo() {
        JOptionPane.showMessageDialog(frame, "Versione 1.0", "Informazioni", JOptionPane.INFORMATION_MESSAGE);
    }

}
