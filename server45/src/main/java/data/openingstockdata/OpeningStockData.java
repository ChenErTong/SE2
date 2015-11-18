package data.openingstockdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.openingstockdataservice.OpeningStockDataService;
import po.OpeningStockPO;
import state.ResultMessage;

public class OpeningStockData extends ManageData implements OpeningStockDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpeningStockData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(OpeningStockPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public OpeningStockPO findOpeningStock(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
