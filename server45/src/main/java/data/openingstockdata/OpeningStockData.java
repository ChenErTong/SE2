package data.openingstockdata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.openingstockdataservice.OpeningStockDataService;
import po.OpeningStockPO;
import util.SerSaveAndLoad;

public class OpeningStockData extends ManageData<OpeningStockPO> implements OpeningStockDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public OpeningStockData() throws RemoteException {
	}

//	@Override
//	public ResultMessage add(OpeningStockPO po) throws RemoteException {
//		if (poList.add(po))
//			return ResultMessage.SUCCESS;
//		return ResultMessage.FAIL;
//	}


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
	public void initialFile() {
		poList=new SerSaveAndLoad<OpeningStockPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
