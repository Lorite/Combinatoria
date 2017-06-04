package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import paneles.*;

public class Combinatoria extends JFrame{

	/*	Variables	*/
	
	// general
	private static final long serialVersionUID = 1L;
	protected static Combinatoria combinatoria = null;
	protected String tipoProblema;
	
	// jframe
	private JPanel panelCentral;
	private ArrayList<JPanel> listaPanelesCentral;
	private JPanel panelInferior;
	private JButton botonCalcular;
	
	
	/*	Constructor	*/
	
	protected Combinatoria() {
		this.tipoProblema = "Desconocido";
		
		// opciones del jframe
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		this.setTitle("Combinatoria");
		this.setSize(new Dimension((int) (3*screenWidth/5), (int) (3*screenHeight/5)));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		// panel central
		this.panelCentral = new JPanel();
		this.listaPanelesCentral = new ArrayList<>();
		this.panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		this.add(panelCentral, BorderLayout.CENTER);
		PanelTitulo panelTitulo = new PanelTitulo();
		this.panelCentral.add(panelTitulo);
		Panel1 panel1 = new Panel1();
		this.panelCentral.add(panel1);
		this.listaPanelesCentral.add(panel1);
		
		// panel inferior
		this.panelInferior = new JPanel(new BorderLayout());
		this.botonCalcular = new JButton("Calcular");
		this.botonCalcular.setFont( new Font("Arial", Font.BOLD, 16));
		this.botonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaPanelesCentral.size() >= 2 && listaPanelesCentral.get(1) instanceof Panel3) {
					anadirCompPanelCentral(new PanelResultadoa(((Panel3) listaPanelesCentral.get(1)).getM(), 
							((Panel3) listaPanelesCentral.get(1)).getN()));	
					anadirCompPanelCentral(new PanelResultadob());
				} else
					JOptionPane.showMessageDialog(null, "Completa primero los pasos previos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		this.panelInferior.add(botonCalcular, BorderLayout.EAST);
		this.add(panelInferior, BorderLayout.SOUTH);
		
		// mostrar ventana
		this.revalidate();
		this.pack();
	}
	
	
	private static void empezar() {
		combinatoria = Combinatoria.getCombinatoria();
		anadirCompPanelCentral(new Panel2());
		combinatoria.setVisible(true);
	}
	
	
	/*	Métodos	*/
	
	public static void anadirCompPanelCentral(JPanel panel) {
		combinatoria.panelCentral.add(new JLabel("-"));
		if (combinatoria.listaPanelesCentral.size() >= 2 && combinatoria.listaPanelesCentral.size() % 2 == 1)
			combinatoria.panelCentral.add(new JLabel("-"));
		combinatoria.panelCentral.add(panel);
		combinatoria.listaPanelesCentral.add(panel);
		combinatoria.pack();
	}
	
	public static void quitarUltimoCompPanelCentral() {
		combinatoria.panelCentral.remove(combinatoria.panelCentral.getComponentCount() - 1);
		combinatoria.listaPanelesCentral.remove(combinatoria.listaPanelesCentral.size() - 1);
		combinatoria.pack();
	}
	
	public static void quitarPanelesCentralMenosPrimero() {
		for (int i = combinatoria.listaPanelesCentral.size() - 1; i > 0; i--) {
			combinatoria.panelCentral.remove(i+1);
			combinatoria.panelCentral.remove(i+1);
			combinatoria.listaPanelesCentral.remove(i);
		}
	}
	
	public static void quitarPanelesCentral() {
		combinatoria.panelCentral.removeAll();
		combinatoria.listaPanelesCentral = new ArrayList<>();
	}
	
	
	/*		Main	*/
	
	public static void main(String[] args) {
		empezar();
	}

	
	/*	Getters/Setters	*/
	
	public static Combinatoria getCombinatoria() {
	      if(combinatoria == null) {
	    	  combinatoria = new Combinatoria();
	      }
	      return combinatoria;
	   }

	public static String getTipoProblema() {
		return combinatoria.tipoProblema;
	}


	public static void setTipoProblema(String tipoProblema) {
		combinatoria.tipoProblema = tipoProblema;
	}


	public static ArrayList<JPanel> getListaPanelesCentral() {
		return combinatoria.listaPanelesCentral;
	}


	public static JPanel getPanelCentral() {
		return combinatoria.panelCentral;
	}
	

}
