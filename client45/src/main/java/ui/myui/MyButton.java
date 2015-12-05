package ui.myui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 图片按钮类
 * 
 * @author czw
 * @time 2015年11月15日下午4:12:14
 */
public class MyButton extends JButton {
	private static final long serialVersionUID = 1L;

	private Image image;

	/**
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 */
	public MyButton(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setVisible(true);
	}

	/**
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 */
	@SuppressWarnings("static-access")
	public MyButton(int x, int y, int width, int height, ImageIcon icon) {
		this(x, y, width, height);
		image = icon.getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), icon.getImage().SCALE_DEFAULT);
	}

	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		HashMap<Key, Object> mapH = new HashMap<Key, Object>();
		//色差
		mapH.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		//抗锯齿	
		mapH.put(RenderingHints.KEY_TEXT_ANTIALIASING,   RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		mapH.put(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
		//呈现质量开关		
		mapH.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY); 
		//抖动形状
		mapH.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);	
		g2d.setRenderingHints(mapH);
		g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 0, 0, image.getWidth(null), image.getHeight(null), null);
	}
}