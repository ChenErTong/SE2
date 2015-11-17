package ui.specialui.finance;

import javax.swing.JButton;

import ui.myui.MyJPanel;

public class Panel_Finance_Total extends MyJPanel{

	public Panel_Finance_Total(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public Panel_Finance_Total(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JButton CostManage = new JButton("成本管理");
		CostManage.setBounds(200, 300, 150, 40);
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		JButton SettlementManage = new JButton("结算管理");
		SettlementManage.setBounds(200, 350, 150, 40);
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		JButton OpenningStock = new JButton("期初账目管理");
		OpenningStock.setBounds(200, 400, 150, 40);
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		JButton ViewBusinessPerformance = new JButton("查看经营情况表");
		ViewBusinessPerformance.setBounds(200,450,150,40);
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		JButton ViewIncomeStatement = new JButton("查看成本收益表");
		ViewIncomeStatement.setBounds(200, 500, 150, 40);
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		JButton Withdraw = new JButton("注销登录");
		Withdraw.setBounds(1120,55,150,40);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frame_Finance);
		this.add(Withdraw);
	}
	private static final long serialVersionUID = 1L;
		
	}

