package passwordStrengthMeter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jasmin Krhan
 */


public class TestPasswordStrengthMeter extends JFrame {

    public TestPasswordStrengthMeter(PassWordStrengthMeter p) {
        super("Test PasswordStrengthMeter");
        this.setVisible(true);
        this.add(p);
        this.pack();
    }

    public static void main(String[] args) {

        PassWordStrengthMeter psm = new PassWordStrengthMeter();

        new TestPasswordStrengthMeter(psm);

        AlgorithmA algA = new AlgorithmA();
        psm.setAlgorithm(algA);
        
        AnotherView av = new AnotherView();
        psm.setView(av); 

    }

}
