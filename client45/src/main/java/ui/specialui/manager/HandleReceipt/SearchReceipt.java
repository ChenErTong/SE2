package ui.specialui.manager.HandleReceipt;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyColor;

import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class SearchReceipt extends MyTranslucentPanel{
	private JTable table;
	DefaultTableModel model;
	
	private MyButton selectButton;
	private MyJComboBox receiptTypeList;
	private MyJComboBox receiptStateList;
	private JScrollPane jsp;
	private static final long serialVersionUID = 1L;
	
	public SearchReceipt(HandleReceipt handle) {
		super(30,100-30, 655, 540);
		this.initComponent(handle);
	}

	private void initComponent(HandleReceipt handle) {
		String [] receiptType = {"所有单据","寄件单","装车单","营业厅到达单","收款单","派件单","中转中心到达单","入库单","中转单","出库单","付款单"};
		String [] receiptState = {"全部状态", "待审批", "通过审批", "未通过审批"};
		
		MyJLabel receiptTypeLabel= new MyJLabel(20,10,120,30, "选择单据状态",14,true);
		this.add(receiptTypeLabel);
		
		MyJLabel receiptStateLabel = new MyJLabel(295,10,120,30,"选择单据类别",14,true);
		this.add(receiptStateLabel);
		
		selectButton = new MyButton(395+150+5,10,30,30,LoginImage.getBUTTON_LOGISTIC());
		selectButton.setActionCommand("SearchReceipt");;
		selectButton.addActionListener(handle);
			
		
		this.add(selectButton);

		receiptTypeList = new MyJComboBox(135,10,150,30,receiptState);
		this.add(receiptTypeList);
		
		receiptStateList = new MyJComboBox(395,10,150,30,receiptType);
		this.add(receiptStateList);
		this.initTable();	
	}
	
	
	private void initTable(){
		ReceiptTableModel tablemodel = new ReceiptTableModel();
		
		table = new JTable(tablemodel);
		table.setCellSelectionEnabled(false);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);	
		JTableHeader head = table.getTableHeader();
		head.setBackground(MyColor.getColor());
		
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(30);
		firsetColumn.setMaxWidth(30);
		firsetColumn.setMinWidth(30);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setMaxWidth(110);
		table.getColumnModel().getColumn(1).setMinWidth(110);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setMaxWidth(180);
		table.getColumnModel().getColumn(2).setMinWidth(180);
		
		jsp = new JScrollPane(table);
		jsp.setBounds(10, 50, 630, 485);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);	
	}
	
	 public JTable getTable(){
		 return table;
	 }
	 public int[] getData(){
		int data[] = new int[2];
		 data[0] = receiptTypeList.getSelectedIndex();
		 data[1] = receiptStateList.getSelectedIndex();
		 return data;
	 }
	
	public MyButton getSearch() {
		return selectButton;
	}

	@SuppressWarnings("unused")
	private class WheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			JScrollBar onlineFriendsBar =  jsp.getHorizontalScrollBar();
			if (!((onlineFriendsBar.getValue() == onlineFriendsBar.getMinimum() && e.getWheelRotation() <= 0) || (onlineFriendsBar.getValue() == onlineFriendsBar.getMaximum() && e.getWheelRotation() >= 0))) {
				if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 >= onlineFriendsBar.getMaximum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMaximum());
				} else if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 <= onlineFriendsBar.getMinimum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMinimum());
				} else {
					onlineFriendsBar.setValue(onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement()
												* e.getUnitsToScroll() * 10);
				}
			}
		}
	}
}

