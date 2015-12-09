package ui.specialui.finance.ViewIncomeState;

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
