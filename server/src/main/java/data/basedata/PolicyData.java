package data.basedata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.basedataservice.PolicyDataService;
import po.PolicyPO;
import util.SerSaveAndLoad;

public class PolicyData extends ManageData<PolicyPO> implements PolicyDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PolicyData() throws RemoteException {
	}

	@Override
	public void initialFile() throws RemoteException {
		poList=new SerSaveAndLoad<PolicyPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
