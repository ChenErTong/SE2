package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.specialui.inventory.Frame_Inventory;

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
	//new Frame_Courier(userID);

		
//	new Frame_Branch(userID);
			//new	Frame_Transfer(userID);
			//	new Frame_Branch("0");
		
//	new	Frame_Transfer(userID);
//	new Frame_Branch(userID);
//			new	Frame_Transfer(userID);
			//	new Frame_Branch("0");
		
//		new	Frame_Transfer(userID);

		

		new Frame_Inventory(userID);


//		MyJFrame frame = new Frame_Inventory(userID);
//		frame.repaint();
//		new Frame_Inventory(userID);


	}
}