package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import ui.commonui.login.Frame_Login;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.FrameManager;
import ui.specialui.sender.Frame_Sender;

public class mainForUITest {

	public static void main(String[] args) {
		try {
			UIManager.put("RootPane.setupButtonVisible",false);
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//	Frame_Login loginFrame = new Frame_Login();
	//loginFrame.setVisible(true);

//	Frame_Courier courierFrame = new Frame_Courier();
	//	courierFrame.setVisible(true);

	
FrameManager managerFrame = new FrameManager();
managerFrame.setVisible(true);
		
//	Frame_Branch branchFrame = new Frame_Branch();
	//	branchFrame.setVisible(true);
		

	//	Frame_Admin adminFrame = new Frame_Admin();
	//	adminFrame.setVisible(true);

//		Frame_Admin adminFrame = new Frame_Admin();
//		adminFrame.setVisible(true);


	//Frame_Finance financeFrame = new Frame_Finance();
//		financeFrame.setVisible(true);

//		Frame_Finance financeFrame = new Frame_Finance();
//		financeFrame.setVisible(true);

//Frame_Sender senderFrame = new Frame_Sender();
	//	senderFrame.setVisible(true);
	}
}