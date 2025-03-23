// Carlos Andrés Ordóñez Cerón
package simpleGUI3;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();
		
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		Color startColor = new Color(red, green, blue);
		
		red = random.nextInt(256);
		green = random.nextInt(256);
		blue = random.nextInt(256);
		Color endColor = new Color(red, green, blue);
		
		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillRect(70, 70, 100, 100);  // Se cambia fillOval por fillRect para crear un rectángulo
	}

}
