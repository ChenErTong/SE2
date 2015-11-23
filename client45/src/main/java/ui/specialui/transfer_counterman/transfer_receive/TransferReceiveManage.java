package ui.specialui.transfer_counterman.transfer_receive;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.transfer_counterman.Frame_Transfer;

public class TransferReceiveManage extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public TransferReceiveManage(Frame_Transfer frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(544, 30, 192, 32, "中转接收管理", 30, true));
	}
}