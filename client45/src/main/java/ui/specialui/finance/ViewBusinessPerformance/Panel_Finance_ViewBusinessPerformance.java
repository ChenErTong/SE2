package ui.specialui.finance.ViewBusinessPerformance;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.ViewBusinessPerformance.Panel_Manager_BusinessPerformance;

public class Panel_Finance_ViewBusinessPerformance extends MyJPanel{
	private Panel_Finance_BusinessPerformance businessPerformance;
	private MyJButton ExportBusinessTable;
	private static final long serialVersionUID = 1L;

	public Panel_Finance_ViewBusinessPerformance(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}
	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(540,40,200,40,"查看经营情况表",24,true));
		businessPerformance = new Panel_Finance_BusinessPerformance(frame_Finance);
		this.add(businessPerformance);
		
		ExportBusinessTable = new MyJButton(1040,673,150,40,"导出经营情况表",14);
		ExportBusinessTable.setActionCommand("ExportBusinessTable");
		ExportBusinessTable.addActionListener(frame_Finance);
		this.add(ExportBusinessTable);
		ExportBusinessTable.setVisible(true);
		
	}
}
