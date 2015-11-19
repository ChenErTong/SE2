package ui.specialui.courier.orderInput;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.courier.Frame_Courier;

public class OrderInput extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public OrderInput(Frame_Courier frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyJLabel title = new MyJLabel(550, 30, 150, 45, "订单输入", 30, true);
		this.add(title);
		
		SenderInfoInput sender = new SenderInfoInput();
		this.add(sender);
		
		ReceiverInfoInput receiver = new ReceiverInfoInput();
		this.add(receiver);
		
		CommodityInfoInput commodities = new CommodityInfoInput();
		this.add(commodities);
		
		MyJButton confirm = new MyJButton(560, 640, 110, 40, "生成订单", 18);
		this.add(confirm);
	}
}