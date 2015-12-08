package businesslogic.orderbl;

import java.math.BigDecimal;
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
public class OrderController implements OrderBLService {
	Order orderBL = new Order();

	@Override
	public ConfirmState confirmOperation() {
		return orderBL.confirmOperation();
	}

	@Override
	public ResultMessage addOrder(OrderVO order) throws RemoteException {
		return orderBL.addOrder(order);
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) throws RemoteException {
		return orderBL.inquireOrder(orderNumber, senderName);
	}

	@Override
	public String getOrderId() throws RemoteException {
		return orderBL.getOrderId();
	}

	@Override
	public BigDecimal getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) throws RemoteException {
		try {
			return orderBL.getCost(commodityList, senderAddress, receiverAddress, expressType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new BigDecimal(0);
	}

	@Override
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType,
			String begindate) throws RemoteException {
		return orderBL.getArrivalDate(senderAddress, receiverAddress, expressType, begindate);
	}

	@Override
	public ResultMessage addOrder(CommodityVO[] commmodities, OrderVO order) throws RemoteException {
		try {
			return orderBL.addOrder(commmodities, order);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber) throws RemoteException {
		return orderBL.inquireOrder(orderNumber);
	}

	@Override
	public ResultMessage updateOrder(OrderVO order) throws RemoteException {
		return orderBL.updateOrder(order);
	}

}
