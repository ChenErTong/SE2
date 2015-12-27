package ui.specialui.manager.HandleOrganization;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyFont;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.finance.ViewIncomeState.IncomeStateInfo;
/**
 * 搜索机构信息并显示列表
 * @author zsq
 * @version 2015/12/15 15:45
 */
public class SearchOrganizationInfo extends MyTranslucentPanel{
	
	private static final long serialVersionUID = 1L;

	 private MyJLabel ChooseType;
	 private MyJComboBox organizationType;
	 private MyButton search;
	 private  MyJTable table;
	 private JScrollPane jsp;
	 public SearchOrganizationInfo(HandleOrganization handle) {
		super(50, 100-30, 620, 560);
		this.initComponent(handle);
	}
	
	private void initComponent(HandleOrganization handle) {
		String [] organizationTypes = {"所有机构","营业厅","中转中心"};
		
		ChooseType = new MyJLabel(20,10,120,30, "请选择机构类别",14,true);
		this.add(ChooseType);
		
		 organizationType= new MyJComboBox(140,10,150,30,organizationTypes);
		this.add(organizationType);
		
		search = new MyButton(300,10,30,30,LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("SearchOrganization");
		search.addActionListener(handle);
		this.add(search);
		
		this.initTable();
	}
	private void initTable(){
		//the table
				String[] headers = {"编号","类型","日期","仓库/转运工具信息","员工信息","地址"};
				table = new MyJTable(headers,false,this);
				jsp=new MyJScrollPane(15, 50, 590, 495, table);
				jsp.addMouseWheelListener(new MouseWheelListener() {
					public void mouseWheelMoved(MouseWheelEvent e) {
						SearchOrganizationInfo.this.repaint();
					}
				});
				this.add(jsp);
	}
	
	public void setData(String[] data) {
		organizationType.setSelectedItem(data);
		
	}

	public String getData() {
		String data = organizationType.getSelectedIndex()+"";
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
