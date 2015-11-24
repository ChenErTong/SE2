package ui.specialui.finance.ViewIncomeState;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;


public class Panel_Finance_ViewIncomeStatement extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private Panel_Finance_SearchIncomeState searchPanel;
	private Panel_Finance_IncomeState statePanel;
	private MyJButton SelectedAllReceipts;
	private MyJButton ViewIncomeTable;
	private MyJButton ExportIncomeTable;
	public Panel_Finance_ViewIncomeStatement(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}
	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(540,40,200,40,"查看成本收益表",24,true));
		searchPanel = new Panel_Finance_SearchIncomeState(frame_Finance);
		this.add(searchPanel);
		
		statePanel = new Panel_Finance_IncomeState();
		this.add(statePanel);
		
		SelectedAllReceipts = new MyJButton(120, 673, 150, 40,"选中所有单据",14);
		SelectedAllReceipts.setActionCommand("SelectedAllReceipts");
		SelectedAllReceipts.addActionListener(frame_Finance);
		this.add(SelectedAllReceipts);
		
		ViewIncomeTable = new MyJButton(380, 673, 150, 40,"成本收益表预览",14);
		ViewIncomeTable.setActionCommand("ViewIncomeTable");
		ViewIncomeTable.addActionListener(frame_Finance);
		this.add(ViewIncomeTable);
		
		ExportIncomeTable = new MyJButton(1040,673,150,40,"导出成本收益表",14);
		ExportIncomeTable.setActionCommand("ExportIncomeTable");
		ExportIncomeTable.addActionListener(frame_Finance);
		this.add(ExportIncomeTable);
	}

}
