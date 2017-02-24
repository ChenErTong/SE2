package ui.specialui.courier.orderInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ui.Config.JComboBoxOfChina;
import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class ReceiverInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField NameField;
	private MyJTextField PhoneField;
	private MyJTextField AddressField;
	private MyJTextField OfficeField;
	private JComboBox<String> province;
	private JComboBox<String> city;
	
	public ReceiverInfoInput() {
		super(60, 360, 550, 250);
		this.initComponent();
	}
	
	@SuppressWarnings("unchecked")
	private void initComponent(){		
		this.add(new MyJLabel(215, 30, 120, 40, "收件人信息", 22, true));
		this.add(new MyJLabel(50, 102, 40, 20, "姓名", 15, true));
		this.add(new MyJLabel(270, 102, 40, 20, "手机", 15, true));
		this.add(new MyJLabel(50, 145, 40, 20, "住址", 15, true));
		this.add(new MyJLabel(50, 186, 40, 20, "单位", 15, true));
		
		NameField = new MyJTextField(100, 100, 130, 30);
		NameField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==NameField){
					PhoneField.requestFocus();
				}
			}
			
		});
		this.add(NameField);
		
		PhoneField = new MyJTextField(320, 100, 130, 30);
		PhoneField.setOnlyInteger(11);;
		this.add(PhoneField);
		
		//构建中国各大城市的三级联动下拉框
	    JComboBoxOfChina box = new JComboBoxOfChina();
	    province = box.getCombobox_privince();
	    province.setFont(new MyFont(15));
	    province.setBounds(100, 144, 81, 30);
	    this.add(province);
		city = box.getCombobox_city();
	    city.setFont(new MyFont(15));
	    city.setBounds(190, 144, 81, 30);
	    this.add(city);
		
	    AddressField = new MyJTextField(280, 144, 170, 30);
	    AddressField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==AddressField){
					OfficeField.requestFocus();
				}
				
			}
			
		});
		this.add(AddressField);
		
		OfficeField = new MyJTextField(100, 183, 350, 30);
		this.add(OfficeField);		
	}

	public String[] getReceiverInfo() {
		String[] info = new String[4];
		info[0] = NameField.getText();
		info[1] = PhoneField.getText();
		String pro = (String) province.getSelectedItem();
		String cit = (String) city.getSelectedItem();
		info[2] = pro + " " + cit + " " + AddressField.getText();
		info[3] = OfficeField.getText();
		for (String string : info) {
			if(string.equals("")) return null;
		}
		return info;
	}

	/**
	 * 界面刷新
	 */
	public void refresh() {
		NameField.setText(null);
		PhoneField.setText(null);
		AddressField.setText(null);
		OfficeField.setText(null);
		province.setSelectedIndex(0);
		city.setSelectedIndex(0);
	}
}