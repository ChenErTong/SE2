package dataservice.openingstockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.OpeningStockPO;
import state.ResultMessage;

public interface OpeningStockDataService extends DataService<OpeningStockPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OpeningStockData";
	public ResultMessage add(OpeningStockPO po) throws RemoteException;
	public String getID() throws RemoteException;
	public void init() throws RemoteException;
	public ArrayList<OpeningStockPO> find() throws RemoteException;
	public OpeningStockPO findOpeningStock(String id) throws RemoteException;
	
}

