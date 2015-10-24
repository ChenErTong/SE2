package businesslogicservice.orderblservice;

import java.util.ArrayList;

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
		@SuppressWarnings("unused")
		OrderPO orderPO = new OrderPO(
				order.getOrderIdString(), order.getOrderIdString(),
				order.getSenderName(), order.getSenderAddress(),order.getSenderTel(),order.getSenderCo(),
				order.getRecipientName(),order.getRecipientAddress(),order.getRecipientTel(),order.getRecipientCo(),
				commmodities,order.getMidAddres(),
				order.getSendTime(),order.getRecipientTime(),order.getMoney());
		System.out.println("You have added an order!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		System.out.println("Inquire an order!");
		if(orderNumber=="00000"){
			System.out.println("Found!");
			return new OrderVO("2015-10-24","2015-10-26",10.67);
		}else{
			System.out.println("Not Found");
			return null;
		}
	}

	@Override
	public ResultMessage costAndTime(OrderVO order) {
		System.out.println("Recipient time:"+order.getRecipientTime());
		System.out.println("Cost:"+order.getMoney());
		return ResultMessage.SUCCESS;
	}

}
