package ui.specialui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.specialui.admin.Panel_Admin_AddUser;
import ui.specialui.admin.Panel_Admin_Total;

public class Frame_Finance  extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Panel_Finance_Total totalPanel;
	Panel_Finance_CostManagement costManagePanel;
	Panel_Finance_SettlementManage  settleManagePanel;
	Panel_Finance_OpenningStock openningStockPanel;
	Panel_Finance_ViewBusinessPerformance viewBusinessPerformance;
	Panel_Finance_ViewIncomeStatement viewIncomeStatement;
	
	
	public Frame_Finance(){
		totalPanel = new Panel_Finance_Total(this);
		this.add(totalPanel);
		
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CostManange")){
			totalPanel.setVisible(false);
			costManagePanel = new Panel_Finance_CostManagement(this);
			this.add(costManagePanel);
			this.getLayeredPane().add(costManagePanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("SettlementManage")){
			//TODO
			totalPanel.setVisible(false);
			settleManagePanel = new Panel_Finance_SettlementManage(this);
			this.add(settleManagePanel);
			this.getLayeredPane().add(settleManagePanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("OpenningStock")){
			//TODO
			totalPanel.setVisible(false);
			openningStockPanel = new Panel_Finance_OpenningStock(this);
			this.add(openningStockPanel);
			this.getLayeredPane().add(openningStockPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			//TODO
			totalPanel.setVisible(false);
			viewBusinessPerformance = new Panel_Finance_ViewBusinessPerformance(this);
			this.add(viewBusinessPerformance);
			this.getLayeredPane().add(viewBusinessPerformance,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			//TODO
			totalPanel.setVisible(false);
			viewIncomeStatement = new Panel_Finance_ViewIncomeStatement(this);
			this.add(viewIncomeStatement);
			this.getLayeredPane().add(viewIncomeStatement,new Integer(Integer.MAX_VALUE));
		
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}

}
}
