package paneles;

import javax.swing.*;

public class PanelResultadob extends JPanel {

	// panel con el resultado de la generación de todas las combinaciones
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		PanelResultadob panel = new PanelResultadob();
		frame.add(panel);
		
		frame.setVisible(true);

	}
	
}
