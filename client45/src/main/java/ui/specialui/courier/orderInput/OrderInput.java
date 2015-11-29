package ui.specialui.courier.orderInput;

import java.awt.Color;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogicservice.orderblservice.OrderBLService;
import state.ExpressType;
import state.PackageType;
import ui.GetDate;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.courier.Frame_Courier;
import vo.CommodityVO;
import vo.OrderVO;

public class OrderInput extends MyJPanel {
	private static final long serialVersionUID = 1L;
	// 寄件人信息输入面板
	private SenderInfoInput sender;
	// 收件人信息输入面板
	private ReceiverInfoInput receiver;
	// 货物信息输入面板
	private CommodityInfoInput commodities;

	public OrderInput(Frame_Courier frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 150, 45, "订单输入", 30, true));

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
	 * 
	 * @return
	 */
	public int produceOrder(Frame_Courier frame) {
		String[] senderInfo;
		if ((senderInfo = sender.getSenderInfo()) == null) {
			return 1;
		}
		String[] receiverInfo;
		if ((receiverInfo = receiver.getReceiverInfo()) == null) {
			return 2;
		}
		String[] commodityInfo;
		if ((commodityInfo = commodities.getCommodityInfo()) == null) {
			return 3;
		}
		ArrayList<CommodityVO> commodityList;
		if ((commodityList = commodities.getCommodityList()) == null) {
			return 4;
		}
		// 如果选择比较重量则矫正重量
		if (commodities.isCompareWight()) {
			for (CommodityVO commodityVO : commodityList) {
				commodityVO.correctWeight();
			}
		}

		OrderBLService controller = ControllerFactory.getOrderController();
		String id = controller.getOrderId();
		
		CommodityVO[] commodities = new CommodityVO[commodityList.size()];
		for(int i = 0; i < commodities.length; ++i){
			commodities[i] = commodityList.get(i);
		}
		
		double cost = controller.getCost(commodities, senderInfo[2],
				receiverInfo[2], ExpressType.getType(commodityInfo[2]));
		String arrivalDate = controller.getArrivalDate(senderInfo[2],
				receiverInfo[2], ExpressType.getType(commodityInfo[2]));

		MyNotification n = new MyNotification(this, "预计到达时间\n" + arrivalDate, Color.GREEN);
		
		try {
			Thread.sleep(1500);
			n.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		n = new MyNotification(this, "运费\n" + cost, Color.GREEN);
		
		try {
			Thread.sleep(1500);
			n.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		OrderVO order = new OrderVO(id, senderInfo[0], senderInfo[2],
				senderInfo[1], senderInfo[3], receiverInfo[0], receiverInfo[2],
				receiverInfo[1], receiverInfo[3], new ArrayList<String>(),
				GetDate.getDate(), arrivalDate, cost, commodityList,
				PackageType.getType(commodityInfo[1]),
				ExpressType.getType(commodityInfo[2]));
		controller.addOrder(order);
		return 0;
	}

	public void refresh() {
		sender.refresh();
		receiver.refresh();
		commodities.refresh();
	}
}