package ui.specialui.finance.OpenningStock;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_OpenningStockInfo extends MyTranslucentPanel{

	public Panel_Finance_OpenningStockInfo() {
		super(680,100,550,550);
		//this.setOpaque(false);
		this.initComponent();
		
		
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		MyJLabel title = new MyJLabel(210,10,180,40,"期初账目详细信息",18,true);
		this.add(title);
		
	}

	private static final long serialVersionUID = 1L;

}
