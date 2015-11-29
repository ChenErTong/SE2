package dataservice.inventorydataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.InventoryPO;
      /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface InventoryDataService extends ManageDataService<InventoryPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";

	public String getLotID() throws RemoteException;
	
	/** 获得位置信息 **/
	public InventoryPO find(String id) throws RemoteException;
	
}
