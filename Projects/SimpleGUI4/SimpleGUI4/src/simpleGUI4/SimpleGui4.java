// Carlos Andrés Ordóñez Cerón
package simpleGUI4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleGui4 {
    private JFrame frame;
    private JLabel label;
    
    public static void main(String[] args) {
        SimpleGui4 gui = new SimpleGui4();
        gui.go();
    }
    
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());
        
        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());
        
        label = new JLabel("I’m a label");
        MyDrawPanel drawPanel = new MyDrawPanel();
        
        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(labelButton);
        buttonPanel.add(colorButton);

        // Agregar componentes
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.NORTH, label);
        
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
    
    class LabelListener implements ActionListener {
        private boolean clicked = false;

        public void actionPerformed(ActionEvent event) {
            if (clicked) {
                label.setText("I’m a label");
            } else {
                label.setText("Ouch!");
            }
            clicked = !clicked; // Alterna el estado
        }
    }
    
    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }
}