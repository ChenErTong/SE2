package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.commonui.login.Frame_Login;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.inventory.Frame_Inventory;
import ui.specialui.manager.FrameManager;

public class mainForUITest3 {
	static String id = "123";
	public static void main(String[] args) {
		try {
			UIManager.put("RootPane.setupButtonVisible",false);
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
	


	
	FrameManager managerFrame = new FrameManager(id);
  managerFrame.setVisible(true);

//	 FrameManager managerFrame = new FrameManager(id);
//  managerFrame.setVisible(true);


//	Frame_Courier courierFrame = new Frame_Courier();
	//	courierFrame.setVisible(true);
//
//Frame_Admin adminFrame = new Frame_Admin("0");	adminFrame.setVisible(true);
	Frame_Admin adminFrame = new Frame_Admin(id);
adminFrame.setVisible(true);


//Frame_Finance financeFrame = new Frame_Finance("0");
//financeFrame.setVisible(true);

//Frame_Sender senderFrame = new Frame_Sender(id);
//senderFrame.setVisible(true);
  
//	String userID = "010015001";
//	new Frame_Login(userID);
//new Frame_Inventory(userID);
//new Frame_Transfer(userID);
//new Frame_Courier(userID);
//new Frame_Branch(userID);
	}
}