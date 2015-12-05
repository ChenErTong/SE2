package ui.myui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
/**
 * 密码输入文本框
 * @author zsq
 * @version 2015/12/04 14:10
 */
public class MyPasswordField extends JPasswordField {

	private static final long serialVersionUID = 1L;

	public MyPasswordField(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		//this.setOpaque(false);
		this.setForeground(Color.BLACK);
		this.setVisible(true);
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
