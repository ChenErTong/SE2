package ui.specialui.manager.AdjustBase;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;


public class BaseInfoList extends MyTranslucentPanel{
	private MyJComboBox startCityList;
	private MyJComboBox arrivalCityList;
	private MyJButton search;
	private MyJTable table;
	public BaseInfoList(Panel_Manager_AdjustBase handle) {
		super(50, 100, 620, 560);
		this.initComponent( handle);
	}
	private void initComponent(Panel_Manager_AdjustBase handle) {

			String [] startCity = {"上海","南京","杭州","广州"};
			String [] arrivalCity = {"上海","南京","杭州","广州"};
			this.add(new MyJLabel(20,10,120,30, "选择出发城市",16,true));
			this.add(new MyJLabel(270,10,120,30,"选择到达城市",16,true));
			
			startCityList = new MyJComboBox(140,10,120,30,startCity);
			this.add(startCityList);
	
			arrivalCityList = new MyJComboBox(390,10,150,30,arrivalCity);
			this.add(arrivalCityList);
			search = new MyJButton(550,10,70,30,"搜索",16);
			search.setActionCommand("SearchBase");
			search.addActionListener(handle);
			this.add(search);
			
			//the table
			String[] headers = {"出发城市","到达城市","城市距离","运输单价"};
			table = new MyJTable(headers, false);
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
							
			jsp.setBounds(15, 50, 590, 495);
			jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
			jsp.setOpaque(false);
			jsp.setBorder(BorderFactory.createEmptyBorder());
			jsp.setVisible(true);
			this.add(jsp);
	}
	
	public void setData(String data[]) {
		startCityList.setSelectedItem(data[0]);
		arrivalCityList.setSelectedItem(data[1]);
	
	}

	public String []getData() {
		String  data[] = new String[2] ;
		data[0]= (String) startCityList.getSelectedItem();
		data[1] =(String) arrivalCityList.getSelectedItem();
		return data;
	}
	
	public MyJTable getTable(){
		return table;
	}
	private static final long serialVersionUID = 1L;

}
