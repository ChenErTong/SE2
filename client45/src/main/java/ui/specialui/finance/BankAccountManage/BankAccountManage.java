package ui.specialui.finance.BankAccountManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.fundblservice.BankAccountBLService;
import state.FindTypeAccount;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import vo.BankAccountVO;

/**
 * 负责银行账户管理的Panel，实现对各个按钮的监听和与bl层的连接
 * @author zsq
 * @version 2015/11/16 18:50
 */
public class BankAccountManage extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	BankAccountBLService bankAccountController = ControllerFactory.getBankAccountController();
	
	private SearchBankAccount bankAccountPanel;
	private AddBankAccount addBankAccount;
	private ModifyBankAccount modifyAccountInfo;
	private MyJButton deleteButton;
	private MyJButton modifyButton;
	private MyJButton add;
	private MyJButton modify;
	private MyJTable table;
	
	/**
	 * 存放BankAccountVO对象的常量池
	 */
	static ArrayList<BankAccountVO> accountPool;
	static String accountID = " ";
	
	public BankAccountVO bankAccount;
	
	public BankAccountManage() {
		super(0,0,1280,720);
		this.setOpaque(false);
		//初始化静态成员变量
		accountPool = new ArrayList<BankAccountVO>();
		this.initComponent();
		this.showAll();	
	}

	private void initComponent() {
		this.add(new MyJLabel(540,40,200,30,"银行账户管理",24,true));
		bankAccountPanel = new SearchBankAccount(this);

		this.add(bankAccountPanel);
		addBankAccount = new AddBankAccount();
		this.add(addBankAccount);
		
		modifyAccountInfo = new ModifyBankAccount();
		this.add(modifyAccountInfo);
		
		deleteButton = new MyJButton(150,640,180,30,"删除所选账户",16);
		deleteButton.setActionCommand("DeleteBankAccount");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyJButton(350,640,180,30,"修改所选账户信息",16);
		modifyButton.setActionCommand("ModifyBankAccount");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
		
		
		add = new MyJButton(868,346,120,30,"确认添加",16);	
		add.setActionCommand("AddBankAccount");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(868,640,120,30,"确认修改",16);	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);

	}
	
	/**
	 * 显示所有的银行账号
	 */
	public void showAll(){
			table = bankAccountPanel.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			accountPool.clear();
			accountID = "";
			
			BankAccountBLService controller = ControllerFactory.getBankAccountController();
			ArrayList<BankAccountVO> bankAccountVO = controller.show();
			
			for(int i = 0; i < bankAccountVO.size(); i++){
				String[] rowData = {bankAccountVO.get(i).ID,
						bankAccountVO.get(i).name, String.valueOf(bankAccountVO.get(i).money)+"元"};
				tableModel.addRow(rowData);
				accountPool.add(bankAccountVO.get(i));
			}
		}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SearchBankAccount")){
			table = bankAccountPanel.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			accountPool.clear();
			accountID = "";
			
			//"模糊查找", "账户编号(ID)", "账户名称", "账户余额"
			BankAccountBLService controller = ControllerFactory.getBankAccountController();
			ArrayList<BankAccountVO> bankAccountVO;
			String[] data = bankAccountPanel.getData();
			if(data!=null){
				switch(Integer.parseInt(data[0])){
					case 0 : bankAccountVO = controller.find(data[1], null);break;
					case 1 : bankAccountVO = controller.find(data[1], FindTypeAccount.ID);break;
					case 2 : bankAccountVO = controller.find(data[1], FindTypeAccount.NAME);break;
					default : bankAccountVO = controller.find(data[1], FindTypeAccount.MONEY);break;
				}
			
				for(int i = 0; i < bankAccountVO.size(); i++){
				String[] rowData = {bankAccountVO.get(i).ID, 
						bankAccountVO.get(i).name, String.valueOf(bankAccountVO.get(i).money)+"元"};
				tableModel.addRow(rowData);
				accountPool.add(bankAccountVO.get(i));
				System.out.println("SearchSucceed!");
				new MyNotification(this,"共有"+table.getRowCount()+"个账户满足条件！",Color.GREEN);
				}	
				}else {
					new MyNotification(this,"请输入查询关键字！",Color.RED);
				}
		}else if(e.getActionCommand().equals("ConfirmModify")){
			table = bankAccountPanel.getTable();
			accountID = accountPool.get(table.getSelectedRow()).ID;
				
			if(modifyAccountInfo.getData()==null){
				new MyNotification(this,"请检查账户信息填写是否完整！",Color.RED);
			}else{
				new MyNotification(this,"正在修改账户信息！",Color.GREEN);
				this.modifyAccount();
			}
		
		}else if(e.getActionCommand().equals("ModifyBankAccount")){
			table = bankAccountPanel.getTable();
			
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的账户！",Color.RED);
			}else{
				accountID = accountPool.get(table.getSelectedRow()).ID;
				String[] data = new String[3];
				data[0] = accountID;
				data[1] = accountPool.get(table.getSelectedRow()).name;
				data[2] = accountPool.get(table.getSelectedRow()).money+"";
				modifyAccountInfo.setData(data);
			}
		}else if(e.getActionCommand().equals("AddBankAccount")){
			String[] data = addBankAccount.getData();
			if(addBankAccount.getData()==null){
				new MyNotification(this,"请检查账户信息填写是否完整！",Color.RED);
			}else if(this.isLegal(data[2])){
				new MyNotification(this,"输入的账户余额不合法！",Color.RED);
			}else{
				ResultMessage rsg = bankAccountController.add(new BankAccountVO(bankAccountController.getID(),
						data[1],Double.parseDouble(data[2]),null));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					addBankAccount.refresh();
					new MyNotification(this,"账户添加成功！",Color.GREEN);
				}else{
					new MyNotification(this,"账户添加失败！",Color.RED);
				}
			}
		}else if(e.getActionCommand().equals("DeleteBankAccount")){
			table = bankAccountPanel.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要删除的账户！",Color.RED);
			}else{
				new MyNotification(this,"正在删除账户！",Color.GREEN);
				this.deleteAccount();
			}
		}

	}
	/**
	 * 判断一个字符串是否为数字
	 * @param num
	 * @return 是否是数字
	 */
	private boolean isDigit(String num) {
		if (num.length() == 0) {
			return false;
		}
		for(int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean isLegal(String num){
		if(!this.isDigit(num)){
			return false;
		}else{
			if(Double.parseDouble(num)<0){
				return false;
			}
		}
		
		return true;
	}
	
	public void deleteAccount(){
		table = bankAccountPanel.getTable();
		BankAccountBLService bankAccountController = ControllerFactory.getBankAccountController();
		
		ResultMessage rsg = bankAccountController.delete(accountPool.get(table.getSelectedRow()).ID);
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("DeleteSucceed!");
			this.showAll();
			this.repaint();
			new MyNotification(this,"账户删除成功！",Color.GREEN);
		}else{
			new MyNotification(this,"账户删除失败！",Color.RED);
		}
	}
	
	public void modifyAccount(){
		BankAccountBLService bankAccountController = ControllerFactory.getBankAccountController();
		table = bankAccountPanel.getTable();
		String[] data = modifyAccountInfo.getData();
		accountID = accountPool.get(table.getSelectedRow()).ID;
		if(this.isLegal(data[2])){
			new MyNotification(this,"输入的账户余额不合法！",Color.RED);
		}
		ResultMessage rsg = bankAccountController.update(new BankAccountVO(accountID,
				data[1],Double.parseDouble(data[2]),null));
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("ModifySucceed!");
			this.showAll();
			modifyAccountInfo.refresh();
			new MyNotification(this,"账户修改成功！",Color.GREEN);		
		}else{
			new MyNotification(this,"账户修改失败！",Color.RED);
		}
	}
}

