package ui.specialui.finance.SettlementManage;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;

/**
 * 按照日期搜索收款单
 * @author zsq
 * @version 2015/12/5 10:11
 */
public class SearchPayReceipt extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJLabel chooseDate;
	private MyComboBox dateList;
	private MyButton search;
	private MyJTable table;
	private JScrollPane jsp;
	
	public SearchPayReceipt(SettlementManage handle) {
		super(50, 100, 620, 240);
		this.initComponent(handle);
	}

	private void initComponent(SettlementManage handle) {
		chooseDate = new MyJLabel(20,10,120,30,"请选择日期",14,true);
		this.add(chooseDate);
		
		String[] dates = {""};
		dateList = new MyComboBox(140,10,150,30,14,dates);
		this.add(dateList);
		
		search = new MyButton(470,10,120,30,FinanceImage.getBUTTON_SEARCH());
		search.setActionCommand("SearchPayReceipt");
		search.addActionListener(handle);
		this.add(search);
		this.initTable();
	}
	
	private void initTable(){
		//the table
				String[] headers = {"付款单编号","付款人","付款金额","付款账号","付款条目","付款备注","付款日期"};
				table = new MyJTable(headers, false);
				table.setBackground(new Color(40, 42, 66));
				table.setForeground(Color.WHITE);
				table.setFont(new MyFont(14));
									
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
				tcr.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, tcr);
											  	
				jsp=new JScrollPane(table);
				JTableHeader head = table.getTableHeader();
				head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
				head.setFont(new MyFont(14));
				head.setForeground(Color.BLACK);
				head.setResizingAllowed(false);
										
				jsp.setBounds(15, 50, 590, 180);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
	}
	public void setData(String data) {
		dateList.setSelectedItem(data);
	}

	public String getData() {
		String  data ;
		data= (String) dateList.getSelectedItem();
		return data;
	}
	
	public MyJTable getTable() {
		return table;
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
