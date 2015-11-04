package dataservice.orderdataservice;

import dataservice.DataService;
import po.OrderPO;
import po.PersistentObject;
import state.ResultMessage;

/**
 *提供订单集体载入、增改查的服务
 *@author czw
 *@version Oct 22,2015 
 */
public interface OrderDataService <OrderPO extends PersistentObject>extends DataService<OrderPO>{
	/**
	 * 根据订单号查找订单
	 * @param ordernumber 订单号
	 * @return 订单持久化对象，若没有找到返回null
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public OrderPO find(String ordernumber);
	
	/**
	 * 新增订单
	 * @param order 订单持久化对象
	 * @return 处理信息
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage insert(OrderPO order);
	
	/**
	 * 修改订单
	 * @param order 订单持久化对象
	 * @return 处理信息
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage update(OrderPO order);
}