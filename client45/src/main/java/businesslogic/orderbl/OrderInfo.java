package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.organizationbl.OrderInfo_Branch_Transfer;
import dataservice.orderdataservice.OrderDataService;
import po.CommodityPO;
import po.OrderPO;
import state.CommodityState;
import vo.CommodityVO;
import vo.OrderVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:43
 */
public class OrderInfo implements OrderInfo_Branch_Transfer {
	Order order;
	OrderDataService orderData;

	public OrderInfo() {
		order = new Order();
		orderData = order.getOrderData();
	}

	/**
	 * @see OrderInfo_Branch_Transfer#changeOrderState(ArrayList, String)
	 */
	public void changeOrderState(ArrayList<String> orderIDs, String message) throws RemoteException {
		for (String orderID : orderIDs) {
			OrderPO orderPO = orderData.find(orderID);
			addHitoryMessage(orderPO, message);
		}
	}

	/**
	 * @see OrderInfo_Branch_Transfer#changeOrderState(ArrayList, String,
	 *      CommodityState)
	 */
	public void changeOrderState(ArrayList<String> orderIDs, String message, CommodityState orderState)
			throws RemoteException {
		for (String orderID : orderIDs) {
			OrderPO orderPO = orderData.find(orderID);
			addHitoryMessage(orderPO, message);
			updateOrderState(orderPO, orderState);
		}
	}

	/**
	 * @see OrderInfo_Branch_Transfer#getAllOrders()
	 */
	public ArrayList<OrderVO> getAllOrders() throws RemoteException {
		ArrayList<OrderPO> orderPOs = orderData.find();
		ArrayList<OrderVO> orderVOs = OrderTrans.convertOrderPOstoVOs(orderPOs);
		return orderVOs;
	}

	/**
	 * @see OrderInfo_Branch_Transfer#getAllCommodities()
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		// 获取所有的订单
		ArrayList<OrderPO> orderPOs = orderData.find();
		ArrayList<CommodityVO> commodityVOs = new ArrayList<>();
		// 获取单个订单
		for (OrderPO orderPO : orderPOs) {
			// 单个订单中所有的商品
			ArrayList<CommodityPO> pos = orderPO.getCommodityPO();
			ArrayList<CommodityVO> commos = OrderTrans.convertCommodityPOstoVOs(pos);
			// 将每个商品加入商品列表
			for (CommodityVO commodityVO : commos) {
				commodityVOs.add(commodityVO);
			}
		}
		return commodityVOs;
	}

	/**
	 * @see OrderInfo_Branch_Transfer#changeOrderState(String, String)
	 */
	public boolean changeOrderState(String order, String message) throws RemoteException {
		OrderPO orderPO = orderData.find(order);
		if (orderPO == null) {
			System.out.println("print in package businesslogic.orderbl;");
			System.out.println("package businesslogic.orderbl;");
			return false;
		} else {
			addHitoryMessage(orderPO, message);
			return true;
		}
	}

	/**
	 * @see OrderInfo_Branch_Transfer#changeOrderState(String, String,
	 *      CommodityState)
	 */
	public void changeOrderState(String order, String message, CommodityState orderState) throws RemoteException {
		OrderPO orderPO = orderData.find(order);
		addHitoryMessage(orderPO, message);
		updateOrderState(orderPO, orderState);
	}

	/**
	 * 更新订单的状态
	 * 
	 * @param orderPO
	 *            OrderPO型，订单持久化队形
	 * @param orderState
	 *            CommodityState型，订单新状态
	 * @throws RemoteException
	 *             远程异常
	 */
	private void updateOrderState(OrderPO orderPO, CommodityState orderState) throws RemoteException {
		ArrayList<CommodityPO> commos = orderPO.getCommodityPO();
		for (CommodityPO commodityPO : commos) {
			commodityPO.setCommodityState(orderState);
		}
		orderPO.setCommodityPO(commos);
		orderData.modify(orderPO);
	}

	/**
	 * 为订单添加历史轨迹
	 * 
	 * @param order
	 *            OrderPO型，订单持久化对象
	 * @param message
	 *            String型，历史轨迹信息
	 * @throws RemoteException
	 *             远程异常
	 */
	private void addHitoryMessage(OrderPO order, String message) throws RemoteException {
		ArrayList<String> historyMessage = order.getMidAddres();
		historyMessage.add(message);
		order.setMidAddres(historyMessage);
		orderData.modify(order);
	}
}
