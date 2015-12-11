package ui.specialui.finance.ViewIncomeState;

import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;
/**
 * 
 * @author zsq
 *
 */
public class ViewIncomeState extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private IncomeStateInfo statePanel;
	
	public ViewIncomeState(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}
	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 300, 40, "查看成本收益表", 30, true));
		
		statePanel = new IncomeStateInfo(frame_Finance);
		this.add(statePanel);
		
		this.leadline(frame_Finance);
	}
	
	public void leadline(Frame_Finance frame_Finance){
		MyButton CostManage = new MyButton(300, 690, 95, 20,FinanceImage.getBUTTON_JIESUAN_());
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		MyButton SettlementManage = new MyButton(395+10,690,95,20,FinanceImage.getBUTTON_COST_());
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		MyButton BankAccountManage = new MyButton(395+10+105,690,120,20,FinanceImage.getBUTTON_BANK_());
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(frame_Finance);
		this.add(BankAccountManage);
		BankAccountManage.setVisible(true);
		
		MyButton OpenningStock = new MyButton(405+105+120+10,690,120,20,FinanceImage.getBUTTON_QICHU_());
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(510+130+120+10+5,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(770+130+10,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(770+130+130+15,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frame_Finance);
		this.add(viewLog);
	}
	
	/**
	 * 是否进行报表导出
	 * @return 返回0则导出。返回1则不导出
	 */
	public int isExport(){
		int rowCount = 0;
		rowCount = statePanel.getTable().getRowCount();
		if(rowCount>0){
			return 0;
		}
		return 1;
	}
}
