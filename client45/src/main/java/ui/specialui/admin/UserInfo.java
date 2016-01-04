package ui.specialui.admin;

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

/**
 * 用户管理界面查找用户和用户列表的显示Panel
 * @author zsq
 * @version 2015/12/5 23:21
 */
public class UserInfo extends MyTranslucentPanel{
	
	private static final long serialVersionUID = 1L;
	
	 private MyJLabel userIdentity;
	 private MyJComboBox userList;
	 private MyButton search;
	 private MyJTable table;
	 private JScrollPane jsp;
	 
	 public UserInfo(Panel_Admin_Total handle) {
		super(50, 100, 620, 560);
		this.initComponent(handle);
	}

	private void initComponent(Panel_Admin_Total handle){
	
		String [] identity = {"所有用户","总经理","快递员","中转库存管理员","中转中心业务员","营业厅业务员","财务人员","管理员"};
	
		userIdentity = new MyJLabel(20,10,120,30, "请选择用户类别",14,true);
		this.add(userIdentity);
		
		userList = new MyJComboBox(140,10,180,30,identity);
		this.add(userList);
		
		search = new MyButton(330,10,35,35,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("SearchUser");
		search.addActionListener(handle);
		this.add(search);
		
		this.initTable();
	}
	
	private void initTable(){
		table = new MyJTable(new String[]{"用户编号", "用户姓名", "用户密码", "用户类别", "用户权限","联系方式","家庭地址"},false, this);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				UserInfo.this.repaint();
			}
		});
		
		jsp = new MyJScrollPane(15, 50, 590, 495, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				UserInfo.this.repaint();
			}
		});
		this.add(jsp);
		
//		table.setBackground(new Color(40, 42, 66));
//		table.setForeground(Color.WHITE);
//		table.setFont(new MyFont(14));
//
//		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
//		firsetColumn.setPreferredWidth(80);
//		firsetColumn.setMaxWidth(80);
//		firsetColumn.setMinWidth(80);
//		
//		TableColumn secondColumn = table.getColumnModel().getColumn(1);
//		secondColumn.setPreferredWidth(80);
//		secondColumn.setMaxWidth(80);
//		secondColumn.setMinWidth(80);
//		
//		TableColumn thirdColumn = table.getColumnModel().getColumn(2);
//		thirdColumn.setPreferredWidth(80);
//		thirdColumn.setMinWidth(80);
//		thirdColumn.setMaxWidth(80);
//		
//		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
//		tcr.setHorizontalAlignment(JLabel.CENTER);
//		table.setDefaultRenderer(Object.class, tcr);
//		
//		jsp=new JScrollPane(table);
//		JTableHeader head = table.getTableHeader();
//		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
//		head.setFont(new MyFont(14));
//		head.setForeground(Color.BLACK);
//		head.setResizingAllowed(false);
//				
//		jsp.setBounds(15, 50, 590, 495);
//		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
//		jsp.setOpaque(false);
//		jsp.setBorder(BorderFactory.createEmptyBorder());
//		jsp.setVisible(true);
//		this.add(jsp);
	}
	
	public void setData(String data) {
		userList.setSelectedItem(data);
	}

	public int  getData() {
		int   data ;
		data = userList.getSelectedIndex();
		return data;
	}
	
	public MyJTable getTable(){
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
