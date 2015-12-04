package ui.specialui.manager;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;

public class Panel_Manager_Total extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public Panel_Manager_Total(FrameManager frameManager) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyJButton HandleReceipt = new MyJButton(200, 300, 170, 40,"处理单据",18);
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		MyJButton HandleOrganization = new MyJButton(200, 350, 170, 40,"公司机构管理",18);
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		MyJButton AdjustBase = new MyJButton(200, 400, 170, 40,"公司运营常量调整",18);
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		MyJButton AdjustSalaryPolicy = new MyJButton(200,450, 170, 40,"职工薪水策略制定",18);
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		MyJButton ViewUser = new MyJButton(200, 500, 170, 40,"公司员工信息管理",18);
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		MyJButton ViewBusinessPerformance = new MyJButton(200,550,170,40,"查看经营情况表",18);
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyJButton ViewIncomeStatement = new MyJButton(200, 600, 170, 40,"查看成本收益表",18);
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyJButton viewLog = new MyJButton(200,650,170,40,"查看系统日志",18);
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frameManager);
		this.add(viewLog);
		
		MyJButton Withdraw = new MyJButton(1120,55,150,40,"注销登录",16);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frameManager);
		this.add(Withdraw);
		Withdraw.setVisible(true);
	}

}
