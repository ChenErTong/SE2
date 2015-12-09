package ui.specialui.transfer_counterman.plane_loading;

import ui.image.TransferImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.transfer_counterman.Frame_Transfer;

public class PlaneLoading extends MyJPanel {
	private static final long serialVersionUID = 1L;
	
	private PlaneLoadingInfo planeLoadingInfo;
	
	public PlaneLoading(Frame_Transfer frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "飞机装运管理", 30, true));
		
		planeLoadingInfo = new PlaneLoadingInfo();
		this.add(planeLoadingInfo);
		
		MyButton jumpToCommodity = new MyButton(584, 600, 111, 33, TransferImage.getBUTTON_ZHUANGYUNXINXI());
		jumpToCommodity.setActionCommand("jumpToCommodityForPlane");
		jumpToCommodity.addActionListener(frame);
		this.add(jumpToCommodity);
	}


	public String[] jumpToCommodity() {
		return planeLoadingInfo.getData();
	}	
}