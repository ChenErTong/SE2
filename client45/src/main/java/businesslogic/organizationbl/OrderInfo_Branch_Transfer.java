package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.receiptbl.OrderInfo_Receipt;
import vo.CommodityVO;
import vo.OrderVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:09
 */
public interface OrderInfo_Branch_Transfer extends OrderInfo_Receipt {
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
