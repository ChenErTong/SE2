package ui.commonui.login;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import dataservice.userdataservice.LoginInfo;
import businesslogic.ControllerFactory;
import businesslogic.userbl.UserController;
import state.UserIdentity;
import ui.image.CommonImage;
import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;

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
/**
 * 添加回车登录
 * @author zsq
 * @time 2015/12/08 10:51:01
 */
/**
 * 捕获网络连接异常
 * @author zsq
 *  @time 2015/12/08 18:48:05
 */

public class Frame_Login extends MyJFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	
	private UserController userController;

	private String userID;
	
	private UserIdentity iden;
	static String senderID = "123";
	boolean flag = false;
	
	private MyButton login ;

	private Panel_Login totalPanel = new Panel_Login(this);
	
	public Frame_Login(String id){
		super(id);
		totalPanel = new Panel_Login(this);
		this.add(totalPanel);
		this.setBackground(CommonImage.BACKGROUND);
		
		login = new MyButton(571+85/2,580,137,30,LoginImage.getBUTTON_LOGIN());
		login.setActionCommand("login");
		login.registerKeyboardAction(this, 
		        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), 
		        JComponent.WHEN_IN_FOCUSED_WINDOW); 
		login.addKeyListener(new KeyAdapter(){ 
		    public void keyPressed(KeyEvent event){ 
		    	if (KeyEvent.getKeyText(event.getKeyCode()).compareToIgnoreCase("Enter") == 0){ 
		    		login.doClick(); 
		    	} 
	    	} 
		}); 
		login.addActionListener(this);
		totalPanel.add(login);
		
		this.returnButton.setVisible(false);
		this.subscript.setVisible(false);
	}


	
	@Override
	public void actionPerformed(ActionEvent e)  {
		if(e.getSource()==login){
			String [] data = totalPanel.getData();
			if(data!=null){
				try {
					userController = ControllerFactory.getUserController();
				} catch (MalformedURLException e1) {
					new MyNotification(this,"客户端文件丢失！",Color.RED);
					return;
				} catch (RemoteException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					return;
				} catch (NotBoundException e1) {
					new MyNotification(this,"请检查服务器是否正常工作！",Color.RED);
					return;
				}
				
				try {
					iden = userController.login(new LoginInfo(data[0],data[1],flag));
					System.out.println(data[0]+","+data[1]);
					System.out.println(iden);
				} catch (RemoteException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					e1.printStackTrace();
				}
				userID = data[0];
				if(iden==null){
					new MyNotification(this,"用户名或密码填写错误！",Color.RED);
				}else if(iden.equals(UserIdentity.ADMIN)){
					Frame_Admin frame_Admin = new Frame_Admin(userID);
					frame_Admin.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.GENERAL_MANAGER)){
					FrameManager frame_Manager = new FrameManager(userID);
					frame_Manager.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.FINANCE_MANAGER)){
					Frame_Finance frame_Finance = new Frame_Finance(userID);
					frame_Finance.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.INVENTORY_MANAGER)){
					Frame_Inventory frame_Inventory = new Frame_Inventory(userID);
					frame_Inventory.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.COURIER)){
					Frame_Courier frame_Courier = new Frame_Courier(userID);
					frame_Courier.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.BRANCH_COUNTERMAN)){
					Frame_Branch frame_Branch = new Frame_Branch(userID);
					frame_Branch.setVisible(true);
					this.setVisible(false);
				}else if(iden.equals(UserIdentity.TRANSFER_CONTERMAN)){
					Frame_Transfer frame_Transfer = new Frame_Transfer(userID);
					frame_Transfer.setVisible(true);
					this.setVisible(false);
				}
			}else{
				new MyNotification(this,"请完整输入登录信息！",Color.RED);
			}
	
		}else if(e.getActionCommand().equals("Search")){
			Frame_Sender frame_Sender = new Frame_Sender(senderID);
			frame_Sender.setVisible(true);
			this.setVisible(false);
			
		}else if(e.getActionCommand().equals("keep")){
			flag = true;
		}
	}
}