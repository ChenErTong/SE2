package ui.specialui.manager.AdjustSalaryPolicy;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;

public class PolilcyInfoList  extends MyTranslucentPanel{
	private MyJLabel employeeType;
	private MyJLabel policyType;
	private MyJComboBox employeeTypeBox;
	private MyJComboBox policyTypeBox;
	private MyJButton search;
	private MyJTable table;
	public PolilcyInfoList(Panel_Manager_AdjustSalaryPolicy handle) {
		super(50, 100, 620, 560);
		this.initComponent( handle);
	}

	private void initComponent(Panel_Manager_AdjustSalaryPolicy handle) {
		String [] employeeTypes = {"快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};
		
		employeeType = new MyJLabel(20,10,120,30, "请选择员工类别",14,true);
		this.add(employeeType);
		
		policyType = new MyJLabel(300,10,120,30,"请选择策略类别",14,true);
		this.add(policyType);
		
		 employeeTypeBox= new MyJComboBox(140,10,150,30,employeeTypes);
		this.add(employeeTypeBox);
		
		String [] policyTypes = {"按月","计次","提成"};
		policyTypeBox = new MyJComboBox(420,10,90,30,policyTypes);
		this.add(policyTypeBox);
		
		search = new MyJButton(520,10,90,30,"搜索",14);
		search.setActionCommand("Search");
		search.addActionListener(handle);
		this.add(search);
		
		//the table
		String[] headers = {"员工类别","策略类别","策略规则"};
		table = new MyJTable(headers,false);
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
		employeeTypeBox.setSelectedItem(data[0]);
		policyTypeBox.setSelectedItem(data[1]);
	}

	public String[] getData() {
		String  data[] = new String[2];
		data[0] = (String) employeeTypeBox.getSelectedItem();
		data[1] = (String) policyTypeBox.getSelectedItem();
		return data;
	}
	public MyJTable getTable(){
		return table;
	}
	private static final long serialVersionUID = 1L;

}
