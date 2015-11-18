package ui.specialui.admin.TotalPanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
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
		MyJButton AddUser = new MyJButton(50, 650, 150, 40,"添加用户",14);
		AddUser.setActionCommand("AddUser");
		AddUser.addActionListener(frame_Admin);
		this.add(AddUser);
		AddUser.setVisible(true);
		
		MyJButton ViewUserInfomation = new MyJButton(200, 650, 150, 40,"查看用户信息",14);
		ViewUserInfomation.setActionCommand("ViewUserInfomation");
		ViewUserInfomation.addActionListener(frame_Admin);
		this.add(ViewUserInfomation);
		ViewUserInfomation.setVisible(true);
		
		MyJButton DeleteUser = new MyJButton(350, 650, 150, 40,"删除用户",14);
		DeleteUser.setActionCommand("DeleteUser");
		DeleteUser.addActionListener(frame_Admin);
		this.add(DeleteUser);
		DeleteUser.setVisible(true);
		
		MyJButton ModifyUserInfomation = new MyJButton(500,650,150,40,"修改用户信息",14);
		ModifyUserInfomation.setActionCommand("ModifyUserInfomation");
		ModifyUserInfomation.addActionListener(frame_Admin);
		this.add(ModifyUserInfomation);
		
		MyJButton SaveChanges = new MyJButton(650, 650, 150, 40,"保存更改",14);
		SaveChanges.setActionCommand("SaveChanges");
		SaveChanges.addActionListener(frame_Admin);
		this.add(SaveChanges);
		
		MyJButton Backout = new MyJButton(800, 650, 150, 40,"撤销",14);
		Backout.setActionCommand("Backout");
		Backout.addActionListener(frame_Admin);
		this.add(Backout);
		
		MyJButton Withdraw = new MyJButton(1120,55,150,40,"注销登录",14);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frame_Admin);
		this.add(Withdraw);
		
		MyJLabel title = new MyJLabel(535,50,210,50,"用户信息",22,true);
		this.add(title);
		
		
		String [] identity = {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
		
		MyJLabel userIdentity = new MyJLabel(35,100,120,30, "请选择用户类别",16,true);
		this.add(userIdentity);
		
		MyComboBox userList = new MyComboBox(155,100,150,30,14,identity);
		this.add(userList);
		//the table
				String[] headers = {"员工编号", "员工姓名", "员工职务", "联系方式", "用户名称", "用户密码"};
				MyTable	table = new MyTable(headers);
				table.setBackground(new Color(40, 42, 66));
				table.setForeground(Color.WHITE);
				table.setFont(new MyFont(14));
	
						
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
				tcr.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, tcr);
				
					  	
				JScrollPane jsp=new JScrollPane(table);
				JTableHeader head = table.getTableHeader();
				head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
				head.setFont(new MyFont(14));
				head.setForeground(Color.BLACK);
				head.setResizingAllowed(false);
						
				jsp.setBounds(35, 140, 1220, 495);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
			//	UserInfo userInfo = new UserInfo();
				//this.add(userInfo);
		

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
