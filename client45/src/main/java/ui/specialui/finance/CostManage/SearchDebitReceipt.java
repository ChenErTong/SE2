package ui.specialui.finance.CostManage;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;

/**
 * 选择日期进行收款单搜索，并且显示搜索得到的收款单列表
 * @author zsq
 * @version 2015/11/30 23:14
 */
public class SearchDebitReceipt extends MyTranslucentPanel{
	
	private MyJLabel chooseBranch;
	private MyComboBox branchList;
	private MyComboBox dateList;
	private MyJButton search;
	private MyJTable table;
	
	public SearchDebitReceipt(CostManagement handle) {
		super(50, 100, 620, 560);
		this.initComponent(handle);
	}

	private void initComponent(CostManagement handle) {
		
		chooseBranch = new MyJLabel(20,10,150,30,"请选择营业厅和日期",14,true);
		this.add(chooseBranch);
		//TODO 
		String[] branches = {"南京","上海","杭州","广州"};
		branchList = new MyComboBox(170,10,150,30,14,branches);
		this.add(branchList);
		//TODO 
		String[] dates = {""};
		dateList = new MyComboBox(330,10,150,30,14,dates);
		this.add(dateList);
		
		search = new MyJButton(490,10,90,30,"搜索",14);
		search.setActionCommand("SearchDebitReceipt");
		search.addActionListener(handle);
		this.add(search);
		
		this.initTable();
	}
	private void initTable(){
		String[] headers = {"收款单编号","收款日期","收款金额","收款快递员","对应订单条形码"};
		table = new MyJTable(headers, false);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));
							
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
									  	
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setResizingAllowed(false);
								
		jsp.setBounds(15, 50, 590, 495);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}
	
	public void setData(String[] data) {
		branchList.setSelectedItem(data[0]);
		dateList.setSelectedItem(data[1]);
	}

	public String[] getData() {
		String  data[] = new String[2] ;
		data[0] = (String) branchList.getSelectedItem();
		data[1] = (String) dateList.getSelectedItem();
		return data;
	}
	
	public MyJTable getTable(){
		return table;
	}

	private static final long serialVersionUID = 1L;

}