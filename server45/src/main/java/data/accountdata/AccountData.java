package data.accountdata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import util.SerSaveAndLoad;

public class AccountData extends ManageData<AccountPO> implements AccountDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public AccountData() throws RemoteException {
		poList = new SerSaveAndLoad<AccountPO>("data/"+NAME+".ser");
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<AccountPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
