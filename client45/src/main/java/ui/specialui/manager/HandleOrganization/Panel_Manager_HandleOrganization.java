package ui.specialui.manager.HandleOrganization;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.organizationbl.OrganizationController;
import businesslogicservice.fundblservice.BankAccountBLService;
import businesslogicservice.organizationblservice.OrganizationBLService;
import state.FindTypeAccount;
import state.OrganizationType;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.BankAccountVO;
import vo.BranchVO;
import vo.OrganizationVO;
import vo.TransferVO;

@SuppressWarnings("unused")
public class Panel_Manager_HandleOrganization extends MyJPanel implements ActionListener{
	private MyJButton commonButton;
	private Panel_Manager_OrganizationInfo organizationInfo;
	private OrganizationDetails organizationDetails;
	private BranchVO branch;
	private TransferVO transfer;
	
	private ArrayList<BranchVO> branchList;
	private ArrayList<TransferVO> transferList;
	private MyJTable table;
	
	static MyJButton check;
	static ArrayList<OrganizationVO> organizationPool;
	static ArrayList<TransferVO> transferPool;
	static ArrayList<BranchVO> branchPool;
	static String organizationID= " ";

	OrganizationBLService controller;
	public Panel_Manager_HandleOrganization(FrameManager frameManager) {
	
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		organizationPool = new ArrayList<OrganizationVO>();
		transferPool = new ArrayList<TransferVO>();
		branchPool = new ArrayList<BranchVO>();
		this.initComponent(frameManager);
		this.showAll();
	}

	

	private void initComponent(FrameManager frame_Manager) {
	
		this.add(new MyJLabel(550, 20, 210, 90, "公司机构信息管理", 24, true));
		
		organizationInfo= new Panel_Manager_OrganizationInfo(this);
		this.add(organizationInfo);
		
		organizationDetails = new OrganizationDetails();
		organizationDetails.setUneditable();
		this.add(organizationDetails);
		this.initButton(frame_Manager);
	}
	
	private void initButton(FrameManager frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>机<br/>构<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_HandleOrganization.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(0, 280, 40, 130,
				"<html>修<br/>改<br/>机<br/>构<br/>信<br/>息<br/></html>", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_HandleOrganization.this.modifyPanel(frame);
				
			}
		});
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(0, 410, 40, 130,
				"<html>查<br/>看<br/>机<br/>构<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_HandleOrganization.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(0, 540, 40, 110,
				"<html>删<br/>除<br/>机<br/>构<br/></html>", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Manager_HandleOrganization.this.deletePanel(frame);
				
			}
		});
		this.add(deleteButton);
		
		check = new MyJButton(450,670,200,40,"查看所选机构信息",20);
		check.setActionCommand("ConfirmCheck");
		check.addActionListener(this);
		this.add(check);
	}
	

	private void insertPanel(FrameManager frame) {
	this.removeAll();
	this.add(organizationInfo);
	this.add(new MyJLabel(550, 20, 210, 90, "公司机构信息管理", 24, true));
	this.initButton(frame);

	
	organizationDetails = new OrganizationDetails();
	organizationDetails.add(new MyJLabel(230,5,120,30,"新增机构",18,true));
	this.add(organizationDetails);
	
	
	commonButton = new MyJButton(890, 670, 120, 30, "添加机构", 20);
	commonButton.setActionCommand("AddOrganization");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void modifyPanel(FrameManager frame) {
	this.removeAll();
	this.add(new MyJLabel(550, 20, 210, 90, "公司机构信息管理", 24, true));
	this.add(organizationInfo);
	this.initButton(frame);
	
	organizationDetails = new OrganizationDetails();
	organizationDetails.add(new MyJLabel(230,5,120,30,"修改机构信息",18,true));
	this.add(organizationDetails);
	
	commonButton = new MyJButton(890, 670, 150, 30, "修改机构信息", 20);
	commonButton.setActionCommand("ModifyorganizationInformation");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void searchPanel(FrameManager frame) {
	
	this.removeAll();
	this.add(new MyJLabel(550, 20, 210, 90, "公司机构信息管理", 24, true));
	this.add(organizationInfo);
	this.initButton(frame);
	
	organizationDetails = new OrganizationDetails();
	organizationDetails.setUneditable();
	organizationDetails.add(new MyJLabel(230,5,120,30,"查看机构信息",18,true));
	this.add(organizationDetails);
	
	this.repaint();
}

private void deletePanel(FrameManager frame) {
	
	this.removeAll();
	this.add(new MyJLabel(550,20, 210, 90, "公司机构信息管理", 24, true));
	this.add(organizationInfo);
	this.initButton(frame);
	
	organizationDetails = new OrganizationDetails();
	organizationDetails.setUneditable();
	organizationDetails.add(new MyJLabel(230,5,120,30,"删除机构",18,true));
	this.add(organizationDetails);
	
	commonButton = new MyJButton(890, 670, 120, 30, "删除机构", 20);
	commonButton.setActionCommand("DeleteOrganization");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}


/**
 * TODO 从bl层获取数据
 * 添加用户
 */

/*public int addOrganization() {
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
	branch.id=data[0];
	branch.address=data[7];
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
public boolean vieworganizationDetails(){
	//TODO
	//从organizationList中选择一个要查看的用户
	return false;
}

/**
 * 显示所有的银行账号
 */
public void showAll(){
		table = (MyJTable) organizationInfo.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		organizationPool.clear();
		organizationID = "";
		
		OrganizationBLService controller = ControllerFactory.getOrganizationController();
		ArrayList<TransferVO> transferVO = controller.showTransfer();
		ArrayList<BranchVO> branchVO = controller.showBranch();
		for(int i=0;i<transferVO.size();i++){
			Object [] rowData1 = {transferVO.get(i).organizationID,transferVO.get(i).organizationType,transferVO.get(i).number,
					transferVO.get(i).date,transferVO.get(i).inventories,transferVO.get(i).accounts,transferVO.get(i).address};
			tableModel.addRow(rowData1);
			organizationPool.add(transferVO.get(i));
			
		}
		for(int i=0;i<branchVO.size();i++){
			Object[] rowData2 = {branchVO.get(i).organizationID,branchVO.get(i).organizationType,branchVO.get(i).number,branchVO.get(i).date
					,branchVO.get(i).facilities,branchVO.get(i).accounts,branchVO.get(i).address};
			tableModel.addRow(rowData2);
			organizationPool.add(branchVO.get(i));
 		}
	}

	private static final long serialVersionUID = 1L;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SearchOrganization")){
			table = (MyJTable)organizationInfo.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			organizationPool.clear();
			organizationID = "";
			//营业厅、中转中心
			controller = ControllerFactory.getOrganizationController();
			
			ArrayList<TransferVO> transferVO = new ArrayList<TransferVO>();
			ArrayList<BranchVO> branchVO = new ArrayList<BranchVO>();
			String data = organizationInfo.getData();
			if(data!=null){
				switch(Integer.parseInt(data)){
					case 0 : transferVO = controller.showTransfer(); branchVO = controller.showBranch(); break;
					case 1 : branchVO = controller.showBranch();
					case 2 : transferVO = controller.showTransfer();
				}
				for(int i=0;i<transferVO.size();i++){
					Object[] rowData1 ={transferVO.get(i).organizationID,transferVO.get(i).organizationType,transferVO.get(i).number,
							transferVO.get(i).date,transferVO.get(i).inventories,transferVO.get(i).accounts,transferVO.get(i).address};
					tableModel.addRow(rowData1);
					organizationPool.add(transferVO.get(i));
				}
				for(int i=0;i<branchVO.size();i++){
					Object[] rowData2 = {branchVO.get(i).organizationID,branchVO.get(i).organizationType,branchVO.get(i).number,branchVO.get(i).date
							,branchVO.get(i).facilities,branchVO.get(i).accounts,branchVO.get(i).address};
					tableModel.addRow(rowData2);
					organizationPool.add(branchVO.get(i));
		 		}
				this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个机构满足条件！",Color.GREEN));
				
			}else{
				this.add(new MyNotification(this,"请输入要查询的机构类型！",Color.RED));
			}
		}else if(e.getActionCommand().equals("AddOrganization")){
			String[] data = organizationDetails.getData();
			controller = ControllerFactory.getOrganizationController();
			if(data==null){
				this.add(new MyNotification(this,"请检查机构信息填写是否完整！",Color.RED));
			}else{
				if(data[4].equals("营业厅")){
					//TODO 
					//ResultMessage rsg = controller.addBranch(new BranchVO(controller.getBranchID(data[6]),controller.,data[5]+data[6]+data[7],null,null,null));
				//	if(rsg.equals(ResultMessage.SUCCESS)){
						//System.out.println("AddSucceed!");
						this.showAll();
						this.add(new MyNotification(this,"账户添加成功！",Color.GREEN));

				}else{
					//TODO 
					//ResultMessage rsg = controller.addTransfer(new TransferVO(controller.getTransferID(data[6])));
					//if(rsg.equals(ResultMessage.SUCCESS)){
						this.showAll();
						this.add(new MyNotification(this,"账户添加成功！",Color.GREEN));
			
				}		
			}
		}else if(e.getActionCommand().equals("DeleteOrganization")){
			if(table.getSelectedRowCount() == 0){
				this.add(new MyNotification(this,"请先选择要删除的机构！",Color.RED));
			}else{
				this.add(new MyNotification(this,"正在删除账户！",Color.GREEN));
				this.deleteOrganization();
			}
		}else if(e.getActionCommand().equals("ModifyOrganizationInfo")){
			table =organizationInfo.getTable();
			if(table.getSelectedRowCount() == 0){
				this.add(new MyNotification(this,"请先选择要修改的账户！",Color.RED));
			}else{
				switch(organizationPool.get(table.getSelectedRow()).organizationType){
				case TRANSFER:Object[] data = new String[7];
				organizationID = organizationPool.get(table.getSelectedRow()).organizationID;
				data[0] = organizationID;
				data[1] =  organizationPool.get(table.getSelectedRow()).organizationType;
				data[3] =  organizationPool.get(table.getSelectedRow()).date;
				data[2] = organizationPool.get(table.getSelectedRow()).number;
				data[4] = transferPool.get(table.getSelectedRow()).inventories;
				data[5] = transferPool.get(table.getSelectedRow()).accounts;
				data[6] =transferPool.get(table.getSelectedRow()).address;
				String[] data2 = (String[]) data;
				organizationDetails.setData(data2);
				case BRANCH:
					Object[] data_2 = new String[7];
					organizationID = organizationPool.get(table.getSelectedRow()).organizationID;
					data_2[0] = organizationID;
					data_2[1] =  organizationPool.get(table.getSelectedRow()).organizationType;
					data_2[3] =  organizationPool.get(table.getSelectedRow()).date;
					data_2[2] = organizationPool.get(table.getSelectedRow()).number;
					data_2[4] = branchPool.get(table.getSelectedRow()).facilities;
					data_2[5] = branchPool.get(table.getSelectedRow()).accounts;
					data_2[6] =branchPool.get(table.getSelectedRow()).address;
					String[] data2_2 = (String[]) data_2;
					organizationDetails.setData(data2_2);
				}
			}
		
		}else if(e.getActionCommand().equals("ConfirmCheck")){
			table =organizationInfo.getTable();
			
			organizationID=organizationPool.get(table.getSelectedRow()).organizationID;
			if(table.getSelectedRow()==0){
				this.add(new MyNotification(this,"请先选择需要修改的账户！",Color.RED));
			}else{
				if(organizationDetails.getData()==null){
					this.add(new MyNotification(this,"请检查账户信息填写是否完整！",Color.RED));
				}else{
					this.add(new MyNotification(this,"正在修改账户信息！",Color.GREEN));
					this.modifyOrganization();
				}
			}
		}

	}



	private void modifyOrganization() {
		controller = ControllerFactory.getOrganizationController();
		table = organizationInfo.getTable();
		String[] data = organizationDetails.getData();
		switch(organizationPool.get(table.getSelectedRow()).organizationType){
		case TRANSFER:ResultMessage rsg = controller.updateTransfer(new TransferVO(organizationID, data[0], data[1], null, null));
						if(rsg.equals(ResultMessage.SUCCESS)){
							System.out.println("ModifySucceed!");
							this.showAll();
							this.add(new MyNotification(this,"中转中心信息修改成功！",Color.GREEN));		
						}else{
							this.add(new MyNotification(this,"中转中心信息修改失败！",Color.RED));
						}break;
		case BRANCH:ResultMessage rsg1 = controller.updateBranch(new BranchVO(organizationID, data[0], data[1], null, null));
					if(rsg1.equals(ResultMessage.SUCCESS)){
						this.showAll();
						this.add(new MyNotification(this,"营业厅信息修改成功！",Color.GREEN));
					}else{
						this.add(new MyNotification(this,"营业厅信息修改失败！",Color.RED));
					}
	}
	}



	private void deleteOrganization() {
		controller = ControllerFactory.getOrganizationController();
		switch(organizationPool.get(table.getSelectedRow()).organizationType){
		case TRANSFER:ResultMessage rsg = controller.deleteTransfer(organizationPool.get(table.getSelectedRow()).organizationID);
						if(rsg.equals(ResultMessage.SUCCESS)){
							this.showAll();
							this.add(new MyNotification(this,"账户删除成功！",Color.GREEN));
						}else{
							this.add(new MyNotification(this,"账户删除失败！",Color.RED));
						}
						break;
		case BRANCH:ResultMessage rsg1 = controller.deleteBranch(organizationPool.get(table.getSelectedRow()).organizationID);
					if(rsg1.equals(ResultMessage.SUCCESS)){
						System.out.println("DeleteSucceed!");
						this.showAll();
						this.add(new MyNotification(this,"账户删除成功！",Color.GREEN));
					}else{
						this.add(new MyNotification(this,"账户删除失败！",Color.RED));
					}
					break;
		
		default:
			break;
		}
		
	}

}
