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

public class Panel_Finance_BankAccount extends MyTranslucentPanel{

	public Panel_Finance_BankAccount() {
		super(80,100,550,608);
		this.initComponent();
	// TODO Auto-generated constructor stub
}

private void initComponent() {
	// TODO Auto-generated method stub
	MyJLabel title = new MyJLabel(220,10,120,30,"账户信息",16,true);
	this.add(title);
	
	MyJLabel search = new MyJLabel(10,40,90,30,"模糊查找",16,true);
	this.add(search);
	
	MyJTextField searchField = new MyJTextField(100,40,200,30);
	this.add(searchField);
	
	MyJButton searchButton = new MyJButton(425,40,90,30,"搜索",16);
	searchButton.setActionCommand("SearchBankAccount");
	searchButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
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
					
	jsp.setBounds(10, 76, 532, 490);
	jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
	jsp.setOpaque(false);
	jsp.setBorder(BorderFactory.createEmptyBorder());
	jsp.setVisible(true);
	this.add(jsp);
	
	MyJButton deleteAccount = new MyJButton(50,570,180,30,"删除所选账户",16);
	deleteAccount.setActionCommand("DeleteBankAccount");
	deleteAccount.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
	this.add(deleteAccount);
	
	MyJButton modifyAccountInfo = new MyJButton(250,570,180,30,"修改所选账户信息",16);
	modifyAccountInfo.setActionCommand("ModifyBankAccount");
	modifyAccountInfo.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
	this.add(modifyAccountInfo);
}

private static final long serialVersionUID = 1L;

	

}
