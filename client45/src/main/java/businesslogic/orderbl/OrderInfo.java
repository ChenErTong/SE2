package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.OrderInfo_Branch_Transfer;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderInfo implements OrderInfo_Branch_Transfer{
	Order order;
	OrderDataService orderData;
	public OrderInfo() {
		order = new Order();
		orderData = order.getOrderData();
	}
	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * @author Ann
	 * @param message 历史轨迹信息
	 * @return
	 * @throws RemoteException 
	 */
	public void changeOrderState(ArrayList<String> orderIDs,String message) throws RemoteException{
		for (String orderID : orderIDs) {
			OrderPO orderPO = orderData.find(orderID);
			addHitoryMessage(orderPO, message);
		}
	}
	
	private void addHitoryMessage(OrderPO order,String message) throws RemoteException{
		ArrayList<String> historyMessage = order.getMidAddres();
		historyMessage.add(message);
		order.setMidAddres(historyMessage);
		orderData.modify(order);
	}
}
