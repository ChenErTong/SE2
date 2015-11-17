package ui.myui;

import java.awt.Color;

import javax.swing.JTextField;
/**
 * 输入框
 * @author czw
 * @time 2015年11月17日下午10:42:28
 */
public class MyJTextField extends JTextField{
	private static final long serialVersionUID = 1L;
	/**
	 * 无缺省值
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param fontSize 字体大小
	 */
	public MyJTextField(int x, int y, int width, int height){
		this(x, y, width, height, null);
	}
	
	/**
	 * 有缺省值
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param text 缺省值
	 * @param fontSize 字体大小
	 */
	public MyJTextField(int x, int y, int width, int height, String text){
		this.setBounds(x, y, width, height);
		this.setFont(new MyFont(15));
		this.setForeground(Color.BLACK);
		this.setText(text);
		this.setVisible(true);
	}
}