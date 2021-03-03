package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitle extends JPanel{
	
private JLabel title;
	
	public PanelTitle(){
		Font font=new Font(Font.SERIF,Font.BOLD,27);
		title=new JLabel("CRAPS");
		title.setFont(font);
		title.setForeground(new Color(211, 255, 179));
		setBorder(BorderFactory.createRaisedBevelBorder());
		setBackground(new Color(27, 46, 13));
		setLayout(new FlowLayout());
		add(title);
	}
	

}
