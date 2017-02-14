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
	private static JButton botonAnterior;
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
		combinatoria.setSize(new Dimension((int) (3*screenWidth/5), (int) (4*screenHeight/5)));
		combinatoria.setLocationRelativeTo(null);
		combinatoria.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		combinatoria.getContentPane().setLayout(new BorderLayout());
		
		// panel central
		panelCentral = new JPanel(new BorderLayout());
		combinatoria.add(panelCentral, BorderLayout.CENTER);
		Panel1 panel1 = new Panel1();
		cambiarPanel(panel1);
		
		// panel inferior
		panelInferior = new JPanel(new BorderLayout());
		botonAnterior = new JButton("Anterior");
		botonAnterior.setFont( new Font("Arial", Font.BOLD, 20));
		panelInferior.add(botonAnterior, BorderLayout.WEST);
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setFont( new Font("Arial", Font.BOLD, 20));
		panelInferior.add(botonSiguiente, BorderLayout.EAST);
		combinatoria.add(panelInferior, BorderLayout.SOUTH);
		
		// mostrar ventana
		combinatoria.revalidate();
		combinatoria.show();
	}
	
	
	/*	Métodos	*/
	
	private static void cambiarPanel(JPanel panel) {
		panelCentral.removeAll();
		combinatoria.add(panel);
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
