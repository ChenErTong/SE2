package ui.specialui.manager.ViewIncomeState;

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

public class Panel_Manager_IncomeState extends  MyTranslucentPanel{

	public Panel_Manager_IncomeState() {
		super(660,120,550,550);
		this.initComponent();
		
	}

	private void initComponent() {
		MyJLabel title = new MyJLabel(195,10,170,40,"成本收益表预览",18,true);
		this.add(title);
		
		MyJLabel totalCost = new MyJLabel(30,50,100,30,"总支出:",14,true);
		this.add(totalCost);
		
		MyJLabel totalIncome = new MyJLabel(30,80,100,30,"总收入:",14,true);
		this.add(totalIncome);
		
		MyJLabel balance = new MyJLabel(30,110,100,30,"总利润",14,true);
		this.add(balance);
		
		//the table
			String[] headers = {};
			MyTable	table = new MyTable(headers);
			table.setBackground(new Color(40, 42, 66));
			table.setForeground(Color.WHITE);
			table.setFont(new MyFont(14));
							
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
			tcr.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, tcr);
									  	
			JScrollPane jsp=new JScrollPane(table);
			JTableHeader head = table.getTableHeader();
			head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
			head.setFont(new MyFont(14));
			head.setForeground(Color.BLACK);
			head.setResizingAllowed(false);
								
			jsp.setBounds(20, 140, 510, 400);
			jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
			jsp.setOpaque(false);
			jsp.setBorder(BorderFactory.createEmptyBorder());
			jsp.setVisible(true);
			this.add(jsp);
		
	}

	private static final long serialVersionUID = 1L;

}
