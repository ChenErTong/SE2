package ui.specialui.finance.OpenningStock;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_NewStockInfo extends MyTranslucentPanel{

	public Panel_Finance_NewStockInfo() {
		super(365,100,550,560);
		this.initComponent();
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(210,10,180,40,"新建期初账户信息",18,true);
		this.add(title);
	}

	private static final long serialVersionUID = 1L;

}
