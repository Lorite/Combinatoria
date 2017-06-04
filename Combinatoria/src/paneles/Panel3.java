package paneles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.Combinatoria;

public class Panel3 extends JPanel {

	// panel si ya sabe qué tipo de problema combinatorio es (pregunta n, m)
	
	private static final long serialVersionUID = 1L;
	private JPanel enunciadoPanel;
	private JLabel enunciadoLabel;
	private JPanel[] preguntasPanel;
	private JLabel[] preguntasLabel;
	private String[] preguntasString;
	private JSpinner[] preguntasS;
	
	public Panel3() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		enunciadoPanel = new JPanel();
		enunciadoLabel = new JLabel("");
		if (Combinatoria.getTipoProblema().startsWith("Permutación"))
			enunciadoLabel.setText("n = m");
		else if (Combinatoria.getTipoProblema().startsWith("Combinación"))
			enunciadoLabel.setText("n <= m");
		else {
			if (Combinatoria.getTipoProblema().equals("Variación ordinaria"))
				enunciadoLabel.setText("n < m");
			else if (Combinatoria.getTipoProblema().equals("Variación con repetición"))
				enunciadoLabel.setText("n < m, n > m");
		}
		
		enunciadoPanel.add(enunciadoLabel);
		this.add(enunciadoPanel);
		
		// preguntas
		preguntasString = new String[] {"Elementos disponibles (m): ",
		"Elementos que tomamos (n): "};
		preguntasPanel = new JPanel[preguntasString.length];
		preguntasLabel = new JLabel[preguntasString.length];
		preguntasS = new JSpinner[preguntasString.length];
		
		for (int i = 0; i < preguntasString.length; i++) {
			preguntasPanel[i] = new JPanel();
			preguntasLabel[i] = new JLabel(preguntasString[i]);
			preguntasPanel[i].add(preguntasLabel[i]);
			if (i == 0)
				if (enunciadoLabel.getText().contains("="))
					preguntasS[i] = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
				else
					preguntasS[i] = new JSpinner(new SpinnerNumberModel(2, 1, 1000, 1));
			else
				preguntasS[i] = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
			preguntasS[i].addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					if (enunciadoLabel.getText().equals("n = m")) {
						if (e.getSource().equals(preguntasS[0]))
							preguntasS[1].setValue(preguntasS[0].getValue());
						else if (e.getSource().equals(preguntasS[1]))
							preguntasS[0].setValue(preguntasS[1].getValue());
					} else if (enunciadoLabel.getText().equals("n <= m")) {
						if (e.getSource().equals(preguntasS[1]) && (int) (preguntasS[0].getValue()) < (int) (preguntasS[1].getValue()))
							preguntasS[0].setValue(preguntasS[1].getValue());
						else if (e.getSource().equals(preguntasS[0]) && (int) (preguntasS[0].getValue()) < (int) (preguntasS[1].getValue()))
							preguntasS[1].setValue(preguntasS[0].getValue());
					} else if (enunciadoLabel.getText().equals("n < m")) {
						if (e.getSource().equals(preguntasS[1]) && (int) (preguntasS[0].getValue()) == (int) (preguntasS[1].getValue()))
							preguntasS[0].setValue((int) preguntasS[1].getValue() + 1);
						else if (e.getSource().equals(preguntasS[0]) && (int) (preguntasS[0].getValue()) == (int) (preguntasS[1].getValue()))
							preguntasS[1].setValue((int) preguntasS[0].getValue() - 1);
					} else if (enunciadoLabel.getText().equals("n < m, n > m")) {
						if (e.getSource().equals(preguntasS[1]) && (int) (preguntasS[0].getValue()) == (int) (preguntasS[1].getValue()))
							preguntasS[0].setValue((int) preguntasS[1].getValue() + 1);
						else if (e.getSource().equals(preguntasS[0]) && (int) (preguntasS[0].getValue()) == (int) (preguntasS[1].getValue()))
							preguntasS[1].setValue((int) preguntasS[0].getValue() + 1);
					}
				}
			});
			preguntasPanel[i].add(preguntasS[i]);
			this.add(preguntasPanel[i]);
		}

	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		Panel3 panel = new Panel3();
		frame.add(panel);
		
		frame.setVisible(true);

	}
	
	public int getM() {
		return (int) preguntasS[0].getValue();
	}
	
	public int getN() {
		return (int) preguntasS[1].getValue();
	}
	
}
