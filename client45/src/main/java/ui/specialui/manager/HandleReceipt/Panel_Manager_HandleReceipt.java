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
		this.add(new MyJLabel(550, 20, 210, 90, "公司运营单据处理", 24, true));
		searchPanel = new Panel_Manager_SearchReceipt();
		this.add(searchPanel);
		
		receiptInfo = new Panel_Manager_ReceiptInfo();
		this.add(receiptInfo);

		
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
