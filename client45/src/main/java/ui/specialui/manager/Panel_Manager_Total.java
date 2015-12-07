package ui.specialui.manager;

import ui.image.ManagerImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
/**
 * 总经理主界面的总Panel
 * @author zsq
 * @version 2015/12/05 16:14
 */
public class Panel_Manager_Total extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public Panel_Manager_Total(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyButton HandleReceipt = new MyButton(200, 300, 170, 40,ManagerImage.getBUTTON_APPROVE());;
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		MyButton HandleOrganization = new MyButton(200, 350, 170, 40,ManagerImage.getBUTTON_ORGANIZATION());;
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		MyButton AdjustBase = new MyButton(200, 400, 170, 40,ManagerImage.getBUTTON_BASE());
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		MyButton AdjustSalaryPolicy = new MyButton(200,450, 170, 40,ManagerImage.getBUTTON_POLICY());
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		MyButton ViewUser = new MyButton(200, 500, 170, 40,ManagerImage.getBUTTON_ACCOUNT());
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(200,550,170,40,ManagerImage.getButton_JINGYING());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(200, 600, 170, 40,ManagerImage.getButton_CHENGBEN());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(200,650,170,40,ManagerImage.getButton_LOG());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frameManager);
		this.add(viewLog);
		
		//MyButton Withdraw = new MyButton(1120,55,150,40,"注销登录",16);
	//	Withdraw.setActionCommand("Withdraw");
	//	Withdraw.addActionListener(frameManager);
		//this.add(Withdraw);
		//Withdraw.setVisible(true);
	}

}
