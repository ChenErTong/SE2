package data.userdata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import util.SerSaveAndLoad;

public class UserData extends ManageData<UserPO> implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public UserData() throws RemoteException {
		initAdmin();
	}

	private void initAdmin() {
		return;
	}

	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<UserPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
