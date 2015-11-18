package ui.specialui.admin;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import ui.image.CommonImage;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;


public class Panel_Admin_AddUser extends MyJPanel{
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
		MyJLabel title = new MyJLabel(550, 40, 170, 50, "新增用户信息", 24, true);
		this.add(title);
		
		MyJLabel userID = new MyJLabel(425, 90, 110, 30, "新用户ID", 18, true);
		this.add(userID);
		
		MyJLabel password = new MyJLabel(680,90,110,30,"用户密码",18,true);
		this.add(password);
		
		MyJLabel userName = new MyJLabel(425,150, 110, 30, "用户名", 18, true);
		this.add(userName);
		
		MyJLabel userIdentity = new MyJLabel(680, 150, 40, 30, "用户权限",20,true);
		this.add(userIdentity);
		
		MyJLabel userType = new MyJLabel(425, 210, 40, 30, "用户类别",20,true);
		this.add(userType);
		
		JButton add = new JButton("添加");
		add.setBounds(475,600,40,30);		
		add.setActionCommand("AddUser");
		add.addActionListener(frame_Admin);
		this.add(add);
		//add.setVisible(true);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(720,600,40,30);
		cancel.setActionCommand("cancel");
		cancel.addActionListener(frame_Admin);
		this.add(cancel);
		//add.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

}
