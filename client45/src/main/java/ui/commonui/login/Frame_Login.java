package ui.commonui.login;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataservice.userdataservice.LoginInfo;
import businesslogic.userbl.UserController;
import state.UserIdentity;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.inventory.Frame_Inventory;
import ui.specialui.manager.FrameManager;
import ui.specialui.transfer_counterman.Frame_Transfer;

/**
 * 登陆界面
 * @author czw
 * @time 2015年11月15日下午4:11:44
 */
/**
 * 登录界面完善
 * @author zsq
 * @time 2015/11/23 15:14:55
 */
@SuppressWarnings("unused")

public class Frame_Login extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private MyJTextField userIdField;
	private MyJTextField passwordField;	
	
	private String userName;
	private String userID;
	private String userIden;
	private UserIdentity iden;
	boolean flag = false;

	private Panel_Login totalPanel = new Panel_Login(this);
	public Frame_Login(){
		totalPanel = new Panel_Login(this);
		this.add(totalPanel);
		this.setBackground(CommonImage.TEST_BACKGROUND);
		this.initComponent(this);
	}
	
	
	private void initComponent(Frame_Login frame_Login) {
		this.add(new MyJLabel(432,80,500,90,"快递物流管理系统",50,true));
		
		userIdField = new MyJTextField(590, 235, 200, 40);
		this.add(userIdField);

		passwordField = new MyJTextField(590, 285, 200, 40);
		this.add(passwordField);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")){
			UserController  userController = new UserController();
			//TODO - 如何把iden转成string orz
			iden = userController.login(new LoginInfo(userIdField.getText(),new String(passwordField.getText()),flag));
			String type = "";
			userID = userIdField.getText();
			for(int i=0;i<userController.show(type).size();i++){
				userName = userController.show(type).get(i).userName;
				userIden = userController.show(type).get(i).iden;
			}
		}
		if(iden==null){
			this.add(new MyNotification(this,"用户名或密码填写错误！",Color.RED));
		}else if(iden.equals(UserIdentity.ADMIN)){
			Frame_Admin frame_Admin = new Frame_Admin();
			frame_Admin.setVisible(true);
			this.setVisible(false);
		}else if(iden.equals(UserIdentity.GENERAL_MANAGER)){
			FrameManager frame_Manager = new FrameManager();
			frame_Manager.setVisible(true);
			frame_Manager.add(new MyNotification(frame_Manager,"欢迎使用本系统！",Color.GREEN));
			this.setVisible(false);
		}else if(iden.equals(UserIdentity.FINANCE_MANAGER)){
			Frame_Finance frame_Finance = new Frame_Finance();
			frame_Finance.setVisible(true);
			frame_Finance.add(new MyNotification(frame_Finance,"欢迎使用本系统！",Color.GREEN));
			this.setVisible(false);
		}else if(iden.equals(UserIdentity.INVENTORY_MANAGER)){
			Frame_Inventory frame_Inventory = new Frame_Inventory();
			frame_Inventory.setVisible(true);
			frame_Inventory.add(new MyNotification(frame_Inventory,"欢迎使用本系统！",Color.GREEN));
			this.setVisible(false);
		}else if(iden.equals(UserIdentity.COURIER)){
			Frame_Courier frame_Courier = new Frame_Courier();
			frame_Courier.setVisible(true);
			frame_Courier.add(new MyNotification(frame_Courier,"欢迎使用本系统！",Color.GREEN));
			this.setVisible(false);
		}else if(iden.equals(UserIdentity.BRANCH_COUNTERMAN)){
			Frame_Branch frame_Branch = new Frame_Branch();
			frame_Branch.setVisible(true);
			frame_Branch.add(new MyNotification(frame_Branch,"欢迎使用本系统！",Color.GREEN));
			this.setVisible(false);
		}else if(iden.equals(UserIdentity.TRANSFER_CONTERMAN)){
			Frame_Transfer frame_Transfer = new Frame_Transfer();
			frame_Transfer.setVisible(true);
			frame_Transfer.add(new MyNotification(frame_Transfer,"欢迎使用本系统！",Color.GREEN));
			this.setVisible(false);
		}
//		

	}
}