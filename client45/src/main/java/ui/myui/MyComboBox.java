package ui.myui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
/**
 * 下拉框组件
 * @author zsq
 * @time 2015/11/17 20:33
 */
public class MyComboBox extends JComboBox<String>{

	private static final long serialVersionUID = 1L;

	public MyComboBox(int x, int y, int width, int height,int fontSize, String[] str){
		
		this.setBounds(x, y, width, height);
		for(int i = 0; i < str.length; i++)
			this.addItem(str[i]);
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		this.setBackground(backColor);
		this.setForeground(foreColor);
		this.setFont(new MyFont(fontSize));
		this.setVisible(true);
		
		
		
	}
}
