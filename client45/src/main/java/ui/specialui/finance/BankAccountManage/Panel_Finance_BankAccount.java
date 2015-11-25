package ui.specialui.finance.BankAccountManage;

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
import ui.myui.MyJTextField;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.finance.Frame_Finance;


public class Panel_Finance_BankAccount extends MyTranslucentPanel{
	private MyComboBox findType;
	private MyJTextField searchField_2;
	private MyJTextField searchField;
	private MyJButton searchButton;
	private MyJTable	table;
	public Panel_Finance_BankAccount(Frame_Finance frame_Finance) {
		super(40,100,610,530);
		this.initComponent(frame_Finance);
}

private void initComponent(Frame_Finance frame_Finance) {

	MyJLabel search = new MyJLabel(300,40,90,30,"模糊查找",16,true);
	this.add(search);
	this.add(new MyJLabel(10,10,150,30,"选择查找类型:",16,true));
	searchField = new MyJTextField(140,40,150,30);
	this.add(searchField);
	
	searchField_2 = new MyJTextField(390,40,150,30);
	this.add(searchField_2);
	
	String[] types = {"账户ID","账户名称","账户余额"};
	findType = new MyComboBox(10,40,120,30,16,types);
	this.add(findType);
	
	searchButton = new MyJButton(550,40,60,30,"搜索",16);
	searchButton.setActionCommand("SearchBankAccount");
	searchButton.addActionListener(frame_Finance);
	this.add(searchButton);
	
	//the table
	String[] headers = {"账户编号","账户名称","账户余额"};
	table = new MyJTable(headers, false);
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
					
	jsp.setBounds(10, 76, 590, 444);
	jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
	jsp.setOpaque(false);
	jsp.setBorder(BorderFactory.createEmptyBorder());
	jsp.setVisible(true);
	this.add(jsp);
	
	
}
public String[] getData(){
	String [] data = new String[3];
	
	data[0] = (String)findType.getSelectedItem();
	data[1] = searchField.getText();
	data[2] = searchField_2.getText();
	if((data[0].equals("")&&data[1].equals("")&&data[2].equals(""))||
			((!(data[0].equals("")))&&(data[1].equals(""))&&(data[2].equals("")))||
			((!(data[1].equals("")))&&(data[0].equals(""))&&(data[2].equals("")))){
		return null;
	}
	return data;
}

public  void setData(String[] data){
	findType.setSelectedItem(data[0]);
	searchField.setText(data[1]);
	searchField_2.setText(data[2]);
}

public void refresh() {
	findType.setSelectedItem(null);
	searchField.setText(null);
	searchField_2.setText(null);
}


private static final long serialVersionUID = 1L;

	

}
