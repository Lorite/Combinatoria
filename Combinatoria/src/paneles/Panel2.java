package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel enunciadoPanel, pregunta1Panel, pregunta2Panel, pregunta3Panel, okPanel;
	private JLabel enunciadoLabel, pregunta1Label, pregunta2Label, pregunta3Label;
	private JToggleButton pregunta1SiTB, pregunta1NoTB, pregunta2TodosTB, pregunta2AlgunosTB, pregunta3SiTB, pregunta3NoTB;
	private boolean pregunta1Bool, pregunta2Bool, pregunta3Bool;	// true si es la primera respuesta
	private JButton okButton;
	
	public Panel2() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		enunciadoPanel = new JPanel();
		enunciadoLabel = new JLabel("Responde a estas preguntas para determinar qué tipo de problema combinatorio es:");
		enunciadoPanel.add(enunciadoLabel);
		this.add(enunciadoPanel);
		
		// pregunta 1
		pregunta1Panel = new JPanel();
		pregunta1Label = new JLabel("¿Importa el orden de colocación de los elementos?");
		pregunta1Panel.add(pregunta1Label);
		ActionListener al1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(pregunta1SiTB))
					pregunta1Bool = true;
				else
					pregunta1Bool = false;
				pregunta1SiTB.setSelected(pregunta1Bool);
				pregunta1NoTB.setSelected(!pregunta1Bool);
			}
		};
		pregunta1Bool = true;
		pregunta1SiTB = new JToggleButton("Sí");
		pregunta1SiTB.setSelected(pregunta1Bool);
		pregunta1SiTB.addActionListener(al1);
		pregunta1Panel.add(pregunta1SiTB);
		pregunta1NoTB = new JToggleButton("No");
		pregunta1NoTB.addActionListener(al1);
		pregunta1Panel.add(pregunta1NoTB);
		this.add(pregunta1Panel);
		
		// pregunta 2
		pregunta2Panel = new JPanel();
		pregunta2Label = new JLabel("¿Tomamos todos los elementos diponibles o algunos?");
		pregunta2Panel.add(pregunta2Label);
		pregunta2Bool = true;
		pregunta2TodosTB = new JToggleButton("Sí");
		pregunta2TodosTB.setSelected(pregunta2Bool);
		pregunta2Panel.add(pregunta2TodosTB);
		pregunta2AlgunosTB = new JToggleButton("No");
		pregunta2Panel.add(pregunta2AlgunosTB);
		this.add(pregunta2Panel);
		
		// pregunta 3
		pregunta3Panel = new JPanel();
		pregunta3Label = new JLabel("¿Se pueden repetir los elementos?");
		pregunta3Panel.add(pregunta3Label);
		pregunta3Bool = true;
		pregunta3SiTB = new JToggleButton("Sí");
		pregunta3SiTB.setSelected(pregunta3Bool);
		pregunta3Panel.add(pregunta3SiTB);
		pregunta3NoTB = new JToggleButton("No");
		pregunta3Panel.add(pregunta3NoTB);
		this.add(pregunta3Panel);
		
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
		if (pregunta1NoTB.isSelected()) {	// siempre combinaciones
			tipoProblema = "Combinación";
		} else {	// permutaciones o variaciones
			if (pregunta2TodosTB.isSelected()) {	// permutaciones
				tipoProblema = "Permutación";
			} else {	// variaciones
				tipoProblema = "Variación";
			}
		}
		
		// ver si se repiten elementos o no
		if (pregunta3SiTB.isSelected())
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
