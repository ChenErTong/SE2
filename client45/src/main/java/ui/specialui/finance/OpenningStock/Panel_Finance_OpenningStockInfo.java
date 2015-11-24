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
		
		String[] headers = {"机构编号", "日期"};
		organizationTable= new MyJTable(headers,true);
		organizationTable.setBackground(new Color(40, 42, 66));
		organizationTable.setForeground(Color.WHITE);
		organizationTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		organizationTable.setDefaultRenderer(Object.class, tcr);
		
		String[] headers2 = {"人员编号", "日期"};
		employTable = new MyJTable(headers2,true);
		employTable.setBackground(new Color(40, 42, 66));
		employTable.setForeground(Color.WHITE);
		employTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr1.setHorizontalAlignment(JLabel.CENTER);
		employTable.setDefaultRenderer(Object.class, tcr1);
		
		String[] headers3 = {"车辆编号", "日期"};
		facilityTable = new MyJTable(headers3,true);
		facilityTable.setBackground(new Color(40, 42, 66));
		facilityTable.setForeground(Color.WHITE);
		facilityTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr2.setHorizontalAlignment(JLabel.CENTER);
		organizationTable.setDefaultRenderer(Object.class, tcr2);
		
		String[] headers4 = {"库存编号", "日期"};
		inventoryTable = new MyJTable(headers4,true);
		inventoryTable.setBackground(new Color(40, 42, 66));
		inventoryTable.setForeground(Color.WHITE);
		inventoryTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr3 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr3.setHorizontalAlignment(JLabel.CENTER);
		organizationTable.setDefaultRenderer(Object.class, tcr3);
		
		String[] headers5 = {"账户编号","日期", "账户名称", "账户金额"};
		bankAccountTable = new MyJTable(headers5,false);
		bankAccountTable.setBackground(new Color(40, 42, 66));
		bankAccountTable.setForeground(Color.WHITE);
		bankAccountTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr4 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr4.setHorizontalAlignment(JLabel.CENTER);
		organizationTable.setDefaultRenderer(Object.class, tcr4);
		
		JScrollPane jsp = new JScrollPane(organizationTable);
		jsp.setBounds(10, 50, 530, 512/5);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		JScrollPane jsp2 = new JScrollPane(employTable);
		jsp2.setBounds(10, 50+ (512/5)*1 + 10, 530, 512/5 );
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		JScrollPane jsp3 = new JScrollPane(facilityTable);
		jsp3.setBounds(10, 50 + (512/5)*2 + 10, 530, 512/5 );
		jsp3.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp3.setOpaque(false);
		jsp3.setVisible(true);
		this.add(jsp3);
		
		JScrollPane jsp4 = new JScrollPane(inventoryTable);
		jsp4.setBounds(10, 50 + (512/5)*3 + 10 , 530, 512/5);
		jsp4.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp4.setOpaque(false);
		jsp4.setVisible(true);
		this.add(jsp4);
		
		JScrollPane jsp5 = new JScrollPane(bankAccountTable);
		jsp5.setBounds(10, 50+(512/5)*4+10, 530, 512/5);
		jsp5.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp5.setOpaque(false);
		jsp5.setVisible(true);
		this.add(jsp5);
	}

	public void setUneditable() {
		// TODO Auto-generated method stub
		
	}
	private static final long serialVersionUID = 1L;

}
