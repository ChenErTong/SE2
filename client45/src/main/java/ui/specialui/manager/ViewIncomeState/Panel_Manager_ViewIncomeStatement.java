package ui.specialui.manager.ViewIncomeState;

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
	}

	private static final long serialVersionUID = 1L;

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
