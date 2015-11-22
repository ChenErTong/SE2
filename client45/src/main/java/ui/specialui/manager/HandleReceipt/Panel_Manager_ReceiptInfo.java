package ui.specialui.manager.HandleReceipt;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;
/**
 * 显示单据的详细内容
 * @author zsq
 * @time 2015/11/18 23:56
 */
public class Panel_Manager_ReceiptInfo extends MyTranslucentPanel{

	public Panel_Manager_ReceiptInfo() {
		super(700, 100, 550, 540);
		this.initComponent();
	}
	
	private void initComponent() {
		MyJLabel title = new MyJLabel(195,10,170,40,"单据详细信息",18,true);
		this.add(title);
	}

	private static final long serialVersionUID = 1L;

}
