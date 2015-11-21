package ui.specialui.finance;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;

public class Panel_Finance_Total extends MyJPanel{

	
	public Panel_Finance_Total(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyJButton CostManage = new MyJButton(200, 250, 150, 40,"结算管理",18);
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		MyJButton SettlementManage = new MyJButton(200,300,150,40,"成本管理",18);
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		MyJButton BankAccountManage = new MyJButton(200,350,150,40,"银行账户管理",18);
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(frame_Finance);
		this.add(BankAccountManage);
		BankAccountManage.setVisible(true);
		
		MyJButton OpenningStock = new MyJButton(200, 400, 150, 40,"期初账目管理",18);
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		MyJButton ViewBusinessPerformance = new MyJButton(200,450,150,40,"查看经营情况表",18);
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyJButton ViewIncomeStatement = new MyJButton(200, 500, 150, 40,"查看成本收益表",18);
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyJButton Withdraw = new MyJButton(1120,55,150,40,"注销登录",18);
		Withdraw.setActionCommand("Withdraw");
		Withdraw.addActionListener(frame_Finance);
		this.add(Withdraw);
	}
	private static final long serialVersionUID = 1L;
		
	}

