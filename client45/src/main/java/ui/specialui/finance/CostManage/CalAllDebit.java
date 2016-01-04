package ui.specialui.finance.CostManage;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

/**
 * 显示收款单合计结果的Panel
 * @author zsq
 * @version 2015/11/30 23:44
 */
public class CalAllDebit extends MyTranslucentPanel{

	public CalAllDebit() {
		super(710,390-20,550,240+20);
		this.add(new MyJLabel(240,10,150,30,"合计信息",18,true));
	}

	public void init(String data){
		this.add(new MyJLabel(20,60,150,30,"总收入为:"+data,18,true));
	}
	
	private static final long serialVersionUID = 1L;

}
