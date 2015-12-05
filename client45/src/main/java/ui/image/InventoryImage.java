package ui.image;

import javax.swing.ImageIcon;

public class InventoryImage {
	//库存查看
	private static ImageIcon[] BUTTON_CHAKAN = null;
	//库存盘点
	private static ImageIcon[] BUTTON_PANDIAN = null;
	//库存分区调整
	private static ImageIcon[] BUTTON_FENQUTIAOZHENG = null;
	//入库
	private static ImageIcon[] BUTTON_RUKU = null;
	//出库
	private static ImageIcon[] BUTTON_CHUKU = null;
	
	public static ImageIcon[] getBUTTON_CHAKAN(){
		if(BUTTON_CHAKAN == null){
			BUTTON_CHAKAN = Images.createImageIcons("image/return_button.png");
		}
		return BUTTON_CHAKAN;
	}
	
	public static ImageIcon[] getBUTTON_PANDIAN(){
		if(BUTTON_PANDIAN == null){
			BUTTON_PANDIAN = Images.createImageIcons("image/return_button.png");
		}
		return BUTTON_PANDIAN;
	}
	
	public static ImageIcon[] getBUTTON_FENQUTIAOZHENG(){
		if(BUTTON_FENQUTIAOZHENG == null){
			BUTTON_FENQUTIAOZHENG = Images.createImageIcons("image/return_button.png");
		}
		return BUTTON_FENQUTIAOZHENG;
	}
	
	public static ImageIcon[] getBUTTON_RUKU(){
		if(BUTTON_RUKU == null){
			BUTTON_RUKU = Images.createImageIcons("image/return_button.png");
		}
		return BUTTON_RUKU;
	}
	
	public static ImageIcon[] getBUTTON_CHUKU(){
		if(BUTTON_CHUKU == null){
			BUTTON_CHUKU = Images.createImageIcons("image/return_button.png");
		}
		return BUTTON_CHUKU;
	}
}