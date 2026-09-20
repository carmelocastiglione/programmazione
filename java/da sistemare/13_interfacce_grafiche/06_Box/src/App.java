import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class App {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("App");
        JPanel panel = new JPanel();
        JComboBox<String> box = new JComboBox<String>();
        box.addItem("Rosso");
        box.addItem("Verde");
        box.addItem("Blu");
        box.addItem("Giallo");
        box.setSelectedIndex(2);
        panel.add(box);

        JCheckBox check1 = new JCheckBox("Italia");
        JCheckBox check2 = new JCheckBox("Spagna");
        check2.setSelected(true);
        panel.add(check1);
        panel.add(check2);

        ButtonGroup group = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton("Maschio");
        JRadioButton radio2 = new JRadioButton("Femmina");
        radio2.setSelected(true);
        group.add(radio1);
        group.add(radio2);
        panel.add(radio1);
        panel.add(radio2);
        

        Container container = frame.getContentPane();
        container.add(panel);

        frame.setSize(250,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

