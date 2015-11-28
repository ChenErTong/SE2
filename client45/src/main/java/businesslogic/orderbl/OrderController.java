package businesslogic.orderbl;
import businesslogicservice.orderblservice.OrderBLService;
import state.ConfirmState;
import state.ExpressType;
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
	public ResultMessage addOrder(OrderVO order) {
		return OrderBL.addOrder(order);
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		return OrderBL.inquireOrder(orderNumber, senderName);
	}

	@Override
	public String getOrderId() {
		return null;
	}

	@Override
	public double getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) {
		return 0;
	}

	@Override
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType) {
		return null;
	}

/*	@Override
	public ResultMessage costAndTime(OrderVO order) {
		return OrderBL.costAndTime(order);
	}*/

}
