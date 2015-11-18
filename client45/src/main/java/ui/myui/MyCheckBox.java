package ui.myui;

import javax.swing.JCheckBox;

/**
 * 单选框组件
 * @author zsq
 * @time 2015/11/18 20:00
 *
 */
public class MyCheckBox extends JCheckBox{

	private static final long serialVersionUID = 1L;
	
	public MyCheckBox(int x,int y){
		this.setBounds(x, y, 30, 30);
		this.setOpaque(false);
		
		this.setVisible(true);
	}
}
