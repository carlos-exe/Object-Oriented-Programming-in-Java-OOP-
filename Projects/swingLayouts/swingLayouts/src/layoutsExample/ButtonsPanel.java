// Carlos Andrés Ordóñez Cerón
package layoutsExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel{
	  private JButton BtYellow = new JButton("Yellow");
	  private JButton BtBlue = new JButton("Blue");
	  private JButton BtRed = new JButton("Red");
	  private JButton BtTurquoise = new JButton("Turquoise");
	  
	  public ButtonsPanel(LayoutManager layout) {
	    setBackground(Color.lightGray);
	    setLayout(layout);
	    add(this.BtYellow);
	    add(this.BtBlue);
	    add(this.BtRed);
	    add(this.BtTurquoise);
	  }
	  
	  public ButtonsPanel() {
		    setBackground(Color.lightGray);
		    setLayout(new BorderLayout());
		    add(this.BtYellow, BorderLayout.EAST);
		    add(this.BtBlue, BorderLayout.WEST);
		    add(this.BtRed,BorderLayout.NORTH);
		    add(this.BtTurquoise, BorderLayout.SOUTH);
		  }
	  	  
}
