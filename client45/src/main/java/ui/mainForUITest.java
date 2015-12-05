package ui;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.commonui.login.Frame_Login;

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
	
Frame_Login loginFrame = new Frame_Login(id);
	loginFrame.setVisible(true);

//	Frame_Courier courierFrame = new Frame_Courier();
	//	courierFrame.setVisible(true);

	
	//FrameManager managerFrame = new FrameManager(id);
	  // managerFrame.setVisible(true);
		
	//Frame_Branch branchFrame = new Frame_Branch();
		//branchFrame.setVisible(true);
		
//	Frame_Finance financeFrame = new Frame_Finance(id);
//	financeFrame.setVisible(true);

//		Frame_Admin adminFrame = new Frame_Admin();	adminFrame.setVisible(true);


//	Frame_Admin adminFrame = new Frame_Admin(id);
//adminFrame.setVisible(true);



	//Frame_Finance financeFrame = new Frame_Finance();
	//financeFrame.setVisible(true);

//	Frame_Finance financeFrame = new Frame_Finance();
//		financeFrame.setVisible(true);


//		Frame_Finance financeFrame = new Frame_Finance();
//		financeFrame.setVisible(true);

//Frame_Sender senderFrame = new Frame_Sender(id);
	//	senderFrame.setVisible(true);
	}
}