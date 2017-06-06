package paneles;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Combinatoria;

public class Panel1 extends JPanel{
	
	// panel que pregunta si sabe qué tipo de problema combinatorio es
	
	private static final long serialVersionUID = 1L;
	private JLabel preguntaLabel;
	private static JComboBox<String> tipoCB;

	public Panel1() {
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		this.setPreferredSize(new Dimension(0, (int) (1*screenHeight/20)));
		this.setMinimumSize(new Dimension(0, (int) (1*screenHeight/20)));
		
		preguntaLabel = new JLabel("¿Sabes qué tipo de problema se trata?");
		this.add(preguntaLabel);
		tipoCB = new JComboBox<>(new String[]{"No", "Combinación con repetición", "Combinación ordinaria",
				"Permutación circular", "Permutación con repetición", "Permutación ordinaria",
				"Variación circular", "Variación con repetición", "Variación ordinaria"});
		tipoCB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
						cambiarPorPanel3("Combinación con repetición");
						break;
					case 2:
						cambiarPorPanel3("Combinación ordinaria");
						break;
					case 3:
						cambiarPorPanel3("Permutación circular");
						break;
					case 4:
						cambiarPorPanel3("Permutación con repetición");
						break;
					case 5:
						cambiarPorPanel3("Permutación ordinaria");
						break;
					case 6:
						cambiarPorPanel3("Variación circular");
						break;
					case 7:
						cambiarPorPanel3("Variación con repetición");
						break;
					case 8:
						cambiarPorPanel3("Variación ordinaria");
						break;
					default:
						break;
					}
				}				
			}
		});
		this.add(tipoCB);
		
	}
	
	public static void cambiarPorPanel3(String tipoProblema) {
		Combinatoria.quitarPanelesCentralMenosPrimero();
		Combinatoria.setTipoProblema(tipoProblema);
		tipoCB.setSelectedItem(tipoProblema);
		if (Combinatoria.getListaPanelesCentral().size() == 1 && !tipoProblema.equals("Desconocido"))
			Combinatoria.anadirCompPanelCentral(new Panel3());
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
