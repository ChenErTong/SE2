package ui.specialui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.specialui.finance.BankAccountManage.Panel_Finance_BankAccountManage;
import ui.specialui.finance.CostManage.Panel_Finance_CostManagement;
import ui.specialui.finance.OpenningStock.Panel_Finance_AddNewStock;
import ui.specialui.finance.OpenningStock.Panel_Finance_OpenningStock;
import ui.specialui.finance.SettlementManage.Panel_Finance_SettlementManage;
import ui.specialui.finance.ViewBusinessPerformance.Panel_Finance_ViewBusinessPerformance;
import ui.specialui.finance.ViewIncomeState.Panel_Finance_ViewIncomeStatement;



public class Frame_Finance  extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private Panel_Finance_Total totalPanel;
	private Panel_Finance_CostManagement costManagePanel;
	private Panel_Finance_SettlementManage  settleManagePanel;
	private Panel_Finance_OpenningStock openningStockPanel;
	private Panel_Finance_ViewBusinessPerformance viewBusinessPerformance;
	private Panel_Finance_ViewIncomeStatement viewIncomeStatement;
	private MyJPanel subPanel ;
	private Panel_Finance_AddNewStock addNewStock;
	private Panel_Finance_BankAccountManage bankAccountManage;
	public Frame_Finance(){
		totalPanel = new Panel_Finance_Total(this);
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
		}else if(e.getActionCommand().equals("CostManage")){
			totalPanel.setVisible(false);
			subPanel = new Panel_Finance_CostManagement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("SettlementManage")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Finance_SettlementManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("OpenningStock")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Finance_OpenningStock(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("BankAccountManage")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Finance_BankAccountManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Finance_ViewBusinessPerformance(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Finance_ViewIncomeStatement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		
		}else if(e.getActionCommand().equals("Withdraw")){
			totalPanel.setVisible(false);
		}else if(e.getActionCommand().equals("AddNewStock")){
			openningStockPanel.setVisible(false);
			addNewStock = new Panel_Finance_AddNewStock();
			this.add(addNewStock);
			this.getLayeredPane().add(addNewStock,new Integer(Integer.MAX_VALUE));
		}

	}
}

