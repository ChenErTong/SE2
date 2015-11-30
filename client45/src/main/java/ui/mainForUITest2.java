package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.specialui.transfer_counterman.Frame_Transfer;

public class mainForUITest2 {
	public static void main(String[] args) {
		try {
			UIManager.put("RootPane.setupButtonVisible",false);
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		new Frame_Courier("0");
		
//		new Frame_Branch("0");
		
		new	Frame_Transfer("0");
		
//	new Frame_Inventory("0");
	}
}