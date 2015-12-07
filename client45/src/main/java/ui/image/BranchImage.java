package ui.image;

import javax.swing.ImageIcon;

public class BranchImage {
	//车辆装车管理
	private static ImageIcon[] BUTTON_ZHUANGCHE = null;
	//车辆信息管理
	private static ImageIcon[] BUTTON_CHELIANG = null;
	//司机信息管理
	private static ImageIcon[] BUTTON_SIJI = null;
	//接收派件货物
	private static ImageIcon[] BUTTON_JIESHOUPAIJIAN = null;
	//收款单建立
	private static ImageIcon[] BUTTON_SHOUKUANDAN = null;

	public static ImageIcon[] getBUTTON_ZHUANGCHE(){
		if(BUTTON_ZHUANGCHE == null){
			BUTTON_ZHUANGCHE = Images.createImageIcons("image/button/车辆装车管理.png");
		}
		return BUTTON_ZHUANGCHE;
	}

	public static ImageIcon[] getBUTTON_CHELIANG(){
		if(BUTTON_CHELIANG == null){
			BUTTON_CHELIANG = Images.createImageIcons("image/button/车辆信息管理.png");
		}
		return BUTTON_CHELIANG;
	}

	public static ImageIcon[] getBUTTON_SIJI(){
		if(BUTTON_SIJI == null){
			BUTTON_SIJI = Images.createImageIcons("image/button/司机信息管理.png");
		}
		return BUTTON_SIJI;
	}

	public static ImageIcon[] getBUTTON_JIESHOUPAIJIAN(){
		if(BUTTON_JIESHOUPAIJIAN == null){
			BUTTON_JIESHOUPAIJIAN = Images.createImageIcons("image/button/接收派件货物.png");
		}
		return BUTTON_JIESHOUPAIJIAN;
	}

	public static ImageIcon[] getBUTTON_SHOUKUANDAN(){
		if(BUTTON_SHOUKUANDAN == null){
			BUTTON_SHOUKUANDAN = Images.createImageIcons("image/button/收款单建立.png");
		}
		return BUTTON_SHOUKUANDAN;
	}
}