package ui.specialui.admin;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import ui.image.CommonImage;
import ui.myui.MyComboBox;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;


public class Panel_Admin_AddUser extends MyJPanel{
	
	String [] identity = {"总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
	String [] authority = {"管理员权限","总经理权限","普通员工权限"};

	public Panel_Admin_AddUser(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public Panel_Admin_AddUser(Frame_Admin frame_Admin) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		
		this.initComponent(frame_Admin);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		

		BufferedImage image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		g2d.drawImage(CommonImage.TEST_HALFOPAQUE, 0, 0, null);
	   
	    g2d.dispose();
	    
	    g.drawImage(image, 365, 40, null);
	  
	}
	
	private void initComponent(Frame_Admin frame_Admin){
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "新增用户信息", 24, true);
		this.add(title);
		
		MyJLabel userID = new MyJLabel(400, 90, 90, 30, "新用户ID", 18, true);
		this.add(userID);
		
		MyJLabel password = new MyJLabel(660,90,90,30,"用户密码",18,true);
		this.add(password);
		
		MyJLabel userName = new MyJLabel(400,150, 90, 30, "用户名", 18, true);
		this.add(userName);
		
		MyJLabel userIdentity = new MyJLabel(660, 150, 90, 30, "用户类别",18,true);
		this.add(userIdentity);
		
		MyJLabel userAuthority = new MyJLabel(400, 210, 90, 30, "用户权限",18,true);
		this.add(userAuthority);
		
		MyJTextField userId = new MyJTextField(490,90,140,30);
		this.add(userId);

		MyJTextField passwordField = new MyJTextField(750,90,140,30);
		this.add(passwordField);
		
		MyJTextField userNameField = new MyJTextField(490, 150, 140, 30);

		this.add(userNameField);
		
		MyComboBox userIdentityBox = new MyComboBox(750,150,150,30,18,identity);
		this.add(userIdentityBox);
		
		MyComboBox userAuthorityBox = new MyComboBox(490,210,150,30,18,authority);
		this.add(userAuthorityBox);
		
		MyJButton add = new MyJButton(475,600,60,30,"添加",18);
			
		add.setActionCommand("AddUser");
		add.addActionListener(frame_Admin);
		this.add(add);
		//add.setVisible(true);
		
		MyJButton cancel = new MyJButton(720,600,60,30,"取消",18);
		
		cancel.setActionCommand("cancel");
		cancel.addActionListener(frame_Admin);
		this.add(cancel);
		//add.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

}
