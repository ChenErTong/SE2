package ui.specialui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.finance.BankAccountManage.Panel_Finance_BankAccountManage;
import ui.specialui.finance.CostManage.Panel_Finance_CostManagement;
import ui.specialui.finance.OpenningStock.Panel_Finance_OpenningStock;
import ui.specialui.finance.SettlementManage.Panel_Finance_SettlementManage;
import ui.specialui.finance.ViewBusinessPerformance.Panel_Finance_ViewBusinessPerformance;
import ui.specialui.finance.ViewIncomeState.Panel_Finance_ViewIncomeStatement;
import ui.specialui.manager.HandleOrganization.Panel_Manager_HandleOrganization;



public class Frame_Finance  extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private Panel_Finance_Total totalPanel;
	private Panel_Finance_CostManagement costManagePanel;
	private Panel_Finance_SettlementManage  settleManagePanel;
	private Panel_Finance_OpenningStock openningStockPanel;
	private Panel_Finance_ViewBusinessPerformance viewBusinessPerformance;
	private Panel_Finance_ViewIncomeStatement viewIncomeStatement;
	private MyJPanel subPanel ;
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
			
		}else if(e.getActionCommand().equals("AddDebitReceipt")){
			
		}else if(e.getActionCommand().equals("ModifyDebitReceipt")){
			
		}else if(e.getActionCommand().equals("CalculateAllDebit")){
			
		}else if(e.getActionCommand().equals("SearchDebitReceipt")){
			
		}else if(e.getActionCommand().equals("AddBankAccount")){
			if(this.addBankAccount()){
				((Panel_Finance_BankAccountManage)subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("ModifyBankAccount")){
			if(this.modifyBankAccountInfo()){
				((Panel_Finance_BankAccountManage)subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("DeleteBankAccount")){
			if(this.deleteBankAccount()){
				((Panel_Finance_BankAccountManage)subPanel).refresh();
			}
		}

	}
	/**
	 * 添加新银行账户
	 * @return 是否成功添加
	 * 与bl层连接
 	 */
	private boolean addBankAccount(){
		switch(((Panel_Finance_BankAccountManage)subPanel).addAccount()){
		case 0: new MyNotification(this, "成功添加新银行账户", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成新银行账户信息填写", Color.RED); break;
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * @return 是否修改成功
	 * 与bl层连接
	 */
	private boolean modifyBankAccountInfo(){
		switch(((Panel_Finance_BankAccountManage)subPanel).modifyBankAccount()){
		case 0: new MyNotification(this, "成功修改银行账户信息", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成银行账户信息修改", Color.RED); break;
		}
		return false;
	}
	
	private boolean deleteBankAccount(){
		switch(((Panel_Finance_BankAccountManage)subPanel).deleteBankAccount()){
		case 0: new MyNotification(this, "删除成功", Color.GREEN); return true;
		}
		return false;
	}
	private boolean searchBankAccount(){
		//模糊查找 TODO 
		return false;
	}
}

