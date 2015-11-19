package ui.specialui.sender;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;
/**
 * 订单货物信息显示面板
 * @author zsq
 * @time 2015/11/18 19:32
 */
public class Panel_Sender_CommodityInfo extends MyTranslucentPanel{

	public Panel_Sender_CommodityInfo() {
		super(60, 220, 550, 490);
		this.initComponent();
	}

	

	private void initComponent() {
		// TODO Auto-generated method stub
		MyJLabel title = new MyJLabel(195,10,170,40,"商品订单信息",18,true);
		this.add(title);
		
	}

	private static final long serialVersionUID = 1L;

}
