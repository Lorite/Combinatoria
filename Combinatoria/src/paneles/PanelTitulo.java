package paneles;

import java.awt.*;
import javax.swing.*;

public class PanelTitulo extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel tituloLabel;
	JLabel autorLabel;
	
	public PanelTitulo() {
		super();
		
		this.setLayout( new BorderLayout());
		
//		JLabel asdsa = new JLabel("asdasdada");
//		this.add(asdsa, BorderLayout.WEST);
		tituloLabel = new JLabel("COMBINATORIA");
		tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(tituloLabel, BorderLayout.CENTER);
		autorLabel = new JLabel("Por Alejandro Lorite");
		autorLabel.setFont(new Font("Arial", Font.BOLD, 12));
		this.add(autorLabel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		
		PanelTitulo panel = new PanelTitulo();
		frame.add(panel);
		
		frame.setVisible(true);

	}

}
