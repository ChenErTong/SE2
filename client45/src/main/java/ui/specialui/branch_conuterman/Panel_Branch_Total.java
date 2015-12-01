package ui.specialui.branch_conuterman;

import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJPanel;

public class Panel_Branch_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Branch_Total(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame);
	}
	
	private void initComponent(Frame_Branch frame){
		MyJButton Vehicleloading = new MyJButton(200, 300, 150, 40, "车辆装车管理", 15);
		Vehicleloading.setActionCommand("Vehicleloading");
		Vehicleloading.addActionListener(frame);
		this.add(Vehicleloading);
		
		MyJButton FacilityInfoManage = new MyJButton(200, 350, 150, 40, "车辆信息管理", 15);
		FacilityInfoManage.setActionCommand("FacilityInfoManage");
		FacilityInfoManage.addActionListener(frame);
		this.add(FacilityInfoManage);
		
		MyJButton DriverInfoManage = new MyJButton(200, 400, 150, 40, "司机信息管理", 15);
		DriverInfoManage.setActionCommand("DriverInfoManage");
		DriverInfoManage.addActionListener(frame);
		this.add(DriverInfoManage);
		
		MyJButton ReceiveAndSendCommodity = new MyJButton(200, 450, 150, 40, "接收派件货物", 15);
		ReceiveAndSendCommodity.setActionCommand("ReceiveAndSendCommodity");
		ReceiveAndSendCommodity.addActionListener(frame);
		this.add(ReceiveAndSendCommodity);
		
		MyJButton DebitNoteBuild = new MyJButton(200, 500, 150, 40, "收款单建立", 15);
		DebitNoteBuild.setActionCommand("DebitNoteBuild");
		DebitNoteBuild.addActionListener(frame);
		this.add(DebitNoteBuild);
	}
}