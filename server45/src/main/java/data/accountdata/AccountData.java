package data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;

public class AccountData extends ManageData<AccountPO> implements AccountDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public AccountData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
