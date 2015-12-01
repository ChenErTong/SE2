package ui.specialui.manager.HandleOrganization;

import javax.swing.JComboBox;

import ui.GetDate;
import ui.Config.JComboBoxOfChina;
import ui.myui.MyComboBox;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class OrganizationDetails extends MyTranslucentPanel{
	private MyJTextField[] fields;
	private MyComboBox organizationType ;
	@SuppressWarnings("rawtypes")
	private JComboBox provincesBox;
	@SuppressWarnings("rawtypes")
	private JComboBox citiesBox;
	private MyEmptyTextArea address;
	public OrganizationDetails() {
		super(680,100,550,562);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[4];
		this.add(new MyJLabel(10, 60, 90, 30, "机构类别", 18, true));
		fields[0] = new MyJTextField(100,60,140,30);
		//fields[0].setVisible(true);
		fields[0].setOnlyInteger(10);
		this.add(fields[0]);
		
		this.add(new MyJLabel(250,60,90,30,"成立日期",18,true));
		fields[1] = new MyJTextField(340,60,140,30);
		fields[1].setText(GetDate.getTime());
		this.add(fields[1]);
		
	//	this.add(new MyJLabel(10,100, 90, 30, "机构类型", 18, true));
		String[] organizationTypes = {"营业厅","中转中心"};
		organizationType = new MyComboBox(100,60,140,30,18,organizationTypes);
		this.add(organizationType);
		
	//	this.add(new MyJLabel(250,100,100,30,"机构人数",18,true));
		//fields[2] = new MyJTextField(340,100,140,30);
		//fields[2].setOnlyInteger(11);
		//this.add(fields[2]);
	
		//this.add(new MyJLabel(10, 140, 90, 30, "联系电话",18,true));
		//fields[3] = new MyJTextField(100,140,150,30);
		//fields[3].setOnlyInteger(11);
		//this.add(fields[3]);
		
		
		this.add(new MyJLabel(10,100,90,30,"机构地址:",18,true));
		this.add(new MyJLabel(10,170,90,30,"详细地址:",18,true));
		this.add(new MyJLabel(100,130,25,30,"省",18,true));
		this.add(new MyJLabel(300,130,25,30,"市",18,true));
		
	    JComboBoxOfChina box = new JComboBoxOfChina();
	    
	    provincesBox = box.getCombobox_privince();
	    provincesBox.setBounds(130,130,120,30);
	    provincesBox.setFont(new MyFont(14,true));
	    provincesBox.setVisible(true);
	    this.add(provincesBox);
	    
	    //构造市级下拉框
	    citiesBox =box.getCombobox_city();
	    citiesBox.setBounds(325,130,120,30);
	    citiesBox.setFont(new MyFont(14,true));
	    citiesBox.setVisible(true);
	    this.add(citiesBox);
	}

	private static final long serialVersionUID = 1L;

	public void setUneditable() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEditable(false);
		}
		organizationType.setEditable(false);
		provincesBox.setEditable(false);
		citiesBox.setEditable(false);
	//	address.setEditable(false);
	}
	
	public void setData(String[] data) {
		for(int i = 0; i < 4; i++){
			fields[i].setText(data[i]);
		}
		organizationType.setSelectedItem(data[4]);
		provincesBox.setSelectedItem(data[5]);
		citiesBox.setSelectedItem(data[6]);
	//	address.setText(data[7]);	
	}

	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
		
	//	address.setText(null);
		
	}

	public String[] getData() {
		String[] data = new String[9];
		for (int i = 1; i < 4; i++) {			
			if((data[i] = fields[i].getText()).equals("")) return null;
		}
		data[4] = (String)organizationType.getSelectedItem();
		data[5] = (String) provincesBox.getSelectedItem();
		data[6] = (String) citiesBox.getSelectedItem();
		//data[7] = address.getText();
		for(int i = 4;i<7;i++){
			if(data[i].equals("")) return null;
		}
		return data;
	}


}
