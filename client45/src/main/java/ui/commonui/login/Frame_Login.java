package ui.commonui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

import dataservice.userdataservice.LoginInfo;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import state.UserIdentity;
import ui.commonui.annocement.AnnocementFrame;
import ui.mainui.MainFrame;
import ui.specialui.admin.Frame_Admin;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.inventory.Frame_Inventory;
import ui.specialui.manager.FrameManager;
import ui.specialui.transfer_counterman.Frame_Transfer;

public class Frame_Login extends MainFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	boolean flag = false;
	
	TextField userNameField;
	TextField passwordField;
	JButton button_Enter;
	JLabel label_field1,label_field2;
	JLabel loginBackground2,loginBackground;
	
	private static String userName,userID;
	private static UserIdentity userIden;
	
	public Frame_Login(){
		Color color = new Color(46, 52, 101);
		color.toString();
		
		//text field for user name input
		
		userNameField = new TextField();
		userNameField.setFont(new Font("Arail",Font.BOLD,20));
		userNameField.setForeground(Color.WHITE);
		
		userNameField.setBounds((Rectangle) BorderFactory.createEmptyBorder());
		
		userNameField.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				label_field1.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0){
				label_field1.setVisible(false);
			}
		});
	
		this.add(userNameField);
		
		//a password field for password input
		passwordField = new TextField();
		passwordField.setFont(new Font("Arail",Font.PLAIN,20));
		passwordField.setForeground(Color.WHITE);
		passwordField.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				label_field2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0){
				label_field2.setVisible(true);
			}
		});
		this.add(passwordField);
		
		//the button for action login
		button_Enter = new JButton();
		button_Enter.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				loginBackground.setVisible(false);
				loginBackground2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0){
				loginBackground.setVisible(true);
				loginBackground2.setVisible(false);
			}
		});
		button_Enter.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		button_Enter.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent event){
				if(KeyEvent.getKeyText(event.getKeyCode()).compareToIgnoreCase("enter")==0){
					button_Enter.doClick();
				}
			}
		});
		button_Enter.addActionListener(this);
		this.add(button_Enter);
	}
	

	
	
	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		if(events.getSource()==button_Enter){
			UserBLService controller = new UserController();
			
			UserIdentity ui = controller.login(new LoginInfo(userNameField.getText(),new String(passwordField.getText()),flag));
			userID = userNameField.getText();
			for(int i=0;i<controller.show().size();i++){
				if(controller.show().get(i).username.equals(userID)){
					userName = controller.show().get(i).name;
					userIden = controller.show().get(i).iden;
				}
			}
			if(ui == null){
				AnnocementFrame af = new AnnocementFrame("用户名或密码填写错误！");
				af.setVisible(true);
			}else if(ui.equals(UserIdentity.ADMIN)){
				Frame_Admin au = new Frame_Admin();
				au.setVisible(true);
				
				this.setVisible(false);
				
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				
				af.setVisible(true);
			}else if(ui.equals(UserIdentity.INVENTORY_MANAGER)){
				Frame_Inventory fi = new Frame_Inventory();
				fi.setVisible(true);
				
				this.setVisible(false);
				
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				af.setVisible(true);
			}else if(ui.equals(UserIdentity.COURIER)){
				Frame_Courier fc = new Frame_Courier();
				fc.setVisible(true);
				
				this.setVisible(false);
				
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				af.setVisible(true);
			}else if(ui.equals(UserIdentity.GENERAL_MANAGER)){
				FrameManager fm = new FrameManager();
				fm.setVisible(true);
				
				this.setVisible(false);
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				af.setVisible(true);
			}else if(ui.equals(UserIdentity.FINANCE_MANAGER)){
				Frame_Finance ff = new Frame_Finance();
				ff.setVisible(true);
				
				this.setVisible(false);
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				af.setVisible(true);

			}else if(ui.equals(UserIdentity.TRANSFER_CONTERMAN)){
				Frame_Transfer ft = new Frame_Transfer();
				ft.setVisible(true);
				
				this.setVisible(false);
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				af.setVisible(true);
			}else if(ui.equals(UserIdentity.BRANCH_COUNTERMAN)){
				Frame_Branch fb = new Frame_Branch();
				fb.setVisible(true);
				
				this.setVisible(true);
				AnnocementFrame af = new AnnocementFrame("欢迎您使用本系统！");
				af.setVisible(true);
			}
		}
	}
}