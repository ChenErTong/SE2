package ui.myui;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JList;

public class MyJList extends JList<String>{
	private static final long serialVersionUID = 1L;

	public MyJList(int x, int y, int width, int height){
		this.setFont(new MyFont(15));
		this.setBounds(x, y, width, height);
		this.setVisibleRowCount(5);
		MyColor.setColor(4);
		this.setBackground(MyColor.getColor());
		this.setForeground(Color.BLACK);
		this.setVisible(true);
	}
}
