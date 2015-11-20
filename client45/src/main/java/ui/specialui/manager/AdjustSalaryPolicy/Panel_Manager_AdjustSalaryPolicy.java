package ui.specialui.manager.AdjustSalaryPolicy;

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

public class Panel_Manager_AdjustSalaryPolicy extends MyJPanel{


	public Panel_Manager_AdjustSalaryPolicy(FrameManager frameManager) {
		
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
	}

	
	private void initComponent(FrameManager frameManager) {
		String [] employeeType = {"所有员工","快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};
		String [] policyType = {"所有策略","按月","计次","提成"};
		
		MyJLabel employeeTypeLabel= new MyJLabel(50,100,120,30, "选择员工类别",16,true);
		this.add(employeeTypeLabel);
		
		MyJLabel policyTypeLabel = new MyJLabel(325,100,120,30,"选择策略类别",16,true);
		this.add(policyTypeLabel);
		
		MyComboBox employeeTypeList = new MyComboBox(165,100,150,30,14,employeeType);
		this.add(employeeTypeList);
		
		MyComboBox policyTypeList = new MyComboBox(425,100,150,30,14,policyType);
		this.add(policyTypeList);
		
		//the table
		String[] headers = {"员工类别","策略类别","策略规则解释","详细薪水信息"};
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
						
		jsp.setBounds(35, 140, 1216, 495);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		 
		MyJButton ViewPolicyInfo = new MyJButton(85, 650, 150, 40,"查看当前所选策略",14);
		ViewPolicyInfo.setActionCommand("ViewOrganizationInfo");
		ViewPolicyInfo.addActionListener(frameManager);
		this.add(ViewPolicyInfo);
		ViewPolicyInfo.setVisible(true);
		
		MyJButton AddNewPolicy = new MyJButton(425, 650, 150, 40,"添加策略",14);
		AddNewPolicy.setActionCommand("AddNewPolicy");
		AddNewPolicy.addActionListener(frameManager);
		this.add(AddNewPolicy);
		AddNewPolicy.setVisible(true);
		
		
		
		MyJButton ModifyPolicyInfo = new MyJButton(705,650,150,40,"修改策略信息",14);
		ModifyPolicyInfo.setActionCommand("ModifyPolicy");
		ModifyPolicyInfo.addActionListener(frameManager);
		this.add(ModifyPolicyInfo);
		ModifyPolicyInfo.setVisible(true);
		
		
		MyJButton DeletePolicy = new MyJButton(1045, 650, 150, 40,"删除策略",14);
		 DeletePolicy.setActionCommand(" DeletePolicy");
		 DeletePolicy.addActionListener(frameManager);
		this.add( DeletePolicy);
		
	}


	private static final long serialVersionUID = 1L;

}
