package ui.myui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import ui.image.CommonImage;

/**
 * 单选按钮
 * @author zsq
 * @version 2015/11/10 14:10
 */
public class MyJRadioButton extends JRadioButton {
	private static final long serialVersionUID = 1L;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param text 文本内容
	 */
	public MyJRadioButton(int x, int y, int width, int height, String text){
		this.setFont(new MyFont(15, true));
		this.setBounds(x, y, width, height);
		this.setForeground(new Color(0,0,0,0.6f));
		this.setContentAreaFilled(false);
		this.setSelected(false);
		this.setText(text);
		this.setIcon(CommonImage.getRADIOBUTTON_UNSELECTED());
		this.setSelectedIcon(CommonImage.getRADIOBUTTON_SELECTED());
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setVisible(true);
	}
}