package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.myui.MyJFrame;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.inventory.Frame_Inventory;
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

		String userID = "010000001";
//		new Frame_Courier("0");

		
//	new Frame_Branch(userID);
//			new	Frame_Transfer(userID);
			//	new Frame_Branch("0");
		
//		new	Frame_Transfer(userID);

		

//		new Frame_Inventory("0");


		MyJFrame frame = new Frame_Inventory(userID);
//		frame.repaint();
//		new Frame_Inventory(userID);


	}
}