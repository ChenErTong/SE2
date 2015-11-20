package ui.specialui.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.specialui.manager.AdjustBase.Panel_Manager_AddNewBase;
import ui.specialui.manager.AdjustBase.Panel_Manager_AdjustBase;
import ui.specialui.manager.AdjustBase.Panel_Manager_ModifyBase;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_AddNewPolicy;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_AdjustSalaryPolicy;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_ModifyPolicy;
import ui.specialui.manager.HandleOrganization.Panel_Manager_AddOrganization;
import ui.specialui.manager.HandleOrganization.Panel_Manager_HandleOrganization;
import ui.specialui.manager.HandleOrganization.Panel_Manager_ModifyOrganizationInfo;
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
	private Panel_Manager_ModifyOrganizationInfo modifyOrganizationInfo;
	private Panel_Manager_AddOrganization addOrganization;
	private Panel_Manager_AddNewPolicy addNewPolicy;
	private Panel_Manager_ModifyPolicy modifyPolicy;
	private Panel_Manager_AddNewBase addNewBase;
	private Panel_Manager_ModifyBase modifyBase;
	public FrameManager(){
		totalPanel = new Panel_Manager_Total(this);
		this.add(totalPanel);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("HandleReceipt")){
			totalPanel.setVisible(false);
			handleReceipt = new Panel_Manager_HandleReceipt(this);
			this.add(handleReceipt);
			this.getLayeredPane().add(handleReceipt,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("HandleOrganization")){
			//TODO
			totalPanel.setVisible(false);
			handleOrganization = new Panel_Manager_HandleOrganization(this);
			this.add(handleOrganization);
			this.getLayeredPane().add(handleOrganization,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AdjustBase")){
			//TODO
			totalPanel.setVisible(false);
			adjustBase = new Panel_Manager_AdjustBase(this);
			this.add(adjustBase);
			this.getLayeredPane().add(adjustBase,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("AdjustSalaryPolicy")){
			//TODO
			totalPanel.setVisible(false);
			adjustSalaryPolicy = new Panel_Manager_AdjustSalaryPolicy(this);
			this.add(adjustSalaryPolicy);
			this.getLayeredPane().add(adjustSalaryPolicy,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewUser")){
			//TODO
			totalPanel.setVisible(false);
			viewUser = new Panel_Manager_ViewUser(this);
			this.add(viewUser);
			this.getLayeredPane().add(viewUser,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			//TODO
			totalPanel.setVisible(false);
			viewIncomeStatement = new Panel_Manager_ViewIncomeStatement(this);
			this.add(viewIncomeStatement);
			this.getLayeredPane().add(viewIncomeStatement,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			//TODO
			totalPanel.setVisible(false);
			viewBusinessPerformance = new Panel_Manager_ViewBusinessPerformance(this);
			this.add(viewBusinessPerformance);
			this.getLayeredPane().add(viewBusinessPerformance,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}else if(e.getActionCommand().equals("ModifyReceiptInfo")){
			handleReceipt.setVisible(false);
			modifyReceiptInfo = new Panel_Manager_ModifyReceiptInfo();
			this.add(modifyReceiptInfo);
			this.getLayeredPane().add(modifyReceiptInfo,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ModifyOrganizationInfo")){
			handleOrganization.setVisible(false);
			modifyOrganizationInfo = new Panel_Manager_ModifyOrganizationInfo();
			this.add(modifyOrganizationInfo);
			this.getLayeredPane().add(modifyOrganizationInfo,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AddOrganization")){
			handleOrganization.setVisible(false);
			addOrganization = new Panel_Manager_AddOrganization();
			this.add(addOrganization);
			this.getLayeredPane().add(addOrganization,new Integer(Integer.MAX_VALUE));
			
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
	
}
