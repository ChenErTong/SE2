package ui.specialui.courier.receiveInput;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class OrderInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	public OrderInfo() {
		super(85, 160, 550, 540);
		this.initComponent();
	}
	
	private void initComponent() {
		MyJLabel title = new MyJLabel(225,10,170,40,"单据详细信息",18,true);
		this.add(title);
	}
	/**
	 * 清空数据等待下次输入
	 * TODO
	 */
	public void refresh(){
		
	}
}
