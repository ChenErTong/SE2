package ui.myui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

	private Image[] images;
	//0为正常状态，1为鼠标进入，2为鼠标点击
	private int condition = 0;
	
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
		images = new Image[3];
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
	public MyButton(int x, int y, int width, int height, ImageIcon[] icons) {
		this(x, y, width, height);
		for(int i = 0; i < 3; i++){
			images[i] = icons[i].getImage().getScaledInstance(this.getWidth(),
					this.getHeight(), icons[i].getImage().SCALE_DEFAULT);
		}
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				condition = 2;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				condition = 0;
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				condition = 1;
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
		g2d.drawImage(images[condition], 0, 0, this.getWidth(), this.getHeight(), 0, 0, images[0].getWidth(null), images[0].getHeight(null), null);
	}
}