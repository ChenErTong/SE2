package ui.specialui.manager.AccountManage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;


public class SearchAccount extends MyTranslucentPanel{

	private MyButton search ;
	private MyJComboBox userList;
	private MyJTable	table;
	private JScrollPane jsp;
	public SearchAccount(AccountManage handle) {
		super(50,100-30,610,240);
		this.initComponent(handle);
	}

	private void initComponent(AccountManage handle) {
		String [] identity = {"所有员工","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员","司机","快递员"};
		
		MyJLabel userIdentity = new MyJLabel(35,5,120,30, "请选择员工类别",16,true);
		this.add(userIdentity);
		
		search = new MyButton(350,5,30,30,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("Search");
		search.addActionListener( handle);
		this.add(search);
		
		
		userList = new MyJComboBox(155,5,150,30,identity);
		this.add(userList);
		
		this.initTable();
	}
	
	private void initTable(){
		//the table
		String[] headers = {"编号", "姓名", "职务", "出生日期", "身份证号","任职时间","薪水","联系方式","车辆编号","订单编号"};
		table = new MyJTable(headers, false, this);		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SearchAccount.this.repaint();
			}
		});
		jsp=new MyJScrollPane(15, 45, 580, 190, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				SearchAccount.this.repaint();
			}
		});
		this.add(jsp);
	}
	public String getData(){
		int i = userList.getSelectedIndex();
		String data = i+"";
		return data;
	}
	
	public MyJTable getTable(){
		return table;
	}

	private static final long serialVersionUID = 1L;
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
