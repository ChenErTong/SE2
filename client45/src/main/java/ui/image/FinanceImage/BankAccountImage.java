package ui.image.FinanceImage;

import javax.swing.ImageIcon;

import ui.image.Images;

public class BankAccountImage {
	//添加
	private static ImageIcon[] BUTTON_ADD = null;
	//删除
	private static ImageIcon[] BUTTON_DELETE = null;
	//修改
	private static ImageIcon[] BUTTON_MODIFY = null;
	//查看
	private static ImageIcon[] BUTTON_CONFIRM = null;
	
	public static ImageIcon[] getBUTTON_ADD(){
		if(BUTTON_ADD == null){
			BUTTON_ADD= Images.createImageIcons("image/button/确认添加.png");
		}
		return BUTTON_ADD;
	}
	
	public static ImageIcon[] getBUTTON_DELETE(){
		if(BUTTON_DELETE == null){
			BUTTON_DELETE = Images.createImageIcons("image/button/删除账户.png");
		}
		return BUTTON_DELETE;
	}
	
	public static ImageIcon[] getBUTTON_MODIFY(){
		if(BUTTON_MODIFY == null){
			BUTTON_MODIFY = Images.createImageIcons("image/button/修改账户.png");
		}
		return BUTTON_MODIFY;
	}
	
	public static ImageIcon[] getBUTTON_CONFIRM(){
		if(BUTTON_CONFIRM == null){
			BUTTON_CONFIRM = Images.createImageIcons("image/button/确认修改.png");
		}
		return BUTTON_CONFIRM;
	}
}
