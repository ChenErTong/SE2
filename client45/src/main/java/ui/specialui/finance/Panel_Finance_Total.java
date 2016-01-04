package ui.specialui.finance;

import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
import ui.myui.MyLogo;
import ui.myui.MyTitle;
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
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "财务人员界面", 544-60, 100, 387, 117);
		
		this.initComponent(frame_Finance);
	
		
		
	}
	
	public void initComponent(Frame_Finance frame_Finance){
		MyButton CostManage = new MyButton(551, 250, 257, 46,FinanceImage.getBUTTON_JIESUAN());
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		MyButton SettlementManage = new MyButton(551,250+46+10,257,46,FinanceImage.getBUTTON_COST());
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		MyButton BankAccountManage = new MyButton(551,250+46*2+10+10,257,46,FinanceImage.getBUTTON_BANK());
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(frame_Finance);
		this.add(BankAccountManage);
		BankAccountManage.setVisible(true);
		
		MyButton OpenningStock = new MyButton(551, 250+46*3+10*3, 257, 46,FinanceImage.getBUTTON_QICHU());
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(551,250+46*4+10*4,257,46,FinanceImage.getButton_JINGYING());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(551, 250+46*5+10*5, 257, 46,FinanceImage.getButton_CHENGBEN());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(551,250+46*6+10*6,257,46,FinanceImage.getButton_LOG());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frame_Finance);
		this.add(viewLog);
		
		this.repaint();
	}
	
	

}

