package ui.specialui.manager.ViewBusinessPerformance;

import ui.image.ManagerImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class ViewBusinessPerformance extends MyJPanel{

	private static final long serialVersionUID = 1L;
	
	private BusinessPerformanceInfo businessPerformance;
	
	public ViewBusinessPerformance(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
		this.leadline(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(550, 20, 300, 40, "查看经营情况表", 30, true));
		businessPerformance = new BusinessPerformanceInfo(frameManager);
		this.add(businessPerformance);
	
	}
public void leadline(FrameManager frameManager){
		
		MyButton HandleReceipt = new MyButton(300-105, 690,95,20,ManagerImage.getBUTTON_APPROVE_());
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		MyButton HandleOrganization = new MyButton(300, 690,120,20,ManagerImage.getBUTTON_ORGANIZATION_());
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		MyButton AdjustBase = new MyButton(300+120+10, 690,120,20,ManagerImage.getBUTTON_BASE_());
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		MyButton AdjustSalaryPolicy = new MyButton(300+120+10+130,690,120,20,ManagerImage.getBUTTON_POLICY_());
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		MyButton ViewUser = new MyButton(300+120+10+130+130,  690,120,20,ManagerImage.getBUTTON_ACCOUNT_());
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(300+120+10+130+130+130,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(300+130*5,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(300+130*6,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frameManager);
		this.add(viewLog);
	}
	/**
	 * 是否进行报表导出
	 * @return 返回0则导出。返回1则不导出
	 */
	public int isExport(){
		int rowCount = 0;
		rowCount = businessPerformance.getTable().getRowCount();
		if(rowCount>0){
			return 0;
		}
		return 1;
	}

}
