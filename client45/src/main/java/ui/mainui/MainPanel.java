package ui.mainui;

import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public MainPanel(){
		this.setOpaque(false);
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0.25f));
	}
}
