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
	
	/**初始化持久数据**/
	public void init() throws RemoteException;
	
	
	/** 出库数量 **/
	public int  getexportNumber(String beginDate, String endDate)throws RemoteException;
	/** 入库数量）**/
	public int getimportNumber(String beginDate, String endDate)throws RemoteException;
	/**总数量**/
	public int getNum(String beginDate, String endDate)throws RemoteException;
	
}
