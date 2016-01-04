package businesslogic.orderbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.logbl.LogController;
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
	Order orderBL;

	public OrderController() throws MalformedURLException, RemoteException, NotBoundException {
		orderBL = new Order();
	}

	@Override
	public ConfirmState confirmOperation() {
		return orderBL.confirmOperation();
	}

	/**
	 * @see OrderBLService#addOrder(OrderVO)
	 */
	public ResultMessage addOrder(OrderVO order) throws RemoteException {
		LogController.getInstance().addLog("添加订单");
		return orderBL.addOrder(order);
	}

	/**
	 * @see OrderBLService#inquireOrder(String, String)
	 */
	public OrderVO inquireOrder(String orderNumber, String senderName) throws RemoteException {
		LogController.getInstance().addLog("查询订单");
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
			return orderBL.getCost(commodityList, senderAddress, receiverAddress, expressType);
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
		LogController.getInstance().addLog("添加订单");
			return orderBL.addOrder(commmodities, order);
	}

	/**
	 * @see OrderBLService#inquireOrder(String)
	 */
	public OrderVO inquireOrder(String orderNumber) throws RemoteException {
		LogController.getInstance().addLog("查询订单");
		return orderBL.inquireOrder(orderNumber);
	}

	/**
	 * @see OrderBLService#updateOrder(OrderVO)
	 */
	public ResultMessage updateOrder(OrderVO order) throws RemoteException {
		LogController.getInstance().addLog("更新订单信息");
		return orderBL.updateOrder(order);
	}

}
