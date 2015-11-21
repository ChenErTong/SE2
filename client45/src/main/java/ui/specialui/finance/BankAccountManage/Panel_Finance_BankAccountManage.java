package ui.specialui.finance.BankAccountManage;

import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_BankAccountManage extends MyJPanel{
	private Panel_Finance_BankAccount bankAccountPanel;
	private Panel_Finance_AddBankAccount addBankAccount;
	private Panel_Finance_ModifyAccountInfo modifyAccountInfo;
	public Panel_Finance_BankAccountManage(Frame_Finance frame_Finance) {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
		// TODO Auto-generated constructor stub
	}

	private void initComponent(Frame_Finance frame_Finance) {
		// TODO Auto-generated method stub
		bankAccountPanel = new Panel_Finance_BankAccount();
		this.add(bankAccountPanel);
		
		addBankAccount = new Panel_Finance_AddBankAccount();
		this.add(addBankAccount);
		
		modifyAccountInfo = new Panel_Finance_ModifyAccountInfo();
		this.add(modifyAccountInfo);
	}

	private static final long serialVersionUID = 1L;

}
