package ui.specialui.admin.TotalPanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;

import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyTable;
import ui.specialui.admin.Frame_Admin;


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
		MyJButton AddUser = new MyJButton(50, 670, 150, 40,"添加用户",14);
		AddUser.setActionCommand("AddUser");
		AddUser.addActionListener(frame_Admin);
		this.add(AddUser);
		AddUser.setVisible(true);
		
		MyJButton ViewUserInfomation = new MyJButton(210, 670, 150, 40,"查看用户信息",14);
		ViewUserInfomation.setActionCommand("ViewUserInfomation");
		ViewUserInfomation.addActionListener(frame_Admin);
		this.add(ViewUserInfomation);
		ViewUserInfomation.setVisible(true);
		
		MyJButton DeleteUser = new MyJButton(370, 670, 150, 40,"删除用户",14);
		DeleteUser.setActionCommand("DeleteUser");
		DeleteUser.addActionListener(frame_Admin);
		this.add(DeleteUser);
		DeleteUser.setVisible(true);
		
		MyJButton ModifyUserInfomation = new MyJButton(530,670,150,40,"修改用户信息",14);
		ModifyUserInfomation.setActionCommand("ModifyUserInformation");
		ModifyUserInfomation.addActionListener(frame_Admin);
		this.add(ModifyUserInfomation);
		ModifyUserInfomation.setVisible(true);
		
		MyJButton SaveChanges = new MyJButton(690, 670, 150, 40,"保存更改",14);
		SaveChanges.setActionCommand("SaveChanges");
		SaveChanges.addActionListener(frame_Admin);
		this.add(SaveChanges);
		
		MyJButton Backout = new MyJButton(850, 670, 150, 40,"撤销",14);
		Backout.setActionCommand("Backout");
		Backout.addActionListener(frame_Admin);
		this.add(Backout);
		
		MyJButton Withdraw = new MyJButton(1120,55,150,40,"注销登录",14);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frame_Admin);
		this.add(Withdraw);
		
		MyJLabel title = new MyJLabel(535,50,210,50,"用户信息",22,true);
		this.add(title);
		
		UserInfo userInfo = new UserInfo();
		this.add(userInfo);
		

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
