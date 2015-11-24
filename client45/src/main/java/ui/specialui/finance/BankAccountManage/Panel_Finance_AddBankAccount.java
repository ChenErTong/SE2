package ui.specialui.finance.BankAccountManage;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_AddBankAccount extends MyTranslucentPanel{
	private MyJTextField nameField;
	private MyJTextField balanceField;
	public Panel_Finance_AddBankAccount() {
		super(660,100,550,240);
		this.initComponent();
		
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(240,10,150,30,"添加账户",18,true);
		this.add(title);
		
		MyJLabel accountName = new MyJLabel(10,80,90,30,"账户名称",16,true);
		this.add(accountName);
		
		MyJLabel balance = new MyJLabel(290,80,90,30,"账户余额",16,true);
		this.add(balance);
		
		nameField = new MyJTextField(100,80,150,30);
		this.add(nameField);
		
		balanceField = new MyJTextField(380,80,150,30);
		this.add(balanceField);
		
		

	}

	private static final long serialVersionUID = 1L;

}
