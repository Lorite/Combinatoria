import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<String> A = new ArrayList<>();
	static int m = 0;
	static int n = 0;
	
	private static BufferedReader brTeclado=new BufferedReader(new InputStreamReader(System.in));
	/** Lee un entero positivo de teclado
	* @return Entero le�da, o -1 si error en la entrada
	*/
	public static int leerEnteroDeTeclado(String texto) {
		try {
			System.out.println("Introduce un n�mero entero. " + texto);
			String lin = brTeclado.readLine();
			if (lin==null) return -1;
			return Integer.parseInt( lin );
		} catch (Exception e) {
			return -1;
		}
	}
	
	/** Lee un String de teclado
	* @return String le�do, o -null si error en la entrada
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
				String elemento = leerStringDeTeclado("Introduzca un elemento para a�adirlo al conjunto,"
						+ "introduzca . para acabar: ");

				if (elemento != null && !A.contains(elemento)) {
					if (!elemento.equals(".")) {
						A.add(elemento);
					} else {
						conjuntoFinalizado = true;
					}
					break;
				}
				System.out.println("No has introducido un valor v�lido.");
			} 
		}
		
		// m
		m = A.size();
		
		// n
		boolean datoValido = false;
		while (datoValido == false) {
			int numero = leerEnteroDeTeclado("Introduzca el n�mero de elementos para cada agrupaci�n: ");

			if (numero != -1) {
				n = numero;
				break;
			}
			System.out.println("No has introducido un valor v�lido.");
		}
	}
	
	public static int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
	
	public static int calcularCombinacionesConRepeticion(int m, int n) {
		int total = 0;
		
		// f�rmula
		total = factorial(m + n - 1)/(factorial(m - 1) * factorial(n));
		
		return total;
	}
	
	public static ArrayList<ArrayList<String>> generarCombinacionesConRepeticion(ArrayList<String> A, int n) {
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
		int totalVariacionesOrdinarias = calcularCombinacionesConRepeticion(m, n);
		System.out.println(totalVariacionesOrdinarias);
		
		
		System.out.println("Generaci�n aleatoria de variaciones ordinarias de n elementos tomados de m en m:");
		ArrayList<ArrayList<String>> conjuntoVariacionesOrdinarias = 
				generarCombinacionesConRepeticion(A, n);
		for (ArrayList<String> conjuntoGenerado : conjuntoVariacionesOrdinarias) {
			System.out.println(conjuntoGenerado);
		}
	}

}
