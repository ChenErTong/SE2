package ui.specialui.manager;

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
import ui.myui.MyJPanel;
import ui.myui.MyTable;

public class Panel_Manager_ViewUser extends MyJPanel{

	public Panel_Manager_ViewUser(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}
	private void initComponent(FrameManager frameManager) {
		MyJButton AddUser = new MyJButton(565, 650, 150, 40,"查看员工信息",14);
		AddUser.setActionCommand("ViewUser");
		AddUser.addActionListener(frameManager);
		this.add(AddUser);
		AddUser.setVisible(true);
		
		String [] identity = {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
		
		MyJLabel userIdentity = new MyJLabel(35,100,120,30, "请选择员工类别",16,true);
		this.add(userIdentity);
		
		MyComboBox userList = new MyComboBox(155,100,150,30,14,identity);
		this.add(userList);
		//the table
		String[] headers = {"用户编号", "用户姓名", "用户职务", "员工类别", "员工权限","联系方式","家庭地址"};
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
	}

	private static final long serialVersionUID = 1L;

}
