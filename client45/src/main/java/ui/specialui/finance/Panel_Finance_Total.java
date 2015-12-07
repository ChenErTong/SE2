package ui.specialui.finance;

import ui.image.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
/**
 * 财务管理界面的主Panel
 * @author zsq
 *
 */
public class Panel_Finance_Total extends MyJPanel{

	private static final long serialVersionUID = 1L;
	
	public Panel_Finance_Total(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyButton CostManage = new MyButton(200, 250, 150, 40,FinanceImage.getBUTTON_JIESUAN());
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		MyButton SettlementManage = new MyButton(200,300,150,40,FinanceImage.getBUTTON_COST());
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		MyButton BankAccountManage = new MyButton(200,350,150,40,FinanceImage.getBUTTON_BANK());
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(frame_Finance);
		this.add(BankAccountManage);
		BankAccountManage.setVisible(true);
		
		MyButton OpenningStock = new MyButton(200, 400, 150, 40,FinanceImage.getBUTTON_QICHU());
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(200,450,150,40,FinanceImage.getButton_JINGYING());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(200, 500, 150, 40,FinanceImage.getButton_CHENGBEN());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(200,550,170,40,FinanceImage.getButton_LOG());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frame_Finance);
		this.add(viewLog);
		
	//	MyButton Withdraw = new MyButton(1120,55,150,40,"注销登录",18);
		//Withdraw.setActionCommand("Withdraw");
		//Withdraw.addActionListener(frame_Finance);
		//this.add(Withdraw);
	}
}

