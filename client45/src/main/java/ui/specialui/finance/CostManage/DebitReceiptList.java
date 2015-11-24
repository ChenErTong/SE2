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
import ui.specialui.finance.Frame_Finance;

public class DebitReceiptList extends MyTranslucentPanel{
	private MyJLabel chooseBranch;
	private MyJLabel chooseDate;
	private MyComboBox branchList;
	private MyComboBox dateList;
	private MyJButton search;
	public DebitReceiptList(Frame_Finance frame_Finance) {
		super(50, 100, 620, 560);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		// TODO Auto-generated method stub

		chooseBranch = new MyJLabel(20,10,120,30,"请选择营业厅",14,true);
		this.add(chooseBranch);
		
		chooseDate = new MyJLabel(180,10,120,30,"请选择日期",14,true);
		this.add(chooseDate);
		
		String[] branches = {"所有营业厅"};
		branchList = new MyComboBox(140,10,150,30,14,branches);
		this.add(branchList);
		
		String[] dates = {""};
		dateList = new MyComboBox(300,10,150,30,14,dates);
		this.add(dateList);
		
		search = new MyJButton(470,10,90,30,"搜索",14);
		search.setActionCommand("SearchDebitReceipt");
		search.addActionListener(frame_Finance);
		this.add(search);
		//the table
				String[] headers = {"收款单编号","营业厅编号","营业厅名称","经手人"};
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
	public void setData(String[] data) {
		branchList.setSelectedItem(data[0]);
		dateList.setSelectedItem(data[1]);
	}

	@SuppressWarnings("null")
	public String[] getData() {
		String  data[] = null ;
		data[0] = (String) branchList.getSelectedItem();
		data[1] = (String) dateList.getSelectedItem();
		return data;
	}

	private static final long serialVersionUID = 1L;

}
