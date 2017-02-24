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
	 * 背景图片
	 */
	public static final ImageIcon BACKGROUND = createImageIcon("image/background1.jpg");
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
	/**
	 * 单选框选中
	 */
	private static ImageIcon RADIOBUTTON_SELECTED = null;
	/**
	 * 单选框未选中
	 */
	private static ImageIcon RADIOBUTTON_UNSELECTED = null;
	/**
	 * 下拉框文本
	 */
	private static Image COMBOBOX_TEXT = null;
	/**
	 * undo
	 */
	private static ImageIcon[] BUTTON_BACKOUT = null;
	/**
	 * 下标
	 */
	private static ImageIcon SUBSCRIPT = null;
	/**
	 * redo
	 */
	private static ImageIcon[] BUTTON_REDO= null;
	/**
	 * 确定框背景
	 */
	private static Image CONFIRM_BACKGROUND = null;
	/**
	 * 确认按钮
	 */
	private static ImageIcon[] BUTTON_CONFIRM = null;
	/**
	 * 取消按钮
	 */
	private static ImageIcon[] BUTTON_CANCEL = null;
	
	public static ImageIcon[] getBUTTON_REDO(){
		if(BUTTON_REDO == null){
			BUTTON_REDO = createImageIcons("image/button/redo.png");
		}
		return BUTTON_REDO;
	}
	public static ImageIcon[] getBUTTON_BACKOUT(){
		if(BUTTON_BACKOUT == null){
			BUTTON_BACKOUT = createImageIcons("image/button/undo.png");
		}
		return BUTTON_BACKOUT;
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
	
	public static ImageIcon  getRADIOBUTTON_SELECTED(){
		if(RADIOBUTTON_SELECTED == null){
			RADIOBUTTON_SELECTED = createImageIcon("image/单选框选中.png");
		}
		return RADIOBUTTON_SELECTED;
	}
	
	public static ImageIcon  getRADIOBUTTON_UNSELECTED(){
		if(RADIOBUTTON_UNSELECTED == null){
			RADIOBUTTON_UNSELECTED = createImageIcon("image/单选框未选中.png");
		}
		return RADIOBUTTON_UNSELECTED;
	}
	
	public static Image  getCOMBOBOX_TEXT(){
		if(COMBOBOX_TEXT == null){
			COMBOBOX_TEXT = createImage("image/下拉框文本.png");
		}
		return COMBOBOX_TEXT;
	}
	
	public static ImageIcon getSUBSCRIPT(){
		if(SUBSCRIPT == null){
			SUBSCRIPT = createImageIcon("image/下标.png");
		}
		return SUBSCRIPT;
	}
	
	public static Image getCONFIRM_BACKGROUND(){
		if(CONFIRM_BACKGROUND == null){
			CONFIRM_BACKGROUND = createImage("image/确定框.png");
		}
		return CONFIRM_BACKGROUND;
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