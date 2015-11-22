package ui.specialui.branch_conuterman.receiveAndSendCommodity;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.branch_conuterman.Frame_Branch;

public class ReceiveAndSendCommodity extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private ReceiveList receiveList;
	
	public ReceiveAndSendCommodity(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		receiveList = new ReceiveList();
		this.add(receiveList);
		
		this.add(new MyJLabel(550, 30, 210, 45, "接收派件货物", 30, true));
	}
}
