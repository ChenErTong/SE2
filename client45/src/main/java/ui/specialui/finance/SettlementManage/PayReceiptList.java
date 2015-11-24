package ui.specialui.finance.SettlementManage;

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

public class PayReceiptList extends MyTranslucentPanel{
	private MyJLabel chooseDate;
	private MyComboBox dateList;
	private MyJButton search;
	public PayReceiptList(Frame_Finance frame_Finance) {
		super(50, 100, 620, 560);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		chooseDate = new MyJLabel(20,10,120,30,"请选择日期",14,true);
		this.add(chooseDate);
		
		String[] dates = {""};
		dateList = new MyComboBox(140,10,150,30,14,dates);
		this.add(dateList);
		
		search = new MyJButton(470,10,90,30,"搜索",14);
		search.setActionCommand("SearchPayReceipt");
		search.addActionListener(frame_Finance);
		this.add(search);
		//the table
				String[] headers = {"付款单编号","付款日期","付款金额","付款人","付款账号","付款条目","备注"};
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
		dateList.setSelectedItem(data);
		
	}

	public String getData() {
		String  data ;
	
		data= (String) dateList.getSelectedItem();
		return data;
	}

	private static final long serialVersionUID = 1L;

}
