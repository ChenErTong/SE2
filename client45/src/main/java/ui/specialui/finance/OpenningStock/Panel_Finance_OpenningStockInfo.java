package ui.specialui.finance.OpenningStock;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

import ui.myui.MyFont;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_OpenningStockInfo extends MyTranslucentPanel{
/**
 * 机构、人员、车辆、库存、银行账户信息（名称，余额）
 */
	private MyJTable organizationTable,employTable,facilityTable,inventoryTable,bankAccountTable;
	public Panel_Finance_OpenningStockInfo() {
		//super(50,100,1180,520);
		super(680,100,550,562);
		this.initComponent();
		
		
	}

	private void initComponent() {
		
	}

	public void setUneditable() {
		// TODO Auto-generated method stub
		
	}
	private static final long serialVersionUID = 1L;

}
