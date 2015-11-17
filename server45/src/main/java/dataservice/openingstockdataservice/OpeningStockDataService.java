package dataservice.openingstockdataservice;

import java.rmi.RemoteException;

import dataservice.DataService;
import po.OpeningStockPO;
import state.ResultMessage;

public interface OpeningStockDataService extends DataService {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OpeningStockData";
	public ResultMessage add(OpeningStockPO po) throws RemoteException;
	public void init() throws RemoteException;
	public OpeningStockPO findOpeningStock(String id) throws RemoteException;
}

