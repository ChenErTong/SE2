package ui.specialui.finance.ViewIncomeState;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.ViewIncomeState.Panel_Manager_IncomeState;


public class Panel_Finance_ViewIncomeStatement extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private Panel_Finance_IncomeState statePanel;
	public Panel_Finance_ViewIncomeStatement(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}
	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(550, 20, 210, 90, "查看成本收益表", 24, true));
		
		statePanel = new Panel_Finance_IncomeState(frame_Finance);
		this.add(statePanel);
		
		
		MyJButton ExportIncomeTable = new MyJButton(1040,673,150,40,"导出成本收益表",14);
		ExportIncomeTable.setActionCommand("ExportIncomeTable");
		ExportIncomeTable.addActionListener(frame_Finance);
		this.add(ExportIncomeTable);
		ExportIncomeTable.setVisible(true);

}
}
