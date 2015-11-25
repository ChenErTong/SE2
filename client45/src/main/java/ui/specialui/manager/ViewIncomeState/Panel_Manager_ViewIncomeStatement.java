package ui.specialui.manager.ViewIncomeState;


import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_ViewIncomeStatement extends MyJPanel {

	private Panel_Manager_IncomeState statePanel;
	public Panel_Manager_ViewIncomeStatement(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(550, 20, 210, 90, "查看成本收益表", 24, true));
		
		statePanel = new Panel_Manager_IncomeState(frameManager);
		this.add(statePanel);
		
		
		MyJButton ExportIncomeTable = new MyJButton(1040,673,150,40,"导出成本收益表",14);
		ExportIncomeTable.setActionCommand("ExportIncomeTable");
		ExportIncomeTable.addActionListener(frameManager);
		this.add(ExportIncomeTable);
		ExportIncomeTable.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

}
