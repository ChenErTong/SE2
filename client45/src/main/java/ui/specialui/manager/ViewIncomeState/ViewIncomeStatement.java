package ui.specialui.manager.ViewIncomeState;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class ViewIncomeStatement extends MyJPanel {

	private IncomeStateInfo statePanel;
	
	public ViewIncomeStatement(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(530, 20, 300, 40, "查看成本收益表", 30, true));
		
		statePanel = new IncomeStateInfo(frameManager);
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
