package ui.specialui.finance.BankAccountManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_BankAccount extends MyTranslucentPanel{
	private MyJTextField searchField;
	private MyJButton searchButton;
	public Panel_Finance_BankAccount(Frame_Finance frame_Finance) {
		super(80,100,550,530);
		this.initComponent(frame_Finance);
	// TODO Auto-generated constructor stub
}

private void initComponent(Frame_Finance frame_Finance) {
	// TODO Auto-generated method stub
	MyJLabel title = new MyJLabel(230,10,120,30,"账户信息",18,true);
	this.add(title);
	
	MyJLabel search = new MyJLabel(10,40,90,30,"模糊查找",16,true);
	this.add(search);
	
	searchField = new MyJTextField(100,40,200,30);
	this.add(searchField);
	
	searchButton = new MyJButton(425,40,90,30,"搜索",16);
	searchButton.setActionCommand("SearchBankAccount");
	searchButton.addActionListener(frame_Finance);
	this.add(searchButton);
	
	//the table
	String[] headers = {"账户编号","账户名称","账户余额"};
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
					
	jsp.setBounds(10, 76, 532, 444);
	jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
	jsp.setOpaque(false);
	jsp.setBorder(BorderFactory.createEmptyBorder());
	jsp.setVisible(true);
	this.add(jsp);
	
	
}

private static final long serialVersionUID = 1L;

	

}
