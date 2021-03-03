package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import java.util.ResourceBundle.Control;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

import controll.ControllCraps;
import model.ActionsCraps;
import model.ListedCircled;
import model.ManagementCraps;
import model.Player;

public class MainWindow extends JFrame implements ActionsCraps{

	private JDesktopPane desktop; 
	private ControllCraps controll;
	private PanelTitle panelTitle;
	private PanelBegin panelBegin;
	private Menu menu;
	private ViewPlayer viewPlayer;
	private ViewHelp viewHelp;
	private ViewCraps viewCraps;

	public MainWindow() {
		setTitle("CRAPS");
		setSize(new Dimension(720,550));
		setResizable(false);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("resources/images/dice.png").getImage());
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void begin() {
		beginComponets();
		addComponents();
		setVisible(true);
	}

	private void beginComponets() {
		desktop=new JDesktopPane();
		panelTitle=new PanelTitle();
		panelBegin= new PanelBegin(this);
		menu=new Menu(this);
		viewPlayer=new ViewPlayer(this, desktop);
		viewHelp=new ViewHelp(this, desktop);
		viewCraps=new ViewCraps(this, desktop);
	}

	private void addComponents() {
		this.setJMenuBar(menu);
		add(panelTitle,BorderLayout.NORTH);
		add(panelBegin, BorderLayout.CENTER);
		menu.setVisible(false);
		desktop.setVisible(false);
	}

	@Override
	public void exit() {
		int exit=JOptionPane.showConfirmDialog(null, "¿Desea Salir?","SALIR", JOptionPane.YES_OPTION);
		if(exit==JOptionPane.YES_NO_OPTION){
			JOptionPane.showMessageDialog(this, "Saliendo de la gestión","SALIR",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	public void addDesktop(){
		add(desktop,BorderLayout.CENTER);
	}


	@Override
	public String[] readInput(String option) {
		switch(option){
		case ActionsCraps.START_GAME: panelTitle.setVisible(false);
		menu.setVisible(true); panelBegin.setVisible(false);
		desktop.setVisible(true); menu.getCraps().setVisible(false);
		controll.getMng().setNumber(Integer.parseInt(panelBegin.getNumberOfPlayer().getValue().toString()));
		viewPlayer.setVisible(true);
		break;
		case ActionsCraps.VIEW_ADD_PLAYER:

			addDesktop();
			viewPlayer.setVisible(true);
			break;
		case ActionsCraps.HELP: addDesktop(); 
		viewHelp.setVisible(true);
		break;
		case ActionsCraps.VIEW_GAME: addDesktop();
		viewCraps.setVisible(true);
		viewCraps.getBtnPlay().setEnabled(false);
		break;
		case ActionsCraps.PLAYER_START:
			controll.getMng().generateTurn();
			String nickName=controll.getMng().getTurn().getNickName();
			viewCraps.getTxtTurn().setText(nickName);
			viewCraps.getBtnPlayerStart().setVisible(false);;
			viewCraps.getBtnPlayerStart().setForeground(new Color(125, 125, 125));
			viewCraps.getBtnPlay().setEnabled(true);
			break;
		case ActionsCraps.THROW_DICE: 
			if(controll.getPlayers().size()>1){
				game();
				if(controll.getPlayers().size()==1){
					JOptionPane.showMessageDialog(null, "Ganaste el JUEGO","JUEGO",JOptionPane.PLAIN_MESSAGE,icono1);
					viewCraps.getBtnPlay().setEnabled(false);
				}
			}


			break;
		case ActionsCraps.AGAIN_START:
			controll.setMng(new ManagementCraps());
			new MainWindow();
			new ListedCircled<>(Player.compId);
			panelBegin.setVisible(true);
			viewCraps.setVisible(false);
			desktop.setVisible(false);
			break;
		case ActionsCraps.ADD_PLAYER: return addPlayer();
		}
		return null;
	}

	private byte dices() {
		byte diceOne=controll.getMng().generateDices();
		byte diceTwo=controll.getMng().generateDices();
		viewCraps.getTxtDiceOne().setText(String.valueOf(diceOne));
		viewCraps.getTxtDiceTwo().setText(String.valueOf(diceTwo));

		byte sum=(byte) (diceOne+diceTwo);


		return sum;


	}

	final int win=0;
	final int lose=1;
	final int next=2;

	private boolean firstThrew=true;
	private byte sumDices=0;
	private byte point=0;
	private byte stateGame= next;


	public 	void game(){
		sumDices=dices();
		if(firstThrew){
			switch(sumDices){
			case 7:
			case 11:
				stateGame= win;
				JOptionPane.showMessageDialog(null, "Ganaste","JUEGO",JOptionPane.PLAIN_MESSAGE,icono1);
				controll.getMng().setTurn(controll.getMng().findNodePlayer(controll.getMng().getTurn().getNickName()).getNext().getInfo());
				viewCraps.getTxtTurn().setText(controll.getMng().getTurn().getNickName());
				break;
			case 2:
			case 3:
			case 12:
				stateGame=lose;
				JOptionPane.showMessageDialog(null, "Perdio","JUEGO",JOptionPane.PLAIN_MESSAGE,icono);
				controll.getMng().setTurn(controll.getMng().findNodePlayer(controll.getMng().getTurn().getNickName()).getNext().getInfo());
				controll.getMng().deleteNode(viewCraps.getTxtTurn().getText());
				viewCraps.getTxtTurn().setText(controll.getMng().getTurn().getNickName());
				controll.actionPerformed(new ActionEvent(this, 0, ActionsCraps.LIST_PLAYER));
				break;
			default:
				stateGame=next;
				point=sumDices;
				viewCraps.getTxtPoints().setText(String.valueOf(point));
				controll.getMng().getTurn().setPoint(point);
				firstThrew=false;
				JOptionPane.showMessageDialog(null, "Lanza de nuevo","JUEGO",JOptionPane.PLAIN_MESSAGE,icono2);
				break;
			}
		}else{
			if(sumDices==point){
				stateGame=win;
				JOptionPane.showMessageDialog(null, "Ganaste","JUEGO",JOptionPane.PLAIN_MESSAGE,icono1);
				controll.getMng().setTurn(controll.getMng().findNodePlayer(controll.getMng().getTurn().getNickName()).getNext().getInfo());
				viewCraps.getTxtTurn().setText(controll.getMng().getTurn().getNickName());

			}else{
				if(sumDices==7){
					stateGame=lose;
					JOptionPane.showMessageDialog(null, "Perdio","JUEGO",JOptionPane.PLAIN_MESSAGE,icono);
					controll.getMng().setTurn(controll.getMng().findNodePlayer(controll.getMng().getTurn().getNickName()).getNext().getInfo());
					controll.getMng().deleteNode(viewCraps.getTxtTurn().getText());
					viewCraps.getTxtTurn().setText(controll.getMng().getTurn().getNickName());
					controll.actionPerformed(new ActionEvent(this, 0, ActionsCraps.LIST_PLAYER));
				}
			}
		}
		showMessague();
	}


	private void showMessague() {
		if(stateGame==next){
			System.out.println("Tirar");

		}else{
			if(stateGame==win){
				System.out.println("gana");
			}else{
				System.out.println("Pierde");
			}
			firstThrew=true;
		}

	}

	ImageIcon icono=new ImageIcon("resources/images/sad.png");
	ImageIcon icono1=new ImageIcon("resources/images/win.png");
	ImageIcon icono2=new ImageIcon("resources/images/dice (5).png");

	private String[] addPlayer() {
		String nickName=viewPlayer.getTxtNickName().getText();
		String name=viewPlayer.getTxtNamePlayer().getText();
		if(nickName.equals("") && name.equals("")) {
			viewPlayer.getTxtNickName().setBackground(Color.red);
			viewPlayer.getTxtNamePlayer().setBackground(Color.red);

			JOptionPane.showMessageDialog(viewPlayer, "Por favor digita Todos los espacios en blanco");
			return null;
		}else
			if (nickName.equals("")) {	
				viewPlayer.getTxtNickName().setBorder(BorderFactory.createLineBorder(Color.red));
				JOptionPane.showMessageDialog(viewPlayer, "Por favor digita el espacio que se marcó en rojo");
				return null;
			}else if(name.equals("")){
				viewPlayer.getTxtNamePlayer().setBorder(BorderFactory.createLineBorder(Color.red));
				JOptionPane.showMessageDialog(viewPlayer, "Por favor digita el espacio que se marcó en rojo");
				return null;

			}


			else {
				if(controll.getPlayers().size()==controll.getMng().getNumber()) {
					viewPlayer.getBtnAddPlayer().setEnabled(true);
					JOptionPane.showMessageDialog(viewPlayer, "Ya digitaste todos los jugadores De este juego","OK",JOptionPane.PLAIN_MESSAGE,icono); //TODO falta icono
				}else {
					if (viewPlayer.getTxtNickName().equals("") || viewPlayer.getTxtNamePlayer().equals("")) {
						JOptionPane.showMessageDialog(null, "Hay campos en blanco");
					}
					return new String[]{nickName,name};
				}

			}
		return new String[]{nickName,name};
	}


	@Override
	public void writeOuput(String option, String[] output, boolean state) {
		switch(option){
		case ActionsCraps.ADD_PLAYER:
			viewPlayer.getLblShowNumberPlayers().setText("Jugador --> "+(controll.getPlayers().size()+1));
				if(output!=null){
					if(state){
						JOptionPane.showMessageDialog(null, "El jugador se ha agregado correctamente");
						viewPlayer.getTxtNickName().setText("");
						viewPlayer.getTxtNamePlayer().setText("");
						viewPlayer.getTxtNickName().setBorder(BorderFactory.createLineBorder(Color.WHITE));
						viewPlayer.getTxtNamePlayer().setBorder(BorderFactory.createLineBorder(Color.WHITE));
						viewPlayer.getTxtNickName().setBackground(Color.WHITE);
						viewPlayer.getTxtNamePlayer().setBackground(Color.WHITE);


						controll.actionPerformed(new ActionEvent(this, 0, ActionsCraps.LIST_PLAYER));
						if (controll.getPlayers().size()==controll.getMng().getNumber()) {
							menu.getCraps().setVisible(true);
							viewPlayer.getLblShowNumberPlayers().setText("Jugadores agregados");;
							viewPlayer.getBtnAddPlayer().setEnabled(false);
							viewPlayer.getTxtNickName().setEnabled(false);
							viewPlayer.getTxtNamePlayer().setEnabled(false);
							controll.actionPerformed(new ActionEvent(this, 0, ActionsCraps.LIST_PLAYER));
							viewCraps.setVisible(true);
							viewPlayer.setVisible(false);
						
						}
					}else{
						JOptionPane.showMessageDialog(null, "El jugador ya existe","Registro",JOptionPane.PLAIN_MESSAGE,icono);
						
					}
				}else{
					
				}
			
			break;
		case "List":
			refreshTable(output);
			break;
		}

	}

	private void refreshTable(String[] output) {
		DefaultTableModel dtm = viewCraps.getModel(); 
		while (dtm.getRowCount()>0) {
			dtm.removeRow(0);
		}	
		for (String line : output) {
			StringTokenizer tokens = new StringTokenizer(line, ";");
			String nickName = tokens.nextToken(); 
			String name = tokens.nextToken(); 
			Object [] row = new Object[] {nickName,name}; 
			dtm.addRow(row);
		}
	}

	@Override
	public void setControll(ControllCraps controll) {
		this.controll=controll;
	}

	public ControllCraps getControll() {
		return controll;
	}

}
