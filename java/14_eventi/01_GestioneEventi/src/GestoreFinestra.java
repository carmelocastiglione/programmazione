import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GestoreFinestra implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window deiconified");    
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window activated");    
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window deactivated");    
    }

}
