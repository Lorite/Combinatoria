package paneles;

import javax.swing.*;

public class PanelTitulo extends JPanel {

	public PanelTitulo() {
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		PanelTitulo panel = new PanelTitulo();
		frame.add(panel);
		
		frame.setVisible(true);

	}

}
