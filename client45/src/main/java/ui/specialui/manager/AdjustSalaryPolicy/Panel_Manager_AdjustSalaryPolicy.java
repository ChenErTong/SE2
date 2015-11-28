package ui.specialui.manager.AdjustSalaryPolicy;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.baseblservice.BaseBLService;

import state.FindTypeBase;
import state.ResultMessage;
import state.SalaryPolicy;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.BaseVO;


public class Panel_Manager_AdjustSalaryPolicy extends MyJPanel implements ActionListener{

	private PolicyDetails policyDetails;
	private PolilcyInfoList policyInfoList;
	private MyJButton commonButton;
	
	private MyJTable table;
	private BaseBLService controller = ControllerFactory.getBaseController();
	static ArrayList<BaseVO> basePool;
	static String baseID = " ";
	public Panel_Manager_AdjustSalaryPolicy(FrameManager frameManager) {
		
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	
	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司职员薪水策略制定", 24, true));
		policyDetails = new PolicyDetails();
		policyDetails.setEnabled(false);
		this.add(policyDetails);
		policyInfoList = new PolilcyInfoList(this);
		this.add(policyInfoList);
		basePool = new ArrayList<BaseVO>();
		this.initButton(frameManager);
		this.showAll();
		
	}
	

	private void initButton(FrameManager frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>策<br/>略<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustSalaryPolicy.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

	MyJButton modifyButton = new MyJButton(400, 665, 120, 40,
			"修改所选策略", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustSalaryPolicy.this.modifyPanel(frame);
				
			}
		});
		modifyButton.setActionCommand("ModifyPolicy");
		modifyButton.addActionListener(this);
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(530, 665, 120, 40,
				"<html>查<br/>看<br/>策<br/>略<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustSalaryPolicy.this.searchPanel(frame);
				
			}
		});
		modifyButton.setActionCommand("ViewPolicy");
		modifyButton.addActionListener(this);
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(0, 540, 40, 110,
				"删除所选策略", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustSalaryPolicy.this.deletePanel(frame);
				
			}
		});
		deleteButton.setActionCommand("DeletePolicy");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
	}
	

	private void insertPanel(FrameManager frame) {
	this.removeAll();
	this.add(policyInfoList);
	this.add(new MyJLabel(530, 20, 250, 90, "公司职员薪水策略制定", 24, true));
	this.initButton(frame);

	
	policyDetails = new PolicyDetails();
	policyDetails.add(new MyJLabel(230,5,120,30,"新增策略",18,true));
	policyDetails.setEnabled(true);
	this.add(policyDetails);
	
	
	commonButton = new MyJButton(890, 670, 120, 30, "添加策略", 20);
	commonButton.setActionCommand("AddNewPolicy");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void modifyPanel(FrameManager frame) {
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司职员薪水策略制定", 24, true));
	this.add(policyInfoList);
	this.initButton(frame);
	
	policyDetails = new PolicyDetails();
	policyDetails.add(new MyJLabel(230,5,120,30,"修改策略信息",18,true));
	policyDetails.setEnabled(true);
	this.add(policyDetails);
	
	commonButton = new MyJButton(890, 670, 150, 30, "修改策略信息", 20);
	commonButton.setActionCommand("CheckModify");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void searchPanel(FrameManager frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司职员薪水策略制定", 24, true));
	this.add(policyInfoList);
	this.initButton(frame);
	
	policyDetails = new PolicyDetails();
	policyDetails.setUneditable();
	policyDetails.add(new MyJLabel(230,5,120,30,"查看策略信息",18,true));
	this.add(policyDetails);
	
	this.repaint();
}

private void deletePanel(FrameManager frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530,20, 250, 90, "公司职员薪水策略制定", 24, true));
	this.add(policyInfoList);
	this.initButton(frame);
	
	policyDetails = new PolicyDetails();
	policyDetails.setUneditable();
	policyDetails.add(new MyJLabel(230,5,120,30,"删除策略",18,true));
	this.add(policyDetails);
	
	commonButton = new MyJButton(890, 670, 120, 30, "删除策略", 20);
	commonButton.setActionCommand("CheckDelete");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

/**
 * TODO 从bl层获取数据
 * 添加用户
 */
/*
public int addOrganization() {
	String [] data = organizationDetails.getData();

	if(data == null){
		return 1;
	}
	if(data[4].equals("营业厅")){
		data[0] = organizationController.getID();
		//branch = new BranchVO(name, name, name, null, null);
		organizationController.addBranch(branch);
	}else if(data[4].equals("中转中心")){
		data[0] = organizationController.getID();
		//transfer = new TransferVO(name, name, flags, null, null);
		organizationController.addTransfer(transfer);
	}
	
	return 0;
	
}
/**
* 修改用户信息
* 从bl层获得数据
*/
/*public int modifyOrganization() {
	String [] data = organizationDetails.getData();
	if(data == null){
		return 1;
	}
	if(data[4].equals("营业厅")){
		branch.setId(data[0]);
		branch.setAddress(data[7]);
		organizationController.updateBranch(branch);
	}else if(data[4].equals("中转中心")){
		organizationController.updateTransfer(transfer);
	}
	

	
	return 0;
}
/**
 * 删除用户
 * @return
 */
/*public int deleteOrganization() {
	String[] data = organizationDetails.getData();
	//现在列表中选择一个用户后再进行删除
	//TODO -
	if(data[4].equals("营业厅")){
		organizationController.deleteBranch(data[0]);
		return 0;
	}else if(data[4].equals("中转中心")){
		organizationController.deleteTransfer(data[0]);
		return 0;
	}
	
	
		return 0;
}

public void refresh() {
	organizationDetails.refresh();
}
/**
 * 查看用户信息列表
 * TODO 从bl层获取数据
 */
/*public boolean searchOrganization() {		
	String type = organizationInfo.getData();
	if(type==null){
		return false;
	}else if(type.equals("营业厅")){
		branchList = organizationController.showBranch();
		return true;
	}else if(type.equals("中转中心")){
		transferList = organizationController.showTransfer();
		return true;
	}
	return false;
}

/**
 * 查看用户详细信息
 */
/*public boolean vieworganizationDetails(){
	//TODO
	//从organizationList中选择一个要查看的用户
	return false;
}*/
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("null")
	private void showAll() {
		table = policyInfoList.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		basePool.clear();
		baseID = "";
		
		controller = ControllerFactory.getBaseController();
		ArrayList<BaseVO> baseVO =  controller.show(FindTypeBase.SalaryPolicy);
		
		for(int i = 0; i < baseVO.size(); i++){
			ArrayList<SalaryPolicy> rowData = baseVO.get(i).salaryPolicies;
			String[] rowData_1 = null ;
			for(int j=0;j<rowData.size();j++){
				String rowData2 = rowData.get(j).toString();
				rowData_1[j] = rowData2;	
			}
			tableModel.addRow(rowData_1);
			basePool.add(baseVO.get(i));	
		}
	}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("AddNewPolicy'")){
		//TODO -改vo和po后
		String[] data = policyInfoList.getData();
		if(policyDetails.getData()==null){
			this.add(new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED));
		}else{
			//TODO- 要改BaseVO 和 BasePO
			ResultMessage rsg = controller.addBase(new BaseVO(data[0], null, null, null));
			if(rsg.equals(ResultMessage.SUCCESS)){
				//System.out.println("AddSucceed!");
				this.showAll();
				this.add(new MyNotification(this,"策略添加成功！",Color.GREEN));
			}else{
				this.add(new MyNotification(this,"策略添加失败！",Color.RED));
			}
		}
	}else if(e.getActionCommand().equals("ViewPolicy")){
		
	}else if(e.getActionCommand().equals("DeletePolicy")){
		table = policyInfoList.getTable();
		if(table.getSelectedRowCount() == 0){
			this.add(new MyNotification(this,"请先选择要删除的策略！",Color.RED));
		}else{
		//	this.add(new MyNotification(this,"正在删除账户！",Color.GREEN));
			baseID = basePool.get(table.getSelectedRow()).id;
			//System.out.println(accountID);
			String[] data = new String[4];
			data[0] = baseID;
			data[1] = "";
			data[2] = "";
			data[3] = "";
			policyDetails.setData(data);
		}

	}else if(e.getActionCommand().equals("ModifyPolicy")){
		table = policyInfoList.getTable();
		if(table.getSelectedRowCount() == 0){
			this.add(new MyNotification(this,"请先选择要修改的员工！",Color.RED));
		}else{
			baseID = basePool.get(table.getSelectedRow()).id;
			//System.out.println(accountID);
			String[] data = new String[4];
			data[0] = baseID;
			data[1] = "";
			data[2] = "";
			data[3] = "";
			policyDetails.setData(data);
		}
	}else if(e.getActionCommand().equals("CheckModify")){
		table = policyInfoList.getTable();
		baseID = basePool.get(table.getSelectedRow()).id;
		if(table.getSelectedRow()==0){
			this.add(new MyNotification(this,"请先选择需要修改的员工！",Color.RED));
		}else{
			if(policyDetails.getData()==null){
				this.add(new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED));
			}else{
				this.add(new MyNotification(this,"正在修改策略信息！",Color.GREEN));
				this.modifyPolicy();
			}
		}
	}else if(e.getActionCommand().equals("CheckDelete")){
		table = policyInfoList.getTable();
		baseID = basePool.get(table.getSelectedRow()).id;
		if(table.getSelectedRow()==0){
			this.add(new MyNotification(this,"请先选择需要删除的员工！",Color.RED));
		}else{
				this.add(new MyNotification(this,"正在修改策略信息！",Color.GREEN));
				this.deletePolicy();
		}
	}else if(e.getActionCommand().equals("Search")){
		//TODO -改vo和po后
		table = policyInfoList.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		basePool.clear();
		baseID  = "";
		
		//"模糊查找", "账户编号(ID)", "账户名称", "账户余额
		ArrayList<BaseVO> baseVO = new ArrayList<BaseVO>();
		String[] data = policyDetails.getData();
		if(data!=null){
			switch(Integer.parseInt(data[0])){
				case 0 :// baseVO = controller.show(SalaryPolicy.BYTIMES)
				case 1 ://baseVO = controller.find();break;
				case 2 : //baseVO = controller.find();break;
				default :// baseVO = controller.find();break;
			}
		
			for(int i = 0; i <baseVO.size(); i++){
			String[] rowData = {};
			tableModel.addRow(rowData);
			basePool.add(baseVO.get(i));
			System.out.println("SearchSucceed!");
				this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个员工满足条件！",Color.GREEN));
			}	
			}else {
				this.add(new MyNotification(this,"请输入查询的薪水类型！",Color.RED));
			}
	}
	
}


private void deletePolicy() {
	table = policyInfoList.getTable();
	
	ResultMessage rsg = controller.deleteBase(basePool.get(table.getSelectedRow()).id);
	if(rsg.equals(ResultMessage.SUCCESS)){
		System.out.println("DeleteSucceed!");
		this.showAll();
		this.add(new MyNotification(this,"策略删除成功！",Color.GREEN));
	}else{
		this.add(new MyNotification(this,"策略删除失败！",Color.RED));
	}
	
}


private void modifyPolicy() {
	table = policyInfoList.getTable();
	String[] data = policyDetails.getData();
	ResultMessage rsg = controller.updateBase(new BaseVO(data[0], null, null, null));
	if(rsg.equals(ResultMessage.SUCCESS)){
		System.out.println("ModifySucceed!");
		this.showAll();
		this.add(new MyNotification(this,"策略修改成功！",Color.GREEN));		
	}else{
		this.add(new MyNotification(this,"策略修改失败！",Color.RED));
	}
}
	

}
