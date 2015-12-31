package ui.myui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
/**
 * 下拉框组件
 * @author zsq
 * @time 2015/11/17 20:33
 */
public class MyComboBox extends JComboBox<String>{

	private static final long serialVersionUID = 1L;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param fontSize 字体大小
	 * @param str 下拉列表集合
	 */
	public MyComboBox(int x, int y, int width, int height,int fontSize, String[] str){
		this.setBorder(BorderFactory.createEmptyBorder());	
		this.setBounds(x, y, width, height);
		for(int i = 0; i < str.length; i++)
			this.addItem(str[i]);
		Color foreColor = new Color(0, 0, 0, 0.6f);
		Color backColor = MyColor.getColor();
		
		this.setBackground(backColor);
		this.setForeground(foreColor);
		this.setFont(new MyFont(fontSize));
		this.setVisible(true);
	}
	/**
	 * JComboBox的联动实现
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 */
	public MyComboBox(int x,int y,int width,int height){
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setFont(new MyFont(15));
		this.setBounds(x, y, width, height);
		this.setForeground(Color.BLACK);
		this.setVisible(true);
	}
}