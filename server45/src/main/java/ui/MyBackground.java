package ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 背景图片
 * @author czw
 * @time 2015年11月15日下午10:01:53
 */
public class MyBackground extends JLabel{
	private static final long serialVersionUID = 1L;

	public MyBackground(ImageIcon image) {
		this.setBounds(0, 0, 900, 506);
		this.setIcon(image);
		this.setVisible(true);
	}
}
