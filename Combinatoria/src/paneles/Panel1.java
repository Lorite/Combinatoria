package paneles;

import java.awt.*;
import javax.swing.*;

public class Panel1 extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel preguntaLabel;
	private JComboBox<String> tipoCB;
	private JButton okButton;

	public Panel1() {
		super();
		
		preguntaLabel = new JLabel("�Sabes que tipo de combinatoria se trata?");
		this.add(preguntaLabel);
		tipoCB = new JComboBox<>(new String[]{"No", "Combinaci�n con repetici�n", "Combinaci�n ordinaria",
				"Permutaci�n circular", "Permutaci�n con repetici�n", "Permutaci�n ordinaria",
				"Variaci�n circular", "Variaci�n con repetici�n", "Variaci�n ordinaria"});
		this.add(tipoCB);
		okButton = new JButton("OK");
		this.add(okButton);
		
	}
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		Panel1 panel = new Panel1();
		frame.add(panel);
		
		frame.setVisible(true);

	}

}
