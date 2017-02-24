package businesslogic.receiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.CommodityState;

public interface OrderInfo_Receipt {

//	/**
//	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
//	 * 
//	 * @author Ann
//	 * @param orders
//	 *            ArrayList<String>型，订单ID列表
//	 * @param message
//	 *            String型，历史轨迹信息
//	 * @throws RemoteException
//	 *             远程异常
//	 */
//	public void changeOrderState(ArrayList<String> orders, String message) throws RemoteException;
//
//	/**
//	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
//	 * 
//	 * @param order
//	 *            String型，订单ID
//	 * @param message
//	 *            String型，历史轨迹信息
//	 * @return boolean型，是否修改成功
//	 * @throws RemoteException
//	 *             远程异常
//	 */
//	public boolean changeOrderState(String order, String message) throws RemoteException;
//
//	/**
//	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
//	 * 
//	 * @param order
//	 *            String型，订单ID
//	 * @param message
//	 *            String型，历史轨迹信息
//	 * @param commodifyState
//	 *            CommodityState型，订单新状态
//	 * @throws RemoteException
//	 *             远程异常
//	 */
//	public void changeOrderState(String order, String message, CommodityState commodifyState) throws RemoteException;
//
//	/**
//	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
//	 * 
//	 * @param orders
//	 *            ArrayList<String>型，订单ID列表
//	 * @param message
//	 *            String型，历史轨迹信息
//	 * @param commodityState
//	 *            CommodityState型，订单新状态
//	 * @throws RemoteException
//	 *             远程异常
//	 */
//	public void changeOrderState(ArrayList<String> orders, String message, CommodityState commodityState) throws RemoteException;

	public void changeOrderStateToExporting(ArrayList<String> orders, String string) throws RemoteException;

	public void changeOrderStateToTBE(String order, String string, CommodityState state) throws RemoteException;

	public void changeOrderStateToExporting(String order, String message) throws RemoteException;

}