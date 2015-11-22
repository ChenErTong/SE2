package dataservice.openingstockdataservice;

import java.rmi.RemoteException;

import po.OpeningStockPO;
import state.ResultMessage;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public interface OpeningStockDataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OpeningStockData";
	/**增加一条po数据**/
	public ResultMessage add(OpeningStockPO po) throws RemoteException;
	/**初始化持久数据**/
	public void init() throws RemoteException;
	/**返回OpeningStockPO持久数据**/
	public OpeningStockPO findOpeningStock(String id) throws RemoteException;
}

