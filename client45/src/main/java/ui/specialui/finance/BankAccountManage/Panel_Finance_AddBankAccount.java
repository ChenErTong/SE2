package ui.specialui.finance.BankAccountManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_AddBankAccount extends MyTranslucentPanel{

	public Panel_Finance_AddBankAccount() {
		super(660,100,550,300);
		this.initComponent();
		
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(210,10,150,30,"添加账户",16,true);
		this.add(title);
		
		MyJLabel accountName = new MyJLabel(10,80,90,30,"账户名称",16,true);
		this.add(accountName);
		
		MyJLabel balance = new MyJLabel(290,80,90,30,"账户余额",16,true);
		this.add(balance);
		
		MyJTextField nameField = new MyJTextField(100,80,150,30);
		this.add(nameField);
		
		MyJTextField balanceField = new MyJTextField(380,80,150,30);
		this.add(balanceField);
		
		MyJButton add = new MyJButton(210,250,120,30,"确认添加",16);	
		add.setActionCommand("AddBankAccount");
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(add);

	}

	private static final long serialVersionUID = 1L;

}
