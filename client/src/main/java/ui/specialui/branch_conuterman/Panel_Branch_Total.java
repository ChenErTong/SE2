package ui.specialui.branch_conuterman;

import ui.image.BranchImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
import ui.myui.MyLogo;
import ui.myui.MyTitle;

public class Panel_Branch_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Branch_Total(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "营业厅业务员界面", 480, 100, 306, 142);
		
		this.initComponent(frame);
	}
	
	private void initComponent(Frame_Branch frame){
		MyButton Vehicleloading = new MyButton(511, 340, 257, 46, BranchImage.getBUTTON_ZHUANGCHE());
		Vehicleloading.setActionCommand("Vehicleloading");
		Vehicleloading.addActionListener(frame);
		this.add(Vehicleloading);
		
		MyButton FacilityInfoManage = new MyButton(511, 410, 257, 46, BranchImage.getBUTTON_CHELIANG());
		FacilityInfoManage.setActionCommand("FacilityInfoManage");
		FacilityInfoManage.addActionListener(frame);
		this.add(FacilityInfoManage);
		
		MyButton DriverInfoManage = new MyButton(511, 480, 257, 46, BranchImage.getBUTTON_SIJI());
		DriverInfoManage.setActionCommand("DriverInfoManage");
		DriverInfoManage.addActionListener(frame);
		this.add(DriverInfoManage);
		
		MyButton ReceiveAndSendCommodity = new MyButton(511, 550, 257, 46, BranchImage.getBUTTON_JIESHOUPAIJIAN());
		ReceiveAndSendCommodity.setActionCommand("ReceiveAndSendCommodity");
		ReceiveAndSendCommodity.addActionListener(frame);
		this.add(ReceiveAndSendCommodity);
		
		MyButton DebitNoteBuild = new MyButton(511, 620, 257, 46, BranchImage.getBUTTON_SHOUKUANDAN());
		DebitNoteBuild.setActionCommand("DebitNoteBuild");
		DebitNoteBuild.addActionListener(frame);
		this.add(DebitNoteBuild);
	}
}