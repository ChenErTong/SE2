package ui.specialui.admin;

import javax.swing.JButton;

import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyTable;


public class Panel_Admin_Total extends MyJPanel{
	
	String [] headers = {"所有用户列表"};
	String [] identity = {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};

	public Panel_Admin_Total(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public Panel_Admin_Total(Frame_Admin frame_Admin) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Admin);
		
	
	}
	
	private void initComponent(Frame_Admin frame_Admin){
		JButton AddUser = new JButton("添加用户");
		AddUser.setBounds(50, 650, 150, 40);
		AddUser.setActionCommand("AddUser");
		AddUser.addActionListener(frame_Admin);
		this.add(AddUser);
		AddUser.setVisible(true);
		
		JButton ViewUserInfomation = new JButton("查看用户信息");
		ViewUserInfomation.setBounds(200, 650, 150, 40);
		ViewUserInfomation.setActionCommand("ViewUserInfomation");
		ViewUserInfomation.addActionListener(frame_Admin);
		this.add(ViewUserInfomation);
	//	ViewUserInfomation.setVisible(true);
		
		JButton DeleteUser = new JButton("删除用户");
		DeleteUser.setBounds(350, 650, 150, 40);
		DeleteUser.setActionCommand("DeleteUser");
		DeleteUser.addActionListener(frame_Admin);
		this.add(DeleteUser);
		DeleteUser.setVisible(true);
		
		JButton ModifyUserInfomation = new JButton("修改用户信息");
		ModifyUserInfomation.setBounds(500,650,150,40);
		ModifyUserInfomation.setActionCommand("ModifyUserInfomation");
		ModifyUserInfomation.addActionListener(frame_Admin);
		this.add(ModifyUserInfomation);
		
		JButton SaveChanges = new JButton("保存更改");
		SaveChanges.setBounds(650, 650, 150, 40);
		SaveChanges.setActionCommand("SaveChanges");
		SaveChanges.addActionListener(frame_Admin);
		this.add(SaveChanges);
		
		JButton Backout = new JButton("撤销");
		Backout.setBounds(800, 650, 150, 40);
		Backout.setActionCommand("Backout");
		Backout.addActionListener(frame_Admin);
		this.add(Backout);
		
		JButton Withdraw = new JButton("注销登录");
		Withdraw.setBounds(1120,55,150,40);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frame_Admin);
		this.add(Withdraw);
		
		MyEmptyTextArea userDetails = new MyEmptyTextArea(660,100,600,540);
		this.add(userDetails);
		
		
		//TODO-表格谜之加不上去
		MyTable userTable = new MyTable(headers);
		this.add(userTable);
		

		MyJLabel userIdentity = new MyJLabel(20,70,120,30, "请选择用户类别",14,true);
		this.add(userIdentity);
		
		
		MyComboBox userList = new MyComboBox(140,70,150,30,14,identity);
		this.add(userList);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
