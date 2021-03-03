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
import javax.swing.JTextField;

import model.ActionsCraps;

public class ViewPlayer extends JInternalFrame {
	
	private JDesktopPane desktop;
	private MainWindow window;
	
	private JTextField txtNamePlayer;
	private JTextField txtNickName;
	private JLabel image;
	
	private JLabel lblShowNumberPlayers;
	private JLabel lblNamePlayer;
	private JLabel lblNickName;

	private JButton btnAddPlayer;
	
	public ViewPlayer(MainWindow window, JDesktopPane desktop ) {
		this.desktop=desktop;
		this.window=window;
		setTitle("Adicionar Jugador");
		setSize(new Dimension(400, 250));
		//setBackground(new Color(24, 24, 61));
		setBackground(Color.BLACK);
		setFrameIcon(new ImageIcon("resources/images/user.png"));
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		beginElements();
		addElements();
		desktop.add(this);
	}

	private void beginElements() {
		
		Font font=new Font("Century", 3, 17);
		Font fontLbl=new Font("Calibri", Font.BOLD, 17);
		
		lblShowNumberPlayers=new JLabel("Jugador --> 1");
		lblShowNumberPlayers.setForeground(new Color(19, 237, 212));
		lblShowNumberPlayers.setFont(fontLbl);
		
		txtNamePlayer=new JTextField();
		txtNamePlayer.setFont(font);
		txtNamePlayer.setForeground(Color.BLACK);
		
		lblNamePlayer=new JLabel("Nombre");
		lblNamePlayer.setFont(fontLbl);
		lblNamePlayer.setForeground(new Color(187, 207, 74));
		
		txtNickName=new JTextField();
		txtNickName.setFont(font);
		txtNickName.setForeground(Color.BLACK);
		
		lblNickName=new JLabel("NickName");
		lblNickName.setFont(fontLbl);
		//lblNickName.setForeground(new Color(219, 101, 22));
		lblNickName.setForeground(new Color(224, 95, 9));
		
		image=new JLabel(new ImageIcon("resources/images/user (2).png"));
		
		Font fontBtn=new Font("David", 3, 18);
		
		btnAddPlayer=new JButton("Agregar");
		btnAddPlayer.setFont(fontBtn);
		btnAddPlayer.setBackground(new Color(120, 209, 56));
		btnAddPlayer.setForeground(Color.WHITE);
		//btnAddPlayer.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		btnAddPlayer.setActionCommand(ActionsCraps.ADD_PLAYER);
		btnAddPlayer.addActionListener(window.getControll());
	}

	private void addElements() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		gbc.weightx=1.0;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.NONE;
		gbc.gridwidth=2;
		add(lblShowNumberPlayers,gbc);
		
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=2;
		add(image,gbc);
		
		gbc.gridx=1;
		gbc.gridheight=1;
		add(lblNickName,gbc);
		
		gbc.gridy=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtNickName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		add(new JLabel(" "),gbc);
		
		gbc.gridy=4;
		gbc.fill=GridBagConstraints.NONE;
		add(lblNamePlayer,gbc);
		
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtNamePlayer,gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		add(new JLabel(" "),gbc);
		
		gbc.gridy=6;
		gbc.fill=GridBagConstraints.NONE;
		gbc.gridwidth=2;
		add(btnAddPlayer,gbc);
		
	}

	public JTextField getTxtNamePlayer() {
		return txtNamePlayer;
	}

	public void setTxtNamePlayer(JTextField txtNamePlayer) {
		this.txtNamePlayer = txtNamePlayer;
	}

	public JTextField getTxtNickName() {
		return txtNickName;
	}

	public void setTxtNickName(JTextField txtNickName) {
		this.txtNickName = txtNickName;
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}

	public JButton getBtnAddPlayer() {
		return btnAddPlayer;
	}

	public void setBtnAddPlayer(JButton btnAddPlayer) {
		this.btnAddPlayer = btnAddPlayer;
	}

	public JLabel getLblShowNumberPlayers() {
		return lblShowNumberPlayers;
	}

	public void setLblShowNumberPlayers(JLabel lblShowNumberPlayers) {
		this.lblShowNumberPlayers = lblShowNumberPlayers;
	}
	
}