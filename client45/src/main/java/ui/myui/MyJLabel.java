package ui.myui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
/**
 * 文本类
 * @author czw
 * @time 2015年11月16日下午11:09:03
 */
public class MyJLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	public MyJLabel(int x, int y, int width, int height, String text, int fontSize, boolean isBold){
		this.setBounds(x, y, width, height);
		this.setBorder(BorderFactory.createEmptyBorder());
		if(isBold){
			this.setFont(new MyFont(fontSize, true));
		}else{
			this.setFont(new MyFont(fontSize));
		}	
		this.setForeground(new Color(0,0,0,0.6f));
		this.setText(text);
		this.setVisible(true);
	}
}