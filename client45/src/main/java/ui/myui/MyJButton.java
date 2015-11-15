package ui.myui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
/**
 * 按钮总类
 * @author czw
 * @time 2015年11月15日下午4:12:14
 */
public class MyJButton extends JButton{
	private static final long serialVersionUID = 1L;
	/**
	 * 按钮构造器
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 */
	public MyJButton(int x, int y, int width, int height){
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		this.setFont(new Font("Arail",Font.PLAIN,20));
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setBackground(backColor);
		this.setForeground(foreColor);
		this.setVisible(true);
	}
	/**
	 * 设置内容
	 * @param str 按钮内容
	 */
	public void setText(String str){
		this.setText(str);
	}
}
