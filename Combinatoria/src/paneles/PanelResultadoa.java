package paneles;

import javax.swing.*;

import main.Combinatoria;

public class PanelResultadoa extends JPanel {

	// panel con el resultado del valor num�rico
	
	private static final long serialVersionUID = 1L;
	protected int m, n;
	protected String formula = "";
	protected int resultado = 0;
	private String[] resultadosString;
	private JLabel[] resultadosLabel;
	private JPanel[] resultadosPanel;
	
	public PanelResultadoa(int m, int n) {
		super();
		this.m = m;
		this.n = n;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// seleccionar la f�rmula dependiendo del tipo y calcular las posibilidades
		if (Combinatoria.getTipoProblema().equals("Combinaci�n con repetici�n")) {
			formula = "(m + n - 1)! / ((m - 1)! * n!)";
			resultado = factorial(m + n - 1)/(factorial(m - 1) * factorial(n));
			
		} else if (Combinatoria.getTipoProblema().equals("Combinaci�n ordinaria")) {
			formula = "m! / (n!*(m-n)!)";
			resultado = factorial(m)/(factorial(n)*factorial(m-n));
			
		} else if (Combinatoria.getTipoProblema().equals("Permutaci�n circular")) {
			formula = "(n - 1)!";
			resultado = factorial(n - 1);
			
		} else if (Combinatoria.getTipoProblema().equals("Permutaci�n con repetici�n")) {
			formula = "";
			resultado = 0;	// TODO
			
		} else if (Combinatoria.getTipoProblema().equals("Permutaci�n ordinaria")) {
			formula = "n!";
			resultado = factorial(n);
			
		} else if (Combinatoria.getTipoProblema().equals("Variaci�n circular")) {
			formula = "m! / (n*(m-n)!)";
			resultado = factorial(m)/(n*factorial(m-n));
			
		} else if (Combinatoria.getTipoProblema().equals("Variaci�n con repetici�n")) {
			formula = "m^n";
			resultado = (int) Math.pow(m,n);
			
		}  else if (Combinatoria.getTipoProblema().equals("Variaci�n ordinaria")) {
			formula = "m!/(m-n)!";
			resultado = factorial(m)/factorial(m-n);
		}
		
		// resultados
		resultadosString = new String[] {"Se ha utilizado la f�rmula: " + formula,
				"El resultado es: " + resultado + " posibilidades." };
		resultadosLabel = new JLabel[resultadosString.length];
		resultadosPanel = new JPanel[resultadosString.length];
		
		for (int i = 0; i < resultadosString.length; i++) {
			resultadosPanel[i] = new JPanel();
			resultadosLabel[i] = new JLabel(resultadosString[i]);
			resultadosPanel[i].add(resultadosLabel[i]);
			this.add(resultadosPanel[i]);
		}
		
	}
	
	protected static int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

	public int getResultado() {
		return resultado;
	}
	
}
