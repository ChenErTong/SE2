package ui.specialui.manager.AdjustBase;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.image.CommonImage;
import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyTable;
import ui.specialui.manager.FrameManager;

public class Panel_Manager_AdjustBase extends MyJPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panel_Manager_AdjustBase(FrameManager frameManager) {
		
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
		
	}
	

	private void initComponent(FrameManager frameManager) {
	
		String [] baseType = {"所有常量","快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};
	//	String [] policyType = {"所有策略","按月","计次","提成"};
		
		MyJLabel baseTypeLabel= new MyJLabel(50,100,120,30, "选择常量类别",16,true);
		this.add(baseTypeLabel);
		
	//	MyJLabel policyTypeLabel = new MyJLabel(325,100,120,30,"选择策略类别",14,true);
	//	this.add(policyTypeLabel);
		
		MyComboBox baseTypeList = new MyComboBox(165,100,150,30,14,baseType);
		this.add(baseTypeList);
		
		//MyComboBox policyTypeList = new MyComboBox(425,100,150,30,14,policyType);
		//this.add(policyTypeList);
		
		//the table
		String[] headers = {"常量类别","两地距离","运输单价","详细常量信息"};
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
		
		 
		MyJButton ViewBaseInfo = new MyJButton(85, 650, 150, 40,"查看当前所选常量",14);
		ViewBaseInfo.setActionCommand("ViewBaseInfo");
		ViewBaseInfo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(ViewBaseInfo);
		ViewBaseInfo.setVisible(true);
		
		MyJButton AddNewBase = new MyJButton(425, 650, 150, 40,"添加常量",14);
		AddNewBase.setActionCommand("AddNewBase");
		AddNewBase.addActionListener(frameManager);
		this.add(AddNewBase);
		AddNewBase.setVisible(true);
		
		
		
		MyJButton ModifyBaseInfo = new MyJButton(705,650,150,40,"修改常量信息",14);
		ModifyBaseInfo.setActionCommand("ModifyBase");
		ModifyBaseInfo.addActionListener(frameManager);
		this.add(ModifyBaseInfo);
		ModifyBaseInfo.setVisible(true);
		
		
		MyJButton DeleteBase = new MyJButton(1045, 650, 150, 40,"删除常量",14);
		 DeleteBase.setActionCommand(" DeleteBase");
		 DeleteBase.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			 
		 });
		 //DeleteBase.addActionListener(frameManager);
		this.add( DeleteBase);
		
	}
}
