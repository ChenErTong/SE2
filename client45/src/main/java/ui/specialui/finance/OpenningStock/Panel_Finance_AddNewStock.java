package ui.specialui.finance.OpenningStock;

import ui.myui.MyJPanel;

public class Panel_Finance_AddNewStock extends MyJPanel{
	private Panel_Finance_NewStockInfo newStockInfo;
	public Panel_Finance_AddNewStock() {
		super(0,0,1280,720);
		this.setOpaque(false);
		this.initComponent();
	
	}

	private void initComponent() {
		newStockInfo = new Panel_Finance_NewStockInfo();
		this.add(newStockInfo);
		
	}

	private static final long serialVersionUID = 1L;

}
