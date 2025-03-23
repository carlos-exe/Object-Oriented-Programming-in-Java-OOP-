// Carlos Andrés Ordóñez Cerón
package observerExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingObserver {
	private JFrame frame;

	public static void main(String[] args) {
		SwingObserver example = new SwingObserver();
		example.go();
	}
	public  void go() {
		frame = new JFrame("Demonio vs Angel");
		
		JButton button = new JButton("Debería hacerlo?");
		button.setForeground(Color.BLUE);
		button.setBackground(Color.YELLOW);
		
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set frame properties here
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
	
	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// System.out.println("Don't do it, you might regret it!");
			JOptionPane.showMessageDialog(null, "No lo hagas, te arrepentirás!");
		}
	}
	
	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// System.out.println("Come on, do it!");
			System.out.println(event);
			JOptionPane.showMessageDialog(null, "Hazloooooo!");
			// ((JComponent) event.getSource()).setEnabled(false);
		}
	}
}

