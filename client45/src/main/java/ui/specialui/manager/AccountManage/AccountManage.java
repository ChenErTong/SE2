package ui.specialui.manager.AccountManage;


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
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountBLService;
import state.ResultMessage;
import ui.image.CommonImage;
import ui.image.ManagerImage;
import ui.image.FinanceImage.BankAccountImage;

import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.accountvo.AccountVO;

public class AccountManage extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
			
	private SearchAccount userInfo;
	private AddAccount addAccount;
	private ModifyAccount modifyAccount;
	private ViewAccount viewAccount;
	private MyButton viewButton;
	private MyButton modifyButton;
	private MyButton add;
	private MyButton modify;
	private MyButton deleteButton;
	private MyButton backout;
	private MyButton redo;
	
	
	private MyJTable table;

	static ArrayList<AccountVO> accountPool;
	static String accountID = "";
	

	public AccountManage(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
		
		accountPool = new ArrayList<AccountVO>();
		
		this.showAll();
	}
	
	private void initComponent() {
		this.add(new MyJLabel(530, 20, 300, 40, "公司员工信息管理", 30, true));
		addAccount = new AddAccount();
		this.add(addAccount);
		modifyAccount = new ModifyAccount();
		this.add(modifyAccount);
		viewAccount = new ViewAccount();
		this.add(viewAccount);
		
		viewButton = new MyButton(100,346-30,150,40,ManagerImage.getBUTTON_VIEWACCOUNT());
		viewButton.setActionCommand("ViewAccount");
		viewButton.addActionListener(this);
		this.add(viewButton);
		
		modifyButton = new MyButton(270,346-30,150,40,ManagerImage.getBUTTON_MODIFYACCOUNT());
		modifyButton.setActionCommand("ModifyAccountInfo");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
		
		deleteButton = new MyButton(440,346-30,150,40,ManagerImage.getBUTTON_DELETEACCOUNT());
		deleteButton.setActionCommand("DeleteAccount");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		add = new MyButton(910,346-30,120,30,BankAccountImage.getBUTTON_ADD());	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyButton(910,640-30,120,30,ManagerImage.getBUTTON_CONFIRMMODIFY());	
		modify.setActionCommand("CheckModify");
		modify.addActionListener(this);
		this.add(modify);
		
		backout = new MyButton(1223-39-40,610,35,35,CommonImage.getBUTTON_BACKOUT());
		backout.setActionCommand("backout");
		backout.addActionListener(this);
		this.add(backout);
		
		redo = new MyButton(1223-39,610,35,35,CommonImage.getBUTTON_REDO());
		redo.setActionCommand("redo");
		redo.addActionListener(this);
		this.add(redo);
		
		
		userInfo = new SearchAccount(this);
		this.add(userInfo);
	
	}
	
	
	/**
	 * 显示所有的员工列表
	 */
	public void showAll(){
			table = userInfo.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			accountPool.clear();
			accountID = "";
			
			ArrayList<AccountVO> accountVO;
			try {
				AccountBLService controller = ControllerFactory.getAccountController();
				accountVO = controller.show();
				if(accountVO==null){
					new MyNotification(this,"系统中无员工账户信息！",Color.RED);
					return;
				}
				for(int i = 0; i < accountVO.size(); i++){
					String[] rowData = {accountVO.get(i).ID,accountVO.get(i).Name,accountVO.get(i).Duty,accountVO.get(i).BirthDay,accountVO.get(i).IDCard,accountVO.get(i).WorkTime,
							accountVO.get(i).Salary+"",accountVO.get(i).Phone};
					tableModel.addRow(rowData);
					accountPool.add(accountVO.get(i));
				}
				this.repaint();
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				ControllerFactory.init();
				return;
			}
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Search")){
			table = userInfo.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			accountPool.clear();
			accountID = "";
			
			//用户类型查找 {"编号", "姓名", "职务", "出生日期", "身份证号",“任职时间”,"薪水","联系方式"};
			//{"所有员工","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员","司机"};
		
			ArrayList<AccountVO> accountVO;
			String data = userInfo.getData();
			if(data!=null){
				
				try {
					AccountBLService controller = ControllerFactory.getAccountController();
					switch(Integer.parseInt(data)){
						case 1 : accountVO = controller.show("总经理"); break;
						case 2 :accountVO = controller.show("快递员"); break;
						case 3 : accountVO = controller.show("中转库存人员"); break;
						case 4: accountVO = controller.show("中转中心业务员"); break;
						case 5 :accountVO = controller.show("营业厅业务员"); break;
						case 6:accountVO = controller.show("财务人员"); break;
						case 7:accountVO = controller.show("管理员"); break;
						case 8:accountVO = controller.show("司机"); break;
						case 9:accountVO = controller.show("快递员"); break;
						default : accountVO = controller.show();
					}

					for(int i = 0; i < accountVO.size(); i++){
					String[] rowData = {accountVO.get(i).ID,accountVO.get(i).Name,accountVO.get(i).Duty,accountVO.get(i).BirthDay,accountVO.get(i).IDCard,accountVO.get(i).WorkTime,
							accountVO.get(i).Salary+"",accountVO.get(i).Phone,accountVO.get(i).ordersID.toString()};
					tableModel.addRow(rowData);
					accountPool.add(accountVO.get(i));
					}
					new MyNotification(this,"共有"+table.getRowCount()+"个用户满足条件！",Color.GREEN);
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					ControllerFactory.init();
					return;
				}	
				}else {
					new MyNotification(this,"请选择员工类型！",Color.RED);
				}
		}else if(e.getActionCommand().equals("CheckAdd")){
			String[] data = addAccount.getData();
			if(addAccount.getData()==null){
				new MyNotification(this,"请检查员工信息填写是否完整！",Color.RED);
			}else{
				try {
					AccountController controller = ControllerFactory.getAccountController();
					ResultMessage rsg = controller.addAccount(new AccountVO(controller.getID(),data[1],data[0],data[2],data[3],data[5],new BigDecimal(data[4]),data[6],data[7],data[8],new ArrayList<>()));
					if(rsg.equals(ResultMessage.SUCCESS)){
					//	System.out.println("AddSucceed!");
						this.showAll();
						addAccount.refresh();
						new MyNotification(this,"新员工添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"新员工添加失败！",Color.RED);
					}
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					ControllerFactory.init();
					return;
				}
			}
		}else if(e.getActionCommand().equals("ModifyAccountInfo")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的员工！",Color.RED);
			}else{
				accountID = accountPool.get(table.getSelectedRow()).ID;
				String[] data = this.setAccountData();
				modifyAccount.setData(data);
			}
		}else if(e.getActionCommand().equals("CheckModify")){
			table = userInfo.getTable();
			if(modifyAccount.getData()==null){
				new MyNotification(this,"请检查员工信息填写是否完整！",Color.RED);
			}else{
				new MyNotification(this,"正在修改员工信息！",Color.GREEN);
				this.modifyAccount();
			}
		}else if(e.getActionCommand().equals("ViewAccount")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的员工！",Color.RED);
			}else{
				accountID = accountPool.get(table.getSelectedRow()).ID;
				String[] data = this.setAccountData();
				viewAccount.setData(data);
				viewAccount.setUneditable();
			}
		}else if(e.getActionCommand().equals("DeleteAccount")){
			table =userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要删除的员工！",Color.RED);
			}else{
				new MyNotification(this,"正在删除员工！",Color.GREEN);
				this.deleteAccount();
			}
		}else if(e.getActionCommand().equals("backout")){
			try {
				AccountController controller = ControllerFactory.getAccountController();
				ResultMessage rsg = controller.undo();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"撤销操作成功！",Color.GREEN);
					this.showAll();
				}else{
					new MyNotification(this,"撤销操作失败！",Color.RED);
				}
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				ControllerFactory.init();
				return;
			
			}
		}else if(e.getActionCommand().equals("redo")){
			try {
				AccountController controller = ControllerFactory.getAccountController();
				ResultMessage rsg = controller.redo();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"撤销操作成功！",Color.GREEN);
					this.showAll();
				}else{
					new MyNotification(this,"撤销操作失败！",Color.RED);
				}
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				ControllerFactory.init();
				return;
			
			}
		}
		
	}
	
	private void deleteAccount() {
		table = userInfo.getTable();
		ResultMessage rsg;
		try {
			AccountController controller = ControllerFactory.getAccountController();
			rsg = controller.deleteAccount(accountPool.get(table.getSelectedRow()).ID);
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("DeleteSucceed!");
				this.showAll();
				this.repaint();
				new MyNotification(this,"员工删除成功！",Color.GREEN);
			}else{
				new MyNotification(this,"员工删除失败！",Color.RED);
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			ControllerFactory.init();
			return;
		}
		
	}
	
	private void modifyAccount() {
		accountID = accountPool.get(table.getSelectedRow()).ID;
		table = userInfo.getTable();
		String[] data = modifyAccount.getData();
		try {
			AccountController controller = ControllerFactory.getAccountController();
			ResultMessage rsg = controller.updateAccount(new AccountVO(accountID,data[1],data[0],data[2],data[3],data[5],new BigDecimal(data[4]),data[6],data[7],data[8],new ArrayList<>()));
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("ModifySucceed!");
				this.showAll();
				modifyAccount.refresh();
				new MyNotification(this,"员工修改成功！",Color.GREEN);		
			}else{
				new MyNotification(this,"员工修改失败！",Color.RED);
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			ControllerFactory.init();
			return;
		}
	}
	
	/**
	 * 设置修改、查看面板的信息
	 * @return
	 */
	private String[] setAccountData(){
		accountID = accountPool.get(table.getSelectedRow()).ID;
		String[] data = new String[9];
		
		data[0] = accountPool.get(table.getSelectedRow()).Name;
		data[1] = accountPool.get(table.getSelectedRow()).Duty;
		data[2] = accountPool.get(table.getSelectedRow()).BirthDay;
		data[3] = accountPool.get(table.getSelectedRow()).IDCard;
		data[4] = accountPool.get(table.getSelectedRow()).Salary+"";
		data[5] = accountPool.get(table.getSelectedRow()).Phone;
		data[6] = accountPool.get(table.getSelectedRow()).WorkTime;
		data[7] = accountPool.get(table.getSelectedRow()).branchID;
		data[8] = accountPool.get(table.getSelectedRow()).userID;
		return data;
	}
}
