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
	
	/**
	 * 可自定义是否可编辑
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param editable 可修改
	 */
	public MyEmptyTextArea(int x, int y, int width, int height, boolean editable){
		this(x, y, width, height);
		this.setEnabled(editable);
	}
	
	/**
	 * 默认不可编辑
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 */
	public MyEmptyTextArea(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setForeground(Color.BLACK);
		this.setBackground(new Color(255, 255, 255, 75));
		this.setFocusable(true);
		this.setFont(new Font("幼圆", Font.BOLD, 14));
		this.setEnabled(false);
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}