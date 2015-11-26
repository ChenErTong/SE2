package dataservice.inventorydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.ManageDataService;
import po.InventoryPO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public interface InventoryDataService extends ManageDataService<InventoryPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";

	public String getLotNum()throws RemoteException;
	
	/**获得位置信息**/
	public InventoryPO getInventoryPO(String id)throws RemoteException;
	
	public InventoryPO getInventoryPO(int a,int b,int c,int d)throws RemoteException;
	
	public ArrayList<InventoryPO> getInventoryPOList(String date)throws RemoteException;

}
