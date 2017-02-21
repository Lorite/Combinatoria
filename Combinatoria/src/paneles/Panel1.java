package paneles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Panel1 extends JPanel{
	
	// panel que pregunta si sabe qué tipo de problema combinatorio es
	
	private static final long serialVersionUID = 1L;
	private JLabel preguntaLabel;
	private JComboBox<String> tipoCB;
	private JButton okButton;

	public Panel1() {
		super();
		
		preguntaLabel = new JLabel("¿Sabes que tipo de combinatoria se trata?");
		this.add(preguntaLabel);
		tipoCB = new JComboBox<>(new String[]{"No", "Combinación con repetición", "Combinación ordinaria",
				"Permutación circular", "Permutación con repetición", "Permutación ordinaria",
				"Variación circular", "Variación con repetición", "Variación ordinaria"});
		this.add(tipoCB);
		okButton = new JButton("OK");
		okButton.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tipoCB != null && tipoCB.getSelectedIndex() >= 0) {
					switch (tipoCB.getSelectedIndex()) {
					case 0:
						
						break;
					case 1:
						
						break;
					default:
						break;
					}
				}
			}
		});
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
