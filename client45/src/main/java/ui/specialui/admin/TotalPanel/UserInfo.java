package ui.specialui.admin.TotalPanel;


import ui.myui.MyComboBox;

import ui.myui.MyJLabel;

import ui.myui.MyTranslucentPanel;



public class UserInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;
	public UserInfo() {
	
		super(20, 100, 1240, 30);

		// TODO Auto-generated constructor stub
	
		
		this.initComponent();
	}

	
	private void initComponent(){
	
		String [] identity = {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
	
		MyJLabel userIdentity = new MyJLabel(20,10,120,30, "请选择用户类别",14,true);
		this.add(userIdentity);
		
		MyComboBox userList = new MyComboBox(140,10,150,30,14,identity);
		this.add(userList);
		
		
	}
	
}
