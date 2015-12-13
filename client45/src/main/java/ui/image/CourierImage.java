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
	//添加货物按钮
	private static ImageIcon[] BUTTON_TIANJIAHUOWU = null;
	//删除选中货物按钮
	private static ImageIcon[] BUTTON_SHANCHUHUOWU = null;
	//清空货物按钮
	private static ImageIcon[] BUTTON_QINGKONGHUOWU = null;
	//生成收件单按钮
	private static ImageIcon[] BUTTON_SHOUJIANDAN = null;
	//时间与报价管理按钮
	private static ImageIcon[] BUTTON_JISUAN = null;
	// 订单输入导航
	private static ImageIcon[] BUTTON_DINGDAN_GUIDE = null;
	// 收件信息输入导航
	private static ImageIcon[] BUTTON_SHOUJIAN_GUIDE = null;
	// 报价和时间管理导航
	private static ImageIcon[] BUTTON_BAOJIASHIJIAN_GUIDE = null;
		
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
	
	public static ImageIcon[] getBUTTON_TIANJIAHUOWU() {
		if (BUTTON_TIANJIAHUOWU == null) {
			BUTTON_TIANJIAHUOWU = Images.createImageIcons("image/button/添加货物.png");
		}
		return BUTTON_TIANJIAHUOWU;
	}
	
	public static ImageIcon[] getBUTTON_SHANCHUHUOWU() {
		if (BUTTON_SHANCHUHUOWU == null) {
			BUTTON_SHANCHUHUOWU = Images.createImageIcons("image/button/删除选中货物.png");
		}
		return BUTTON_SHANCHUHUOWU;
	}
	
	public static ImageIcon[] getBUTTON_QINGKONGHUOWU() {
		if (BUTTON_QINGKONGHUOWU == null) {
			BUTTON_QINGKONGHUOWU = Images.createImageIcons("image/button/清空货物.png");
		}
		return BUTTON_QINGKONGHUOWU;
	}
	
	public static ImageIcon[] getBUTTON_JISUAN() {
		if (BUTTON_JISUAN == null) {
			BUTTON_JISUAN = Images.createImageIcons("image/button/计算时间与报价.png");
		}
		return BUTTON_JISUAN;
	}
	
	public static ImageIcon[] getBUTTON_SHOUJIANDAN() {
		if (BUTTON_SHOUJIANDAN == null) {
			BUTTON_SHOUJIANDAN = Images.createImageIcons("image/button/生成收件单.png");
		}
		return BUTTON_SHOUJIANDAN;
	}
	
	public static ImageIcon[] getBUTTON_DINGDAN_GUIDE() {
		if (BUTTON_DINGDAN_GUIDE == null) {
			BUTTON_DINGDAN_GUIDE = Images
					.createImageIcons("image/button/导航订单输入.png");
		}
		return BUTTON_DINGDAN_GUIDE;
	}

	public static ImageIcon[] getBUTTON_SHOUJIAN_GUIDE() {
		if (BUTTON_SHOUJIAN_GUIDE == null) {
			BUTTON_SHOUJIAN_GUIDE = Images
					.createImageIcons("image/button/导航收件信息输入.png");
		}
		return BUTTON_SHOUJIAN_GUIDE;
	}

	public static ImageIcon[] getBUTTON_BAOJIASHIJIAN_GUIDE() {
		if (BUTTON_BAOJIASHIJIAN_GUIDE == null) {
			BUTTON_BAOJIASHIJIAN_GUIDE = Images.createImageIcons("image/button/导航报价与时间管理.png");
		}
		return BUTTON_BAOJIASHIJIAN_GUIDE;
	}
}
