package ui.myui;

import java.awt.Color;
import javax.swing.JButton;
/**
 * 文字按钮类
 * @author czw
 * @time 2015年11月16日下午10:59:42
 */
public class MyJButton extends JButton {
	private static final long serialVersionUID = 1L;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param text 文本
	 * @param fontSize 字体大小
	 */
	public MyJButton(int x, int y, int width, int height, String text, int fontSize){
		this(x, y, width, height, text, fontSize, Color.BLACK);
	}
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param text 文本
	 * @param fontSize 字体大小
	 * @param color 字体颜色
	 */
	public MyJButton(int x, int y, int width, int height, String text, int fontSize, Color color){
		this.setFont(new MyFont(fontSize));
		this.setBounds(x, y, width, height);
		this.setForeground(color);
		this.setText(text);
		this.setVisible(true);
	}
}