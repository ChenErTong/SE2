package ui.specialui.courier.orderInput;

import ui.NumberLenghtLimited;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class SenderInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	public SenderInfoInput() {
		super(60, 100, 550, 250);
		this.initComponent();
	}
	
	private void initComponent(){		
		MyJLabel Info = new MyJLabel(215, 30, 120, 40, "寄件人信息", 22, true);
		this.add(Info);
		
		MyJLabel Name = new MyJLabel(50, 102, 40, 20, "姓名", 15, true);
		this.add(Name);
		MyJTextField NameField = new MyJTextField(100, 100, 130, 30);
		this.add(NameField);
		
		MyJLabel Phone = new MyJLabel(270, 102, 40, 20, "手机", 15, true);
		this.add(Phone);
		MyJTextField PhoneField = new MyJTextField(320, 100, 130, 30);
		PhoneField.setDocument(new NumberLenghtLimited(11));
		this.add(PhoneField);
		
		MyJLabel Address = new MyJLabel(50, 145, 40, 20, "住址", 15, true);
		this.add(Address);
		MyJTextField AddressField = new MyJTextField(100, 142, 350, 30);
		this.add(AddressField);
		
		MyJLabel Office = new MyJLabel(50, 186, 40, 20, "单位", 15, true);
		this.add(Office);
		MyJTextField OfficeField = new MyJTextField(100, 183, 350, 30);
		this.add(OfficeField);
	}
}