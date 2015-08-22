package passwordStrengthMeter;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Jasmin Krhan
 */

public class AnotherView extends IView {

    private final JTextField textField;
    private final JLabel label;
    private final JLabel label2;
    private JPanel result;
    private JLabel strength;
    private JPanel rectangle;
    private CustomPanel cp;

    public AnotherView() {
        super();
        this.setSize(new Dimension(400, 400));
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(280, 20));
        label = new JLabel("Enter password");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);

        result = new JPanel();
        result.setAlignmentX(LEFT_ALIGNMENT);
        result.setLayout(new BoxLayout(result, BoxLayout.X_AXIS));

        label2 = new JLabel("Password Strength");
        strength = new JLabel("");

        result.add(label2);
        result.add(Box.createRigidArea(new Dimension(10, 0)));
        result.add(strength);

        cp = new CustomPanel(0, 0, 0, 0);

        this.add(label);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(textField);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(result);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(cp);
    }

    @Override
    public void result(int res) {
        System.out.println(res);
        if (res == 0) {
            strength.setText("Very Weak");
            strength.setForeground(new Color(128, 0, 0));
            cp.set(0, 0, 30, 30, Color.black);
            cp.repaint();
        } else if (res == 1) {
            strength.setText("Weak");
            strength.setForeground(new Color(255, 0, 0));
            cp.set(0, 0, 70, 30, Color.black); 
            cp.repaint();
        } else if (res == 2) {
            strength.setText("Fair");
            strength.setForeground(new Color(255, 215, 0));
            cp.set(0, 0, 130, 30, Color.black); 
            cp.repaint();
        } else if (res == 3) {
            strength.setText("Good");
            strength.setForeground(Color.cyan);
            cp.set(0, 0, 180, 30, Color.black); 
            repaint();
        } else if (res == 4) {
            strength.setText("Very Good");
            strength.setForeground(Color.green);
            cp.set(0, 0, 280, 30, Color.black); 
            repaint();
        }

    }

    @Override
    void addListener(DocumentListener l) {
        textField.getDocument().addDocumentListener(l);
    }

    @Override
    JTextField getTextField() {
        return textField;
    }

    class CustomPanel extends JPanel {

        private int x, y, w, h;
        private Color color;
        private int count; 
        
        CustomPanel(int x, int y, int width, int height) {

            x = x;
            y = y;
            w = width;
            h = height;
            setPreferredSize(new Dimension(200, 30));
            setBorder(BorderFactory.createLineBorder(Color.gray));
            setAlignmentX(LEFT_ALIGNMENT);
        }

        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            g.clearRect(x, y, w, h);
            g.setColor(color);
            g.drawRect(x, y, w, h);
            g.fillRect(x, y, w, h);

        }

        public void set(int x, int y, int width, int height, Color c) {
            x = x;
            y = y;
            w = width;
            h = height;
            color = c;
        }
    }

}
