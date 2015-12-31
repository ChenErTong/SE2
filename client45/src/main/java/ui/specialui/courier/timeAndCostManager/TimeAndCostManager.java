package ui.specialui.courier.timeAndCostManager;

import java.awt.Color;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ExpressType;
import ui.image.CourierImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.courier.orderInput.CommodityInfoInput;
import ui.specialui.courier.orderInput.ReceiverInfoInput;
import ui.specialui.courier.orderInput.SenderInfoInput;
import util.GetDate;
import vo.CommodityVO;
import businesslogic.ControllerFactory;
import businesslogicservice.orderblservice.OrderBLService;
/**
 * 根据订单信息估计时间与报价
 * @author czw
 * @time 2015年11月19日下午8:59:04
 */
public class TimeAndCostManager extends MyJPanel{
	private static final long serialVersionUID = 1L;
	//寄件人信息输入面板
	private SenderInfoInput sender;
	//收件人信息输入面板
	private ReceiverInfoInput receiver;
	//货物信息输入面板
	private CommodityInfoInput commodities;
	//逻辑接口
	private OrderBLService controller;
	
	public TimeAndCostManager(Frame_Courier frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		try {
			controller = ControllerFactory.getOrderController();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			new MyNotification(frame, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
		}
		
		this.add(new MyJLabel(500, 30, 230, 45, "报价与时间管理", 30, true));
		
		sender = new SenderInfoInput();
		this.add(sender);
		
		receiver = new ReceiverInfoInput();
		this.add(receiver);
		
		commodities = new CommodityInfoInput();
		this.add(commodities);
		
		MyButton confirm = new MyButton(527, 640, 137, 33, CourierImage.getBUTTON_JISUAN());
		confirm.setActionCommand("calculateTimeCost");
		confirm.addActionListener(frame);
		this.add(confirm);
	}
	/**
	 * 计算时间与报价
	 * @return 
	 */
	public int calculateTimeAndCost() {
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
		if ((commodityList = commodities.getCommodityList(null)) == null) {
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
		String arrivalDate = null;
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
		
		return 0;
	}
	
	public void refresh() {
		sender.refresh();
		receiver.refresh();
		commodities.refresh();
	}
}