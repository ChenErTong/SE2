package ui.specialui.manager.AdjustSalaryPolicy;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.baseblservice.PolicyBLService;
import state.ResultMessage;
import state.SalaryPolicy;
import state.UserIdentity;
import ui.image.CommonImage;
import ui.image.ManagerImage;
import ui.image.FinanceImage.BankAccountImage;
import ui.myui.MyButton;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.PolicyVO;

/**
 * 负责薪水策略管理中panel的转换
 * @author zsq
 * @version 2015/12/05 14：40
 */
public class AdjustSalaryPolicy extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private SearchPolicyInfo policyInfoList;
	private AddPolicy addPolicy;
	private ModifyPolicy modifyPolicy;

	private MyButton add;
	private MyButton modify;
	private MyButton deleteButton;
	private MyButton modifyButton;
	private MyButton backout;
	private MyButton redo;
	private MyJTable table;

	static ArrayList<PolicyVO> policyPool;
	static String policyID = " ";
	
	public AdjustSalaryPolicy(FrameManager frameManager) {	
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(510, 20, 320, 40, "公司职员薪水策略制定", 30, true));
		
		addPolicy = new AddPolicy();
		this.add(addPolicy);
		modifyPolicy = new ModifyPolicy();
		this.add(modifyPolicy);
		
		policyInfoList = new SearchPolicyInfo(this);
		this.add(policyInfoList);
		policyPool = new ArrayList<PolicyVO>();
		deleteButton = new MyButton(150,660-30-27,150,40,ManagerImage.getBUTTON_DELETEPOLICY());
		deleteButton.setActionCommand("DeletePolicy");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyButton(350,660-30-27,150,40,ManagerImage.getBUTTON_MODIFYPOLICY());
		modifyButton.setActionCommand("ModifyPolicy");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
	
		add = new MyButton(880,346-30,120,30,BankAccountImage.getBUTTON_ADD());	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyButton(880,640-30,120,30,ManagerImage.getBUTTON_CONFIRMMODIFY());	
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
		
		
		this.showAll();
	}

	private void showAll() {
		table = policyInfoList.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		policyPool.clear();
		policyID = "";
		

		try {
			PolicyBLService controller = ControllerFactory.getPolicyController();
			ArrayList<PolicyVO> policyVO =  controller.show();
			
			if(policyVO==null){
				new MyNotification(this,"系统中无薪水策略信息！",Color.RED);
				return;
			}
			for(int i = 0; i < policyVO.size(); i++){
				Object[] rowData = {policyVO.get(i).userIdentity.value,policyVO.get(i).salaryPolicy.value,policyVO.get(i).remark};
				tableModel.addRow(rowData);
				policyPool.add(policyVO.get(i));	
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			ControllerFactory.init();
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CheckAdd")){
			String[] data = addPolicy.getData();
			if(addPolicy.getData()==null){
				this.add(new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED));
			}else{
				UserIdentity iden = this.decideIden(data[0]);
				SalaryPolicy policy = this.decidePolicy(data[1]);
				try {
					PolicyBLService controller = ControllerFactory.getPolicyController();
					ResultMessage rsg = controller.addPolicy(new PolicyVO(controller.getID(),iden,policy,data[2]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						System.out.println("AddSucceed!");
						this.showAll();
						addPolicy.refresh();
						new MyNotification(this,"策略添加成功！",Color.GREEN);
					}else{
						new MyNotification(this,"策略添加失败！",Color.RED);
					}
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					ControllerFactory.init();
					return;
				}
			}
			
		}else if(e.getActionCommand().equals("DeletePolicy")){
			table = policyInfoList.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要删除的策略！",Color.RED);
			}else{
				new MyNotification(this,"正在删除策略！",Color.RED);
				this.deletePolicy();
			}
		}else if(e.getActionCommand().equals("ModifyPolicy")){
			table = policyInfoList.getTable();
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的策略！",Color.RED);
			}else{
				Object[] data = new Object[3];
				data[0] = policyPool.get(table.getSelectedRow()).userIdentity;
				data[1] = policyPool.get(table.getSelectedRow()).salaryPolicy;
				data[2] = policyPool.get(table.getSelectedRow()).remark;
				modifyPolicy.setData(data);
			}
		}else if(e.getActionCommand().equals("CheckModify")){
			table = policyInfoList.getTable();
			if(modifyPolicy.getData()==null){
				new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED);
			}else{
				this.modifyPolicy();
			}
		}else if(e.getActionCommand().equals("Search")){
			table = policyInfoList.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
		
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			policyPool.clear();
			policyID  = "";
		
			String data = policyInfoList.getData();
			if(data!=null){
		
				try {
					PolicyBLService controller = ControllerFactory.getPolicyController();
					PolicyVO vo = controller.find(data);
					if(vo==null){
						new MyNotification(this,"系统中无薪水策略信息！",Color.RED);
						return;
					}
					String [] rowData = {vo.userIdentity+"",vo.salaryPolicy+"",vo.remark};
					tableModel.addRow(rowData);
					policyPool.add(vo);
					new MyNotification(this,"共有"+table.getRowCount()+"个策略符合条件！",Color.GREEN);
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					ControllerFactory.init();
					return;
				}
			}else {
				new MyNotification(this,"请输入查询的薪水类型！",Color.RED);
			}
		}else if(e.getActionCommand().equals("backout")){
			try {
				PolicyBLService controller  = ControllerFactory.getPolicyController();
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
				PolicyBLService controller  = ControllerFactory.getPolicyController();
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


	private void deletePolicy() {
		table = policyInfoList.getTable();
		
		try {
			PolicyBLService controller = ControllerFactory.getPolicyController();
			ResultMessage rsg = controller.deletePolicy(policyPool.get(table.getSelectedRow()).ID);
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("DeleteSucceed!");
				this.showAll();
				this.repaint();
				new MyNotification(this,"策略删除成功！",Color.GREEN);
			}else{
				new MyNotification(this,"策略删除失败！",Color.RED);
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			ControllerFactory.init();
			return;
		}
		
	}
	
	private void modifyPolicy() {
		table = policyInfoList.getTable();
		if(table.getSelectedRow()<0){
			new MyNotification(this,"请选择需要修改的策略信息！",Color.RED);
			return;
		}
		
		String[] data = modifyPolicy.getData();
		try {
			PolicyBLService controller = ControllerFactory.getPolicyController();
			ResultMessage rsg = controller.updatePolicy(new PolicyVO(policyPool.get(table.getSelectedRow()).ID, UserIdentity.COURIER, SalaryPolicy.DEDUCT, data[2]));
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("ModifySucceed!");
				this.showAll();
				modifyPolicy.refresh();
				new MyNotification(this,"策略修改成功！",Color.GREEN);	
			}else{
				new MyNotification(this,"策略修改失败！",Color.RED);
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			ControllerFactory.init();
			return;
		}
	}
	
	/**
	 * 添加新策略的决策表
	 */
	
	private UserIdentity decideIden(String data){
		switch (data){
		case "0":return UserIdentity.COURIER;
		case "1":return UserIdentity.FINANCE_MANAGER;
		case "2":return UserIdentity.TRANSFER_CONTERMAN;
		case "3":return UserIdentity.INVENTORY_MANAGER;
		case "4":return UserIdentity.BRANCH_COUNTERMAN;
		case "5":return UserIdentity.DRIVER;
		case "6":return UserIdentity.ADMIN;
		case "7":return UserIdentity.GENERAL_MANAGER;
		default:
			break;
		}
		return null;
	}
	
	private SalaryPolicy decidePolicy(String data){
		switch(data){
		case "0":return SalaryPolicy.EVERYMONTH;
		case "1":return SalaryPolicy.BYTIMES;
		case "2":return SalaryPolicy.DEDUCT;
		default:
			break;
		}
		return null;
	}
}
