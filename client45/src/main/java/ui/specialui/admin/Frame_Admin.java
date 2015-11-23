package ui.specialui.admin;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.commonui.confirmOperation.ConfirmOperationFrame;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.facilityInfoManage.FacilityInfoManage;

public class Frame_Admin extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private MyJPanel subPanel;
	private Panel_Admin_Total totalPanel;
	private ConfirmOperationFrame confirmOperation;
	
	public Frame_Admin(){
		totalPanel = new Panel_Admin_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@SuppressWarnings("deprecation")
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
			if(this.addUser()){
				//totalPanel.refresh();
			}
			
		}else if(e.getActionCommand().equals("DeleteUser")){
			//TODO
			if(this.deleteUser()){
				//totalPanel.refresh();
			}
	
		}else if(e.getActionCommand().equals("ModifyUserInformation")){
			//TODO
			if(this.modifyUserInfo()){
			//	totalPanel.refresh();
			}
			
		}else if(e.getActionCommand().equals("ViewUserInfomation")){
			//TODO
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}else if(e.getActionCommand().equals("Add")){
			if(this.addUser()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("ModifyUser")){
			if(this.modifyUserInfo()){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}
	}
	
	/**
	 * 添加新用户
	 * @return 是否成功添加
	 * 与bl层连接
 	 */
	private boolean addUser(){
		switch(totalPanel.addUser()){
		case 0: new MyNotification(this, "成功添加新用户", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成新用户信息填写", Color.RED); break;
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * @return 是否修改成功
	 * 与bl层连接
	 */
	private boolean modifyUserInfo(){
		switch(totalPanel.modifyUser()){
		case 0: new MyNotification(this, "成功修改用户信息", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成用户信息修改", Color.RED); break;
		}
		return false;
	}
	
	private boolean deleteUser(){
		switch(totalPanel.deleteUser()){
		case 0: new MyNotification(this, "删除成功", Color.GREEN); return true;
		}
		return false;
	}
}
