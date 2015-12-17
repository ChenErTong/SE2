package ui.specialui.manager.ViewBusinessPerformance;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;

public class ViewBusinessPerformance extends MyJPanel{

	private static final long serialVersionUID = 1L;
	
	private BusinessPerformanceInfo businessPerformance;
	
	public ViewBusinessPerformance(FrameManager frameManager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(550, 20, 300, 40, "查看经营情况表", 30, true));
		businessPerformance = new BusinessPerformanceInfo(frameManager);
		this.add(businessPerformance);
	
	}

	/**
	 * 是否进行报表导出
	 * @return 返回0则导出。返回1则不导出
	 */
	public int isExport(){
		int rowCount = 0;
		rowCount = businessPerformance.getTable().getRowCount();
		if(rowCount>0){
			return 0;
		}
		return 1;
	}

}
