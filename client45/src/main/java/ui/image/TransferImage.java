package ui.image;

import javax.swing.ImageIcon;

public class TransferImage {
	// 汽车装运管理
	private static ImageIcon[] BUTTON_QICHE = null;
	// 火车装运管理
	private static ImageIcon[] BUTTON_HUOCHE = null;
	// 飞机装运管理
	private static ImageIcon[] BUTTON_FEIJI = null;
	// 中转接收管理
	private static ImageIcon[] BUTTON_ZHONGZHUAN = null;
	//确认装运信息按钮
	private static ImageIcon[] BUTTON_ZHUANGYUNXINXI = null;
	//生成装车单按钮
	private static ImageIcon[] BUTTON_ZHUANGCHEDAN = null;
	//生成到达单
	private static ImageIcon[] BUTTON_DAODADAN = null;
	
	public static ImageIcon[] getBUTTON_QICHE() {
		if (BUTTON_QICHE == null) {
			BUTTON_QICHE = Images.createImageIcons("image/button/汽车装运管理.png");
		}
		return BUTTON_QICHE;
	}

	public static ImageIcon[] getBUTTON_HUOCHE() {
		if (BUTTON_HUOCHE == null) {
			BUTTON_HUOCHE = Images.createImageIcons("image/button/火车装运管理.png");
		}
		return BUTTON_HUOCHE;
	}

	public static ImageIcon[] getBUTTON_FEIJI() {
		if (BUTTON_FEIJI == null) {
			BUTTON_FEIJI = Images.createImageIcons("image/button/飞机装运管理.png");
		}
		return BUTTON_FEIJI;
	}

	public static ImageIcon[] getBUTTON_ZHONGZHUAN() {
		if (BUTTON_ZHONGZHUAN == null) {
			BUTTON_ZHONGZHUAN = Images.createImageIcons("image/button/中转接收管理.png");
		}
		return BUTTON_ZHONGZHUAN;
	}
	
	public static ImageIcon[] getBUTTON_ZHUANGYUNXINXI() {
		if (BUTTON_ZHUANGYUNXINXI == null) {
			BUTTON_ZHUANGYUNXINXI = Images.createImageIcons("image/button/确认装运信息.png");
		}
		return BUTTON_ZHUANGYUNXINXI;
	}
	
	public static ImageIcon[] getBUTTON_ZHUANGCHEDAN() {
		if (BUTTON_ZHUANGCHEDAN == null) {
			BUTTON_ZHUANGCHEDAN = Images.createImageIcons("image/button/生成装车单.png");
		}
		return BUTTON_ZHUANGCHEDAN;
	}
	
	public static ImageIcon[] getBUTTON_DAODADAN() {
		if (BUTTON_DAODADAN == null) {
			BUTTON_DAODADAN = Images.createImageIcons("image/button/生成到达单.png");
		}
		return BUTTON_DAODADAN;
	}
}
