package passwordStrengthMeter;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * This is the main class that haves instances of a view and algorithm. The
 * algorithm can easily be changed, same thing for the view. This class can be
 * seen as the controller.
 *
 * @author Jasmin Krhan 
 */

public class PassWordStrengthMeter extends JPanel {

    private Algorithm alg;
    private IView view;

    /**
     * This class has two constructors, one default constructor that sets the
     * algorithm to A and standardview and one which takes the specific
     * Algorithm and view as arguments.
     */
    public PassWordStrengthMeter() {
        super();
        alg = new AlgorithmA();
        view = new StandardView();
        view.addListener(new Listener(view.getTextField()));
        this.add(view);
    }

    public PassWordStrengthMeter(Algorithm a, IView v) {
        alg = a;
        v = v;
    }

    /**
     * method for changing the algorithm
     *
     * @param a
     */
    public void setAlgorithm(Algorithm a) {
        alg = a;
    }

    /**
     * method for changing the view
     *
     * @param v
     */
    public void setView(IView v) {
        this.remove(view); 
        view = v;
        view.addListener(new Listener(view.getTextField()));
        this.add(view); 
        
    }

    private class Listener implements DocumentListener {

        private JTextField text;

        public Listener(JTextField t) {
            text = t;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            int result = alg.checkPassWord(text.getText().toString());
            view.result(result);
        }

    }

}
