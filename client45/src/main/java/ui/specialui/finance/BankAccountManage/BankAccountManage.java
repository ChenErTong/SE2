package ui.specialui.finance.BankAccountManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.fundblservice.BankAccountBLService;
import state.FindTypeAccount;
import state.ResultMessage;
import ui.image.CommonImage;
import ui.image.FinanceImage.BankAccountImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;
import vo.BankAccountVO;

/**
 * 负责银行账户管理的Panel，实现对各个按钮的监听和与bl层的连接
 * @author zsq
 * @version 2015/11/16 18:50
 */
public class BankAccountManage extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private SearchBankAccount bankAccountPanel;
	private AddBankAccount addBankAccount;
	private ModifyBankAccount modifyAccountInfo;
	private MyButton deleteButton;
	private MyButton modifyButton;
	private MyButton add;
	private MyButton modify;
	private MyButton backout;
	private MyButton redo;
	private MyJTable table;
	
	/**
	 * 存放BankAccountVO对象的常量池
	 */
	static ArrayList<BankAccountVO> accountPool;
	static String accountID = " ";
	
	public BankAccountVO bankAccount;
	
	public BankAccountManage(Frame_Finance frame_Finance) {
		super(0,0,1280,720);
		this.setOpaque(false);
		//初始化静态成员变量
		accountPool = new ArrayList<BankAccountVO>();
		this.initComponent(frame_Finance);
		this.showAll();	
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530,20,300,40,"银行账户管理",30,true));
		bankAccountPanel = new SearchBankAccount(this);

		this.add(bankAccountPanel);
		addBankAccount = new AddBankAccount();
		this.add(addBankAccount);
		
		modifyAccountInfo = new ModifyBankAccount();
		this.add(modifyAccountInfo);
		
		deleteButton = new MyButton(150,640-30,120,30,BankAccountImage.getBUTTON_DELETE());
		deleteButton.setActionCommand("DeleteBankAccount");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyButton(350,640-30,120,30,BankAccountImage.getBUTTON_MODIFY());
		modifyButton.setActionCommand("ModifyBankAccount");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
		
		
		add = new MyButton(868,346-30,120,30,BankAccountImage.getBUTTON_ADD());	
		add.setActionCommand("AddBankAccount");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyButton(868,640-30,120,30,BankAccountImage.getBUTTON_CONFIRM());	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);
		
		backout = new MyButton(1223-35-40,610,35,35,CommonImage.getBUTTON_BACKOUT());
		backout.setActionCommand("backout");
		backout.addActionListener(this);
		this.add(backout);
		
		redo = new MyButton(1223-35,610,35,35,CommonImage.getBUTTON_REDO());
		redo.setActionCommand("redo");
		redo.addActionListener(this);
		this.add(redo);
		
		this.leadline(frame_Finance);

	}
	
	public void leadline(Frame_Finance frame_Finance){
		MyButton CostManage = new MyButton(300, 690, 95, 20,FinanceImage.getBUTTON_JIESUAN_());
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		MyButton SettlementManage = new MyButton(395+10,690,95,20,FinanceImage.getBUTTON_COST_());
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		MyButton BankAccountManage = new MyButton(395+10+105,690,120,20,FinanceImage.getBUTTON_BANK_());
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(frame_Finance);
		this.add(BankAccountManage);
		BankAccountManage.setVisible(true);
		
		MyButton OpenningStock = new MyButton(405+105+120+10,690,120,20,FinanceImage.getBUTTON_QICHU_());
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(510+130+120+10+5,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(770+130+10,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(770+130+130+15,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frame_Finance);
		this.add(viewLog);
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
			
			
			try {
				BankAccountBLService controller = ControllerFactory.getBankAccountController();
				ArrayList<BankAccountVO> bankAccountVO = controller.show();
				if(bankAccountVO==null){
					return;
				}
				for(int i = 0; i < bankAccountVO.size(); i++){
					String[] rowData = {bankAccountVO.get(i).ID,
							bankAccountVO.get(i).name, String.valueOf(bankAccountVO.get(i).money)+"元"};
					tableModel.addRow(rowData);
					accountPool.add(bankAccountVO.get(i));
				}
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
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
			
			ArrayList<BankAccountVO> bankAccountVO;
			String[] data = bankAccountPanel.getData();
			if(data!=null){
				try {
					BankAccountBLService controller = ControllerFactory.getBankAccountController();
					switch(Integer.parseInt(data[0])){
						case 0 : bankAccountVO = controller.find(data[1], null);break;
						case 1 : bankAccountVO = controller.find(data[1], FindTypeAccount.ID);break;
						case 2 : bankAccountVO = controller.find(data[1], FindTypeAccount.NAME);break;
						default : bankAccountVO = controller.find(data[1], FindTypeAccount.MONEY);break;
					}
					if(bankAccountVO==null){
						return ;
					}
					for(int i = 0; i < bankAccountVO.size(); i++){
					String[] rowData = {bankAccountVO.get(i).ID, 
							bankAccountVO.get(i).name, String.valueOf(bankAccountVO.get(i).money)+"元"};
					tableModel.addRow(rowData);
					accountPool.add(bankAccountVO.get(i));
					System.out.println("SearchSucceed!");
					new MyNotification(this,"共有"+table.getRowCount()+"个账户满足条件！",Color.GREEN);
					}
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					return;
				}	
				}else {
					new MyNotification(this,"请输入查询关键字！",Color.RED);
				}
		}else if(e.getActionCommand().equals("ConfirmModify")){
			table = bankAccountPanel.getTable();
			//accountID = accountPool.get(table.getSelectedRow()).ID;
				
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
			}else if(!this.isLegal(data[2])){
				new MyNotification(this,"输入的账户余额不合法！",Color.RED);
			}
			else{
				try {
					BankAccountBLService bankAccountController = ControllerFactory.getBankAccountController();
					ResultMessage rsg = bankAccountController.add(new BankAccountVO(bankAccountController.getID(),
							data[1],new BigDecimal(data[2]),null));
					if(rsg.equals(ResultMessage.SUCCESS)){
						
						new MyNotification(this,"账户添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"账户添加失败！",Color.RED);
						

					}
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					return;
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
		}else if(e.getActionCommand().equals("backout")){
			try {
				BankAccountBLService controller = ControllerFactory.getBankAccountController();
				ResultMessage rsg = controller.undo();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"操作撤销成功！",Color.GREEN);
				}else{
					new MyNotification(this,"操作撤销失败！",Color.RED);
				}
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
		}else if(e.getActionCommand().equals("redo")){
			try {
				BankAccountBLService controller = ControllerFactory.getBankAccountController();
				ResultMessage rsg = controller.redo();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"操作撤销成功！",Color.GREEN);
				}else{
					new MyNotification(this,"操作撤销失败！",Color.RED);
				}
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
		}

	}
	/**
	 * 判断输入的付款金额是否合法
	 * @param num
	 * @return true为合法，false为不合法
	 */
	private boolean isLegal (String num){
		
		try{
			if(BigDecimal.valueOf(Double.parseDouble(num)).compareTo(BigDecimal.ZERO)<0){
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	public void deleteAccount(){
		table = bankAccountPanel.getTable();
		try {
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
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e.printStackTrace();
		}
	}
	
	public void modifyAccount(){
		table = bankAccountPanel.getTable();
		String[] data = modifyAccountInfo.getData();
		accountID = accountPool.get(table.getSelectedRow()).ID;
		if(!this.isLegal(data[2])){
			new MyNotification(this,"输入的账户余额不合法！",Color.RED);
		}
		try {
			BankAccountBLService bankAccountController = ControllerFactory.getBankAccountController();
			ResultMessage rsg = bankAccountController.update(new BankAccountVO(accountID,
					data[1],new BigDecimal(data[2]),null));
			if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					modifyAccountInfo.refresh();
					new MyNotification(this,"账户修改成功！",Color.GREEN);
			
			}else{
				new MyNotification(this,"账户修改失败！",Color.RED);
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e.printStackTrace();
		}
	}
}

