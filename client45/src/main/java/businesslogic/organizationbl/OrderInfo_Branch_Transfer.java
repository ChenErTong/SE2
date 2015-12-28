package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
import vo.CommodityVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:09
 */
public interface OrderInfo_Branch_Transfer{
	/**
	 * 获取所有的订单
	 * 
	 * @return ArrayList<OrderPO>型，所有订单列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<OrderPO> getAllOrders() throws RemoteException;

	/**
	 * 获取所有的订单商品
	 * 
	 * @return ArrayList<CommodityVO>型，所有商品列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException;
	
	public void changeOrderStateToAPPROVING(String orderID) throws RemoteException;
}
