package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import paneles.*;

public class Combinatoria extends JFrame{

	/*	Variables	*/
	
	// general
	private static final long serialVersionUID = 1L;
	protected static Combinatoria combinatoria;
	protected static String tipoProblema;
	
	// jframe
	private static JPanel panelCentral;
	private static ArrayList<JPanel> listaPanelesCentral;
	private static JPanel panelInferior;
	private static JButton botonSiguiente;
	
	
	/*	Constructor	*/
	
	@SuppressWarnings("deprecation")
	private static void empezar() {
		
		combinatoria = new Combinatoria();
		tipoProblema = "Desconocido";
		
		// opciones del jframe
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		combinatoria.setTitle("Combinatoria");
		combinatoria.setSize(new Dimension((int) (3*screenWidth/5), (int) (3*screenHeight/5)));
		combinatoria.setLocationRelativeTo(null);
		combinatoria.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		combinatoria.getContentPane().setLayout(new BorderLayout());
		
		// panel central
		panelCentral = new JPanel();
		listaPanelesCentral = new ArrayList<>();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		combinatoria.add(panelCentral, BorderLayout.CENTER);
		PanelTitulo panelTitulo = new PanelTitulo();
		panelCentral.add(panelTitulo);
		Panel1 panel1 = new Panel1();
		anadirCompPanelCentral(panel1);
		
		// panel inferior
		panelInferior = new JPanel(new BorderLayout());
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setFont( new Font("Arial", Font.BOLD, 16));
		panelInferior.add(botonSiguiente, BorderLayout.EAST);
		combinatoria.add(panelInferior, BorderLayout.SOUTH);
		
		// mostrar ventana
		combinatoria.revalidate();
		combinatoria.pack();
		combinatoria.show();
	}
	
	
	/*	Métodos	*/
	
	public static void anadirCompPanelCentral(JPanel panel) {
		panelCentral.add(panel);
		listaPanelesCentral.add(panel);
		combinatoria.pack();
	}
	
	public static void quitarUltimoCompPanelCentral() {
		panelCentral.remove(panelCentral.getComponentCount() - 1);
		listaPanelesCentral.remove(listaPanelesCentral.size() - 1);
		combinatoria.pack();
	}
	
	public static void quitarPanelesCentralMenosPrimero() {
		for (int i = listaPanelesCentral.size() - 1; i > 0; i--) {
			panelCentral.remove(i+1);
			listaPanelesCentral.remove(i);
		}
	}
	
	public static void quitarPanelesCentral() {
		panelCentral.removeAll();
		listaPanelesCentral = new ArrayList<>();
	}
	
	
	/*		Main	*/
	
	public static void main(String[] args) {
		empezar();
	}

	
	/*	Getters/Setters	*/
	
	public static Combinatoria getCombinatoria() {
		return combinatoria;
	}

	public static String getTipoProblema() {
		return tipoProblema;
	}


	public static void setTipoProblema(String tipoProblema) {
		Combinatoria.tipoProblema = tipoProblema;
	}


	public static ArrayList<JPanel> getListaPanelesCentral() {
		return listaPanelesCentral;
	}


	public static JPanel getPanelCentral() {
		return panelCentral;
	}
	

}
