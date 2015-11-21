package ui.specialui.admin;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.specialui.admin.TotalPanel.Panel_Admin_Total;

public class Frame_Admin extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel subPanel;
	Panel_Admin_Total totalPanel;
	Panel_Admin_AddUser addUser;
	Panel_Admin_Modify modify;
	
	public Frame_Admin(){
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
		}else if(e.getActionCommand().equals("AddUser")){
			totalPanel.setVisible(false);
			addUser = new Panel_Admin_AddUser(this);
			this.add(addUser);
			this.getLayeredPane().add(addUser,new Integer(Integer.MAX_VALUE));
			
			
		}else if(e.getActionCommand().equals("DeleteUser")){
			//TODO
			//totalPanel.setVisible(false);
		}else if(e.getActionCommand().equals("ModifyUserInformation")){
			//TODO
			totalPanel.setVisible(false);
			modify = new Panel_Admin_Modify(this);
			this.add(modify);
			this.getLayeredPane().add(modify,new Integer(Integer.MAX_VALUE));
			
		//	System.out.println("succeed!");
			
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

}
