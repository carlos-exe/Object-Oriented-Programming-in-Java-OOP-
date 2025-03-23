package ui;

import javax.swing.JButton; // Importa la clase JButton
import javax.swing.JFrame; // Importa la clase JFrame
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar cuadros de diálogo

public class PruebaSwing {
    public static void main(String[] args) {
        // Crear un marco de Swing
        JFrame frame = new JFrame("Prueba de Swing");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un botón
        JButton boton = new JButton("¡Haz clic aquí!");
        boton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "¡Swing está funcionando!"));

        // Agregar el botón al marco
        frame.add(boton);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
