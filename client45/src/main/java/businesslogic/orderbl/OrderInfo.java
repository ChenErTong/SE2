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

public class OrderInfo implements OrderInfo_Branch_Transfer{
	Order order;
	OrderDataService orderData;
	public OrderInfo() {
		order = new Order();
		orderData = order.getOrderData();
	}
	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * @author Ann
	 * @param message 历史轨迹信息
	 * @return
	 * @throws RemoteException 
	 */
	public void changeOrderState(ArrayList<String> orderIDs,String message ) throws RemoteException{
		for (String orderID : orderIDs) {
			OrderPO orderPO = orderData.find(orderID);
			addHitoryMessage(orderPO, message);
		}
	}
	public void changeOrderState(ArrayList<String> orderIDs,String message,CommodityState orderState) throws RemoteException{
		for (String orderID : orderIDs) {
			OrderPO orderPO = orderData.find(orderID);
			addHitoryMessage(orderPO, message);
			updateOrderState(orderPO,orderState);
		}
	}
	
	private void updateOrderState(OrderPO orderPO, CommodityState orderState) throws RemoteException {
		ArrayList<CommodityPO> commos = orderPO.getCommodityPO();
		for (CommodityPO commodityPO : commos) {
			commodityPO.setCommodityState(orderState);
		}
		orderPO.setCommodityPO(commos);
		orderData.modify(orderPO);
	}
	private void addHitoryMessage(OrderPO order,String message) throws RemoteException{
		ArrayList<String> historyMessage = order.getMidAddres();
		historyMessage.add(message);
		order.setMidAddres(historyMessage);
		orderData.modify(order);
	}
	@Override
	public ArrayList<OrderVO> getAllOrders() throws RemoteException {
		ArrayList<OrderPO> orderPOs = orderData.find();
		ArrayList<OrderVO> orderVOs = OrderTrans.convertOrderPOstoVOs(orderPOs);
		return orderVOs;
	}

	@Override
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
	@Override
	public void changeOrderState(String order, String message) throws RemoteException {
		OrderPO orderPO = orderData.find(order);
		addHitoryMessage(orderPO, message);
	}
	@Override
	public void changeOrderState(String order, String message, CommodityState orderState) throws RemoteException {
		OrderPO orderPO = orderData.find(order);
		addHitoryMessage(orderPO, message);
		updateOrderState(orderPO,orderState);
	}
}
