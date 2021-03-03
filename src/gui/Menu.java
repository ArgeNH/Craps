package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.ActionsCraps;

public class Menu extends JMenuBar{
	
	private JMenu player;
	private JMenu craps;
	private JMenu help;
	
	private JMenuItem addPlayer;
	private JMenuItem gameCraps;
	private JMenuItem helping;
	
	private MainWindow window;
	
	public Menu(MainWindow window) {
		this.window=window;
		beginElements();
		addElements();
		setBackground(new Color(181, 235, 82));
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	private void beginElements() {
		Font font=new Font("David", 3, 18);
		
		player=new JMenu("Jugador");
		player.setMnemonic('P');
		player.setFont(font);
		
		craps=new JMenu("Juego");
		craps.setMnemonic('J');
		craps.setFont(font);
		
		help=new JMenu("Ayuda");
		help.setMnemonic('H');
		help.setFont(font);
		
		addPlayer=new JMenuItem("Añadir Jugadores");
		addPlayer.setMnemonic('A');
		addPlayer.setIcon(new ImageIcon("resources/images/player.png"));
		addPlayer.setActionCommand(ActionsCraps.VIEW_ADD_PLAYER);
		addPlayer.addActionListener(window.getControll());
		
		gameCraps=new JMenuItem("Jugar");
		gameCraps.setMnemonic('G');
		gameCraps.setIcon(new ImageIcon("resources/images/dice (4).png"));
		gameCraps.setActionCommand(ActionsCraps.VIEW_GAME);
		gameCraps.addActionListener(window.getControll());
		
		helping=new JMenuItem("Instrucciones");
		helping.setMnemonic('I');
		helping.setIcon(new ImageIcon("resources/images/instructions.png"));
		helping.setActionCommand(ActionsCraps.HELP);
		helping.addActionListener(window.getControll());
		
	}

	private void addElements() {
		add(player);
		add(craps);
		add(help);
		
		player.add(addPlayer);
		
		craps.add(gameCraps);
		
		help.add(helping);
	}

	public JMenu getPlayer() {
		return player;
	}

	public void setPlayer(JMenu player) {
		this.player = player;
	}

	public JMenu getCraps() {
		return craps;
	}

	public void setCraps(JMenu craps) {
		this.craps = craps;
	}

	public JMenu getHelp() {
		return help;
	}

	public void setHelp(JMenu help) {
		this.help = help;
	}

	public JMenuItem getAddPlayer() {
		return addPlayer;
	}

	public void setAddPlayer(JMenuItem addPlayer) {
		this.addPlayer = addPlayer;
	}
	
}