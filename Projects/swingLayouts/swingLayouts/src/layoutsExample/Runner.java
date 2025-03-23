// Carlos Andrés Ordóñez Cerón
package layoutsExample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Runner {

    public static void main(String[] args) {
        int x = 100; // Posición inicial en X
        int y = 100; // Posición inicial en Y
        int offset = 50; // Desplazamiento entre ventanas

        ButtonsFrame flowFrame = new ButtonsFrame("FlowButtons", new FlowLayout());
        flowFrame.setLocation(x, y);
        flowFrame.setVisible(true);

        ButtonsFrame borderFrame = new ButtonsFrame("BorderButtons", new BorderLayout());
        borderFrame.setLocation(x + offset, y + offset);
        borderFrame.setVisible(true);

        ButtonsFrame gridBagFrame = new ButtonsFrame("GridBagButtons", new GridBagLayout());
        gridBagFrame.setLocation(x + 2 * offset, y + 2 * offset);
        gridBagFrame.setVisible(true);

        ButtonsFrame gridFrame = new ButtonsFrame("GridButtons", new GridLayout());
        gridFrame.setLocation(x + 3 * offset, y + 3 * offset);
        gridFrame.setVisible(true);

        ButtonsFrame newBorderFrame = new ButtonsFrame("NewBorderButtons", null);
        newBorderFrame.setLocation(x + 4 * offset, y + 4 * offset);
        newBorderFrame.setVisible(true);
    }
}
