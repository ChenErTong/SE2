package ui.specialui.finance.CostManage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import ui.specialui.finance.Frame_Finance;

public class Panel_Finance_CostManagement extends MyJPanel{

	private static final long serialVersionUID = 1L;

	private Panel_Finance_DebitReceiptInfo debitReceiptInfo;
	public Panel_Finance_CostManagement(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		debitReceiptInfo = new Panel_Finance_DebitReceiptInfo();
		this.add(debitReceiptInfo);
		
		MyJLabel chooseBranch = new MyJLabel(20,120,120,30,"请选择营业厅",18,true);
		this.add(chooseBranch);
		
		MyJLabel chooseDate = new MyJLabel(300,120,108,30,"请选择日期",18,true);
		this.add(chooseDate);
		
		String[] branches = {"所有营业厅"};
		MyComboBox branchList = new MyComboBox(140,120,150,30,18,branches);
		this.add(branchList);
		
		String[] dates = {};
		MyComboBox dateList = new MyComboBox(408,120,150,30,18,dates);
		this.add(dateList);
		
		//the table
				String[] headers = {"收款单编号","营业厅编号","营业厅名称","经手人"};
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
								
				jsp.setBounds(20, 160, 620, 510);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
		
				MyJButton ViewDebitInfo = new MyJButton(85, 675, 150, 40,"查看收款单",14);
				ViewDebitInfo.setActionCommand("ViewReceiptInfo");
				ViewDebitInfo.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				this.add(ViewDebitInfo);
				ViewDebitInfo.setVisible(true);
				
				MyJButton AddDebitReceipt = new MyJButton(255, 675, 150, 40,"添加收款单",14);
				AddDebitReceipt.setActionCommand("AddDebit");
				AddDebitReceipt.addActionListener(frame_Finance);
				this.add(AddDebitReceipt);
				AddDebitReceipt.setVisible(true);
				
				MyJButton ModifyDebitInfo = new MyJButton(425, 675, 150, 40,"删除收款单",14);
				
				ModifyDebitInfo.setActionCommand("ModifyDebitInfo");
				ModifyDebitInfo.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
				
					}
					
				});
				this.add(ModifyDebitInfo);
				ModifyDebitInfo.setVisible(true);
				
				MyJButton DeleteDebit = new MyJButton(705,675,150,40,"修改收款单",14);
				DeleteDebit.setActionCommand("DeleteDebit");
				DeleteDebit.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				this.add(DeleteDebit);
				DeleteDebit.setVisible(true);
				
				MyJButton SaveChanges = new MyJButton(875, 675, 150, 40,"保存修改",14);
				SaveChanges.setActionCommand("SaveChanges");
				SaveChanges.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				this.add(SaveChanges);
				
				MyJButton BackoutChanges = new MyJButton(1045, 675, 150, 40,"撤销修改",14);
				BackoutChanges.setActionCommand("BackoutChanges");
				BackoutChanges.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				this.add(BackoutChanges);

	}
}
	