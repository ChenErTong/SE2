package ui.myui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

/**
 * 空白文本区域
 * 打算用于显示详细信息，比如用户的详细信息，单据的详细信息等
 * @author zsq
 * @time 2015/11/17 20:51
 */
public class MyEmptyTextArea extends JTextArea{

	private static final long serialVersionUID = 1L;
	
	public MyEmptyTextArea(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);	
		this.setForeground(Color.BLACK);
		//this.setBackground(Color.BLACK);
		this.setFont(new Font("幼圆", Font.BOLD, 14));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
