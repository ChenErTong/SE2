package ui.image;

import javax.swing.ImageIcon;

public class CourierImage {
	// 订单输入
	private static ImageIcon[] BUTTON_DINGDAN = null;
	// 收件信息输入
	private static ImageIcon[] BUTTON_SHOUJIAN = null;
	// 报价和时间管理
	private static ImageIcon[] BUTTON_BAOJIASHIJIAN = null;
	//生成订单按钮
	private static ImageIcon[] BUTTON_SHENGCHENGDINGDAN = null;
	
	public static ImageIcon[] getBUTTON_DINGDAN() {
		if (BUTTON_DINGDAN == null) {
			BUTTON_DINGDAN = Images
					.createImageIcons("image/button/订单输入.png");
		}
		return BUTTON_DINGDAN;
	}

	public static ImageIcon[] getBUTTON_SHOUJIAN() {
		if (BUTTON_SHOUJIAN == null) {
			BUTTON_SHOUJIAN = Images
					.createImageIcons("image/button/收件信息输入.png");
		}
		return BUTTON_SHOUJIAN;
	}

	public static ImageIcon[] getBUTTON_BAOJIASHIJIAN() {
		if (BUTTON_BAOJIASHIJIAN == null) {
			BUTTON_BAOJIASHIJIAN = Images.createImageIcons("image/button/报价和时间管理.png");
		}
		return BUTTON_BAOJIASHIJIAN;
	}
	
	public static ImageIcon[] getBUTTON_SHENGCHENGDINGDAN() {
		if (BUTTON_SHENGCHENGDINGDAN == null) {
			BUTTON_SHENGCHENGDINGDAN = Images.createImageIcons("image/button/生成订单.png");
		}
		return BUTTON_SHENGCHENGDINGDAN;
	}
}
