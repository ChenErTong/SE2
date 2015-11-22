package data.openingstockdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.openingstockdataservice.OpeningStockDataService;
import po.OpeningStockPO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class OpeningStockData extends ManageData<OpeningStockPO> implements OpeningStockDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public OpeningStockData() throws RemoteException {
		poList=new SerSaveAndLoad<OpeningStockPO>("data/"+NAME+".ser");
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

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

}
