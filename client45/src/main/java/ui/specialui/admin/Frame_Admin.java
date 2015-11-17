package ui.specialui.admin;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;

public class Frame_Admin extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Panel_Admin_Total totalPanel;
	Panel_Admin_AddUser addUser;
	
	public Frame_Admin(){
		totalPanel = new Panel_Admin_Total(this);
		this.add(totalPanel);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("AddUser")){
			totalPanel.setVisible(false);
			addUser = new Panel_Admin_AddUser(this);
			this.add(addUser);
			this.getLayeredPane().add(addUser,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("DeleteUser")){
			//TODO
			//totalPanel.setVisible(false);
		}else if(e.getActionCommand().equals("ModifyUserInformation")){
			//TODO
			//totalPanel.setVisible(false);
		}else if(e.getActionCommand().equals("ViewUserInfomation")){
			//TODO
		}else if(e.getActionCommand().equals("SaveChanges")){
			//TODO
		}else if(e.getActionCommand().equals("Backout")){
			//TODO
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}
	}
	

}
