// Carlos Andrés Ordóñez Cerón
package layoutsExample;

import java.awt.LayoutManager;

import javax.swing.JFrame;

public class ButtonsFrame extends JFrame {

	public ButtonsFrame(String title, LayoutManager layout) {
		setTitle(title);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ButtonsPanel bPanel;
		if(layout == null)
			bPanel = new ButtonsPanel();
		else
			bPanel = new ButtonsPanel(layout);
		this.getContentPane().add(bPanel);
	}

}
