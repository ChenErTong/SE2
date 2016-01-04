package ui.myui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import ui.image.CommonImage;
/**
 * 密码输入文本框
 * @author zsq
 * @version 2015/12/04 14:10
 */
public class MyPasswordField extends JPasswordField {

	private static final long serialVersionUID = 1L;

	private Image background = null;
	
	public MyPasswordField(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setForeground(Color.WHITE);
		this.setVisible(true);
		this.setBorder(BorderFactory.createEmptyBorder());
		
		//调整文本起始位置
		this.setPreferredSize(new Dimension(200, 25));
		Border empty = new EmptyBorder(0, 14, 0, 0);
		CompoundBorder border = new CompoundBorder(this.getBorder(), empty);
		this.setBorder(border);
		
		Image selected = CommonImage.getTEXTFIELD_SELECTED();
		Image unselected = CommonImage.getTEXTFIELD_UNSELECTED();
		background = unselected;
		this.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				background = unselected;
				MyPasswordField.this.repaint();
			}
			public void focusGained(FocusEvent e) {
				background = selected;
				MyPasswordField.this.repaint();
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
		g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), 0, 0, background.getWidth(null), background.getHeight(null), null);
		super.paintComponent(g);
		this.repaint();
	}
}
