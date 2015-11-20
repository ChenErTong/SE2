package ui.specialui.finance.CostManage;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyTable;
import ui.myui.MyTranslucentPanel;

public class Panel_Finance_DebitReceiptInfo extends MyTranslucentPanel{

	public Panel_Finance_DebitReceiptInfo() {
		super(660,120,550,550);

		this.initComponent();
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(195,10,170,40,"收款单详细信息",18,true);
		this.add(title);
		
		
	}

	private static final long serialVersionUID = 1L;

}
