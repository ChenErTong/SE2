package ui.myui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import ui.image.CommonImage;
/**
 * 下拉框
 * @author czw
 * @time 2015年12月9日下午10:36:59
 */
public class MyJComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;

	private Image background = null;

	public MyJComboBox(int x, int y, int width, int height, String[] items) {
		this.setBounds(x, y, width, height);
		this.init();
		
		if (items != null) {
			for (int i = 0; i < items.length; i++) {
				this.addItem(items[i]);
			}
			if (items.length > 0) {
				this.setSelectedItem(items[0]);
			}
		}
		this.setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyJComboBox(DefaultComboBoxModel model) {
		super(model);
		this.init();
	}

	@SuppressWarnings("unchecked")
	private void init(){
		background = CommonImage.getCOMBOBOX_TEXT();
		this.setFont(new MyFont(15));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setUI(new MyComboboxUI());
		this.setRenderer(new MyRenderer());
		this.setOpaque(false);
		this.setMaximumRowCount(5);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		HashMap<Key, Object> mapH = new HashMap<Key, Object>();
		// 色差
		mapH.put(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		// 抗锯齿
		mapH.put(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		mapH.put(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// 呈现质量开关
		mapH.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		// 抖动形状
		mapH.put(RenderingHints.KEY_DITHERING,
				RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHints(mapH);
		
		g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), 0,
				0, background.getWidth(null), background.getHeight(null), null);
		
		//写上选择的内容
		String text = (String) this.getSelectedItem();
		if(text==null){
			g2d.setFont(new MyFont(15, true));
			g2d.setPaint(new Color(0,0,0,0.6f));
		}else{
			g2d.setFont(new MyFont(15, true));
			g2d.setPaint(new Color(0,0,0,0.6f));
			g2d.drawString(text, 10, 19);
		}
		
		this.repaint();
	}

	/**
	 * 重设选项列表中的数据
	 * 
	 * @param newItem
	 */
	public void reset(String[] newItem) {
		this.removeAllItems();
		for (int i = 0; i < newItem.length; i++) {
			this.addItem(newItem[i]);
		}
	}
}