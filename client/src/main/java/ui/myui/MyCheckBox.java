package ui.myui;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;

/**
 * 单选框组件
 * @author zsq
 * @time 2015/11/18 20:00
 *
 */
public class MyCheckBox extends JCheckBox{

	private static final long serialVersionUID = 1L;
	/**
	 * @param x 宽度
	 * @param y 高度
	 */
	public MyCheckBox(int x,int y){
		this.setBounds(x, y, 30, 30);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setVisible(true);
	}
}
