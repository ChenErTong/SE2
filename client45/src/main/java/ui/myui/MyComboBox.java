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
	
		this.setSelectedItem(str[0]);
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		this.setBackground(backColor);
		this.setForeground(foreColor);
		this.setFont(new MyFont(fontSize));
		this.setVisible(true);
		
		
		
	}
	/**
	 * JComboBox的联动实现
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public MyComboBox(int x,int y,int width,int height){
		this.setFont(new MyFont(15));
		this.setBounds(x, y, width, height);
		this.setForeground(Color.BLACK);
		//for(int i = 0; i < items.length; i++){
			//this.addItem(items[i]);
		//}
		//this.setSelectedItem(items[0]);
		this.setVisible(true);
	}
}
