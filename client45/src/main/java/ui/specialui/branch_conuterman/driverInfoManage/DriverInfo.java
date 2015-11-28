package ui.specialui.branch_conuterman.driverInfoManage;

import javax.swing.ButtonGroup;
import ui.myui.MyJLabel;
import ui.myui.MyJRadioButton;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class DriverInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	
	public DriverInfo() {
		super(300, 190, 680, 355);
		this.initComponent();
	}

	private void initComponent() {
		fields = new MyJTextField[7];
		
		this.add(new MyJLabel(78, 42, 42, 21, "姓名", 18, true));
		fields[0] = new MyJTextField(130, 40, 100, 30);
		
		this.add(new MyJLabel(36, 122, 82, 21, "出生日期", 18, true));
		fields[1] = new MyJTextField(130, 120, 150, 30);
		fields[1].setForDate();
		
		this.add(new MyJLabel(57, 202, 63, 21, "手机号", 18, true));
		fields[2] = new MyJTextField(130, 200, 150, 30);
		fields[2].setOnlyInteger(11);
		
		this.add(new MyJLabel(36, 282, 82, 21, "车辆单位", 18, true));
		fields[3] = new MyJTextField(130, 280, 190, 30);
		
		this.add(new MyJLabel(376, 122, 82, 21, "身份证号", 18, true));
		fields[4] = new MyJTextField(470, 120, 150, 30);
		fields[4].setOnlyInteger(17);
		
		this.add(new MyJLabel(418, 202, 63, 21, "编号", 18, true));
		fields[5] = new MyJTextField(470, 200, 150, 30);
		
		this.add(new MyJLabel(355, 282, 103, 21, "行驶证期限", 18, true));
		fields[6] = new MyJTextField(470, 280, 150, 30);
		fields[6].setForDate();
		
		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}
	}

	/**
	 * 将信息置为不可修改状态
	 */
	public void setUneditable() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEnabled(false);
		}
	}

	/**
	 * 根据查询到的数据设置面板内容
	 * @param data
	 */
	public void setData(String[] data) {
		for(int i = 0; i < 7; i++){
			fields[i].setText(data[i]);
		}
	}

	/**
	 * 返回面板数据
	 * @return
	 */
	public String[] getData() {
		String[] data = new String[7];
		for (int i = 0; i < 7; i++) {
			if((data[i] = fields[i].getText()).equals("")) return null;
		}	
		return data;
	}
	
	/**
	 * 将面板数据置为空
	 */
	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
	}
}