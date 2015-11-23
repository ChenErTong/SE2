package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.specialui.admin.Frame_Admin;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.courier.Frame_Courier;

public class mainForUITest2 {
	public static void main(String[] args) {
		try {
			UIManager.put("RootPane.setupButtonVisible",false);
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Frame_Courier();
		
//		new Frame_Branch();
	}
}
