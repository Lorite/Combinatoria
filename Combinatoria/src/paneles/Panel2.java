package paneles;

import javax.swing.*;

public class Panel2 extends JPanel {

	// panel si no sabe qué tipo de problema combinatorio es (le hace unas preguntas para determinarlo)
	
	private static final long serialVersionUID = 1L;
	private JLabel preguntaLabel;
	
	public Panel2() {
		super();
		
		preguntaLabel = new JLabel("2");
		this.add(preguntaLabel);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		Panel2 panel = new Panel2();
		frame.add(panel);
		
		frame.setVisible(true);

	}
	
}
