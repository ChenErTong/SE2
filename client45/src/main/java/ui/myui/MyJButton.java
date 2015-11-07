package ui.myui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class MyJButton extends JButton{
	private static final long serialVersionUID = 1L;
	
	public MyJButton(String str, int x, int y, int width, int height){
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		this.setFont(new Font("Arail",Font.PLAIN,20));
		this.setText(str);
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setVisible(true);
		this.setBackground(backColor);
		this.setForeground(foreColor);
	}
}
