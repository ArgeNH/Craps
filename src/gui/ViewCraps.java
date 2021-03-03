package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ActionsCraps;

public class ViewCraps extends JInternalFrame{

	private MainWindow window;
	private JDesktopPane desktop;
	
	private JLabel lblDiceOne;
	private JLabel lblDiceTwo;
	private JLabel lblPoints;
	private JLabel lblTurn;
	
	private JTextField txtDiceOne;
	private JTextField txtDiceTwo;
	private JTextField txtPoints;
	private JTextField txtTurn;
	
	private JButton btnPlay;
	private JButton btnPlayerStart;
	private JButton btnAgain;
	
	private DefaultTableModel model;
	private JTable table;
	
	private JLabel image;
	
	public ViewCraps(MainWindow window, JDesktopPane desktop) {
		this.window=window;
		this.desktop=desktop;
		setTitle("CRAPS");
		setSize(new Dimension(400,450));
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(new Color(35, 135, 8 ));
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		beginElements();
		addElements();
		desktop.add(this);
	}

	private void beginElements() {
		
		Font font=new Font("Calibri", 3, 18);
		Font fontLbl=new Font("Calibri", Font.BOLD, 15);
		
		lblDiceOne=new JLabel("Dado Uno");
		lblDiceOne.setFont(fontLbl);
		
		lblDiceTwo=new JLabel("Dado Dos");
		lblDiceTwo.setFont(fontLbl);
		
		lblPoints=new JLabel("Puntos del Jugador");
		lblPoints.setFont(fontLbl);
		
		lblTurn=new JLabel("Turno de");
		lblTurn.setFont(fontLbl);
		
		txtDiceOne=new JTextField();
		txtDiceOne.setFont(font);
		txtDiceOne.setEditable(false);
		
		txtDiceTwo=new JTextField();
		txtDiceTwo.setFont(font);
		txtDiceTwo.setEditable(false);
		
		txtPoints=new JTextField();
		txtPoints.setFont(font);
		txtPoints.setEditable(false);
		
		txtTurn=new JTextField();
		txtTurn.setFont(font);
		txtTurn.setEditable(false);
		
		Font fontBtn=new Font("David", 3, 14);
		
		btnPlay=new JButton("Lanzar Dados");
		btnPlay.setFont(fontBtn);
		btnPlay.setBackground(new Color(163, 0, 0 ));
		btnPlay.setActionCommand(ActionsCraps.THROW_DICE);
		btnPlay.addActionListener(window.getControll());
		btnPlay.setForeground(Color.white);
		
		btnPlayerStart= new JButton("Jugador inicial");
		btnPlayerStart.setFont(fontBtn);
		btnPlayerStart.setBackground(new Color(163, 0, 0 ));
		btnPlayerStart.setActionCommand(ActionsCraps.PLAYER_START);
		btnPlayerStart.addActionListener(window.getControll());
		btnPlayerStart.setForeground(Color.white);
		
		btnAgain=new JButton("Volver a Empezar");
		btnAgain.setFont(fontBtn);
		btnAgain.setBackground(new Color(163,0,0));
		btnAgain.setActionCommand(ActionsCraps.AGAIN_START);
		btnAgain.addActionListener(window.getControll());
		btnAgain.setForeground(Color.WHITE);

		image=new JLabel(new ImageIcon("resources/images/dados.gif"));
		image.setSize(new Dimension(10,10));
		
		String[] headings=new String[]{"NickName","Nombre"};
		model=new DefaultTableModel(headings,0);
		table=new JTable(model);
	}

	private void addElements() {
		GridBagConstraints gbc=new GridBagConstraints();
		
		gbc.weightx=1.0;


		gbc.gridx=3;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.NONE;
		add(lblTurn,gbc);
		
		gbc.gridx=4;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtTurn,gbc);
	
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.NONE;
		add(btnPlayerStart,gbc);
		
		gbc.gridy=1; 	//Espacio
		gbc.gridwidth=1;
		add(new JLabel(" "),gbc);
		
		gbc.gridx=0;
		gbc.gridy=2; 	//Espacio
		add(new JLabel(" "),gbc);
		
		gbc.gridy=3;
		gbc.fill=GridBagConstraints.NONE;
		add(lblPoints,gbc);
		
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtPoints,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;		//Espacio
		add(new JLabel(" "),gbc);
		
		gbc.gridy=5;
		gbc.fill=GridBagConstraints.NONE;
		add(lblDiceOne,gbc);
		
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtDiceOne,gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;		//Espacio
		add(new JLabel(" "),gbc);
		
		gbc.gridy=7;
		gbc.fill=GridBagConstraints.NONE;
		add(lblDiceTwo,gbc);
		
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtDiceTwo,gbc);
		
		gbc.gridx=0;
		gbc.gridy=8;		//Espacio
		add(new JLabel(" "),gbc);
		
		gbc.gridy=9;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.NONE;
		add(btnPlay,gbc);
		
		gbc.gridx=0;
		gbc.gridy=10;		//Espacio
		add(new JLabel(" "),gbc);
		
		gbc.gridy=12;
		add(image,gbc);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.gridwidth=1;
		add(new JLabel(" "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=5;
		gbc.gridheight=12;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);
	}

	public JLabel getLblDiceOne() {
		return lblDiceOne;
	}

	public void setLblDiceOne(JLabel lblDiceOne) {
		this.lblDiceOne = lblDiceOne;
	}

	public JLabel getLblDiceTwo() {
		return lblDiceTwo;
	}

	public void setLblDiceTwo(JLabel lblDiceTwo) {
		this.lblDiceTwo = lblDiceTwo;
	}

	public JLabel getLblPoints() {
		return lblPoints;
	}

	public void setLblPoints(JLabel lblPoints) {
		this.lblPoints = lblPoints;
	}

	public JLabel getLblTurn() {
		return lblTurn;
	}

	public void setLblTurn(JLabel lblTurn) {
		this.lblTurn = lblTurn;
	}

	public JTextField getTxtDiceOne() {
		return txtDiceOne;
	}

	public void setTxtDiceOne(JTextField txtDiceOne) {
		this.txtDiceOne = txtDiceOne;
	}

	public JTextField getTxtDiceTwo() {
		return txtDiceTwo;
	}

	public void setTxtDiceTwo(JTextField txtDiceTwo) {
		this.txtDiceTwo = txtDiceTwo;
	}

	public JTextField getTxtPoints() {
		return txtPoints;
	}

	public void setTxtPoints(JTextField txtPoints) {
		this.txtPoints = txtPoints;
	}

	public JTextField getTxtTurn() {
		return txtTurn;
	}

	public void setTxtTurn(JTextField txtTurn) {
		this.txtTurn = txtTurn;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

	public JButton getBtnPlayerStart() {
		return btnPlayerStart;
	}

	public void setBtnPlayerStart(JButton btnPlayerStart) {
		this.btnPlayerStart = btnPlayerStart;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnAgain() {
		return btnAgain;
	}

	public void setBtnAgain(JButton btnAgain) {
		this.btnAgain = btnAgain;
	}
	
	
}
