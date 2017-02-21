package main;

import java.awt.*;
import javax.swing.*;
import paneles.*;

public class Combinatoria extends JFrame{

	/*	Variables	*/
	
	// general
	private static final long serialVersionUID = 1L;
	protected static Combinatoria combinatoria;
	
	// jframe
	private static JPanel panelCentral;
	private static JPanel panelInferior;
	private static JButton botonSiguiente;
	
	
	/*	Constructor	*/
	
	@SuppressWarnings("deprecation")
	private static void empezar() {
		
		combinatoria = new Combinatoria();
		
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
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		combinatoria.add(panelCentral, BorderLayout.CENTER);
		PanelTitulo panelTitulo = new PanelTitulo();
		anadirCompPanelCentral(panelTitulo);
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
		combinatoria.pack();
	}
	
	public static void quitarUltCompPanelCentral(JPanel panel) {
		panelCentral.remove(panelCentral.getComponentCount());
		combinatoria.pack();
	}
	
	public static void cambiarPanel(JPanel panel) {
		panelCentral.removeAll();
		combinatoria.remove(panelCentral);
		combinatoria.add(panel);
		combinatoria.pack();
	}
	
	
	/*		Main	*/
	
	public static void main(String[] args) {
		empezar();
	}

	
	/*	Getters/Setters	*/
	
	public static Combinatoria getCombinatoria() {
		return combinatoria;
	}
	

}
