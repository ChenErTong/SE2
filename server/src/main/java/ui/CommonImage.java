package ui;

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
	 * 背景图片
	 */
	public static final ImageIcon BACKGROUND = createImageIcon("image/background1.png");
	/**
	 * 半透明
	 */
	public static final Image TEST_HALFOPAQUE = createImage("image/半透明.png");
	/**
	 * LOGO
	 */
	private static ImageIcon LOGO = null;

	/**
	 * 下标
	 */
	private static ImageIcon SUBSCRIPT = null;
	/**
	 * 开启服务
	 * @return
	 */
	private static ImageIcon[] OPEN = null;
	/**
	 * 关闭服务
	 * @return
	 */
	private static ImageIcon[] CLOSE = null;
	/**
	 * 刷新
	 * @return
	 */
	private static ImageIcon[] REFRESH = null;
	
	/**
	 * 确认按钮
	 */
	private static ImageIcon[] BUTTON_CONFIRM = null;
	/**
	 * 取消按钮
	 */
	private static ImageIcon[] BUTTON_CANCEL = null;
	

	public static ImageIcon[] getBUTTON_OPEN(){
		if(OPEN == null){
			OPEN = createImageIcons("image/button/open.png");
		}
		return OPEN;
	}
	
	public static ImageIcon[] getCLOSE(){
		if(CLOSE == null){
			CLOSE = createImageIcons("image/button/close.png");
		}
		return CLOSE;
	}
	
	public static ImageIcon[] getBUTTON_REFRESH(){
		if(REFRESH == null){
			REFRESH = createImageIcons("image/button/refresh.png");
		}
		return REFRESH;
	}
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
	
	
	
	public static ImageIcon getSUBSCRIPT(){
		if(SUBSCRIPT == null){
			SUBSCRIPT = createImageIcon("image/下标.png");
		}
		return SUBSCRIPT;
	}
	
	public static ImageIcon[] getBUTTON_CONFIRM(){
		if(BUTTON_CONFIRM == null){
			BUTTON_CONFIRM = createImageIcons("image/确认.png");
		}
		return BUTTON_CONFIRM;
	}
	
	public static ImageIcon[] getBUTTON_CANCEL(){
		if(BUTTON_CANCEL == null){
			BUTTON_CANCEL = createImageIcons("image/取消.png");
		}
		return BUTTON_CANCEL;
	}
	

}