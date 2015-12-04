package dataservice.orderdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.OrderPO;

/**
 *提供订单集体载入、增改查的服务
 *@author czw
 *@author Ann
 *@version Oct 22,2015 
 */
public interface OrderDataService  extends ManageDataService<OrderPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OrderData";
	/**
	 * 根据订单号查找订单
	 * @param ordernumber 订单号
	 * @return 订单持久化对象，若没有找到返回null
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public OrderPO find(String ordernumber) throws RemoteException;
	
}