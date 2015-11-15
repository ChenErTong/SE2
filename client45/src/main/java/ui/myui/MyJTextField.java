package ui.myui;

import javax.swing.JTextField;

public class MyJTextField extends JTextField{
	private static final long serialVersionUID = 1L;

	public MyJTextField(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
	}
}
