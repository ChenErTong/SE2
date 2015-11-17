package ui;

import ui.commonui.login.Frame_Login;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.FrameManager;
import ui.specialui.sender.Frame_Sender;

public class mainForUITest {

	public static void main(String[] args) {
		//Frame_Login loginFrame = new Frame_Login();
		//loginFrame.setVisible(true);
		
		//Frame_Courier courierFrame = new Frame_Courier();
		//courierFrame.setVisible(true);
		
		//FrameManager managerFrame = new FrameManager();
		//managerFrame.setVisible(true);
		
		
		//Frame_Admin adminFrame = new Frame_Admin();
		//adminFrame.setVisible(true);
		
		//Frame_Finance financeFrame = new Frame_Finance();
		//financeFrame.setVisible(true);
		
		Frame_Sender senderFrame = new Frame_Sender();
		senderFrame.setVisible(true);
		
	}
}
