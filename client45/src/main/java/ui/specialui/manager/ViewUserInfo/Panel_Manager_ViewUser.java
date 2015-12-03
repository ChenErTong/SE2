package ui.specialui.manager.ViewUserInfo;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountBLService;

import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import vo.accountvo.AccountVO;

public class Panel_Manager_ViewUser extends MyJPanel implements ActionListener{
	private UserInfo userInfo;
	private AddAccount addAccount;
	private ModifyAccount modifyAccount;
	private ViewAccount viewAccount;
	private MyJButton viewButton;
	private MyJButton modifyButton;
	private MyJButton add;
	private MyJButton modify;
	private MyJButton deleteButton;
	private MyJTable table;
	static ArrayList<AccountVO> accountPool;
	static String accountID = "";
	private AccountController controller = ControllerFactory.getAccountController();
	public Panel_Manager_ViewUser() {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
		accountPool = new ArrayList<AccountVO>();
		this.showAll();
	}
	private void initComponent() {
		this.add(new MyJLabel(550, 20, 210, 90, "公司员工信息管理", 24, true));
		addAccount = new AddAccount();
		this.add(addAccount);
		modifyAccount = new ModifyAccount();
		this.add(modifyAccount);
		viewAccount = new ViewAccount();
		this.add(viewAccount);
		
		viewButton = new MyJButton(100,346,150,30,"查看所选员工",16);
		viewButton.setActionCommand("ViewAccount");
		viewButton.addActionListener(this);
		this.add(viewButton);
		
		modifyButton = new MyJButton(270,346,150,30,"修改员工信息",16);
		modifyButton.setActionCommand("ModifyAccountInfo");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
		
		deleteButton = new MyJButton(440,346,150,30,"删除所选员工",16);
		deleteButton.setActionCommand("DeleteAccount");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		add = new MyJButton(910,346,120,30,"确认添加",16);	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(910,640,120,30,"确认修改",16);	
		modify.setActionCommand("CheckModify");
		modify.addActionListener(this);
		this.add(modify);
		
		userInfo = new UserInfo(this);
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
			
			AccountBLService controller = ControllerFactory.getAccountController();
			ArrayList<AccountVO> accountVO = controller.show();
			
			for(int i = 0; i < accountVO.size(); i++){
				String[] rowData = {accountVO.get(i).ID,accountVO.get(i).Name,accountVO.get(i).BirthDay,accountVO.get(i).IDCard,accountVO.get(i).WorkTime,
						accountVO.get(i).Salary+"",accountVO.get(i).Phone};
				tableModel.addRow(rowData);
				accountPool.add(accountVO.get(i));
			}
		}

	private static final long serialVersionUID = 1L;
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
			AccountBLService controller = ControllerFactory.getAccountController();
			ArrayList<AccountVO> accountVO;
			String data = userInfo.getData();
			if(data!=null){
				switch(Integer.parseInt(data)){
					case 1 : accountVO = controller.show("总经理");
					case 2 :accountVO = controller.show("快递员");
					case 3 : accountVO = controller.show("中转库存人员");
					case 4: accountVO = controller.show("中转中心业务员");
					case 5 :accountVO = controller.show("营业厅业务员");
					case 6:accountVO = controller.show("财务人员");
					case 7:accountVO = controller.show("管理员");
					case 8:accountVO = controller.show("司机");
					case 9:accountVO = controller.show("快递员");
					default : accountVO = controller.show();
				}
			
				for(int i = 0; i < accountVO.size(); i++){
				String[] rowData = {accountVO.get(i).ID,accountVO.get(i).Name,accountVO.get(i).Duty,accountVO.get(i).BirthDay,accountVO.get(i).IDCard,accountVO.get(i).WorkTime,
						accountVO.get(i).Salary+"",accountVO.get(i).Phone,accountVO.get(i).ordersID.toString()};
				tableModel.addRow(rowData);
				accountPool.add(accountVO.get(i));
				System.out.println("SearchSucceed!");
					new MyNotification(this,"共有"+table.getRowCount()+"个用户满足条件！",Color.GREEN);
				}	
				}else {
					new MyNotification(this,"请选择员工类型！",Color.RED);
				}
		}else if(e.getActionCommand().equals("CheckAdd")){
			String[] data = addAccount.getData();
			if(addAccount.getData()==null){
				new MyNotification(this,"请检查员工信息填写是否完整！",Color.RED);
			}else{//String ID, String duty, String name, String birthDay, String IDCard, String phone, double salary,
				//String workTime
				ResultMessage rsg = controller.addBase(new AccountVO(controller.getID(),data[1],data[0],data[2],data[3],data[5],Double.parseDouble(data[4]),data[6],data[7]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					System.out.println("AddSucceed!");
					this.showAll();
					addAccount.refresh();
					new MyNotification(this,"新员工添加成功！",Color.GREEN);
				}else{
					new MyNotification(this,"新员工添加失败！",Color.RED);
				}
			}
		}else if(e.getActionCommand().equals("ModifyAccountInfo")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的员工！",Color.RED);
			}else{
				accountID = accountPool.get(table.getSelectedRow()).ID;
				String[] data = new String[8];
				
				data[0] = accountPool.get(table.getSelectedRow()).Name;
				data[1] = accountPool.get(table.getSelectedRow()).Duty;
				data[2] = accountPool.get(table.getSelectedRow()).BirthDay;
				data[3] = accountPool.get(table.getSelectedRow()).IDCard;
				data[4] = accountPool.get(table.getSelectedRow()).Salary+"";
				data[5] = accountPool.get(table.getSelectedRow()).Phone;
				data[6] = accountPool.get(table.getSelectedRow()).WorkTime;
				data[7] = accountPool.get(table.getSelectedRow()).branchID;
				modifyAccount.setData(data);
			}
		}else if(e.getActionCommand().equals("CheckModify")){
			table = userInfo.getTable();
			accountID = accountPool.get(table.getSelectedRow()).ID;
		//	if(table.getSelectedRow()==0){
			//	new MyNotification(this,"请先选择需要修改的员工！",Color.RED);
			//}else{
				if(modifyAccount.getData()==null){
					new MyNotification(this,"请检查员工信息填写是否完整！",Color.RED);
				}else{
					new MyNotification(this,"正在修改员工信息！",Color.GREEN);
					this.modifyAccount();
				}
			//}
		}else if(e.getActionCommand().equals("ViewAccount")){
			table = userInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的员工！",Color.RED);
			}else{
				accountID = accountPool.get(table.getSelectedRow()).ID;
				String[] data = new String[8];
				
				data[0] = accountPool.get(table.getSelectedRow()).Name;
				data[1] = accountPool.get(table.getSelectedRow()).Duty;
				data[2] = accountPool.get(table.getSelectedRow()).BirthDay;
				data[3] = accountPool.get(table.getSelectedRow()).IDCard;
				data[4] = accountPool.get(table.getSelectedRow()).Salary+"";
				data[5] = accountPool.get(table.getSelectedRow()).Phone;
				data[6] = accountPool.get(table.getSelectedRow()).WorkTime;
				data[7] = accountPool.get(table.getSelectedRow()).branchID;
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
		}
		
	}
	private void deleteAccount() {
		table = userInfo.getTable();
		AccountController controller = ControllerFactory.getAccountController();
		ResultMessage rsg = controller.deleteBase(accountPool.get(table.getSelectedRow()).ID);
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("DeleteSucceed!");
			this.showAll();
			this.repaint();
			new MyNotification(this,"员工删除成功！",Color.GREEN);
		}else{
			new MyNotification(this,"员工删除失败！",Color.RED);
		}
	}
	private void modifyAccount() {
		table = userInfo.getTable();
		AccountController controller = ControllerFactory.getAccountController();
		String[] data = modifyAccount.getData();
		ResultMessage rsg = controller.updateBase(new AccountVO(controller.getID(),data[1],data[0],data[2],data[3],data[5],Double.parseDouble(data[4]),data[6],data[7]));
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("ModifySucceed!");
			this.showAll();
			modifyAccount.refresh();
			new MyNotification(this,"员工修改成功！",Color.GREEN);		
		}else{
			new MyNotification(this,"员工修改失败！",Color.RED);
		}
	
	}

}
