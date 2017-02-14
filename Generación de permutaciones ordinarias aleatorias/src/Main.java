import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<String> A = new ArrayList<>();
	static int n = 0;
	
	private static BufferedReader brTeclado=new BufferedReader(new InputStreamReader(System.in));
	/** Lee un entero positivo de teclado
	* @return Entero leída, o -1 si error en la entrada
	*/
	public static int leerEnteroDeTeclado(String texto) {
		try {
			System.out.println("Introduce un número entero. " + texto);
			String lin = brTeclado.readLine();
			if (lin==null) return -1;
			return Integer.parseInt( lin );
		} catch (Exception e) {
			return -1;
		}
	}
	
	/** Lee un String de teclado
	* @return String leído, o -null si error en la entrada
	*/
	public static String leerStringDeTeclado(String texto) {
		try {
			System.out.println(texto);
			String lin = brTeclado.readLine();
			return lin;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void inputUsuario() {
		// conjunto A
		boolean conjuntoFinalizado = false;
		while (conjuntoFinalizado == false) {
			boolean datoValido = false;
			while (datoValido == false) {
				String elemento = leerStringDeTeclado("Introduzca un elemento para añadirlo al conjunto,"
						+ "introduzca . para acabar: ");

				if (elemento != null && !A.contains(elemento)) {
					if (!elemento.equals(".")) {
						A.add(elemento);
					} else {
						conjuntoFinalizado = true;
					}
					break;
				}
				System.out.println("No has introducido un valor válido.");
			} 
		}
		
		// n
		n = A.size();
		
	}
	
	public static int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
	
	public static int calcularPermutacionesOrdinarias(int n) {
		int total = 0;
		
		// fórmula
		total = factorial(n);
		
		return total;
	}
	
	public static ArrayList<ArrayList<String>> generarPermutacionesOrdinarias(ArrayList<String> A, int n) {
		ArrayList<ArrayList<String>> conjuntosTotal = new ArrayList<>();
		
		// primera variacion ordinaria
		ArrayList<String> variacion = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			variacion.add(A.get(i));
		}
		conjuntosTotal.add(variacion);
		
		// demás variaciones
		while (siguienteVariacionOrdinaria(variacion, A.size(), n)) {
			conjuntosTotal.add(variacion);
		}
		
		return conjuntosTotal;
	}
	
	public static boolean siguienteVariacionOrdinaria(ArrayList<String> variacion, int m, int n) {

//		for (int i = 0; i <= numeroConjuntos - n; i++) {
//			for (int j = i; j < numeroConjuntos - n - i; j++) {
//				ArrayList<String> nuevoConjunto = new ArrayList<>();
//				nuevoConjunto.add(A.get(i));
//				nuevoConjunto.add(A.get(i + j));
//				nuevoConjunto.add(A.get(i + j));
//				conjuntosTotal.add(nuevoConjunto);
//			}
//		}
		
		int i = n - 1;
		
		return true;
	}
	
	public static void main(String[] args) {

		inputUsuario();
		
		System.out.println("Total de variaciones ordinarias de n elementos tomados de m en m:");
		int totalVariacionesOrdinarias = calcularPermutacionesOrdinarias(n);
		System.out.println(totalVariacionesOrdinarias);
		
		
		System.out.println("Generación aleatoria de variaciones ordinarias de n elementos tomados de m en m:");
		ArrayList<ArrayList<String>> conjuntoVariacionesOrdinarias = 
				generarPermutacionesOrdinarias(A, n);
		for (ArrayList<String> conjuntoGenerado : conjuntoVariacionesOrdinarias) {
			System.out.println(conjuntoGenerado);
		}
	}

}
