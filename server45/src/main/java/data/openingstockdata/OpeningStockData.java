package data.openingstockdata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.openingstockdataservice.OpeningStockDataService;
import po.OpeningStockPO;
import state.ResultMessage;

public class OpeningStockData extends Data implements OpeningStockDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpeningStockData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(OpeningStockPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public OpeningStockPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
