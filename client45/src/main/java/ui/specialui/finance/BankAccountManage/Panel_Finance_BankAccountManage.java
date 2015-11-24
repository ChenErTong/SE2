package ui.specialui.finance.BankAccountManage;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_BankAccountManage extends MyJPanel{
	private Panel_Finance_BankAccount bankAccountPanel;
	private Panel_Finance_AddBankAccount addBankAccount;
	private Panel_Finance_ModifyAccountInfo modifyAccountInfo;
	private MyJButton deleteButton;
	private MyJButton modifyButton;
	private MyJButton add;
	private MyJButton modify;
	public Panel_Finance_BankAccountManage(Frame_Finance frame_Finance) {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
		
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(540,40,200,30,"银行账户管理",24,true));
		bankAccountPanel = new Panel_Finance_BankAccount(frame_Finance);
		this.add(bankAccountPanel);
		
		addBankAccount = new Panel_Finance_AddBankAccount();
		this.add(addBankAccount);
		
		modifyAccountInfo = new Panel_Finance_ModifyAccountInfo();
		this.add(modifyAccountInfo);
		
		deleteButton = new MyJButton(150,640,180,30,"删除所选账户",16);
		deleteButton.setActionCommand("DeleteBankAccount");
		deleteButton.addActionListener(frame_Finance);
		this.add(deleteButton);
		
		modifyButton = new MyJButton(350,640,180,30,"修改所选账户信息",16);
		modifyButton.setActionCommand("ModifyBankAccount");
		modifyButton.addActionListener(frame_Finance);
		this.add(modifyButton);
		
		
		add = new MyJButton(868,346,120,30,"确认添加",16);	
		add.setActionCommand("AddBankAccount");
		add.addActionListener(frame_Finance);
		this.add(add);
		
		modify= new MyJButton(868,640,120,30,"确认修改",16);	
		modify.setActionCommand("ModifyBankAccount");
		modify.addActionListener(frame_Finance);
		this.add(modify);

	}

	private static final long serialVersionUID = 1L;

}
