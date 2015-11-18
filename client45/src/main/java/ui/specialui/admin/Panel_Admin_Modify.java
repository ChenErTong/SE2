package ui.specialui.admin;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ui.image.CommonImage;
import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;

public class Panel_Admin_Modify extends MyJPanel{
	String [] identity = {"请选择用户类型","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
	String [] authority = {"请选择权限类型","管理员权限","总经理权限","普通员工权限"};
	String[] provinces ={"江苏省","海南省"};

	public Panel_Admin_Modify(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public Panel_Admin_Modify(Frame_Admin frame_Admin) {
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

	private void initComponent(Frame_Admin frame_Admin) {
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "修改用户信息", 24, true);
		this.add(title);
		
		MyJLabel userID = new MyJLabel(400, 92, 90, 30, "用户编号", 18, true);
		this.add(userID);
		
		MyJLabel password = new MyJLabel(660,92,90,30,"用户密码",18,true);
		this.add(password);
		
		MyJLabel userName = new MyJLabel(400,180, 90, 30, "用户姓名", 18, true);
		this.add(userName);
		
		MyJLabel phone= new MyJLabel(660,180,90,30,"联系电话",18,true);
		this.add(phone);
		
		
		MyJLabel userIdentity = new MyJLabel(400, 270, 90, 30, "员工类别",18,true);
		this.add(userIdentity);
		
		MyJLabel userAuthority = new MyJLabel(660, 270, 90, 30, "员工权限",18,true);
		this.add(userAuthority);
		
		MyJLabel address = new MyJLabel(400,360,90,30,"家庭地址:",18,true);
		this.add(address);
		
		MyJLabel addrDetails = new MyJLabel(400,460,90,30,"详细地址:",18,true);
		this.add(addrDetails);
		
		MyJLabel province = new MyJLabel(490,400,25,30,"省",18,true);
		this.add(province);
		
		MyJLabel city = new MyJLabel(660,400,25,30,"市",18,true);
		this.add(city);
		
		MyJTextField userId = new MyJTextField(490,92,140,30);
		this.add(userId);

		MyJTextField passwordField = new MyJTextField(750,92,140,30);
		this.add(passwordField);
		
		MyJTextField userNameField = new MyJTextField(490, 180, 140, 30);
		this.add(userNameField);
		
		MyJTextField phoneField = new MyJTextField(750,180,140,30);
		this.add(phoneField);
		
		MyComboBox userIdentityBox = new MyComboBox(490,270,150,30,18,identity);
		this.add(userIdentityBox);
		
		MyComboBox userAuthorityBox = new MyComboBox(750,270,150,30,18,authority);
		this.add(userAuthorityBox);
		
		String[] provinces ={"江苏省","海南省"};
		MyComboBox provincesBox = new MyComboBox(520,400,120,30,18,provinces);
		this.add(provincesBox);
		
		String[] cities = {"南京市","海口市"};
		MyComboBox citiesBox = new MyComboBox(690,400,120,30,18,cities);
		this.add(citiesBox);
		
		MyEmptyTextArea addressDetails = new MyEmptyTextArea(490,468,410,100);
		this.add(addressDetails);
		
		MyJButton add = new MyJButton(475,600,100,30,"确认修改",18);
		add.setActionCommand("Modify");
		add.addActionListener(frame_Admin);
		this.add(add);
		add.setVisible(true);
		
		MyJButton cancel = new MyJButton(720,600,100,30,"取消修改",18);
		cancel.setActionCommand("cancel");
		cancel.addActionListener(frame_Admin);
		this.add(cancel);
		cancel.setVisible(true);
		
	}
}