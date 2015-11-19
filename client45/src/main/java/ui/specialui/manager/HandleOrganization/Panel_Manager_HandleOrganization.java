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
import ui.myui.MyJPanel;
import ui.myui.MyTable;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_HandleOrganization extends MyJPanel {

	private Panel_Manager_OrganizationInfo organizationInfo;
	public Panel_Manager_HandleOrganization(FrameManager frameManager) {
	
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	private void initComponent(FrameManager frame_Manager) {
		String [] organizationType = {"所有机构","营业厅","中转中心"};
		
		
		MyJLabel receiptTypeLabel= new MyJLabel(50,100,120,30, "选择机构类别",16,true);
		this.add(receiptTypeLabel);
		
	//	MyJLabel receiptStateLabel = new MyJLabel(325,100,120,30,"选择单据状态",14,true);
	//	this.add(receiptStateLabel);
		
		MyComboBox receiptTypeList = new MyComboBox(165,100,150,30,14,organizationType);
		this.add(receiptTypeList);
		
	//	MyComboBox receiptStateList = new MyComboBox(425,100,150,30,14,receiptState);
	//	this.add(receiptStateList);
		
		//the table
		String[] headers = {"机构编号","机构类型","机构名称","机构地址","机构人数","联系电话"};
		MyTable	table = new MyTable(headers);
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
						
		jsp.setBounds(35, 140, 590, 495);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		 
		MyJButton ViewOrganizationInfo = new MyJButton(85, 650, 150, 40,"查看当前所选机构",14);
		ViewOrganizationInfo.setActionCommand("ViewOrganizationInfo");
		ViewOrganizationInfo.addActionListener(frame_Manager);
		this.add(ViewOrganizationInfo);
		ViewOrganizationInfo.setVisible(true);
		
		MyJButton AddOrganization = new MyJButton(425, 650, 150, 40,"添加机构",14);
		AddOrganization.setActionCommand("AddOrganization");
		AddOrganization.addActionListener(frame_Manager);
		this.add(AddOrganization);
		AddOrganization.setVisible(true);
		
		
		
		MyJButton ModifyOrganizationInfo = new MyJButton(705,650,150,40,"修改机构信息",14);
		ModifyOrganizationInfo.setActionCommand("ModifyOrganizationInfo");
		ModifyOrganizationInfo.addActionListener(frame_Manager);
		this.add(ModifyOrganizationInfo);
		ModifyOrganizationInfo.setVisible(true);
		
		
		MyJButton DeleteOrganization = new MyJButton(1045, 650, 150, 40,"删除机构",14);
		DeleteOrganization.setActionCommand("DeleteOrganization");
		DeleteOrganization.addActionListener(frame_Manager);
		this.add(DeleteOrganization);
		
		organizationInfo = new Panel_Manager_OrganizationInfo();
		this.add(organizationInfo);
	}
	
	private static final long serialVersionUID = 1L;

}
