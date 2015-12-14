package ui.specialui.manager.HandleOrganization;

import java.awt.Color;

import javax.swing.JComboBox;

import ui.Config.JComboBoxOfChina;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyFont;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import util.GetDate;
/**
 * 显示机构详细信息、增加机构、修改机构信息的Panel
 * @author zsq
 * @version 2015/12/05 15:30
 */
public class OrganizationDetails extends MyTranslucentPanel{

	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	private MyJComboBox organizationType ;
	@SuppressWarnings("rawtypes")
	private JComboBox provincesBox;
	@SuppressWarnings("rawtypes")
	private JComboBox citiesBox;
	private MyEmptyTextArea address;
	
	public OrganizationDetails() {
		super(680,100-30,550,562);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[1];
		this.add(new MyJLabel(10, 60, 90, 30, "机构类别", 18, true));
		
		this.add(new MyJLabel(250,60,90,30,"成立日期",18,true));
		fields[0] = new MyJTextField(340,60,140,30);
		fields[0].setText(GetDate.getDate());
		this.add(fields[0]);
		
		String[] organizationTypes = {"营业厅","中转中心"};
		organizationType = new MyJComboBox(100,60,140,30,organizationTypes);
		this.add(organizationType);

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
	    
	    address = new MyEmptyTextArea(100,170,410,100,true);
	    address.setBackground(Color.WHITE);
	    this.add(address);
	}
	
	public void setUneditable() {
		fields[0].setEditable(false);
		organizationType.setEnabled(false);
		provincesBox.setEditable(false);
		citiesBox.setEditable(false);
		address.setEditable(false);
	}
	
	public void setData(String[] data) {
		organizationType.setSelectedItem(data[0]);
		fields[0].setText(data[1]);
		provincesBox.setSelectedItem(data[2]);
		citiesBox.setSelectedItem(data[3]);
		address.setText(data[4]);	
	}

	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
		
		organizationType.setSelectedItem(null);
		address.setText(null);
		
	}

	public String[] getData() {
		String[] data = new String[5];
		data[0] = (String)organizationType.getSelectedItem();
		data[1] = fields[0].getText();
		data[2] = (String) provincesBox.getSelectedItem();
		data[3] = (String) citiesBox.getSelectedItem();
		data[4] = address.getText();
		for(int i = 0;i<5;i++){
			if(data[i].equals(null)) return null;
		}
		return data;
	}
}
