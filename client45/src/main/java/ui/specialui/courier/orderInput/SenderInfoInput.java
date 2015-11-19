package ui.specialui.courier.orderInput;

import ui.NumberLenghLimited;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class SenderInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField NameField;
	private MyJTextField PhoneField;
	private MyJTextField AddressField;
	private MyJTextField OfficeField;
	
	public SenderInfoInput() {
		super(60, 100, 550, 250);
		this.initComponent();
	}
	
	private void initComponent(){		
		this.add(new MyJLabel(215, 30, 120, 40, "寄件人信息", 22, true));
		this.add(new MyJLabel(50, 102, 40, 20, "姓名", 15, true));
		this.add(new MyJLabel(270, 102, 40, 20, "手机", 15, true));
		this.add(new MyJLabel(50, 145, 40, 20, "住址", 15, true));
		this.add(new MyJLabel(50, 186, 40, 20, "单位", 15, true));
		
		NameField = new MyJTextField(100, 100, 130, 30);
		this.add(NameField);
		
		PhoneField = new MyJTextField(320, 100, 130, 30);
		PhoneField.setDocument(new NumberLenghLimited(11));
		this.add(PhoneField);
		
		AddressField = new MyJTextField(100, 142, 350, 30);
		this.add(AddressField);
		
		OfficeField = new MyJTextField(100, 183, 350, 30);
		this.add(OfficeField);
	}

	public String[] getSenderInfo() {
		String[] info = new String[4];
		info[0] = NameField.getText();
		info[1] = PhoneField.getText();
		info[2] = AddressField.getText();
		info[3] = OfficeField.getText();
		for (String string : info) {
			if(string.equals("")) return null;
		}
		return info;
	}
}