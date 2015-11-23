package order;

import java.util.ArrayList;

import po.OrderPO;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice._Order_Data_Stub;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import businesslogic.orderbl.Order;

public class MockOrder extends Order {
	ArrayList<CommodityVO> commmodities;
	OrderPO order;
	
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		this.order = new OrderPO(
				order.getOrderIdString(), 
				order.getSenderName(), order.getSenderAddress(),order.getSenderTel(),order.getSenderCo(),
				order.getRecipientName(),order.getRecipientAddress(),order.getRecipientTel(),order.getRecipientCo(),
				commmodities,order.getMidAddres(),
				order.getSendTime(),order.getRecipientTime(),order.getMoney());
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO inquireOrder(String orderNumber, String senderName){
		if(this.order.getOrderIdString().equals(orderNumber)&&this.order.getSenderName().equals(senderName)){
			OrderVO order = new OrderVO(this.order.getSendTime(), this.order.getRecipientTime(), this.order.getMoney());
			return order;
		}
		return null;
	}
}
