package ui.specialui.courier.orderInput;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.courier.Frame_Courier;

public class OrderInput extends MyJPanel{
	private static final long serialVersionUID = 1L;
	//寄件人信息输入面板
	private SenderInfoInput sender;
	//收件人信息输入面板
	private ReceiverInfoInput receiver;
	//货物信息输入面板
	private CommodityInfoInput commodities;
	
	public OrderInput(Frame_Courier frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyJLabel title = new MyJLabel(550, 30, 150, 45, "订单输入", 30, true);
		this.add(title);
		
		sender = new SenderInfoInput();
		this.add(sender);
		
		receiver = new ReceiverInfoInput();
		this.add(receiver);
		
		commodities = new CommodityInfoInput();
		this.add(commodities);
		
		MyJButton confirm = new MyJButton(560, 640, 110, 40, "生成订单", 18);
		confirm.setActionCommand("produceOrder");
		confirm.addActionListener(frame);
		this.add(confirm);
	}
	/**
	 * 生成订单
	 * @return 
	 */
	public int produceOrder() {
		String[] senderInfo;
		if((senderInfo = sender.getSenderInfo()) == null){
			return 0;
		}
		String[] receiverInfo;
		if((receiverInfo = receiver.getReceiverInfo()) == null){
			return 1;
		}
		String[] commodityInfo;
		if((commodityInfo = commodities.getCommodityInfo()) == null){
			return 2;
		}
		String[] commodityList;
		if((commodityList = commodities.getCommodityList()) == null){
			return 3;
		}
		boolean isCompareWight = commodities.isCompareWight();
		return 4;
	}
}