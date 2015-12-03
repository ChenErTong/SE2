package businesslogic.orderbl;
import java.rmi.RemoteException;

import businesslogicservice.orderblservice.OrderBLService;
import state.ConfirmState;
import state.ExpressType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:39
 */
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
		try {
			return orderBL.getCost(commodityList, senderAddress, receiverAddress, expressType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType,String begindate) {
		try {
			return orderBL.getArrivalDate(senderAddress, receiverAddress, expressType,begindate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
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

	@Override
	public OrderVO inquireOrder(String orderNumber) {
		try {
			return orderBL.inquireOrder(orderNumber);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateOrder(OrderVO order) {
		try {
			return orderBL.updateOrder(order);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
