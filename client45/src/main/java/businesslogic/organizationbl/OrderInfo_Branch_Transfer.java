package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.CommodityState;
import vo.CommodityVO;
import vo.OrderVO;

public interface OrderInfo_Branch_Transfer {
	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * @author Ann
	 * @param orders 订单ID
	 * @param message 历史轨迹信息
	 * @throws RemoteException 
	 */
	public void changeOrderState(ArrayList<String> orders,String message) throws RemoteException;
	public void changeOrderState(String order,String message) throws RemoteException;
	public void changeOrderState(String order,String message,CommodityState orderState) throws RemoteException;
	public void changeOrderState(ArrayList<String> orders,String message,CommodityState orderState) throws RemoteException;
	public ArrayList<OrderVO> getAllOrders() throws RemoteException;
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException;
}
