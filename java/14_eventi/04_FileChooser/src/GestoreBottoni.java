import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class GestoreBottoni implements ActionListener {

    private Container contentPane;
    private JTextArea area;

    public GestoreBottoni(Container contentPane, JTextArea area) {
        this.contentPane = contentPane;
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int status;
        if (e.getActionCommand().equals("apri")) {
            status = fileChooser.showOpenDialog(contentPane);
            if (status == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                try {
                    FileReader fr = new FileReader(f);
                    area.read(fr, null);
                    // BufferedReader br = new BufferedReader(fr);
                    // while (true) {
                    //     String s = br.readLine();
                    //     if (s == null) {
                    //         break;
                    //     }
                    // }
                    // br.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } 
            }
         } else if (e.getActionCommand().equals("salva")) {
            status = fileChooser.showSaveDialog(contentPane);
            if (status == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                FileWriter fw;
                try {
                    fw = new FileWriter(f);
                    area.write(fw);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }   
    }

}
