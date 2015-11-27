package businesslogic.orderbl;
import businesslogicservice.orderblservice.OrderBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.OrderVO;

public class OrderController implements OrderBLService{
    Order OrderBL = new Order();
	@Override
	public ConfirmState confirmOperation() {
		return OrderBL.confirmOperation();
	}

	@Override
	public ResultMessage addOrder(OrderVO order) {
		return OrderBL.addOrder(order);
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		return OrderBL.inquireOrder(orderNumber, senderName);
	}

	@Override
	public ResultMessage costAndTime(OrderVO order) {
		return OrderBL.costAndTime(order);
	}

}
