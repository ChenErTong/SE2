package ui.specialui.manager.ViewUserInfo;
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

public class UserInfo extends MyTranslucentPanel{

	private MyJButton search ;
	private MyComboBox userList;
	private MyJTable	table;
	public UserInfo(Panel_Manager_ViewUser handle) {
		super(50,100,610,240);
		this.initComponent(handle);
	}

	private void initComponent(Panel_Manager_ViewUser handle) {
		String [] identity = {"所有员工","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员","司机","快递员"};
		
		MyJLabel userIdentity = new MyJLabel(35,5,120,30, "请选择员工类别",16,true);
		this.add(userIdentity);
		
		search = new MyJButton(350,5,90,30,"搜索",16);
		search.setActionCommand("Search");
		search.addActionListener( handle);
		this.add(search);
		
		
		userList = new MyComboBox(155,5,150,30,14,identity);
		this.add(userList);
		//the table
		String[] headers = {"编号", "姓名", "职务", "出生日期", "身份证号","任职时间","薪水","联系方式","车辆编号","订单编号"};
		table = new MyJTable(headers, false);
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
						
		jsp.setBounds(15, 45, 580, 190);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
	}
	
	public String getData(){
		int i = userList.getSelectedIndex();
		String data = i+"";
		return data;
	}
	public MyJTable getTable(){
		return table;
	}

	private static final long serialVersionUID = 1L;

}
