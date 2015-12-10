package ui.specialui.manager.AdjustBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 添加新的运营成本常量的Panel
 * @author zsq
 * @version 2015/12/5 13:15
 */
public class AddBase extends MyTranslucentPanel{
	
	private MyJComboBox startCityList;
	private MyJComboBox arrivalCityList;
	private MyJTextField distances;
	private MyJTextField price;

	public AddBase() {
		super(680,70,580,240);
		this.initComponent();
	}
	
	private void initComponent() {
		this.add(new MyJLabel(240,10,100,30,"添加常量",20,true));
		this.add(new MyJLabel(25,50,90,30,"出发城市",18,true));
		this.add(new MyJLabel(285,50,90,30,"到达城市",18,true));
		this.add(new MyJLabel(25,140,90,30,"两地距离",18,true));
		this.add(new MyJLabel(295,140,80,30,"运输单价",18,true));
		this.add(new MyJLabel(265,140,20,30,"km",18,true));
		this.add(new MyJLabel(525,140,50,30,"元/km",18,true));
		
		String [] startCity = {"上海","南京","北京","广州"};
		String [] arrivalCity = {"上海","南京","北京","广州"};
		startCityList = new MyJComboBox(115,50,150,30,startCity);
		this.add(startCityList);
		startCityList.setSelectedIndex(0);

		arrivalCityList = new MyJComboBox(375,50,150,30,arrivalCity);
		this.add(arrivalCityList);
		arrivalCityList.setSelectedIndex(0);
	
		distances = new MyJTextField(115,140,150,30);
		distances.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==distances){
					price.requestFocus();
				}
				
			}
			
		});
		this.add(distances);
	
		price = new MyJTextField(375,140,150,30);
		this.add(price);
	}
	
	public void setUneditable() {
		startCityList.setEditable(false);
		arrivalCityList.setEditable(false);
		distances.setEditable(false);
		price.setEditable(false);
	}

	public void setData(String[] data) {
		if(data==null){
			return;
		}else{
			startCityList.setSelectedItem(data[0]);
			arrivalCityList.setSelectedItem(data[1]);
			distances.setText(data[2]);
			price.setText(data[3]);
		}
	}

	public void refresh() {
		startCityList.setSelectedItem(null);
		arrivalCityList.setSelectedItem(null);
		distances.setText(null);
		price.setText(null);
	}

	public String[] getData() {
		String[] data = new String[4];
		data[0] = startCityList.getSelectedItem()+"";
		data[1] = arrivalCityList.getSelectedItem()+"";
		data[2] = distances.getText();
		data[3] = price.getText();
		return data;
	}
	private static final long serialVersionUID = 1L;
}
