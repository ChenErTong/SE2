package ui.specialui.branch_conuterman.vehicleloading;

import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import util.GetDate;

public class LoadingInfo extends MyTranslucentPanel {
	private static final long serialVersionUID = 1L;
	
	private MyJTextField destination;
	private MyJTextField supercargo;
	private MyJTextField facilityId;
	private MyJTextField facilityNumber;
	private MyJTextField loadingData;
	private MyJTextField branchId;
	
	public LoadingInfo() {
		super(250, 150, 340, 370);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(78, 42, 60, 25, "目的地", 18, true));
		destination = new MyJTextField(150, 40, 130, 30);
		this.add(destination);
		
		this.add(new MyJLabel(78, 92, 60, 25, "押运员", 18, true));
		supercargo = new MyJTextField(150, 90, 130, 30);
		this.add(supercargo);
		
		this.add(new MyJLabel(60, 142, 100, 25, "汽运编号", 18, true));
		facilityId = new MyJTextField(150, 140, 130, 30);
		facilityId.setOnlyInteger(9);
		this.add(facilityId);
		
		this.add(new MyJLabel(60, 192, 100, 25, "车辆代号", 18, true));
		facilityNumber = new MyJTextField(150, 190, 130, 30);
		facilityNumber.setOnlyInteger(9);
		this.add(facilityNumber);
		
		this.add(new MyJLabel(60, 242, 80, 25, "装车日期", 18, true));
		loadingData = new MyJTextField(150, 240, 130, 30);
		loadingData.setText(GetDate.getDate());
		loadingData.setForDate();
		this.add(loadingData);
		
		this.add(new MyJLabel(42, 292, 100, 25, "营业厅编号", 18, true));
		branchId = new MyJTextField(150, 290, 130, 30);
		branchId.setOnlyInteger(3);
		this.add(branchId);
	}
	
	public String[] getInfo(){
		String[] info = new String[6];
		info[0] = destination.getText();
		info[1] = supercargo.getText();
		info[2] = facilityId.getText();
		info[3] = facilityNumber.getText();
		info[4] = loadingData.getText();
		info[5] = branchId.getText();
		for (String string : info) {
			if(string.equals("")) return null;
		}
		return info;
	}
}
