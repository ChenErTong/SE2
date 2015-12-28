package ui.specialui.manager.AdjustBase;

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
 * 进行搜索成本常量的Panel
 * @author zsq
 * @version 2015/12/05 13：45
 */
public class SearchBaseInfo extends MyTranslucentPanel{

	@SuppressWarnings("unused")
	private MyJComboBox startCityList;
	@SuppressWarnings("unused")
	private MyJComboBox arrivalCityList;
	private MyJTextField baseID;
	private MyButton search;
	private MyJTable table;
	private JScrollPane jsp;
	
	public SearchBaseInfo(AdjustBase handle) {
		super(50, 100-30, 620, 560-27);
		this.initComponent( handle);
	}
	
	private void initComponent(AdjustBase handle) {
		//	String [] startCity = {"上海","南京","杭州","广州"};
			//String [] arrivalCity = {"上海","南京","杭州","广州"};
		//	this.add(new MyJLabel(20,10,120,30, "选择出发城市",16,true));
		//	this.add(new MyJLabel(270,10,120,30,"选择到达城市",16,true));
			this.add(new MyJLabel(20,10,180,30,"输入常量ID",16,true));
			baseID = new MyJTextField(140,10,150,30);
			this.add(baseID);
		//	startCityList = new MyJComboBox(140,10,120,30,startCity);
		//	this.add(startCityList);
	
			//arrivalCityList = new MyJComboBox(390,10,150,30,arrivalCity);
			//this.add(arrivalCityList);
			search = new MyButton(300,10,30,30,LoginImage.getBUTTON_LOGISTIC());
			search.setActionCommand("SearchBase");
			search.addActionListener(handle);
			this.add(search);
			
			this.initTable();
	}
	
	private void initTable(){
		//the table
		String[] headers = {"出发城市","到达城市","城市距离","运输单价"};
		table = new MyJTable(headers, false, this);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SearchBaseInfo.this.repaint();
			}
		});
		jsp=new MyJScrollPane(15, 50, 590, 495-27, table);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				SearchBaseInfo.this.repaint();
			}
		});
		this.add(jsp);
	}
	public void setData(String data[]) {
		//startCityList.setSelectedItem(data[0]);
		//arrivalCityList.setSelectedItem(data[1]);
	}

	public String getData() {
		String data = baseID.getText();
		if(data==null){
			return null;
		}
		return data;
		//String  data[] = new String[2] ;
		//data[0]= (String) startCityList.getSelectedItem();
		//data[1] =(String) arrivalCityList.getSelectedItem();
		//return data;
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
