package ui.image;

import javax.swing.ImageIcon;

public class BranchImage {
	// 车辆装车管理
	private static ImageIcon[] BUTTON_ZHUANGCHE = null;
	// 车辆信息管理
	private static ImageIcon[] BUTTON_CHELIANG = null;
	// 司机信息管理
	private static ImageIcon[] BUTTON_SIJI = null;
	// 接收派件货物
	private static ImageIcon[] BUTTON_JIESHOUPAIJIAN = null;
	// 收款单建立
	private static ImageIcon[] BUTTON_SHOUKUANDAN = null;
	// 计算运费按钮
	private static ImageIcon[] BUTTON_JISUAN = null;
	// 生成收款单
	private static ImageIcon[] BUTTON_SKD = null;
	// 生成派件单
	private static ImageIcon[] BUTTON_PAIJIANDAN = null;
	// 添加车辆垂直
	private static ImageIcon[] BUTTON_TIANJIACHELIANG_VERTICAL = null;
	// 修改车辆垂直
	private static ImageIcon[] BUTTON_XIUGAICHELIANG_VERTICAL = null;
	// 查询车辆垂直
	private static ImageIcon[] BUTTON_CHAXUNCHELIANG_VERTICAL = null;
	// 删除车辆垂直
	private static ImageIcon[] BUTTON_SHANCHUCHELIANG_VERTICAL = null;
	// 添加车辆水平
	private static ImageIcon[] BUTTON_TIANJIACHELIANG_HORIZONTAL = null;
	// 修改车辆水平
	private static ImageIcon[] BUTTON_XIUGAICHELIANG_HORIZONTAL = null;
	// 删除车辆水平
	private static ImageIcon[] BUTTON_SHANCHUCHELIANG_HORIZONTAL = null;
	// 添加司机垂直
	private static ImageIcon[] BUTTON_TIANJIASIJI_VERTICAL = null;
	// 修改司机垂直
	private static ImageIcon[] BUTTON_XIUGAISIJI_VERTICAL = null;
	// 查询司机垂直
	private static ImageIcon[] BUTTON_CHAXUNSIJI_VERTICAL = null;
	// 删除司机垂直
	private static ImageIcon[] BUTTON_SHANCHUSIJI_VERTICAL = null;
	// 添加司机水平
	private static ImageIcon[] BUTTON_TIANJIASIJI_HORIZONTAL = null;
	// 修改司机水平
	private static ImageIcon[] BUTTON_XIUGAISIJI_HORIZONTAL = null;
	// 删除司机水平
	private static ImageIcon[] BUTTON_SHANCHUSIJI_HORIZONTAL = null;
	//添加按钮
	private static ImageIcon[] BUTTON_TIANJIA = null;
	// 车辆装车管理导航
	private static ImageIcon[] BUTTON_ZHUANGCHE_GUIDE = null;
	// 车辆信息管理导航
	private static ImageIcon[] BUTTON_CHELIANG_GUIDE = null;
	// 司机信息管理导航
	private static ImageIcon[] BUTTON_SIJI_GUIDE = null;
	// 接收派件货物导航
	private static ImageIcon[] BUTTON_JIESHOUPAIJIAN_GUIDE = null;
	// 收款单建立导航
	private static ImageIcon[] BUTTON_SHOUKUANDAN_GUIDE = null;
		
	public static ImageIcon[] getBUTTON_ZHUANGCHE() {
		if (BUTTON_ZHUANGCHE == null) {
			BUTTON_ZHUANGCHE = Images
					.createImageIcons("image/button/车辆装车管理.png");
		}
		return BUTTON_ZHUANGCHE;
	}

	public static ImageIcon[] getBUTTON_CHELIANG() {
		if (BUTTON_CHELIANG == null) {
			BUTTON_CHELIANG = Images
					.createImageIcons("image/button/车辆信息管理.png");
		}
		return BUTTON_CHELIANG;
	}

	public static ImageIcon[] getBUTTON_SIJI() {
		if (BUTTON_SIJI == null) {
			BUTTON_SIJI = Images.createImageIcons("image/button/司机信息管理.png");
		}
		return BUTTON_SIJI;
	}

	public static ImageIcon[] getBUTTON_JIESHOUPAIJIAN() {
		if (BUTTON_JIESHOUPAIJIAN == null) {
			BUTTON_JIESHOUPAIJIAN = Images
					.createImageIcons("image/button/接收派件货物.png");
		}
		return BUTTON_JIESHOUPAIJIAN;
	}

	public static ImageIcon[] getBUTTON_SHOUKUANDAN() {
		if (BUTTON_SHOUKUANDAN == null) {
			BUTTON_SHOUKUANDAN = Images
					.createImageIcons("image/button/收款单建立.png");
		}
		return BUTTON_SHOUKUANDAN;
	}

	public static ImageIcon[] getBUTTON_JISUAN() {
		if (BUTTON_JISUAN == null) {
			BUTTON_JISUAN = Images.createImageIcons("image/button/计算运费.png");
		}
		return BUTTON_JISUAN;
	}

	public static ImageIcon[] getBUTTON_SKD() {
		if (BUTTON_SKD == null) {
			BUTTON_SKD = Images.createImageIcons("image/button/生成收款单.png");
		}
		return BUTTON_SKD;
	}

	public static ImageIcon[] getBUTTON_PAIJIANDAN() {
		if (BUTTON_PAIJIANDAN == null) {
			BUTTON_PAIJIANDAN = Images
					.createImageIcons("image/button/生成派件单.png");
		}
		return BUTTON_PAIJIANDAN;
	}

	public static ImageIcon[] getBUTTON_TIANJIACHELIANG_VERTICAL() {
		if (BUTTON_TIANJIACHELIANG_VERTICAL == null) {
			BUTTON_TIANJIACHELIANG_VERTICAL = Images
					.createImageIcons("image/button/添加车辆垂直.png");
		}
		return BUTTON_TIANJIACHELIANG_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_XIUGAICHELIANG_VERTICAL() {
		if (BUTTON_XIUGAICHELIANG_VERTICAL == null) {
			BUTTON_XIUGAICHELIANG_VERTICAL = Images
					.createImageIcons("image/button/修改车辆垂直.png");
		}
		return BUTTON_XIUGAICHELIANG_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_CHAXUNCHELIANG_VERTICAL() {
		if (BUTTON_CHAXUNCHELIANG_VERTICAL == null) {
			BUTTON_CHAXUNCHELIANG_VERTICAL = Images
					.createImageIcons("image/button/查询车辆垂直.png");
		}
		return BUTTON_CHAXUNCHELIANG_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_SHANCHUCHELIANG_VERTICAL() {
		if (BUTTON_SHANCHUCHELIANG_VERTICAL == null) {
			BUTTON_SHANCHUCHELIANG_VERTICAL = Images
					.createImageIcons("image/button/删除车辆垂直.png");
		}
		return BUTTON_SHANCHUCHELIANG_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_TIANJIACHELIANG_HORIZONTAL() {
		if (BUTTON_TIANJIACHELIANG_HORIZONTAL == null) {
			BUTTON_TIANJIACHELIANG_HORIZONTAL = Images
					.createImageIcons("image/button/添加车辆水平.png");
		}
		return BUTTON_TIANJIACHELIANG_HORIZONTAL;
	}

	public static ImageIcon[] getBUTTON_XIUGAICHELIANG_HORIZONTAL() {
		if (BUTTON_XIUGAICHELIANG_HORIZONTAL == null) {
			BUTTON_XIUGAICHELIANG_HORIZONTAL = Images
					.createImageIcons("image/button/修改车辆水平.png");
		}
		return BUTTON_XIUGAICHELIANG_HORIZONTAL;
	}

	public static ImageIcon[] getBUTTON_SHANCHUCHELIANG_HORIZONTAL() {
		if (BUTTON_SHANCHUCHELIANG_HORIZONTAL == null) {
			BUTTON_SHANCHUCHELIANG_HORIZONTAL = Images
					.createImageIcons("image/button/删除车辆水平.png");
		}
		return BUTTON_SHANCHUCHELIANG_HORIZONTAL;
	}

	public static ImageIcon[] getBUTTON_TIANJIASIJI_VERTICAL() {
		if (BUTTON_TIANJIASIJI_VERTICAL == null) {
			BUTTON_TIANJIASIJI_VERTICAL = Images
					.createImageIcons("image/button/添加司机垂直.png");
		}
		return BUTTON_TIANJIASIJI_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_XIUGAISIJI_VERTICAL() {
		if (BUTTON_XIUGAISIJI_VERTICAL == null) {
			BUTTON_XIUGAISIJI_VERTICAL = Images
					.createImageIcons("image/button/修改司机垂直.png");
		}
		return BUTTON_XIUGAISIJI_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_CHAXUNSIJI_VERTICAL() {
		if (BUTTON_CHAXUNSIJI_VERTICAL == null) {
			BUTTON_CHAXUNSIJI_VERTICAL = Images
					.createImageIcons("image/button/查询司机垂直.png");
		}
		return BUTTON_CHAXUNSIJI_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_SHANCHUSIJI_VERTICAL() {
		if (BUTTON_SHANCHUSIJI_VERTICAL == null) {
			BUTTON_SHANCHUSIJI_VERTICAL = Images
					.createImageIcons("image/button/删除司机垂直.png");
		}
		return BUTTON_SHANCHUSIJI_VERTICAL;
	}

	public static ImageIcon[] getBUTTON_TIANJIASIJI_HORIZONTAL() {
		if (BUTTON_TIANJIASIJI_HORIZONTAL == null) {
			BUTTON_TIANJIASIJI_HORIZONTAL = Images
					.createImageIcons("image/button/添加司机水平.png");
		}
		return BUTTON_TIANJIASIJI_HORIZONTAL;
	}

	public static ImageIcon[] getBUTTON_XIUGAISIJI_HORIZONTAL() {
		if (BUTTON_XIUGAISIJI_HORIZONTAL == null) {
			BUTTON_XIUGAISIJI_HORIZONTAL = Images
					.createImageIcons("image/button/修改司机水平.png");
		}
		return BUTTON_XIUGAISIJI_HORIZONTAL;
	}

	public static ImageIcon[] getBUTTON_SHANCHUSIJI_HORIZONTAL() {
		if (BUTTON_SHANCHUSIJI_HORIZONTAL == null) {
			BUTTON_SHANCHUSIJI_HORIZONTAL = Images
					.createImageIcons("image/button/删除司机水平.png");
		}
		return BUTTON_SHANCHUSIJI_HORIZONTAL;
	}
	
	public static ImageIcon[] getBUTTON_TIANJIA() {
		if (BUTTON_TIANJIA == null) {
			BUTTON_TIANJIA = Images
					.createImageIcons("image/button/添加.png");
		}
		return BUTTON_TIANJIA;
	}
	
	public static ImageIcon[] getBUTTON_ZHUANGCHE_GUIDE() {
		if (BUTTON_ZHUANGCHE_GUIDE == null) {
			BUTTON_ZHUANGCHE_GUIDE = Images
					.createImageIcons("image/button/导航车辆装车管理.png");
		}
		return BUTTON_ZHUANGCHE_GUIDE;
	}

	public static ImageIcon[] getBUTTON_CHELIANG_GUIDE() {
		if (BUTTON_CHELIANG_GUIDE == null) {
			BUTTON_CHELIANG_GUIDE = Images
					.createImageIcons("image/button/导航车辆信息管理.png");
		}
		return BUTTON_CHELIANG_GUIDE;
	}

	public static ImageIcon[] getBUTTON_SIJI_GUIDE() {
		if (BUTTON_SIJI_GUIDE == null) {
			BUTTON_SIJI_GUIDE = Images.createImageIcons("image/button/导航司机信息管理.png");
		}
		return BUTTON_SIJI_GUIDE;
	}

	public static ImageIcon[] getBUTTON_JIESHOUPAIJIAN_GUIDE() {
		if (BUTTON_JIESHOUPAIJIAN_GUIDE == null) {
			BUTTON_JIESHOUPAIJIAN_GUIDE = Images
					.createImageIcons("image/button/导航接收派件货物.png");
		}
		return BUTTON_JIESHOUPAIJIAN_GUIDE;
	}

	public static ImageIcon[] getBUTTON_SHOUKUANDAN_GUIDE() {
		if (BUTTON_SHOUKUANDAN_GUIDE == null) {
			BUTTON_SHOUKUANDAN_GUIDE = Images
					.createImageIcons("image/button/导航收款单建立.png");
		}
		return BUTTON_SHOUKUANDAN_GUIDE;
	}
}