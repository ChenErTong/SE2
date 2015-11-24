package ui.specialui.transfer_counterman.train_loading;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.transfer_counterman.Frame_Transfer;

public class TrainLoading extends MyJPanel {
	private static final long serialVersionUID = 1L;
	
	private TrainLoadingInfo trainLoadingInfo;
	
	public TrainLoading(Frame_Transfer frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "火车装运管理", 30, true));
		
		trainLoadingInfo = new TrainLoadingInfo();
		this.add(trainLoadingInfo);
		
		MyJButton jumpToCommodity = new MyJButton(571, 600, 150, 30, "确认装运信息", 20);
		jumpToCommodity.setActionCommand("jumpToCommodityForTrain");
		jumpToCommodity.addActionListener(frame);
		this.add(jumpToCommodity);
	}

	public String[] jumpToCommodity() {
		return trainLoadingInfo.getData();
	}	
}