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
}
