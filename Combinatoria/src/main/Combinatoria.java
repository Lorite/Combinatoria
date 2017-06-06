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
	private JScrollPane panelCentralSP;
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
		this.setSize(new Dimension((int) (1*screenWidth/3), (int) (3*screenHeight/5)));
		this.setMaximumSize(new Dimension((int) (1*screenWidth/3), (int) (3*screenHeight/5)));
		this.setPreferredSize(new Dimension((int) (1*screenWidth/3), (int) (3*screenHeight/5)));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		// panel central
		this.panelCentral = new JPanel();
		this.panelCentralSP = new JScrollPane(panelCentral);
		this.listaPanelesCentral = new ArrayList<>();
		this.panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		this.add(panelCentralSP, BorderLayout.CENTER);
		PanelTitulo panelTitulo = new PanelTitulo();
		this.add(panelTitulo, BorderLayout.NORTH);
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
				int m = ((Panel3) listaPanelesCentral.get(1)).getM();
				int n = ((Panel3) listaPanelesCentral.get(1)).getN();
				if (listaPanelesCentral.size() >= 2 && listaPanelesCentral.get(1) instanceof Panel3) {
					PanelResultadoa pa = new PanelResultadoa(m, n);
					anadirCompPanelCentral(pa);
					int posibilidadesTotales = pa.getResultado();
					anadirCompPanelCentral(new PanelResultadob(m, n, posibilidadesTotales));
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
		if (combinatoria.listaPanelesCentral.size() >= 2 && combinatoria.listaPanelesCentral.size() % 2 == 0)
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
		JPanel primerComponente = getListaPanelesCentral().get(0);
		combinatoria.panelCentral.removeAll();
		combinatoria.listaPanelesCentral = new ArrayList<>();
		combinatoria.listaPanelesCentral.add(primerComponente);
		combinatoria.panelCentral.add(primerComponente);
		combinatoria.panelCentral.repaint();
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
