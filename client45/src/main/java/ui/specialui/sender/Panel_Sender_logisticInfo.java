package ui.specialui.sender;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;
/**
 * 物流信息显示面板
 * @author zsq
 * @time 2015/11/18 19:33
 */
public class Panel_Sender_logisticInfo extends MyTranslucentPanel{

	public Panel_Sender_logisticInfo() {
		super(650, 120, 550, 590);
		this.initComponent();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		MyJLabel title = new MyJLabel(195,10,170,40,"订单物流信息",18,true);
		this.add(title);
	}

	private static final long serialVersionUID = 1L;

}

