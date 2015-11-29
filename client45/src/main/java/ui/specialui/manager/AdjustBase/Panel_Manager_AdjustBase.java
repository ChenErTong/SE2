package ui.specialui.manager.AdjustBase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.baseblservice.BaseBLService;
import state.FindTypeBase;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.BankAccountVO;
import vo.BaseVO;


public class Panel_Manager_AdjustBase extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private AddBase addBase;
	private ModifyAccountInfo modifyBase;
	private BaseInfoList baseInfo;
	private MyJButton add;
	private MyJButton modify;
	private MyJButton deleteButton;
	private MyJButton modifyButton;
	private MyJTable table;
	private BaseBLService controller = ControllerFactory.getBaseController();
	static ArrayList<BaseVO> basePool;
	static String baseID = " ";
	public Panel_Manager_AdjustBase(FrameManager frameManager) {
		
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
		
	}
	

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司成本常量制定", 24, true));
		addBase = new AddBase();
		this.add(addBase);
		modifyBase = new ModifyAccountInfo();
		this.add(modifyBase);
		//baseDetails = new BaseDetails();
		//baseDetails.setEnabled(false);
		//this.add(baseDetails);
		basePool = new ArrayList<BaseVO>();
		baseInfo = new BaseInfoList(this);
		this.add(baseInfo);
		deleteButton = new MyJButton(150,660,180,30,"删除所选常量",16);
		deleteButton.setActionCommand("DeleteBase");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyJButton(350,660,180,30,"修改所选常量信息",16);
		modifyButton.setActionCommand("ModifyBase");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
	
		add = new MyJButton(880,346,120,30,"确认添加",16);	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(880,640,120,30,"确认修改",16);	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);

		//this.initButton(frameManager);
		this.showAll();
		
		
	}
	private void initButton(FrameManager frame) {
	/*	MyJButton insertButton = new MyJButton(75, 665, 120, 40,
				"添加常量", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustBase.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);*/

	/*	MyJButton modifyButton = new MyJButton(205, 665, 120, 40,
				"修改所选常量", 18);
		/*modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustBase.this.modifyPanel(frame);
				
			}
		});*/
//		modifyButton.setActionCommand("ModifyBase");
	//	modifyButton.addActionListener(this);
		//this.add(modifyButton);

		/*MyJButton searchButton = new MyJButton(335, 660, 130, 40,
				"查看所选常量", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustBase.this.searchPanel(frame);
				
			}
		});
		searchButton.setActionCommand("ViewBase");
		searchButton.addActionListener(this);
		this.add(searchButton);*/

	//	MyJButton deleteButton = new MyJButton(465,  660, 130, 40,
			//	"删除所选常量", 18);
		/*deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_AdjustBase.this.deletePanel(frame);
				
			}
		});*/
		//deleteButton.setActionCommand("DeleteBase");
		//deleteButton.addActionListener(this);
		//this.add(deleteButton);
//		deleteButton = new MyJButton(150,640,180,30,"删除所选账户",16);
//		deleteButton.setActionCommand("DeleteBankAccount");
//		deleteButton.addActionListener(this);
		//this.add(deleteButton);
		
/*		modifyButton = new MyJButton(350,640,180,30,"修改所选账户信息",16);
		modifyButton.setActionCommand("ModifyBankAccount");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
	
		add = new MyJButton(868,346,120,30,"确认添加",16);	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(868,640,120,30,"确认修改",16);	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);*/

	}
	

	/*private void insertPanel(FrameManager frame) {
	this.removeAll();
	this.add(baseInfo);
	this.add(new MyJLabel(530, 20, 250, 90, "公司成本常量制定", 24, true));
	this.initButton(frame);

	
	baseDetails = new BaseDetails();
	baseDetails.add(new MyJLabel(230,5,120,30,"新增常量",18,true));
	this.add(baseDetails);
	
	
	commonButton = new MyJButton(890, 670, 120, 30, "添加常量", 20);
	commonButton.setActionCommand("CheckAdd");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void modifyPanel(FrameManager frame) {
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司成本常量制定", 24, true));
	this.add(baseInfo);
	this.initButton(frame);
	
	baseDetails = new BaseDetails();
	baseDetails.add(new MyJLabel(230,5,120,30,"修改常量信息",18,true));
	this.add(baseDetails);
	
	commonButton = new MyJButton(890, 670, 150, 30, "修改常量信息", 20);
	commonButton.setActionCommand("CheckModify");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void searchPanel(FrameManager frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司成本常量制定", 24, true));
	this.add(baseInfo);
	this.initButton(frame);
	
	baseDetails = new BaseDetails();
	baseDetails.setUneditable();
	baseDetails.add(new MyJLabel(230,5,120,30,"查看常量信息",18,true));
	this.add(baseDetails);
	
	this.repaint();
}

private void deletePanel(FrameManager frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530,20, 250, 90, "公司成本常量制定", 24, true));
	this.add(baseInfo);
	this.initButton(frame);
	
	baseDetails = new BaseDetails();
	baseDetails.setUneditable();
	baseDetails.add(new MyJLabel(230,5,120,30,"删除常量",18,true));
	this.add(baseDetails);
	
	commonButton = new MyJButton(890, 670, 120, 30, "删除常量", 20);
	commonButton.setActionCommand("CheckDelete");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}*/
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

private void showAll() {
	table = baseInfo.getTable();
	DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	
	int rowCount = table.getRowCount();
	
	for(int i = 0; i < rowCount; i++){
		tableModel.removeRow(0);
	}
	
	basePool.clear();
	baseID = "";
	//ArrayList<BaseVO> baseVO = controller.show(baseTy);
	
	/*for(int i = 0; i < baseVO.size(); i++){
		String[] rowData = {baseVO.get(i).ID,
				baseVO.get(i).name, String.valueOf(baseVO.get(i).money)+"元"};
		tableModel.addRow(rowData);
		basePool.add(baseVO.get(i));
	}*/
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("CheckAdd")){
		//TODO -改vo和po后
		String[] data = baseInfo.getData();
		if(addBase.getData()==null){
			this.add(new MyNotification(this,"请检查常量信息填写是否完整！",Color.RED));
		}else{
			//TODO- 
		//	ResultMessage rsg = controller.addBase(new BaseVO(controller.getID(baseType),data[0],data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3])));
		//	if(rsg.equals(ResultMessage.SUCCESS)){
				//System.out.println("AddSucceed!");
			//	this.showAll();
				new MyNotification(this,"常量添加成功！",Color.GREEN);
			//}else{
				new MyNotification(this,"常量添加失败！",Color.RED);
			//}
		}
	}else if(e.getActionCommand().equals("DeleteBase")){
		table = baseInfo.getTable();
		if(table.getSelectedRowCount() == 0){
			new MyNotification(this,"请先选择要删除的常量！",Color.RED);
		}else{
			new MyNotification(this,"正在删除常量！！",Color.RED);
			this.deleteBase();
		}
	}else if(e.getActionCommand().equals("ModifyBase")){
		table = baseInfo.getTable();
		if(table.getSelectedRowCount() == 0){
			new MyNotification(this,"请先选择要修改的员工！",Color.RED);
		}else{
			baseID = basePool.get(table.getSelectedRow()).ID;
			//System.out.println(accountID);
			String[] data = new String[4];
			data[0] = basePool.get(table.getSelectedRow()).cityFrom;
			data[1] = basePool.get(table.getSelectedRow()).cityTo;
			data[2] = basePool.get(table.getSelectedRow()).distance+"";
			data[3] = basePool.get(table.getSelectedRow()).price+"";
			modifyBase.setData(data);
		}
	}else if(e.getActionCommand().equals("CheckModify")){
		table = baseInfo.getTable();
		baseID = basePool.get(table.getSelectedRow()).ID;
		if(table.getSelectedRow()==0){
			new MyNotification(this,"请先选择需要修改的员工！",Color.RED);
		}else{
			if(modifyBase.getData()==null){
				new MyNotification(this,"请检查策略信息填写是否完整！",Color.RED);
			}else{
				new MyNotification(this,"正在修改策略信息！",Color.GREEN);
				this.modifyBase();
			}
		}
	}else if(e.getActionCommand().equals("SearchBase")){
		table = baseInfo.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		basePool.clear();
		baseID  = "";
		
		//"模糊查找", "账户编号(ID)", "账户名称", "账户余额
		ArrayList<BaseVO> baseVO = new ArrayList<BaseVO>();
		String[] data = baseInfo.getData();
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
				this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个常量满足条件！",Color.GREEN));
			}	
			}else {
				this.add(new MyNotification(this,"请输入查询的常量类型！",Color.RED));
			}
	}
	
}


	private void modifyBase() {
	table = baseInfo.getTable();
	String[] data = modifyBase.getData();
//	ResultMessage rsg = controller.updateBase(new BaseVO(data[0], null, null, null));
	//if(rsg.equals(ResultMessage.SUCCESS)){
		//System.out.println("ModifySucceed!");
		//this.showAll();
		//this.add(new MyNotification(this,"常量修改成功！",Color.GREEN));		
	//}else{
		//this.add(new MyNotification(this,"常量修改失败！",Color.RED));
	//}
	
	}


	private void deleteBase() {
		table =  baseInfo.getTable();
	
		ResultMessage rsg = controller.deleteBase(basePool.get(table.getSelectedRow()).ID);
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("DeleteSucceed!");
			this.showAll();
			this.add(new MyNotification(this,"常量删除成功！",Color.GREEN));
		}else{
			this.add(new MyNotification(this,"常量删除失败！",Color.RED));
		}
	
	}
}
