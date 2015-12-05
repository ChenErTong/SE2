package ui.image;

import java.awt.Image;
import javax.swing.ImageIcon;

public class CommonImage extends Images{
	/**
	 * 关闭按钮图标
	 */
	private static ImageIcon[] BUTTON_CLOSE = null;
	/**
	 * 最小化按钮图标
	 */
	private static ImageIcon[] BUTTON_MINIMUMIZE = null;
	/**
	 * 最小化按钮图标
	 */
	public static ImageIcon[] BUTTON_RETURN = null;
	/**
	 * TODO
	 * 测试背景图片
	 */
	public static final ImageIcon TEST_BACKGROUND = createImageIcon("image/background_test2.jpg");
	/**
	 * 半透明
	 */
	public static final Image TEST_HALFOPAQUE = createImage("image/半透明.png");
	/**
	 * LOGO
	 */
	private static ImageIcon LOGO = null;
	/**
	 * 主界面文字
	 */
	private static ImageIcon TITLE = null;
	
	public static ImageIcon[] getBUTTON_CLOSE(){
		if(BUTTON_CLOSE == null){
			BUTTON_CLOSE = createImageIcons("image/button/关闭.png");
		}
		return BUTTON_CLOSE;
	}
	
	public static ImageIcon[] getBUTTON_MINIMUMIZE(){
		if(BUTTON_MINIMUMIZE == null){
			BUTTON_MINIMUMIZE = createImageIcons("image/button/最小化.png");
		}
		return BUTTON_MINIMUMIZE;
	}
	
	public static ImageIcon[] getBUTTON_RETURN(){
		if(BUTTON_RETURN == null){
			BUTTON_RETURN = createImageIcons("image/button/返回.png");
		}
		return BUTTON_RETURN;
	}
	
	public static ImageIcon getLOGO(){
		if(LOGO == null){
			LOGO = createImageIcon("image/logo.png");
		}
		return LOGO;
	}
	
	public static ImageIcon getTITLE(String title){
		TITLE = createImageIcon("image/" + title + ".png");
		return TITLE;
	}
}