package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.OrderInfo_Branch_Transfer;
import businesslogic.orderbl.Order;
import businesslogic.orderbl.OrderTrans;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

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
	public void changeOrderState(ArrayList<OrderVO> orders,String message) throws RemoteException{
		for (OrderVO orderVO : orders) {
			addHitoryMessage(orderVO, message);
		}
	}
	
	private void addHitoryMessage(OrderVO order,String message) throws RemoteException{
		ArrayList<String> historyMessage = order.midAddres;
		historyMessage.add(message);
		OrderPO po = OrderTrans.convertVOtoPO(order);
		po.setMidAddres(historyMessage);
		orderData.modify(po);
	}
}
