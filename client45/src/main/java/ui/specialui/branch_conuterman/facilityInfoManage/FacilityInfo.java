package ui.specialui.branch_conuterman.facilityInfoManage;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class FacilityInfo extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField[] fields;
	
	public FacilityInfo() {
		super(470, 190, 340, 355);
		this.initComponent();
	}
	
	private void initComponent(){
		fields = new MyJTextField[5];
		this.add(new MyJLabel(78, 42, 60, 25, "车牌号", 18, true));
		fields[0] = new MyJTextField(150, 40, 130, 30);
		
		this.add(new MyJLabel(78, 102, 60, 25, "底盘号", 18, true));
		fields[1] = new MyJTextField(150, 100, 130, 30);
		fields[1].setOnlyInteger(9);
		
		this.add(new MyJLabel(60, 162, 100, 25, "车辆代号", 18, true));
		fields[2] = new MyJTextField(150, 160, 130, 30);
		fields[2].setOnlyInteger(9);
		
		this.add(new MyJLabel(60, 222, 100, 25, "发动机号", 18, true));
		fields[3] = new MyJTextField(150, 220, 130, 30);
		fields[3].setOnlyInteger(9);
		
		this.add(new MyJLabel(60, 282, 80, 25, "购买时间", 18, true));
		fields[4] = new MyJTextField(150, 280, 130, 30);
		
		for (MyJTextField myJTextField : fields) {
			this.add(myJTextField);
		}
	}
	
	/**
	 * 文本框不可修改
	 */
	public void setUneditable(){
		for (MyJTextField myJTextField : fields) {
			myJTextField.setEnabled(false);
		}
	}

	public void setData(String[] data) {
		for(int i = 0; i < 5; i++){
			fields[i].setText(data[i]);
		}
	}

	public String[] getData() {
		String[] data = new String[5];
		for (int i = 0; i < 5; i++) {			
			if((data[i] = fields[i].getText()).equals("")) return null;
		}
		return data;
	}

	public void refresh() {
		for (MyJTextField myJTextField : fields) {
			myJTextField.setText(null);
		}
	}
}