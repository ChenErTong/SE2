package ui.specialui.manager.HandleReceipt;

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
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.specialui.manager.FrameManager;
/**
 * 处理单据的总Panel
 * @author zsq
 * @time 2015/11/18 23:58
 */
public class Panel_Manager_HandleReceipt extends MyJPanel {
	private static final long serialVersionUID = 1L;
	
	private Panel_Manager_SearchReceipt searchPanel;
	private Panel_Manager_ReceiptInfo receiptInfo;
	public Panel_Manager_HandleReceipt(FrameManager frame_Manager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Manager);
	}
	
	private void initComponent(FrameManager frame_Manager) {
		searchPanel = new Panel_Manager_SearchReceipt();
		this.add(searchPanel);
		
		receiptInfo = new Panel_Manager_ReceiptInfo();
		this.add(receiptInfo);
		/*String [] receiptType = {"所有单据","寄件订单","装车单","收件确认单","营业厅到达单","营业厅派件单","收款单","付款单","中转中心到达单","飞机转运单","火车转运单","卡车转运单","入库单","出库单","库存调整单"};
		String [] receiptState = {"所有状态","草稿","正在审批","通过审批","未通过审批"};
		
		MyJLabel receiptTypeLabel= new MyJLabel(50,100,120,30, "选择单据类别",14,true);
		this.add(receiptTypeLabel);
		
		MyJLabel receiptStateLabel = new MyJLabel(325,100,120,30,"选择单据状态",14,true);
		this.add(receiptStateLabel);
		
		MyComboBox receiptTypeList = new MyComboBox(165,100,150,30,14,receiptType);
		this.add(receiptTypeList);
		
		MyComboBox receiptStateList = new MyComboBox(425,100,150,30,14,receiptState);
		this.add(receiptStateList);
		
		//the table
		String[] headers = {};
<<<<<<< HEAD
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
		this.add(jsp);*/

	//	MyJTable	table = new MyJTable(headers, false);
//		table.setBackground(new Color(40, 42, 66));
//		table.setForeground(Color.WHITE);
//		table.setFont(new MyFont(14));					  	
		
	//	MyJScrollPane jsp=new MyJScrollPane(35, 140, 590, 495, table);
		//this.add(jsp);

		
		MyJButton ViewReceiptInfo = new MyJButton(85, 650, 150, 40,"查看当前所选单据",14);
		ViewReceiptInfo.setActionCommand("ViewReceiptInfo");
		ViewReceiptInfo.addActionListener(frame_Manager);
		this.add(ViewReceiptInfo);
		ViewReceiptInfo.setVisible(true);
		
		MyJButton PassSelectedReceipts = new MyJButton(255, 650, 150, 40,"通过所有选中单据",14);
		PassSelectedReceipts.setActionCommand("PassSelectedReceipts");
		PassSelectedReceipts.addActionListener(frame_Manager);
		this.add(PassSelectedReceipts);
		PassSelectedReceipts.setVisible(true);
		
		MyJButton ModifyReceiptInfo = new MyJButton(425, 650, 150, 40,"修改单据内容",14);
		
		ModifyReceiptInfo.setActionCommand("ModifyReceiptInfo");
		ModifyReceiptInfo.addActionListener(frame_Manager);
		this.add(ModifyReceiptInfo);
		ModifyReceiptInfo.setVisible(true);
		
		MyJButton PassThisReceipt = new MyJButton(705,650,150,40,"通过此单据",14);
		PassThisReceipt.setActionCommand("PassThisReceipt");
		PassThisReceipt.addActionListener(frame_Manager);
		this.add(PassThisReceipt);
		PassThisReceipt.setVisible(true);
		
		MyJButton DontPassThisReceipt = new MyJButton(875, 650, 150, 40,"不通过此单据",14);
		DontPassThisReceipt.setActionCommand("DontPassThisReceipt");
		DontPassThisReceipt.addActionListener(frame_Manager);
		this.add(DontPassThisReceipt);
		
		MyJButton ExportReceipt = new MyJButton(1045, 650, 150, 40,"导出单据",14);
		ExportReceipt.setActionCommand("ExportReceipt");
		ExportReceipt.addActionListener(frame_Manager);
		this.add(ExportReceipt);
		
		
		
		
		
	}
	
	

}
