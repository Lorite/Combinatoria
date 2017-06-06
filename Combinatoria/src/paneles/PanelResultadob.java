package paneles;

import java.util.Arrays;
import java.util.Random;

import javax.swing.*;

import main.Combinatoria;

public class PanelResultadob extends JPanel {

	// panel con el resultado de la generación de todas las combinaciones
	
	private static final long serialVersionUID = 1L;
	protected int m, n;
	protected String resultadoAleatorio = "";
	protected int[][] posibilidadesTotales;
	private String[] resultadosString;
	private JLabel[] resultadosLabel;
	private JPanel[] resultadosPanel;

	public PanelResultadob(int m, int n, int posibilidadesTotales) {
		super();
		this.m = m;
		this.n = n;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.posibilidadesTotales = new int[posibilidadesTotales][n];
		// seleccionar la fórmula dependiendo del tipo y calcular las posibilidades
		if (Combinatoria.getTipoProblema().equals("Combinación con repetición")) {
			calcularPosibilidadesCombinacionConRepeticion();

		} else if (Combinatoria.getTipoProblema().equals("Combinación ordinaria")) {
			calcularPosibilidadesCombinacionOrdinaria();

		} else if (Combinatoria.getTipoProblema().equals("Permutación circular")) {
			calcularPosibilidadesPermutacionCircular();

		} else if (Combinatoria.getTipoProblema().equals("Permutación con repetición")) {
			calcularPosibilidadesPermutacionConRepeticion();

		} else if (Combinatoria.getTipoProblema().equals("Permutación ordinaria")) {
			calcularPosibilidadesPermutacionOrdinaria();

		} else if (Combinatoria.getTipoProblema().equals("Variación circular")) {
			calcularPosibilidadesVariacionCircular();

		} else if (Combinatoria.getTipoProblema().equals("Variación con repetición")) {
			calcularPosibilidadesVariacionConRepeticion();

		}  else if (Combinatoria.getTipoProblema().equals("Variación ordinaria")) {
			calcularPosibilidadesVariacionOrdinaria();
		}
		
		// coger un resultado aleatorio de los calculados
		if (this.posibilidadesTotales != null && this.posibilidadesTotales.length > 0) {
			resultadoAleatorio = Arrays.toString(this.posibilidadesTotales[new Random().nextInt(this.posibilidadesTotales.length)]);
		}

		// resultados
		resultadosString = new String[] {"Un resultado aleatorio: " + resultadoAleatorio,
				"Todas las posibilidades: "};
		resultadosLabel = new JLabel[resultadosString.length];
		resultadosPanel = new JPanel[resultadosString.length];

		for (int i = 0; i < resultadosString.length; i++) {
			resultadosPanel[i] = new JPanel();
			if (i == 1)
				resultadosPanel[i].setLayout(new BoxLayout(resultadosPanel[i], BoxLayout.Y_AXIS));
			resultadosLabel[i] = new JLabel(resultadosString[i]);
			resultadosPanel[i].add(resultadosLabel[i]);
			if (resultadosString[i].equals("Todas las posibilidades: "))
				for (int j = 0; j < this.posibilidadesTotales.length; j++) {
					JLabel tempPosibilidadLabel = new JLabel(Arrays.toString(this.posibilidadesTotales[j]));
					resultadosPanel[i].add(tempPosibilidadLabel);
				}
			this.add(resultadosPanel[i]);
				
		}
		
	}
	
	protected void calcularPosibilidadesCombinacionConRepeticion() {
		
	}
	
	protected void calcularPosibilidadesCombinacionOrdinaria() {
		// source: https://planetcalc.com/3757/
		
		//  first combination
		for (int i = 1; i <= n; i++)
			this.posibilidadesTotales[0][i-1] = i;
		
		// loop
		for (int i = 1; i < this.posibilidadesTotales.length; i++) {
			
			// load previous combination
			for (int z = 0; z < n; z++)
				this.posibilidadesTotales[i][z] = this.posibilidadesTotales[i-1][z];
			
			int max_value = m;
			int j = n - 1;
			
			while (this.posibilidadesTotales[i][j] == max_value) {
				j--;
				max_value--;
			}
			this.posibilidadesTotales[i][j]++;
			
			for (int k = j + 1; k < n; k++)
				this.posibilidadesTotales[i][k] = this.posibilidadesTotales[i][k - 1] + 1;
		}
		
	}
	
	protected void calcularPosibilidadesPermutacionCircular() {
			
	}
	
	protected void calcularPosibilidadesPermutacionConRepeticion() {
		
	}
	
	protected void calcularPosibilidadesPermutacionOrdinaria() {
		
		//  first combination
		for (int i = 1; i <= n; i++)
			this.posibilidadesTotales[0][i-1] = i;
		
		// loop
		for (int i = 1; i < this.posibilidadesTotales.length; i++) {
			
			// load previous combination
			for (int z = 0; z < n; z++) {
				this.posibilidadesTotales[i][z] = this.posibilidadesTotales[i-1][z];
				
			}
			int max_value = n - 1;
			int j = n - 2;
			
			while (j > 0 && this.posibilidadesTotales[i][j] > this.posibilidadesTotales[i][j+1])
				j--;
			
			while (max_value > 0 && this.posibilidadesTotales[i][j] > this.posibilidadesTotales[i][max_value])
				max_value--;
			
			// swap value at j and max_value
			int tempSwap = this.posibilidadesTotales[i][j];
			this.posibilidadesTotales[i][j] = this.posibilidadesTotales[i][max_value];
			this.posibilidadesTotales[i][max_value] = tempSwap;
			
			int p = j + 1;
			int q = n - 1;
			while (p < q) {
				// swap p and q
				tempSwap = this.posibilidadesTotales[i][p];
				this.posibilidadesTotales[i][p] = this.posibilidadesTotales[i][q];
				this.posibilidadesTotales[i][q] = tempSwap;
				p++;
				q--;
			}
				
		}
		
	}
	
	protected void calcularPosibilidadesVariacionCircular() {
		
	}
	
	protected void calcularPosibilidadesVariacionConRepeticion() {
		
	}
	
	protected void calcularPosibilidadesVariacionOrdinaria() {
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		PanelResultadob panel = new PanelResultadob(1 ,1, 1);
		frame.add(panel);
		
		frame.setVisible(true);

	}
	
}
