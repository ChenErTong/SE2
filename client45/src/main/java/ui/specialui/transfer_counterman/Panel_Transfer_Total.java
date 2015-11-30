package ui.specialui.transfer_counterman;

import ui.myui.MyJButton;
import ui.myui.MyJPanel;

public class Panel_Transfer_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Transfer_Total(Frame_Transfer frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.initComponent(frame);
	}

	private void initComponent(Frame_Transfer frame) {
		MyJButton CarLoading = new MyJButton(200, 300, 150, 40, "汽车装运管理", 15);
		CarLoading.setActionCommand("CarLoading");
		CarLoading.addActionListener(frame);
		this.add(CarLoading);
		
		MyJButton TrainLoading = new MyJButton(200, 350, 150, 40, "火车装运管理", 15);
		TrainLoading.setActionCommand("TrainLoading");
		TrainLoading.addActionListener(frame);
		this.add(TrainLoading);
		
		MyJButton PlaneLoading = new MyJButton(200, 400, 150, 40, "飞机装运管理", 15);
		PlaneLoading.setActionCommand("PlaneLoading");
		PlaneLoading.addActionListener(frame);
		this.add(PlaneLoading);
		
		MyJButton TransferReceiveManage = new MyJButton(200, 450, 150, 40, "中转接收管理", 15);
		TransferReceiveManage.setActionCommand("TransferReceiveManage");
		TransferReceiveManage.addActionListener(frame);
		this.add(TransferReceiveManage);
	}
}
