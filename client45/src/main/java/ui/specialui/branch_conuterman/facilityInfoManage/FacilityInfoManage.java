package ui.specialui.branch_conuterman.facilityInfoManage;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.branch_conuterman.Frame_Branch;

public class FacilityInfoManage extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public FacilityInfoManage(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(550, 30, 210, 45, "车辆信息管理", 30, true));
	}
}
