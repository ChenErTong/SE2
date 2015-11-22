package ui.myui;

import java.awt.Color;
import javax.swing.JRadioButton;

public class MyJRadioButton extends JRadioButton {
	private static final long serialVersionUID = 1L;
	
	public MyJRadioButton(int x, int y, int width, int height, String text){
		this.setFont(new MyFont(15, true));
		this.setBounds(x, y, width, height);
		this.setForeground(Color.BLACK);
		this.setContentAreaFilled(false);
		this.setSelected(true);
		this.setText(text);
		this.setVisible(true);
	}
}