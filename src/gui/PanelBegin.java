package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.shaper.StandardButtonShaper;

import model.ActionsCraps;

public class PanelBegin extends JPanel{

	private JLabel img;
	private JLabel lblNumber;
	private JButton btnPlay;
	private JSpinner numberOfPlayer;
	private MainWindow window;
	
	private Image background;

	public PanelBegin(MainWindow window) {
		this.window=window;
		setLayout(new GridBagLayout());
		setBackground("resources/images/FondoPrincipal.jpg");
		//setBackground(new Color(147, 159, 225 ));
		begin();
		add();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = this.getSize().width;
		int height= this.getSize().height;
		if(this.background!=null){
			g.drawImage(this.background, 0, 0, width, height, null);
		}
		super.paintComponent(g);
	}
	
	public void setBackground(String image){
		this.setOpaque(false);
		this.background=new ImageIcon(image).getImage();
		repaint();
	}

	private void begin() {

		img=new JLabel(new ImageIcon("resources/images/logo.png"));
		btnPlay= new JButton("Jugar");
		btnPlay.setBackground(new Color(115, 117, 103 ));
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setActionCommand(ActionsCraps.START_GAME);
		btnPlay.addActionListener(window.getControll());
		
		lblNumber=new JLabel("Número de jugadores");
		
		lblNumber.setForeground(Color.white);
		Font font = new Font("Century", Font.BOLD, 27);
		lblNumber.setFont(font);
		lblNumber.setForeground(new Color(211, 255, 179));
		
		
		btnPlay.setFont(font);
		btnPlay.setForeground(new Color(224, 224, 222));
		this.btnPlay.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
		//btnPlay.setBorder(BorderFactory.createLoweredBevelBorder());
		
		SpinnerNumberModel model= new SpinnerNumberModel(2,2,10,1);
		Font font1 = new Font("Century", Font.BOLD, 20);
		numberOfPlayer= new JSpinner(model);
		numberOfPlayer.setFont(font1);

	}


	private void add() {
		
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.weightx=1.0;
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=3;
		add(new JLabel(" "),gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=1;
		add(lblNumber,gbc);
		
		gbc.gridy=3;
		add(new JLabel("  "),gbc);
		
		gbc.gridwidth=1;
		gbc.gridy=4;
		gbc.fill=GridBagConstraints.NONE;
		add(numberOfPlayer, gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		add(new JLabel("  "),gbc);
		
		gbc.gridy=6;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.NONE;
		add(btnPlay, gbc);
		
	}


	public JButton getBtnPlay() {
		return btnPlay;
	}


	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}


	public JSpinner getNumberOfPlayer() {
		return numberOfPlayer;
	}


	public void setNumberOfPlayer(JSpinner numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}


}
