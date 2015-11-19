package data.accountdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.accountdataservice.AccountDataService;
import po.PersistentObject;

public class AccountData extends ManageData implements AccountDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
<<<<<<< Updated upstream
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
=======
	public void init() {
		
>>>>>>> Stashed changes
		
	}

}
