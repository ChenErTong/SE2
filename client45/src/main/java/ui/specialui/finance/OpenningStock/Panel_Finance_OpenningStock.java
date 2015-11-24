package ui.specialui.finance.OpenningStock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;


public class Panel_Finance_OpenningStock extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private Panel_Finance_OpenningStockInfo openningStockInfo;
	private OpenningStockList openningStockList;
	private MyJButton commonButton;
	public Panel_Finance_OpenningStock(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司期初建账管理", 24, true));
		openningStockInfo = new Panel_Finance_OpenningStockInfo();
		openningStockInfo.setEnabled(false);
		this.add(openningStockInfo);
		
		openningStockList = new OpenningStockList(frame_Finance);
		this.add(openningStockList);
		this.initButton(frame_Finance);
	
		
	}
	private void initButton(Frame_Finance frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>期<br/>初<br/>账<br/>目<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_OpenningStock.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

	

		MyJButton searchButton = new MyJButton(0, 280, 40, 130,
				"<html>查<br/>看<br/>期<br/>初<br/>账<br/>目<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_OpenningStock.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);
	}
	
	

	private void insertPanel(Frame_Finance frame) {
	this.removeAll();
	this.add(openningStockList);
	this.add(new MyJLabel(530, 20, 250, 90, "公司期初建账管理", 24, true));
	this.initButton(frame);

	
	openningStockInfo = new Panel_Finance_OpenningStockInfo();
	openningStockInfo.add(new MyJLabel(230,5,120,30,"新增期初账目",18,true));
	this.add(openningStockInfo);
	
	
	commonButton = new MyJButton(890, 670, 150, 30, "新增期初账目", 20);
	commonButton.setActionCommand("AddNewStock");
	commonButton.addActionListener(frame);
	this.add(commonButton);
	
	this.repaint();
}


private void searchPanel(Frame_Finance frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司期初建账管理", 24, true));
	this.add(openningStockList);
	this.initButton(frame);
	
	openningStockInfo = new Panel_Finance_OpenningStockInfo();
	openningStockInfo.setUneditable();
	openningStockInfo.add(new MyJLabel(230,5,150,30,"查看期初账目",18,true));
	this.add(openningStockInfo);
	
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

}
