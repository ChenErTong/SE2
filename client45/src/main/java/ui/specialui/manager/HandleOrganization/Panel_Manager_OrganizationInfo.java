package ui.specialui.manager.HandleOrganization;

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
import ui.specialui.manager.FrameManager;

public class Panel_Manager_OrganizationInfo extends MyTranslucentPanel{
	
	private static final long serialVersionUID = 1L;

	 private MyJLabel ChooseType;
	 private MyComboBox organizationType;
	 private MyJButton search;
	public Panel_Manager_OrganizationInfo(FrameManager frame_Manager) {
		super(50, 100, 620, 560);
		this.initComponent(frame_Manager);
	}
	
	private void initComponent(FrameManager frame_Manager) {
		String [] organizationTypes = {"营业厅","中转中心"};
		
		ChooseType = new MyJLabel(20,10,120,30, "请选择机构类别",14,true);
		this.add(ChooseType);
		
		 organizationType= new MyComboBox(140,10,150,30,14,organizationTypes);
		this.add(organizationType);
		
		search = new MyJButton(500,10,90,30,"搜索",14);
		search.setActionCommand("SearchOrganization");
		search.addActionListener(frame_Manager);
		this.add(search);
		
		//the table
		String[] headers = {"机构编号","机构类型","机构名称","机构地址","机构人数","联系电话"};
		MyJTable table = new MyJTable(headers,false);
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
		organizationType.setSelectedItem(data);
		
	}

	public String getData() {
		String  data ;
		data = (String) organizationType.getSelectedItem();
		return data;
	}
}
