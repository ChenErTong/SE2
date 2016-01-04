package ui.specialui.finance.ViewBusinessPerformance;


import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;
/**
 * 
 * @author zsq
 *
 */

public class ViewBusinessPerformance extends MyJPanel{
	
	private BusinessPerformanceInfo businessPerformance;
	private static final long serialVersionUID = 1L;

	public ViewBusinessPerformance(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}
	
	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530,20,300,40,"查看经营情况表",30,true));
		businessPerformance = new BusinessPerformanceInfo(frame_Finance);
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
