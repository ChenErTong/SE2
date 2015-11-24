package dataservice.openingstockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.OpeningStockPO;
import state.ResultMessage;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public interface OpeningStockDataService extends DataService<OpeningStockPO>{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OpeningStockData";
	/**增加一条po数据**/
	public ResultMessage add(OpeningStockPO po) throws RemoteException;
	
	public String getID() throws RemoteException;
	/**返回OpeningStockPO持久数据**/
	public OpeningStockPO findOpeningStock(String id) throws RemoteException;
	
	public ArrayList<OpeningStockPO> find() throws RemoteException;
}

