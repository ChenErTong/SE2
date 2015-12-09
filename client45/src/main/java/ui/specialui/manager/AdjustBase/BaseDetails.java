package ui.specialui.manager.AdjustBase;

import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class BaseDetails extends MyTranslucentPanel{
	private MyComboBox startCityList;
	private MyComboBox arrivalCityList;
	private MyEmptyTextArea baseDetail;
	private MyJTextField distances;
	private MyJTextField price;
	public BaseDetails() {
		super(680,100,550,562);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(25,50,90,30,"出发城市",18,true));
		this.add(new MyJLabel(285,50,90,30,"到达城市",18,true));
		this.add(new MyJLabel(25,140,90,30,"两地距离",18,true));
		this.add(new MyJLabel(285,140,90,30,"运输单价",18,true));
		this.add(new MyJLabel(25,230,90,30,"详细信息",18,true));
		String [] startCity = {"所有城市"};
		String [] arrivalCity = {"所有城市"};
		startCityList = new MyComboBox(115,50,150,30,16,startCity);
		this.add(startCityList);
		startCityList.setSelectedIndex(0);

		arrivalCityList = new MyComboBox(375,50,150,30,16,arrivalCity);
		this.add(arrivalCityList);
		arrivalCityList.setSelectedIndex(0);
		
		distances = new MyJTextField(115,140,150,30);
		distances.setOnlyDouble();
		this.add(distances);
		
		price = new MyJTextField(375,140,150,30);
		price.setOnlyDouble();
		this.add(price);
		
		baseDetail = new MyEmptyTextArea(115,230,410,180);
		this.add(baseDetail);
		
	}
	public void setUneditable() {
		startCityList.setEditable(false);
		arrivalCityList.setEditable(false);
		distances.setEditable(false);
		price.setEditable(false);
		baseDetail.setEditable(false);
	}

	public void setData(String[] data) {
		if(data==null){
			return;
		}else{
			startCityList.setSelectedItem(data[0]);
			arrivalCityList.setSelectedItem(data[1]);
			distances.setText(data[2]);
			price.setText(data[3]);
			baseDetail.setText(data[4]);
		}
	}

	public void refresh() {
		startCityList.setSelectedItem(null);
		arrivalCityList.setSelectedItem(null);
		distances.setText(null);
		price.setText(null);
		baseDetail.setText(null);
	}

	public String[] getData() {
		String[] data = new String[5];
		data[0] = startCityList.getSelectedIndex()+"";
		data[1] = arrivalCityList.getSelectedIndex()+"";
		data[2] = distances.getText();
		data[3] = price.getText();
		data[4] = baseDetail.getText();
		return data;
	}
	private static final long serialVersionUID = 1L;

}
