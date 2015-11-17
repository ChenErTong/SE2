package ui.specialui.courier;

import ui.myui.MyJLabel;
import ui.myui.MyTranslucentPanel;

public class Panel_Courier_OrderInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Courier_OrderInput(Frame_Courier frame) {
		super(60, 40, 550, 640);
		this.initComponent(frame);
	}
	
	private void initComponent(Frame_Courier frame){
		MyJLabel title = new MyJLabel(220, 15, 110, 50, "订单输入", 24, true);
		this.add(title);
		
		MyJLabel senderInfo = new MyJLabel(110, 60, 110, 30, "寄件人信息", 18, true);
		this.add(senderInfo);
		
		MyJLabel receiverInfo = new MyJLabel(330, 60, 110, 30, "收件人信息", 18, true);
		this.add(receiverInfo);
		
		MyJLabel senderName = new MyJLabel(50, 100, 40, 20, "姓名", 15, true);
		this.add(senderName);
		
		MyJLabel senderAddress = new MyJLabel(50, 140, 40, 20, "住址", 15, true);
		this.add(senderAddress);
	}
}