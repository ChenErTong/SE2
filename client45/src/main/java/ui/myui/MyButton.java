package ui.myui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 图片按钮类
 * @author czw
 * @time 2015年11月15日下午4:12:14
 */
public class MyButton extends JButton{
	private static final long serialVersionUID = 1L;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 */
	public MyButton(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setVisible(true);
	}
	public void setMyIcon(ImageIcon icon){
		@SuppressWarnings("static-access")
		Image image = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), icon.getImage().SCALE_DEFAULT);
		this.setIcon(new ImageIcon(image));
	}
}
