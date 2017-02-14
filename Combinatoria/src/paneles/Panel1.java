package paneles;

import java.awt.*;
import javax.swing.*;

public class Panel1 extends JPanel{

	public Panel1() {
		super();
	}
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Prueba");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600,300);
		frame.setLocationRelativeTo(null);
		
		Panel1 panel = new Panel1();
		frame.add(panel);
		
		frame.show();

	}

}
