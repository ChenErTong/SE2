package ui.specialui.manager.HandleReceipt;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;
/**
 * 显示单据的详细内容
 * @author zsq
 * @time 2015/11/18 23:56
 */
public class ReceiptInfo extends MyTranslucentPanel{
	private MyEmptyTextArea ta;

	public ReceiptInfo() {
		super(700, 100-30, 550, 540);
		this.initComponent();
	}
	
	private void initComponent() {
		MyJLabel title = new MyJLabel(228,10,170,40,"单据详细信息",18,true);
		this.add(title);
		
		ta = new MyEmptyTextArea(10,60,530,460);
		ta.setEditable(false);
		//ta.setBackground(getBackground());
		this.add(ta);
	}
	
	public MyEmptyTextArea getTa(){
		return ta;
	}
		
	private static final long serialVersionUID = 1L;

}
