package ui.specialui.manager.AdjustSalaryPolicy;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.baseblservice.PolicyBLService;

import state.ResultMessage;
import state.SalaryPolicy;
import state.UserIdentity;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.PolicyVO;


public class Panel_Manager_AdjustSalaryPolicy extends MyJPanel implements ActionListener{

	private PolilcyInfoList policyInfoList;
	private AddPolicy addPolicy;
	private ModifyPolicy modifyPolicy;
	private MyJButton add;
	private MyJButton modify;
	private MyJButton deleteButton;
	private MyJButton modifyButton;
	private MyJTable table;
	private PolicyBLService controller = ControllerFactory.getPolicyController();
	static ArrayList<PolicyVO> policyPool;
	static String policyID = " ";
	public Panel_Manager_AdjustSalaryPolicy(FrameManager frameManager) {
		
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	
	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司职员薪水策略制定", 24, true));
		
		addPolicy = new AddPolicy();
		this.add(addPolicy);
		modifyPolicy = new ModifyPolicy();
		this.add(modifyPolicy);
		
		policyInfoList = new PolilcyInfoList(this);
		this.add(policyInfoList);
		policyPool = new ArrayList<PolicyVO>();
		deleteButton = new MyJButton(150,660,180,30,"删除所选策略",16);
		deleteButton.setActionCommand("DeletePolicy");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyJButton(350,660,180,30,"修改所选策略信息",16);
		modifyButton.setActionCommand("ModifyPolicy");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
	
		add = new MyJButton(880,346,120,30,"确认添加",16);	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(880,640,120,30,"确认修改",16);	
		modify.setActionCommand("CheckModify");
		modify.addActionListener(this);
		this.add(modify);
		this.showAll();
		
	}
	


	private static final long serialVersionUID = 1L;
	private void showAll() {
		table = policyInfoList.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		policyPool.clear();
		policyID = "";
		

		ArrayList<PolicyVO> policyVO =  controller.show();
		
		for(int i = 0; i < policyVO.size(); i++){
			Object[] rowData = {policyVO.get(i).userIdentity,policyVO.get(i).salaryPolicy,policyVO.get(i).remark};
			tableModel.addRow(rowData);
			policyPool.add(policyVO.get(i));	
		}
	}

@Override
public void actionPerformed(ActionEvent e) {/*		String [] employeeList = {"快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};*/
	if(e.getActionCommand().equals("CheckAdd")){/*		String [] policyList = {"按月","计次","提成"};*/
		String[] data = addPolicy.getData();
		if(addPolicy.getData()==null){
			this.add(new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED));
		}else if(data[0].equals("0")&&data[1].equals("2")){
			ResultMessage rsg = controller.addBase(new PolicyVO(controller.getID(),UserIdentity.COURIER,SalaryPolicy.DEDUCT,data[2]));
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("AddSucceed!");
				this.showAll();
				addPolicy.refresh();
				new MyNotification(this,"策略添加成功！",Color.GREEN);
			}else{
				new MyNotification(this,"策略添加失败！",Color.RED);
			}
		}else if(data[0].equals("5")&&data[1].equals("1")){
			ResultMessage rsg = controller.addBase(new PolicyVO(controller.getID(),UserIdentity.DRIVER,SalaryPolicy.BYTIMES,data[2]));
			if(rsg.equals(ResultMessage.SUCCESS)){
				this.showAll();
				addPolicy.refresh();
				new MyNotification(this,"策略添加成功！",Color.GREEN);
			}else{
				new MyNotification(this,"策略添加失败！",Color.RED);
			}
		}else if(data[0].equals("2")&&data[1].equals("0")){
			ResultMessage rsg = controller.addBase(new PolicyVO(controller.getID(),UserIdentity.TRANSFER_CONTERMAN,SalaryPolicy.EVERYMONTH,data[2]));
			if(rsg.equals(ResultMessage.SUCCESS)){
				this.showAll();
				addPolicy.refresh();
				new MyNotification(this,"策略添加成功！",Color.GREEN);
			}else{
				new MyNotification(this,"策略添加失败！",Color.RED);
			}
		}
	}else if(e.getActionCommand().equals("DeletePolicy")){
		table = policyInfoList.getTable();
		policyID = policyPool.get(table.getSelectedRow()).ID;
		if(table.getSelectedRowCount() == 0){
			new MyNotification(this,"请先选择要删除的策略！",Color.RED);
		}else{
			new MyNotification(this,"正在删除策略！",Color.RED);
			this.deletePolicy();
		}

	}else if(e.getActionCommand().equals("ModifyPolicy")){
		table = policyInfoList.getTable();
		if(table.getSelectedRowCount() == 0){
			this.add(new MyNotification(this,"请先选择要修改的策略！",Color.RED));
		}else{
			policyID = policyPool.get(table.getSelectedRow()).ID;
			Object[] data = new Object[3];
			data[0] = policyPool.get(table.getSelectedRow()).userIdentity;
			data[1] = policyPool.get(table.getSelectedRow()).salaryPolicy;
			data[2] = policyPool.get(table.getSelectedRow()).remark;
			modifyPolicy.setData(data);
		}
	}else if(e.getActionCommand().equals("CheckModify")){
		table = policyInfoList.getTable();
		policyID = policyPool.get(table.getSelectedRow()).ID;
			if(modifyPolicy.getData()==null){
				new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED);
			}else{
				new MyNotification(this,"正在修改策略信息！",Color.GREEN);
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
		
		//"模糊查找", "账户编号(ID)", "账户名称", "账户余额
		ArrayList<PolicyVO> policyVO = new ArrayList<PolicyVO>();
		String[] data = policyInfoList.getData();
		if(data!=null){
			switch(Integer.parseInt(data[0])){
				case 0 :// baseVO = controller.show(SalaryPolicy.BYTIMES)
				case 1 ://baseVO = controller.find();break;
				case 2 : //baseVO = controller.find();break;
				default :// baseVO = controller.find();break;
			}
		
			for(int i = 0; i <policyVO.size(); i++){
			String[] rowData = {};
			tableModel.addRow(rowData);
			policyPool.add(policyVO.get(i));
			System.out.println("SearchSucceed!");
				new MyNotification(this,"共有"+table.getColumnCount()+"个员工满足条件！",Color.GREEN);
			}	
			}else {
				new MyNotification(this,"请输入查询的薪水类型！",Color.RED);
			}
	}
	
}


private void deletePolicy() {
	table = policyInfoList.getTable();
	
	ResultMessage rsg = controller.deleteBase(policyPool.get(table.getSelectedRow()).ID);
	if(rsg.equals(ResultMessage.SUCCESS)){
		System.out.println("DeleteSucceed!");
		this.showAll();
		new MyNotification(this,"策略删除成功！",Color.GREEN);
	}else{
		new MyNotification(this,"策略删除失败！",Color.RED);
	}
	
}


private void modifyPolicy() {
	table = policyInfoList.getTable();
	
	String[] data = modifyPolicy.getData();
	ResultMessage rsg = controller.updateBase(new PolicyVO(policyPool.get(table.getSelectedRow()).ID, UserIdentity.COURIER, SalaryPolicy.DEDUCT, data[2]));
	if(rsg.equals(ResultMessage.SUCCESS)){
		System.out.println("ModifySucceed!");
		this.showAll();
		modifyPolicy.refresh();
		new MyNotification(this,"策略修改成功！",Color.GREEN);		
	}else{
		new MyNotification(this,"策略修改失败！",Color.RED);
	}
}
	

}
