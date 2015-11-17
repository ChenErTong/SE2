package ui.specialui.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import ui.image.CommonImage;
import ui.myui.MyJFrame;


public class FrameManager extends MyJFrame implements ActionListener{
private static final long serialVersionUID = 1L;
	
	Panel_Manager_Total totalPanel;
	Panel_Manager_HandleReceipt handleReceipt;
	Panel_Manager_HandleOrganization handleOrganization;
	Panel_Manager_AdjustBase adjustBase;
	Panel_Manager_AdjustSalaryPolicy adjustSalaryPolicy;
	Panel_Manager_ViewUser viewUser;
	Panel_Manager_ViewIncomeStatement viewIncomeStatement;
	Panel_Manager_ViewBusinessPerformance viewBusinessPerformance;
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
			totalPanel.setVisible(false);
			viewBusinessPerformance = new Panel_Manager_ViewBusinessPerformance(this);
			this.add(viewBusinessPerformance);
			this.getLayeredPane().add(viewBusinessPerformance,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}
	}

	
}
