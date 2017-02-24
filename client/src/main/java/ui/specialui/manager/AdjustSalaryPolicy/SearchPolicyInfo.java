package ui.specialui.manager.AdjustSalaryPolicy;

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
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 查询薪水策略
 * @author zsq
 * @version 2015/12/05 14：30
 */
public class SearchPolicyInfo  extends MyTranslucentPanel{

	@SuppressWarnings("unused")
	private MyJLabel employeeType;
	@SuppressWarnings("unused")
	private MyJLabel policyType;
	private MyJComboBox employeeTypeBox;
	private MyJComboBox policyTypeBox;
	private MyButton search;
	private MyJTable table;
	private JScrollPane jsp;
	private MyJTextField policyID;
	
	public SearchPolicyInfo(AdjustSalaryPolicy handle) {
		super(50, 100-30, 620, 560-27);
		this.initComponent( handle);
	}

	private void initComponent(AdjustSalaryPolicy handle) {
		//String [] employeeTypes = {"快递员","财务人员","中转中心业务员","库存管理人员","营业厅业务员","司机","管理员","总经理"};
		
		//employeeType = new MyJLabel(20,10,120,30, "请选择员工类别",14,true);
		//this.add(employeeType);
		
		//policyType = new MyJLabel(300,10,120,30,"请选择策略类别",14,true);
		//this.add(policyType);
		
		// employeeTypeBox= new MyJComboBox(140,10,150,30,employeeTypes);
		//this.add(employeeTypeBox);
		
	//	String [] policyTypes = {"按月","计次","提成"};
	//	policyTypeBox = new MyJComboBox(420,10,90,30,policyTypes);
		//this.add(policyTypeBox);
		
		this.add(new MyJLabel(20,10,180,30,"输入常量ID",16,true));
		policyID = new MyJTextField(140,10,150,30);
		this.add(policyID);	
	
		search = new MyButton(300,10,30,30,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("Search");
		search.addActionListener(handle);
		this.add(search);
		
		this.initTable();
	}
	
		private void initTable(){
		//the table
				String[] headers = {"员工类别","策略类别","策略规则"};
				table = new MyJTable(headers,false, this);
				table.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						SearchPolicyInfo.this.repaint();
					}
				});
				jsp=new MyJScrollPane(15, 50, 590, 495-27, table);
				jsp.addMouseWheelListener(new MouseWheelListener() {
					public void mouseWheelMoved(MouseWheelEvent e) {
						SearchPolicyInfo.this.repaint();
					}
				});
				this.add(jsp);
	}
	
	public void setData(String[] data) {
		employeeTypeBox.setSelectedItem(data[0]);
		policyTypeBox.setSelectedItem(data[1]);
	}

	public String getData() {
		String data = policyID.getText();
		if(data==null){
			return null;
		}
		//String  data[] = new String[2];
		//data[0] = (String) employeeTypeBox.getSelectedItem();
		//data[1] = (String) policyTypeBox.getSelectedItem();
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
	private static final long serialVersionUID = 1L;
}
