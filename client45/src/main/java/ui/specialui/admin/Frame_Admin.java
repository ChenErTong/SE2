
package ui.specialui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;

public class Frame_Admin extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private MyJPanel subPanel;
	private Panel_Admin_Total totalPanel;
	public Frame_Admin(String userID){
		super(userID);
		totalPanel = new Panel_Admin_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("AddUser")){
			//if(this.addUser()){
				//totalPanel.refresh();
			//}
			
		}else if(e.getActionCommand().equals("DeleteUser")){
			//TODO
			//if(this.deleteUser()){
				//totalPanel.refresh();
			//}
	
		}else if(e.getActionCommand().equals("ModifyUserInformation")){
			//TODO
		//	if(this.modifyUserInfo()){
			//	totalPanel.refresh();
		//	}
			
		}else if(e.getActionCommand().equals("ViewUserInfomation")){
			//TODO
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}else if(e.getActionCommand().equals("Add")){
			//if(this.addUser()){
				//subPanel.setVisible(false);
				//this.remove(subPanel);
				//subPanel = null;
				//totalPanel.setVisible(true);
			//}
		}else if(e.getActionCommand().equals("ModifyUser")){
			//if(this.modifyUserInfo()){
				//subPanel.setVisible(false);
				//this.remove(subPanel);
				//subPanel = null;
				//totalPanel.setVisible(true);
			//}
		}
	}
	
}
