package ui.specialui.admin.TotalPanel;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.admin.Frame_Admin;



public class UserInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;
	
	 private MyJLabel userIdentity;
	 private MyComboBox userList;
	 private MyJButton search;
	
	public UserInfo(Frame_Admin frame_Admin) {
	
		super(50, 100, 620, 560);
		
		this.initComponent(frame_Admin);
	}

	
	private void initComponent(Frame_Admin frame_Admin){
	
		String [] identity = {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
	
		userIdentity = new MyJLabel(20,10,120,30, "请选择用户类别",14,true);
		this.add(userIdentity);
		
		userList = new MyComboBox(140,10,150,30,14,identity);
		this.add(userList);
		
		search = new MyJButton(300,10,90,30,"搜索",14);
		search.setActionCommand("SearchUser");
		search.addActionListener(frame_Admin);
		this.add(search);
		
		//the table
		String[] headers = {"用户编号", "用户姓名", "用户职务", "员工类别", "员工权限","联系方式","家庭地址"};
		MyJTable table = new MyJTable(headers,false);
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
				
		jsp.setBounds(15, 50, 590, 495);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		
	}
	
}
