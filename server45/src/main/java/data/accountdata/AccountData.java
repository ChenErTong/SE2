package data.accountdata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.accountdataservice.AccountDataService;

public class AccountData extends Data implements AccountDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
