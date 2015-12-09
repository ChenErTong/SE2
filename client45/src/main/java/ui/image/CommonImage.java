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
	 * 测试背景图片
	 */
	public static final ImageIcon TEST_BACKGROUND = createImageIcon("image/background1.jpg");
	/**
	 * 测试总经理功能界面图片
	 */
	public static final ImageIcon MANAGER_BACKGROUND = createImageIcon("image/background_Manager.png");
	/**
	 * 测试财务人员功能界面图片
	 */
	public static final ImageIcon FINANCE_BACKGROUND = createImageIcon("image/background_finance.png");
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
	/**
	 * 文本框选中
	 */
	private static Image TEXTFIELD_SELECTED = null;
	/**
	 * 文本框未选中
	 */
	private static Image TEXTFIELD_UNSELECTED = null;
	/**
	 * 注销登录
	 */
	private static ImageIcon WITHDRAW[]= null;
	
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
	
	public static Image getTEXTFIELD_SELECTED(){
		if(TEXTFIELD_SELECTED == null){
			TEXTFIELD_SELECTED = createImage("image/文本框选中.png");
		}
		return TEXTFIELD_SELECTED;
	}
	
	public static Image getTEXTFIELD_UNSELECTED(){
		if(TEXTFIELD_UNSELECTED == null){
			TEXTFIELD_UNSELECTED = createImage("image/文本框未选中.png");
		}
		return TEXTFIELD_UNSELECTED;
	}
	
	public static ImageIcon[] getWITHDRAW(){
		if(WITHDRAW==null){
			WITHDRAW  = createImageIcons("image/button/注销登录.png");
		}
		return WITHDRAW;
	}
}