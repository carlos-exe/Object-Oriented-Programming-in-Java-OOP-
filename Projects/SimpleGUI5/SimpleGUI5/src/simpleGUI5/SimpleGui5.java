// Carlos Andrés Ordóñez Cerón
package simpleGUI5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleGui5 {
	private JFrame frame;
	private JLabel label;
	
	public static void main(String[] args) {
		SimpleGui5 gui = new SimpleGui5();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(event -> label.setText("Ouch!"));
		JButton colorButton = new JButton("Change Circle");
		colorButton.addActionListener(event -> frame.repaint());
		
		label = new JLabel("I’m a label");
		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
