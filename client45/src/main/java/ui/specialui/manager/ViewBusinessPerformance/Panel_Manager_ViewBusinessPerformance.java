package ui.specialui.manager.ViewBusinessPerformance;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_ViewBusinessPerformance extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private Panel_Manager_BusinessPerformance businessPerformance;
	private MyJButton ExportBusinessTable;
	public Panel_Manager_ViewBusinessPerformance(FrameManager frameManager) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(550, 20, 210, 90, "查看经营情况表", 24, true));
		businessPerformance = new Panel_Manager_BusinessPerformance(frameManager);
		this.add(businessPerformance);
		
		ExportBusinessTable = new MyJButton(1040,673,150,40,"导出经营情况表",14);
		ExportBusinessTable.setActionCommand("ExportBusinessTable");
		ExportBusinessTable.addActionListener(frameManager);
		this.add(ExportBusinessTable);
		ExportBusinessTable.setVisible(true);
	}

}
