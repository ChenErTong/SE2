package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.CommodityState;
import vo.CommodityVO;
import vo.OrderVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:09
 */
public interface OrderInfo_Branch_Transfer {
	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * 
	 * @author Ann
	 * @param orders
	 *            ArrayList<String>型，订单ID列表
	 * @param message
	 *            String型，历史轨迹信息
	 * @throws RemoteException
	 *             远程异常
	 */
	public void changeOrderState(ArrayList<String> orders, String message) throws RemoteException;

	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * 
	 * @param order
	 *            String型，订单ID
	 * @param message
	 *            String型，历史轨迹信息
	 * @return boolean型，是否修改成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public boolean changeOrderState(String order, String message) throws RemoteException;

	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * 
	 * @param order
	 *            String型，订单ID
	 * @param message
	 *            String型，历史轨迹信息
	 * @param orderState
	 *            CommodityState型，订单新状态
	 * @throws RemoteException
	 *             远程异常
	 */
	public void changeOrderState(String order, String message, CommodityState orderState) throws RemoteException;

	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * 
	 * @param orders
	 *            ArrayList<String>型，订单ID列表
	 * @param message
	 *            String型，历史轨迹信息
	 * @param orderState
	 *            CommodityState型，订单新状态
	 * @throws RemoteException
	 *             远程异常
	 */
	public void changeOrderState(ArrayList<String> orders, String message, CommodityState orderState)
			throws RemoteException;

	/**
	 * 获取所有的订单
	 * 
	 * @return ArrayList<OrderVO>型，所有订单列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<OrderVO> getAllOrders() throws RemoteException;

	/**
	 * 获取所有的订单商品
	 * 
	 * @return ArrayList<CommodityVO>型，所有商品列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException;
}
