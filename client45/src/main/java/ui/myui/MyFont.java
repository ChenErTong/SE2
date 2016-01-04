package ui.myui;

import java.awt.Font;
/**
 * 统一字体
 * @author czw
 * @time 2015年11月16日下午10:22:17
 */
public class MyFont extends Font {
	private static final long serialVersionUID = 1L;
	/**
	 * 细体
	 * @param size
	 */
	public MyFont(int size){
		super("幼圆", Font.PLAIN, size);
	}
	/**
	 * 粗体
	 * @param size
	 * @param isBold
	 */
	public MyFont(int size, boolean isBold){
		super("幼圆", Font.BOLD, size);
	}
}