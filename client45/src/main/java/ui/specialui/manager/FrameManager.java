package ui.specialui.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.manager.AdjustBase.Panel_Manager_AddNewBase;
import ui.specialui.manager.AdjustBase.Panel_Manager_AdjustBase;
import ui.specialui.manager.AdjustBase.Panel_Manager_ModifyBase;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_AddNewPolicy;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_AdjustSalaryPolicy;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_ModifyPolicy;
import ui.specialui.manager.HandleOrganization.Panel_Manager_HandleOrganization;
import ui.specialui.manager.HandleReceipt.Panel_Manager_HandleReceipt;
import ui.specialui.manager.HandleReceipt.Panel_Manager_ModifyReceiptInfo;
import ui.specialui.manager.ViewBusinessPerformance.Panel_Manager_ViewBusinessPerformance;
import ui.specialui.manager.ViewIncomeState.Panel_Manager_ViewIncomeStatement;


public class FrameManager extends MyJFrame implements ActionListener{
private static final long serialVersionUID = 1L;
	
	private Panel_Manager_Total totalPanel;
	private Panel_Manager_HandleReceipt handleReceipt;
	private Panel_Manager_HandleOrganization handleOrganization;
	private Panel_Manager_AdjustBase adjustBase;
	private Panel_Manager_AdjustSalaryPolicy adjustSalaryPolicy;
	private Panel_Manager_ViewUser viewUser;
	private Panel_Manager_ViewIncomeStatement viewIncomeStatement;
	private Panel_Manager_ViewBusinessPerformance viewBusinessPerformance;
	private Panel_Manager_ModifyReceiptInfo modifyReceiptInfo;
	
	private Panel_Manager_AddNewPolicy addNewPolicy;
	private Panel_Manager_ModifyPolicy modifyPolicy;
	private Panel_Manager_AddNewBase addNewBase;
	private Panel_Manager_ModifyBase modifyBase;
	private MyJPanel subPanel;
	public FrameManager(){
		totalPanel = new Panel_Manager_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("HandleReceipt")){
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_HandleReceipt(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("HandleOrganization")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_HandleOrganization(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AdjustBase")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_AdjustBase(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("AdjustSalaryPolicy")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_AdjustSalaryPolicy(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewUser")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_ViewUser(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_ViewIncomeStatement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_ViewBusinessPerformance(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}else if(e.getActionCommand().equals("AddOrganization")){
			if(this.addOrganization()){
				((Panel_Manager_HandleOrganization)subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("ModifyOrganizationInfomation")){
			if(this.modifyOrganizationInfo()){
				((Panel_Manager_HandleOrganization)subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("DeleteOrganization")){
			if(this.deleteOrganization()){
				((Panel_Manager_HandleOrganization)subPanel).refresh();
			}
		}
		else if(e.getActionCommand().equals("ModifyReceiptInfo")){
	
			handleReceipt.setVisible(false);
			modifyReceiptInfo = new Panel_Manager_ModifyReceiptInfo();
			this.add(modifyReceiptInfo);
			this.getLayeredPane().add(modifyReceiptInfo,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AddNewPolicy")){
			adjustSalaryPolicy.setVisible(false);
			addNewPolicy = new Panel_Manager_AddNewPolicy();
			this.add(addNewPolicy);
			this.getLayeredPane().add(addNewPolicy,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ModifyPolicy")){
			adjustSalaryPolicy.setVisible(false);
			modifyPolicy = new Panel_Manager_ModifyPolicy();
			this.add(modifyPolicy);
			this.getLayeredPane().add(modifyPolicy,new Integer(Integer.MAX_VALUE));
		
		}else if(e.getActionCommand().equals("AddNewBase")){
			adjustBase.setVisible(false);
			addNewBase = new Panel_Manager_AddNewBase();
			this.add(addNewBase);
			this.getLayeredPane().add(addNewBase,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ModifyBase")){
			adjustBase.setVisible(false);
			modifyBase = new Panel_Manager_ModifyBase();
			this.add(modifyBase);
			this.getLayeredPane().add(modifyBase,new Integer(Integer.MAX_VALUE));
		}
	}
	
	/**
	 * 添加新用户
	 * @return 是否成功添加
	 * 与bl层连接
 	 */
	private boolean addOrganization(){
		switch(((Panel_Manager_HandleOrganization)subPanel).addOrganization()){
		case 0: new MyNotification(this, "成功添加新机构", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成新机构信息填写", Color.RED); break;
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * @return 是否修改成功
	 * 与bl层连接
	 */
	private boolean modifyOrganizationInfo(){
		switch(((Panel_Manager_HandleOrganization)subPanel).modifyOrganization()){
		case 0: new MyNotification(this, "成功修改机构信息", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成机构信息修改", Color.RED); break;
		}
		return false;
	}
	
	private boolean deleteOrganization(){
		switch(((Panel_Manager_HandleOrganization)subPanel).deleteOrganization()){
		case 0: new MyNotification(this, "删除成功", Color.GREEN); return true;
		}
		return false;
	}
}
