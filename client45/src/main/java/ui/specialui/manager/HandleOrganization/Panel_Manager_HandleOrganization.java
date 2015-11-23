package ui.specialui.manager.HandleOrganization;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import businesslogic.organizationbl.OrganizationController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;
import vo.BranchVO;
import vo.TransferVO;

@SuppressWarnings("unused")
public class Panel_Manager_HandleOrganization extends MyJPanel {
	private MyJButton commonButton;
	private Panel_Manager_OrganizationInfo organizationInfo;
	private OrganizationDetails organizationDetails;
	private OrganizationController organizationController;
	private BranchVO branch;
	private TransferVO transfer;
	
	private ArrayList<BranchVO> branchList;
	private ArrayList<TransferVO> transferList;
	public Panel_Manager_HandleOrganization(FrameManager frameManager) {
	
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frame_Manager) {
	
		this.add(new MyJLabel(550, 20, 210, 90, "公司机构信息管理", 24, true));
		
		organizationInfo= new Panel_Manager_OrganizationInfo(frame_Manager);
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
	commonButton.addActionListener(frame);
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
	
	//this.add(new MyJLabel(415, 110, 100, 40, "车辆代号", 20, true));
	//this.add(facilityId);
	
	commonButton = new MyJButton(890, 670, 150, 30, "修改机构信息", 20);
	commonButton.setActionCommand("ModifyorganizationInformation");
	commonButton.addActionListener(frame);
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
	commonButton.addActionListener(frame);
	this.add(commonButton);
	
	this.repaint();
}


/**
 * TODO 从bl层获取数据
 * 添加用户
 */

public int addOrganization() {
	String [] data = organizationDetails.getData();

	if(data == null){
		return 1;
	}
	if(data[4].equals("营业厅")){
		data[0] = organizationController.getID();
	//	branch = new BranchVO(name, name, name, null, null);
		organizationController.addOrganization(branch);
	}else if(data[4].equals("中转中心")){
		data[0] = organizationController.getID();
		//transfer = new TransferVO(name, name, flags, null, null);
		organizationController.addOrganization(transfer);
	}
	
	return 0;
	
}
/**
* 修改用户信息
* 从bl层获得数据
*/
public int modifyOrganization() {
	String [] data = organizationDetails.getData();
	if(data == null){
		return 1;
	}
	if(data[4].equals("营业厅")){
		branch.setId(data[0]);
		branch.setAddress(data[7]);
		organizationController.updateOrganization(branch);
	}else if(data[4].equals("中转中心")){
		organizationController.updateOrganization(transfer);
	}
	

	
	return 0;
}
/**
 * 删除用户
 * @return
 */
public int deleteOrganization() {
	String[] data = organizationDetails.getData();
	//现在列表中选择一个用户后再进行删除
	//TODO -
	if(data[4].equals("营业厅")){
		organizationController.deleteOrganization(branch);
	}else if(data[4].equals("中转中心")){
		organizationController.deleteOrganization(transfer);
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
public boolean searchOrganization() {		
	String type = organizationInfo.getData();
	if(type==null){
		return false;
	}else if(type.equals("营业厅")){
		//branchList = organizationController.show();
		return true;
	}else if(type.equals("中转中心")){
		//transferList = organizationController.show();
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
	private static final long serialVersionUID = 1L;

}
