package passwordStrengthMeter;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Jasmin Krhan
 */

public abstract class IView extends JPanel {

    abstract void result(int res);

    abstract void addListener(DocumentListener l);

    abstract JTextField getTextField();

}
