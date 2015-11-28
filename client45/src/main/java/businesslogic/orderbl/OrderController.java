package businesslogic.orderbl;
import java.rmi.RemoteException;

import businesslogicservice.orderblservice.OrderBLService;
import state.ConfirmState;
import state.ExpressType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class OrderController implements OrderBLService{
    Order orderBL = new Order();
	@Override
	public ConfirmState confirmOperation() {
		return orderBL.confirmOperation();
	}

	@Override
	public ResultMessage addOrder(OrderVO order) {
		try {
			return orderBL.addOrder(order);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		return orderBL.inquireOrder(orderNumber, senderName);
	}

	@Override
	public String getOrderId() {
		try {
			return orderBL.getOrderId();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) {
		return orderBL.getCost(commodityList, senderAddress, receiverAddress, expressType);
	}

	@Override
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType) {
		return orderBL.getArrivalDate(senderAddress, receiverAddress, expressType);
	}

	@Override
	public ResultMessage addOrder(CommodityVO[] commmodities, OrderVO order) {
		try {
			return orderBL.addOrder(commmodities,order);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
