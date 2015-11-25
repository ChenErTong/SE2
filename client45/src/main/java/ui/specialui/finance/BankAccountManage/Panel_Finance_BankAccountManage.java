package ui.specialui.finance.BankAccountManage;

import businesslogic.fundbl.BankAccountController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;
import vo.BankAccountVO;


public class Panel_Finance_BankAccountManage extends MyJPanel{
	private Panel_Finance_BankAccount bankAccountPanel;
	private Panel_Finance_AddBankAccount addBankAccount;
	private Panel_Finance_ModifyAccountInfo modifyAccountInfo;
	private MyJButton deleteButton;
	private MyJButton modifyButton;
	private MyJButton add;
	private MyJButton modify;
	private BankAccountController bankAccountController;
	private BankAccountVO bankAccount;
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
	/**
	 * TODO 从bl层获取数据
	 * 添加银行账户
	 */

	public int addAccount() {
		String [] data = addBankAccount.getData();
		if(data == null){
			return 1;
		}
		data[0] = bankAccountController.getID();
		double money = Double.parseDouble(data[2]);
		bankAccount = new BankAccountVO(data[0], data[1], money,null);
		bankAccountController.add(bankAccount);
		bankAccountController.confirmOperation();
		return 0;	
	}
	/**
	* 修改银行账户
	* 从bl层获得数据
	*/
	public int modifyBankAccount() {
		String [] data = modifyAccountInfo.getData();
		if(data == null){
			return 1;
		}
		double money = Double.parseDouble(data[2]);
		bankAccount.setLevel(null);
		bankAccount.setMoney(money);
		bankAccount.setName(data[1]);
		bankAccountController.update(bankAccount);
		bankAccountController.confirmOperation();
		return 0;
	}
	/**
	 * 删除账户
	 * @return
	 */
	public int deleteBankAccount() {
		//现在列表中选择一个用户后再进行删除 TODO
		bankAccountController.delete(bankAccount.getID());
		bankAccountController.confirmOperation();
		return 0;
	}

	public void refresh() {
		addBankAccount.refresh();
		modifyAccountInfo.refresh();
	}
	/**
	 * 查看账户信息
	 * TODO 从bl层获取数据
	 */
	public boolean searchBankAccount() {		
		//允许模糊查找 TODO
		return false;
	}

	/**
	 * 查看用户详细信息
	 */
	public boolean viewBankAccountDetails(){
		//TODO
		//从bankAccountList中选择一个要查看的用户
		return false;
	}

	

	private static final long serialVersionUID = 1L;

}
