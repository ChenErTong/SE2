package ui.specialui.manager.AdjustBase;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.manager.FrameManager;

public class BaseInfoList extends MyTranslucentPanel{
	private MyComboBox startCityList;
	private MyComboBox arrivalCityList;
	private MyJButton search;
	public BaseInfoList(FrameManager frame_Manager) {
		super(50, 100, 620, 560);
		this.initComponent( frame_Manager);
	}
	private void initComponent(FrameManager frame_Manager) {

			String [] startCity = {"所有城市"};
			String [] arrivalCity = {"所有城市"};
			this.add(new MyJLabel(20,10,120,30, "选择出发城市",16,true));
			this.add(new MyJLabel(270,10,120,30,"选择到达城市",16,true));
			
			startCityList = new MyComboBox(140,10,120,30,16,startCity);
			this.add(startCityList);
	
			arrivalCityList = new MyComboBox(390,10,150,30,16,arrivalCity);
			this.add(arrivalCityList);
			search = new MyJButton(550,10,70,30,"搜索",16);
			search.setActionCommand("SearchBase");
			search.addActionListener(frame_Manager);
			this.add(search);
			
			//the table
			String[] headers = {"城市距离","运输单价","详细常量信息"};
			MyJTable	table = new MyJTable(headers, false);
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

	@SuppressWarnings("null")
	public String []getData() {
		String  data[] = null ;
		data[0]= (String) startCityList.getSelectedItem();
		data[1] =(String) arrivalCityList.getSelectedItem();
		return data;
	}
	private static final long serialVersionUID = 1L;

}
