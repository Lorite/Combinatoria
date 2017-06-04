package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Panel2 extends JPanel {

	// panel si no sabe qué tipo de problema combinatorio es (le hace unas preguntas para determinarlo)
	/*	¿Importa el orden de colocación de los elementos?
			Si --> Pueden ser variaciones o permutaciones
			No --> Son combinaciones
		¿Tomamos todos los elementos diponibles o algunos?
			Todos --> Son permutaciones m = n
			Algunos --> Son variaciones
		¿Se pueden repetir los elementos?
			Si --> Pueden ser combinaciones, variaciones o permutaciones con repetición
			No --> Pueden ser combinaciones, variaciones o permutaciones sin repetición
	*/
	
	private static final long serialVersionUID = 1L;
	private JPanel enunciadoPanel, okPanel;
	private JPanel[] preguntasPanel;
	private JLabel enunciadoLabel;
	private String[] preguntasString;
	private JLabel[] preguntasLabel;
	private JToggleButton[] preguntasTB;
	private boolean[] preguntasBool;	// true si es la primera respuesta
	private JButton okButton;
	
	public Panel2() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		enunciadoPanel = new JPanel();
		enunciadoLabel = new JLabel("Responde a estas preguntas para determinar qué tipo de problema combinatorio es:");
		enunciadoPanel.add(enunciadoLabel);
		this.add(enunciadoPanel);
		
		// preguntas
		preguntasString = new String[] {"¿Importa el orden de colocación de los elementos?",
				"¿Tomamos todos los elementos diponibles o algunos?",
				"¿Se pueden repetir los elementos?"};
		preguntasPanel = new JPanel[preguntasString.length];
		preguntasLabel = new JLabel[preguntasString.length];
		preguntasTB = new JToggleButton[preguntasString.length * 2];
		preguntasBool = new boolean[preguntasString.length];
		
		for (int i = 0; i < preguntasString.length; i++) {
			preguntasPanel[i] = new JPanel();
			preguntasLabel[i] = new JLabel(preguntasString[i]);
			preguntasPanel[i].add(preguntasLabel[i]);
			ActionListener al = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int posTB = Arrays.asList(preguntasTB).indexOf(e.getSource());
					int posReal = posTB / 2;
					if (posTB % 2 == 0) {
						preguntasBool[posReal] = true;
						preguntasTB[posTB].setSelected(preguntasBool[posReal]);
						preguntasTB[posTB + 1].setSelected(!preguntasBool[posReal]);
					} else {
						preguntasBool[posReal] = false;
						preguntasTB[posTB - 1].setSelected(preguntasBool[posReal]);
						preguntasTB[posTB].setSelected(!preguntasBool[posReal]);
					}
				}
			};
			preguntasBool[i] = true;
			if (i == 1)
				preguntasTB[i*2] = new JToggleButton("Todos");
			else
				preguntasTB[i*2] = new JToggleButton("Sí");
			preguntasTB[i*2].setSelected(preguntasBool[i]);
			preguntasTB[i*2].addActionListener(al);
			preguntasPanel[i].add(preguntasTB[i*2]);
			if (i == 1)
				preguntasTB[i*2 + 1] = new JToggleButton("Algunos");
			else
				preguntasTB[i*2 + 1] = new JToggleButton("No");
			preguntasTB[i*2 + 1].addActionListener(al);
			preguntasPanel[i].add(preguntasTB[i*2 + 1]);
			this.add(preguntasPanel[i]);
		}
		
		// ok
		okPanel = new JPanel();
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel1.cambiarPorPanel3(getTipoProblema());				
			}
		});
		okPanel.add(okButton);
		this.add(okPanel);
	}
	
	public String getTipoProblema() {
		String tipoProblema = "Desconocido";
		
		// ver qué tipo es
		if (preguntasTB[1].isSelected()) {	// siempre combinaciones
			tipoProblema = "Combinación";
		} else {	// permutaciones o variaciones
			if (preguntasTB[2].isSelected()) {	// permutaciones
				tipoProblema = "Permutación";
			} else {	// variaciones
				tipoProblema = "Variación";
			}
		}
		
		// ver si se repiten elementos o no
		if (preguntasTB[4].isSelected())
			tipoProblema += " con repetición";
		else
			tipoProblema += " ordinaria";
		
		return tipoProblema;
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
