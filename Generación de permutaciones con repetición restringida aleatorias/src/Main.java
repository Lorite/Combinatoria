import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<String> A = new ArrayList<>();
	static int n = 0;
	static ArrayList<String> n_elementos = new ArrayList<>();
	static ArrayList<Integer> n_repeticiones = new ArrayList<>();
	
	private static BufferedReader brTeclado=new BufferedReader(new InputStreamReader(System.in));
	/** Lee un entero positivo de teclado
	* @return Entero leída, o -1 si error en la entrada
	*/
	public static int leerEnteroDeTeclado(String texto) {
		try {
			System.out.println("Introduzca un número entero. " + texto);
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

				if (elemento != null ) {
					if (!elemento.equals(".")) {
						if (!A.contains(elemento)) {
							A.add(elemento);
							n_elementos.add(elemento);
							n_repeticiones.add(1);
						} else {
							int posicion = n_elementos.indexOf(elemento);
							n_repeticiones.set(posicion, new Integer(n_repeticiones.get(posicion) + 1));
						}
					} else {
						conjuntoFinalizado = true;
					}
					break;
				}
				System.out.println("No has introducido un valor válido.");
			} 
		}
		
		// n
		for (Integer repeticiones: n_repeticiones) {
			n += repeticiones;
		}
	}
	
	public static int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
	
	public static int calcularPermutacionesConRepeticion(int n, ArrayList<Integer> n_repeticiones) {
		int total = 0;
		
		// fórmula
		int parteInferior = 1;
		for (Integer repeticion: n_repeticiones) {
			parteInferior *= factorial(repeticion);
		}
		total = factorial(n)/parteInferior;
		
		return total;
	}
	
	public static ArrayList<ArrayList<String>> generarPermutacionesConRepeticion(ArrayList<String> A, int n) {
		ArrayList<ArrayList<String>> conjuntosTotal = new ArrayList<>();
		
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
		int totalVariacionesOrdinarias = calcularPermutacionesConRepeticion(n, n_repeticiones);
		System.out.println(totalVariacionesOrdinarias);
		
		
		System.out.println("Generación aleatoria de variaciones ordinarias de n elementos tomados de m en m:");
		ArrayList<ArrayList<String>> conjuntoVariacionesOrdinarias = 
				generarPermutacionesConRepeticion(A, n);
		for (ArrayList<String> conjuntoGenerado : conjuntoVariacionesOrdinarias) {
			System.out.println(conjuntoGenerado);
		}
	}

}
