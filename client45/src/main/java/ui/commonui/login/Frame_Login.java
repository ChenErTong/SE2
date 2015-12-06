package ui.commonui.login;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataservice.userdataservice.LoginInfo;
import businesslogic.ControllerFactory;
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
import ui.specialui.sender.Frame_Sender;
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
	static String senderID = "123";
	boolean flag = false;

	private Panel_Login totalPanel = new Panel_Login(this);
	
	public Frame_Login(String id){
		super(id);
		totalPanel = new Panel_Login(this);
		this.add(totalPanel);
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")){
			String [] data = totalPanel.getData();
			if(data!=null){
				UserController  userController = ControllerFactory.getUserController();
				iden = userController.login(new LoginInfo(data[0],data[1],flag));
				String type = "";
				userID = data[0];
				for(int i=0;i<userController.show().size();i++){
					if(userController.show().get(i).id.equals(userID)){
						userName = userController.show().get(i).userName;
						iden = userController.show().get(i).iden;
					}
				}
				if(iden==null){
					new MyNotification(this,"用户名或密码填写错误！",Color.RED);
				}else if(iden.equals(UserIdentity.ADMIN)){
					Frame_Admin frame_Admin = new Frame_Admin(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Admin.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.GENERAL_MANAGER)){
					FrameManager frame_Manager = new FrameManager(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Manager.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.FINANCE_MANAGER)){
					Frame_Finance frame_Finance = new Frame_Finance(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Finance.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.INVENTORY_MANAGER)){
					Frame_Inventory frame_Inventory = new Frame_Inventory(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Inventory.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.COURIER)){
					Frame_Courier frame_Courier = new Frame_Courier(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Courier.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.BRANCH_COUNTERMAN)){
					Frame_Branch frame_Branch = new Frame_Branch(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Branch.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.TRANSFER_CONTERMAN)){
					Frame_Transfer frame_Transfer = new Frame_Transfer(userID);
					new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
					frame_Transfer.setVisible(true);
					this.setVisible(false);
				}
			}else{
				new MyNotification(this,"请完整输入登录信息！",Color.RED);
			}
		}else if(e.getActionCommand().equals("Search")){
			Frame_Sender frame_Sender = new Frame_Sender(senderID);
			frame_Sender.setVisible(true);
			new MyNotification(this,"欢迎使用本系统！",Color.GREEN);
			this.setVisible(false);
		}else if(e.getActionCommand().equals("keep")){
			flag = true;
		}
	}
}