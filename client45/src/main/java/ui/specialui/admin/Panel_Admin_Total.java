package ui.specialui.admin;

import javax.swing.JButton;

import ui.myui.MyJPanel;


public class Panel_Admin_Total extends MyJPanel{

	public Panel_Admin_Total(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public Panel_Admin_Total(Frame_Admin frame_Admin) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
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
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
