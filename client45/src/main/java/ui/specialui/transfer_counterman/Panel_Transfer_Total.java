package ui.specialui.transfer_counterman;

import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
import ui.myui.MyLogo;
import ui.myui.MyTitle;

public class Panel_Transfer_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Transfer_Total(Frame_Transfer frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "中转中心业务员界面", 480, 100, 306, 146);
		
		this.initComponent(frame);
	}

	private void initComponent(Frame_Transfer frame) {
		MyButton CarLoading = new MyButton(511, 360, 257, 46, TransferImage.getBUTTON_QICHE());
		CarLoading.setActionCommand("CarLoading");
		CarLoading.addActionListener(frame);
		this.add(CarLoading);
		
		MyButton TrainLoading = new MyButton(511, 440, 257, 46, TransferImage.getBUTTON_HUOCHE());
		TrainLoading.setActionCommand("TrainLoading");
		TrainLoading.addActionListener(frame);
		this.add(TrainLoading);
		
		MyButton PlaneLoading = new MyButton(511, 520, 257, 46, TransferImage.getBUTTON_FEIJI());
		PlaneLoading.setActionCommand("PlaneLoading");
		PlaneLoading.addActionListener(frame);
		this.add(PlaneLoading);
		
		MyButton TransferReceiveManage = new MyButton(511, 600, 257, 46, TransferImage.getBUTTON_ZHONGZHUAN());
		TransferReceiveManage.setActionCommand("TransferReceiveManage");
		TransferReceiveManage.addActionListener(frame);
		this.add(TransferReceiveManage);
	}
}