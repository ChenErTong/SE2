package businesslogic.orderbl;
/**
 * @author LIUXUANLIN
 */
import java.util.ArrayList;

import businesslogicservice.orderblservice.OrderBLService;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class OrderController implements OrderBLService{
    Order OrderBL = new Order();
	@Override
	public ConfirmState confirmOperation() {
		return OrderBL.confirmOperation();
	}

	@Override
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		return OrderBL.addOrder(commmodities, order);
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
