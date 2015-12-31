package ui.specialui.courier.orderInput;

import java.awt.Color;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ExpressType;
import state.PackageType;
import ui.image.CourierImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.courier.Frame_Courier;
import util.GetDate;
import vo.CommodityVO;
import vo.OrderVO;
import businesslogic.ControllerFactory;
import businesslogicservice.orderblservice.OrderBLService;

public class OrderInput extends MyJPanel {
	private static final long serialVersionUID = 1L;
	// 寄件人信息输入面板
	private SenderInfoInput sender;
	// 收件人信息输入面板
	private ReceiverInfoInput receiver;
	// 货物信息输入面板
	private CommodityInfoInput commodities;
	//逻辑接口
	private OrderBLService controller;
	
	public OrderInput(Frame_Courier frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		try {
			controller = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		this.add(new MyJLabel(550, 30, 150, 45, "订单输入", 30, true));

		sender = new SenderInfoInput();
		this.add(sender);

		receiver = new ReceiverInfoInput();
		this.add(receiver);

		commodities = new CommodityInfoInput();
		this.add(commodities);

		MyButton confirm = new MyButton(559, 640, 111, 33, CourierImage.getBUTTON_SHENGCHENGDINGDAN());
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
		
		String id;
		try {
			controller = ControllerFactory.getOrderController();
			id = controller.getOrderId();
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
		
		ArrayList<CommodityVO> commodityList;
		if ((commodityList = commodities.getCommodityList(id)) == null) {
			return 4;
		}
		// 如果选择比较重量则矫正重量
		if (commodities.isCompareWight()) {
			for (CommodityVO commodityVO : commodityList) {
				commodityVO.correctWeight();
			}
		}
		
		CommodityVO[] commodities = new CommodityVO[commodityList.size()];
		for(int i = 0; i < commodities.length; ++i){
			commodities[i] = commodityList.get(i);
		}
		
		BigDecimal cost = null;
		String arrivalDate = null;;
		try {
			controller = ControllerFactory.getOrderController();
			cost = controller.getCost(commodities, senderInfo[2],
					receiverInfo[2], ExpressType.getType(commodityInfo[2]));
			arrivalDate = controller.getArrivalDate(senderInfo[2],
					receiverInfo[2], ExpressType.getType(commodityInfo[2]), GetDate.getDate());
		} catch (RemoteException | MalformedURLException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}

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
		try {
			controller = null;
			controller = ControllerFactory.getOrderController();
			controller.addOrder(order);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return -1;
		}
		
		n = new MyNotification(this, "订单号\n" + id, Color.GREEN);
		try {
			Thread.sleep(3000);
			n.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void refresh() {
		sender.refresh();
		receiver.refresh();
		commodities.refresh();
	}
}