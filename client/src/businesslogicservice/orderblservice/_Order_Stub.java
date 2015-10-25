package businesslogicservice.orderblservice;

import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice._Order_Data_Stub;
import po.OrderPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class _Order_Stub implements OrderBLService {

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		OrderPO orderPO = new OrderPO(
				order.getOrderIdString(), order.getOrderIdString(),
				order.getSenderName(), order.getSenderAddress(),order.getSenderTel(),order.getSenderCo(),
				order.getRecipientName(),order.getRecipientAddress(),order.getRecipientTel(),order.getRecipientCo(),
				commmodities,order.getMidAddres(),
				order.getSendTime(),order.getRecipientTime(),order.getMoney());
		OrderDataService<OrderPO> orderDataService = new _Order_Data_Stub();
		orderDataService.insert(orderPO);
		return ResultMessage.SUCCESS;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		OrderDataService<OrderPO> orderDataService = new _Order_Data_Stub();
		System.out.println("Inquire an order!");
		OrderPO orderPO = orderDataService.find(orderNumber);
		if(orderPO!=null&&orderPO.getSenderName()==senderName){
			System.out.println("Found!");
			return new OrderVO(orderPO.getSendTime(),orderPO.getRecipientTime(),orderPO.getMoney());
		}else{
			System.out.println("Not Found");
			return null;
		}
	}
	
	public ResultMessage updateOrder(ArrayList<CommodityVO> commmodities, OrderVO order){
		OrderPO orderPO = new OrderPO(
				order.getOrderIdString(), order.getOrderIdString(),
				order.getSenderName(), order.getSenderAddress(),order.getSenderTel(),order.getSenderCo(),
				order.getRecipientName(),order.getRecipientAddress(),order.getRecipientTel(),order.getRecipientCo(),
				commmodities,order.getMidAddres(),
				order.getSendTime(),order.getRecipientTime(),order.getMoney());
		OrderDataService<OrderPO> orderDataService = new _Order_Data_Stub();
		orderDataService.update(orderPO);
		return ResultMessage.SUCCESS;
	}
	@Override
	public ResultMessage costAndTime(OrderVO order) {
		System.out.println("Recipient time:"+order.getRecipientTime());
		System.out.println("Cost:"+order.getMoney());
		return ResultMessage.SUCCESS;
	}

}
