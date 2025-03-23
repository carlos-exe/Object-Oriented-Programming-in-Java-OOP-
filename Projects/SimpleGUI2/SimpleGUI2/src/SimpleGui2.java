// Carlos Andrés Ordóñez Cerón
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class SimpleGui2 implements ActionListener{
	private JButton button;
	private static int clickCounter;
	
	public static void main(String[] args) {	
		SimpleGui2 gui = new SimpleGui2();
		clickCounter = 0;
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("Título nuevo"); //Nuevo título
		button = new JButton("click me");
		button.setBackground(Color.CYAN); // Agregar el color Cyan al botón button		
		button.addActionListener(this);
		
		frame.getContentPane().add(button,BorderLayout.SOUTH); // Agregar el método en la parte inferior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600); // Duplicando el tamaño de la ventana
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		clickCounter++;
		if (clickCounter == 1) {
            button.setText("I've been clicked once"); // Mensaje para el primer clic
        } else {
            button.setText("I've been clicked " + clickCounter + " times!");
        	}
		}

}
