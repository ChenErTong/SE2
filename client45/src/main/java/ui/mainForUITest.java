package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.commonui.login.Frame_Login;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.FrameManager;
import ui.specialui.sender.Frame_Sender;

public class mainForUITest {
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

//Frame_Admin adminFrame = new Frame_Admin("0");	adminFrame.setVisible(true);

//	Frame_Admin adminFrame = new Frame_Admin(id);
//adminFrame.setVisible(true);




//Frame_Finance financeFrame = new Frame_Finance("0");
//financeFrame.setVisible(true);

//Frame_Sender senderFrame = new Frame_Sender(id);
	//senderFrame.setVisible(true);
	}
}