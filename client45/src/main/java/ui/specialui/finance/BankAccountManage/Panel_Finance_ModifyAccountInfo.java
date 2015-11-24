package ui.specialui.finance.BankAccountManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_ModifyAccountInfo extends MyTranslucentPanel{
	private MyJTextField nameField;
	private MyJTextField balanceField;
	public Panel_Finance_ModifyAccountInfo() {
		super(660,390,550,240);
		this.initComponent();
		// TODO Auto-generated constructor stub
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		MyJLabel title = new MyJLabel(240,10,150,30,"修改账户",19,true);
		this.add(title);
		
		MyJLabel accountID = new MyJLabel(10,40,120,30,"当前账户ID:",16,true);
		this.add(accountID);
		
		MyJLabel accountName = new MyJLabel(10,80,90,30,"账户名称",16,true);
		this.add(accountName);
		
		MyJLabel balance = new MyJLabel(290,80,120,30,"账户余额",16,true);
		this.add(balance);
		
		 nameField = new MyJTextField(100,80,150,30);
		this.add(nameField);
		
		balanceField = new MyJTextField(380,80,150,30);
		this.add(balanceField);
		
	}

	private static final long serialVersionUID = 1L;

}
