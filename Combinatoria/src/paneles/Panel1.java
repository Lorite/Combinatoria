package paneles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import main.Combinatoria;

public class Panel1 extends JPanel{
	
	// panel que pregunta si sabe qu� tipo de problema combinatorio es
	
	private static final long serialVersionUID = 1L;
	private JLabel preguntaLabel;
	private JComboBox<String> tipoCB;
	private JButton okButton;

	public Panel1() {
		super();
		
		preguntaLabel = new JLabel("�Sabes qu� tipo de problema se trata?");
		this.add(preguntaLabel);
		tipoCB = new JComboBox<>(new String[]{"No", "Combinaci�n con repetici�n", "Combinaci�n ordinaria",
				"Permutaci�n circular", "Permutaci�n con repetici�n", "Permutaci�n ordinaria",
				"Variaci�n circular", "Variaci�n con repetici�n", "Variaci�n ordinaria"});
		this.add(tipoCB);
		okButton = new JButton("OK");
		okButton.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tipoCB != null && tipoCB.getSelectedIndex() >= 0) {
					switch (tipoCB.getSelectedIndex()) {
					case 0:
						if (!Combinatoria.getTipoProblema().equals("Desconocido")) // si ya hay un panel siguiente a este y no es tipo 2
							Combinatoria.quitarPanelesCentralMenosPrimero();
						if (Combinatoria.getListaPanelesCentral().size() == 1)
							Combinatoria.anadirCompPanelCentral(new Panel2());
						Combinatoria.setTipoProblema("Desconocido");
						break;
					case 1:
						cambiarPorPanel3("Combinaci�n con repetici�n");
						break;
					case 2:
						cambiarPorPanel3("Combinaci�n ordinaria");
						break;
					case 3:
						cambiarPorPanel3("Permutaci�n circular");
						break;
					case 4:
						cambiarPorPanel3("Permutaci�n con repetici�n");
						break;
					case 5:
						cambiarPorPanel3("Permutaci�n ordinaria");
						break;
					case 6:
						cambiarPorPanel3("Variaci�n circular");
						break;
					case 7:
						cambiarPorPanel3("Variaci�n con repetici�n");
						break;
					case 8:
						cambiarPorPanel3("Variaci�n ordinaria");
						break;
					default:
						break;
					}
				}
			}
		});
		this.add(okButton);
		
	}
	
	private static void cambiarPorPanel3(String tipoProblema) {
		if (Combinatoria.getTipoProblema().equals("Desconocido")) // si ya hay un panel siguiente a este y no es tipo 3
			Combinatoria.quitarPanelesCentralMenosPrimero();
		if (Combinatoria.getListaPanelesCentral().size() == 1)
			Combinatoria.anadirCompPanelCentral(new Panel3());
		Combinatoria.setTipoProblema(tipoProblema);
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
