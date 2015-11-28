package data.basedata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import util.SerSaveAndLoad;

public class BaseData extends ManageData<BasePO> implements BaseDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BaseData() throws RemoteException {
	}

	
	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<BasePO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
