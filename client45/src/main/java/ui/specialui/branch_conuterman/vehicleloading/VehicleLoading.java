package ui.specialui.branch_conuterman.vehicleloading;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.branch_conuterman.Frame_Branch;

public class VehicleLoading extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public VehicleLoading(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(550, 30, 210, 45, "车辆装车管理", 30, true));
	}
}
