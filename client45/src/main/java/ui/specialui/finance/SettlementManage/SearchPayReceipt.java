package ui.specialui.finance.SettlementManage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import ui.image.LoginImage;
import ui.myui.MyButton;

import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJScrollPane;
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
	private MyButton search;
	private MyJTable table;
	private JScrollPane jsp;
	private MyJComboBox payState;

	
	public SearchPayReceipt(SettlementManage handle) {
		super(30, 100-30, 620, 240);
		this.initComponent(handle);
	}

	private void initComponent(SettlementManage handle) {
		chooseDate = new MyJLabel(20,10,120,30,"请选择收款单状态",14,true);
		this.add(chooseDate);
		
		String[] state = {"未审批","通过审批","未通过审批"};
		payState = new MyJComboBox(142,10,150,30,state);
		this.add(payState);
	
		
		search = new MyButton(508-30+5,10,30,30,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("SearchPayReceipt");
		search.addActionListener(handle);
		this.add(search);
		
		this.initTable();
	}
	class DateLabel extends JLabel {
		private static final long serialVersionUID = 1L;

		public DateLabel(String Text) {
			super(Text, JLabel.LEFT);
			this.setFont(getFont());
		}
	}
	/**
	 * 添加输入日期的输入框
	 */
		private void initTable(){
		//the table
		String[] headers = {"付款单编号","付款人","付款金额","付款账号","付款条目","付款备注","付款日期"};
		table = new MyJTable(headers, false, this);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SearchPayReceipt.this.repaint();
			}
		});
		jsp=new MyJScrollPane(15, 50, 590, 180, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				SearchPayReceipt.this.repaint();
			}
		});
		this.add(jsp);
	}
	

	public int getData(){
		int data = 0;
		data = payState.getSelectedIndex();
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
