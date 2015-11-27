package ui.specialui.manager.HandleOrganization;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_OrganizationInfo extends MyTranslucentPanel{
	
	private static final long serialVersionUID = 1L;

	 private MyJLabel ChooseType;
	 private MyComboBox organizationType;
	 private MyJButton search;
	 private  MyJTable table;
	public Panel_Manager_OrganizationInfo(Panel_Manager_HandleOrganization handle) {
		super(50, 100, 620, 560);
		this.initComponent(handle);
	}
	
	private void initComponent(Panel_Manager_HandleOrganization handle) {
		String [] organizationTypes = {"营业厅","中转中心"};
		
		ChooseType = new MyJLabel(20,10,120,30, "请选择机构类别",14,true);
		this.add(ChooseType);
		
		 organizationType= new MyComboBox(140,10,150,30,14,organizationTypes);
		this.add(organizationType);
		
		search = new MyJButton(500,10,90,30,"搜索",14);
		search.setActionCommand("SearchOrganization");
		search.addActionListener(handle);
		this.add(search);
		
		//the table
		String[] headers = {"编号","类型","人数","日期","仓库/转运工具信息","员工信息","地址"};
		table = new MyJTable(headers,false);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));

		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(50);
		firsetColumn.setMaxWidth(50);
		firsetColumn.setMinWidth(50);
		
		TableColumn secondColumn = table.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(50);
		secondColumn.setMaxWidth(50);
		secondColumn.setMinWidth(50);
		
		
		TableColumn thirdColum = table.getColumnModel().getColumn(2);
		thirdColum.setPreferredWidth(50);
		thirdColum.setMaxWidth(50);
		thirdColum.setMinWidth(50);
		
		TableColumn forthColum = table.getColumnModel().getColumn(3);
		forthColum.setPreferredWidth(50);
		forthColum.setMaxWidth(50);
		forthColum.setMinWidth(50);
		
		TableColumn fifthColum = table.getColumnModel().getColumn(4);
		fifthColum.setPreferredWidth(150);
		fifthColum.setMaxWidth(150);
		fifthColum.setMinWidth(150);
		
		TableColumn sixthColum = table.getColumnModel().getColumn(5);
		sixthColum.setPreferredWidth(100);
		sixthColum.setMaxWidth(100);
		sixthColum.setMinWidth(100);
		
		TableColumn  seventhColum = table.getColumnModel().getColumn(6);
		 seventhColum.setPreferredWidth(140);
		 seventhColum.setMaxWidth(140);
		 seventhColum.setMinWidth(140);
	
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
		organizationType.setSelectedItem(data);
		
	}

	public String getData() {
		String data = organizationType.getSelectedIndex()+"";
		return data;
	}
	public MyJTable getTable(){
		return table;
	}
}
