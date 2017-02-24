package order;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.Order;
import po.OrderPO;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class MockOrder extends Order {
	public MockOrder() throws MalformedURLException, RemoteException, NotBoundException {
		super();
	}

	ArrayList<CommodityVO> commmodities;
	OrderPO order;
	
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
//		this.order = new OrderPO(order.ID, null, order.senderName, order.senderAddress, order.senderTel,
//				order.senderCo, order.recipientName, order.recipientAddress, order.recipientTel, order.recipientCo,
//				commmodities, order.midAddres, order.sendTime, order.recipientTime, order.money);
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO inquireOrder(String orderNumber, String senderName){
//		if(this.order.getOrderIdString().equals(orderNumber)&&this.order.getSenderName().equals(senderName)){
//			OrderVO order = new OrderVO(this.order.getSendTime(), this.order.getRecipientTime(), this.order.getMoney());
//			return order;
//		}
		return null;
	}
}
