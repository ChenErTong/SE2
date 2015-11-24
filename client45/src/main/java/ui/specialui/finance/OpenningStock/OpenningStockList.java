package ui.specialui.finance.OpenningStock;

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
import ui.specialui.finance.Frame_Finance;

public class OpenningStockList extends MyTranslucentPanel{
	private MyJLabel chooseYear ;
	private MyComboBox yearList;
	private MyJButton search;
	public OpenningStockList(Frame_Finance frame_Finance) {
		super(50, 100, 620, 560);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		chooseYear = new MyJLabel(20,10,120,30, "选择年份",16,true);
		this.add(chooseYear);
		
		String [] years = {"2015","2014"};
		yearList = new MyComboBox(140,10,150,30,14,years);
		this.add(yearList);
		
		search = new MyJButton(320,10,90,30,"搜索",14);
		search.setActionCommand("SearchDebitReceipt");
		search.addActionListener(frame_Finance);
		this.add(search);
		
		//the table
		String[] headers = {"机构","人员","车辆","库存","银行账户","账户余额"};
		MyJTable	table = new MyJTable(headers, false);
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
						
		jsp.setBounds(15, 50, 590, 495);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}
	public void setData(String data) {
		yearList.setSelectedItem(data);
	
	}

	@SuppressWarnings("null")
	public String getData() {
		String  data ;
		data= (String) yearList.getSelectedItem();
	
		return data;
	}
	private static final long serialVersionUID = 1L;

}
