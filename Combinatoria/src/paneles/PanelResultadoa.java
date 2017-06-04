package paneles;

import javax.swing.*;

public class PanelResultadoa extends JPanel {

	// panel con el resultado del valor numérico
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		PanelResultadoa panel = new PanelResultadoa();
		frame.add(panel);
		
		frame.setVisible(true);

	}
	
}
