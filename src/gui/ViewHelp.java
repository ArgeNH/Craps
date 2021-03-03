package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewHelp extends JInternalFrame{
	
	private MainWindow window;
	private JDesktopPane desktop;
	private JTextArea label;
	private JLabel image;
	
	public ViewHelp(MainWindow window, JDesktopPane desktop) {
		this.window = window;
		this.desktop = desktop;
		setTitle("Instrucciones del Juego");
		setSize(new Dimension(330,220));
		setLayout(new GridLayout(1,1));
		setResizable(false);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(new Color(231, 230, 177));
		setFrameIcon(new ImageIcon("resources/images/instructions (1).png"));
		beginComponents();
		addComponents();
		desktop.add(this);
	}

	private void beginComponents() {
		
		Font font=new Font("Calibri", 3, 13);
		
		label=new JTextArea();
		label.setFont(font);
		label.setForeground(Color.BLACK);
		label.setText("	Instrucciones del Juego\n"
				+ "    CRAPS\n"
				+ "> El jugador que tiene el primer turno si obtiene un 7 o 11,\n"
				+ " en la suma de los dados. Gana el Juego\n"
				+ "> Si no, y la suma es 2,3 o 12 en el primer tiro,\n"
				+ "el jugador pierde.\n"
				+ "> Si la suma es 4, 5, 6, 8, 9 o 10, en el\n"
				+ " primer tiro, se convierte en el punto del jugador.\n"
				+ ""
				+ "> ...");
		label.setEditable(false);
	}

	private void addComponents() {
		add(new JScrollPane(label));
		
	}
	
	

}
