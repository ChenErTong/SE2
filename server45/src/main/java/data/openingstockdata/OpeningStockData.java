package data.openingstockdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.openingstockdataservice.OpeningStockDataService;
import po.OpeningStockPO;
import util.SerSaveAndLoad;
import util.Util;

public class OpeningStockData extends ManageData<OpeningStockPO> implements OpeningStockDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public OpeningStockData() throws RemoteException {
		poList=new SerSaveAndLoad<OpeningStockPO>("data/"+NAME+".ser");
	}

//	@Override
//	public ResultMessage add(OpeningStockPO po) throws RemoteException {
//		if (poList.add(po))
//			return ResultMessage.SUCCESS;
//		return ResultMessage.FAIL;
//	}

	@Override
	public void init() throws RemoteException {
		/**@author Ann*/
		// TODO 我觉得不要了
	}

	@Override
	public OpeningStockPO findOpeningStock(String id) throws RemoteException {
		for (int i = 0; i < poList.size(); i++) {
			OpeningStockPO poFind = poList.get(i);
			if (poFind.getID().equals(id)) {
				poList.remove(i);
				return poFind;
			}
		}
		return null;
	}

	@Override
	public String getID() {
		int newID = poList.size();
		return Util.transIntToString(newID, 2);
	}

}
