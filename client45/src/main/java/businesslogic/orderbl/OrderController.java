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

	/**
	 * @see OrderBLService#addOrder(OrderVO)
	 */
	public ResultMessage addOrder(OrderVO order) throws RemoteException {
		return orderBL.addOrder(order);
	}

	/**
	 * @see OrderBLService#inquireOrder(String, String)
	 */
	public OrderVO inquireOrder(String orderNumber, String senderName) throws RemoteException {
		return orderBL.inquireOrder(orderNumber, senderName);
	}

	/**
	 * @see OrderBLService#getOrderId()
	 */
	public String getOrderId() throws RemoteException {
		return orderBL.getOrderId();
	}

	/**
	 * @see OrderBLService#getCost(CommodityVO[], String, String, ExpressType)
	 */
	public BigDecimal getCost(CommodityVO[] commodityList, String senderAddress, String receiverAddress,
			ExpressType expressType) throws RemoteException {
		try {
			return orderBL.getCost(commodityList, senderAddress, receiverAddress, expressType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new BigDecimal(0);
	}

	/**
	 * @see OrderBLService#getArrivalDate(String, String, ExpressType, String)
	 */
	public String getArrivalDate(String senderAddress, String receiverAddress, ExpressType expressType,
			String begindate) throws RemoteException {
		return orderBL.getArrivalDate(senderAddress, receiverAddress, expressType, begindate);
	}

	/**
	 * @see OrderBLService#addOrder(CommodityVO[], OrderVO)
	 */
	public ResultMessage addOrder(CommodityVO[] commmodities, OrderVO order) throws RemoteException {
		try {
			return orderBL.addOrder(commmodities, order);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see OrderBLService#inquireOrder(String)
	 */
	public OrderVO inquireOrder(String orderNumber) throws RemoteException {
		return orderBL.inquireOrder(orderNumber);
	}

	/**
	 * @see OrderBLService#updateOrder(OrderVO)
	 */
	public ResultMessage updateOrder(OrderVO order) throws RemoteException {
		return orderBL.updateOrder(order);
	}

}
