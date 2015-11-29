package ui.specialui.finance.CostManage;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class CalAllDebit extends MyTranslucentPanel{
	private MyJLabel totalIncome;
	public CalAllDebit() {
		super(680,390,550,240);
		this.add(new MyJLabel(240,10,150,30,"合计信息",18,true));
	}
	public void init(String data){
		this.add(new MyJLabel(20,60,150,30,"总收入为:"+data,18,true));
	}
	private static final long serialVersionUID = 1L;

}
