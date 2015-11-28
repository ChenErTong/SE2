package ui.specialui.manager.ViewUserInfo;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.accountblservice.AccountBLService;
import state.AccountType;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import vo.accountvo.AccountVO;

public class Panel_Manager_ViewUser extends MyJPanel implements ActionListener{
	private UserInfo userInfo;
	private MyJButton ViewUser;
	private MyJTable table;
	static ArrayList<AccountVO> accountPool;
	static String accountID = "";
	public Panel_Manager_ViewUser() {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
		accountPool = new ArrayList<AccountVO>();
		this.showAll();
	}
	private void initComponent() {
		this.add(new MyJLabel(550, 20, 210, 90, "查看公司员工信息", 24, true));
		//ViewUser = new MyJButton(565, 670, 150, 40,"查看员工信息",14);
				//ViewUser.setActionCommand("ViewUser");
				///ViewUser.addActionListener(frameManager);
				//this.add(ViewUser);
		
		userInfo = new UserInfo(this);
		this.add(userInfo);
	
	}
	/**
	 * 显示所有的银行账号
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
				//TODO 接口改好后再加
					case 1 : accountVO = controller.show(AccountType.GENERAL_MANAGER);
					case 2 :accountVO = controller.show(AccountType.COURIER);
					case 3 : accountVO = controller.show(AccountType.INVENTORY_MANAGER);
					case 4: accountVO = controller.show(AccountType.TRANSFER_CONTERMAN);
					case 5 :accountVO = controller.show(AccountType.BRANCH_COUNTERMAN);
					case 6:accountVO = controller.show(AccountType.FINANCE_MANAGER);
					case 7:accountVO = controller.show(AccountType.ADMIN);
					case 8:accountVO = controller.show(AccountType.DRIVER);
					default : accountVO = controller.show();
				}
			
				for(int i = 0; i < accountVO.size(); i++){
				String[] rowData = {accountVO.get(i).ID,accountVO.get(i).Name,accountVO.get(i).Duty,accountVO.get(i).BirthDay,accountVO.get(i).IDCard,accountVO.get(i).WorkTime,
						accountVO.get(i).Salary+"",accountVO.get(i).Phone};
				tableModel.addRow(rowData);
				accountPool.add(accountVO.get(i));
				System.out.println("SearchSucceed!");
					this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个用户满足条件！",Color.GREEN));
				}	
				}else {
					this.add(new MyNotification(this,"请选择员工类型！",Color.RED));
				}
		}
		
	}

}
