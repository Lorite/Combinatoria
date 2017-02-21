package paneles;

import javax.swing.*;

public class Panel3 extends JPanel {

	// panel si ya sabe qué tipo de problema combinatorio es (pregunta n, m)
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		Panel3 panel = new Panel3();
		frame.add(panel);
		
		frame.setVisible(true);

	}
	
}
