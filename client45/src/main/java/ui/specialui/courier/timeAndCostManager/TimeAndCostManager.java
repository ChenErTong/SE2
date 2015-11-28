package ui.specialui.courier.timeAndCostManager;

import java.util.ArrayList;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.courier.orderInput.CommodityInfoInput;
import ui.specialui.courier.orderInput.ReceiverInfoInput;
import ui.specialui.courier.orderInput.SenderInfoInput;
import vo.CommodityVO;
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
	
	public TimeAndCostManager(Frame_Courier frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(500, 30, 230, 45, "报价与时间管理", 30, true));
		
		sender = new SenderInfoInput();
		this.add(sender);
		
		receiver = new ReceiverInfoInput();
		this.add(receiver);
		
		commodities = new CommodityInfoInput();
		this.add(commodities);
		
		MyJButton confirm = new MyJButton(527, 640, 180, 40, "计算时间与报价", 18);
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
		if((senderInfo = sender.getSenderInfo()) == null){
			return 1;
		}
		String[] receiverInfo;
		if((receiverInfo = receiver.getReceiverInfo()) == null){
			return 2;
		}
		String[] commodityInfo;
		if((commodityInfo = commodities.getCommodityInfo()) == null){
			return 3;
		}
		ArrayList<CommodityVO> commodityList;
		if((commodityList = commodities.getCommodityList()) == null){
			return 4;
		}
		boolean isCompareWight = commodities.isCompareWight();
		return 0;
	}
}