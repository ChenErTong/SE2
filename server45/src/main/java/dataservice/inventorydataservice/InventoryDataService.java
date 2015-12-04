package dataservice.inventorydataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.InventoryPO;
/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:45:43
 */
public interface InventoryDataService extends ManageDataService<InventoryPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";

	public String getLotID() throws RemoteException;
	
	/** 获得位置信息 **/
	public InventoryPO find(String id) throws RemoteException;
	
}
