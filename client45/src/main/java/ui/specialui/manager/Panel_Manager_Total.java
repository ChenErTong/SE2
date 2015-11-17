package ui.specialui.manager;

import javax.swing.JButton;

import ui.myui.MyJPanel;

public class Panel_Manager_Total extends MyJPanel {
	private static final long serialVersionUID = 1L;

	public Panel_Manager_Total(FrameManager frameManager) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JButton HandleReceipt = new JButton("处理单据");
		HandleReceipt.setBounds(200, 300, 150, 40);
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		JButton HandleOrganization = new JButton("公司机构管理");
		HandleOrganization.setBounds(200, 350, 150, 40);
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		JButton AdjustBase = new JButton("公司运营常量调整");
		AdjustBase.setBounds(200, 400, 150, 40);
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		JButton AdjustSalaryPolicy = new JButton("职工薪水策略制定");
		AdjustSalaryPolicy.setBounds(200,450, 150, 40);
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		JButton ViewUser = new JButton("查看员工信息");
		ViewUser.setBounds(200, 500, 150, 40);
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		JButton ViewBusinessPerformance = new JButton("查看经营情况表");
		ViewBusinessPerformance.setBounds(200,550,150,40);
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		JButton ViewIncomeStatement = new JButton("查看成本收益表");
		ViewIncomeStatement.setBounds(200, 600, 150, 40);
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		JButton Withdraw = new JButton("注销登录");
		Withdraw.setBounds(1120,55,150,40);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frameManager);
		this.add(Withdraw);
	}

}
