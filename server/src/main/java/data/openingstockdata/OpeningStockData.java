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

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<OpeningStockPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
