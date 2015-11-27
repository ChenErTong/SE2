package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountpo.AccountPO;

public class AccountDataService_Stub implements AccountDataService{

	@Override
	public void init() {
		System.out.println("Init the data succeed!");
		
	}

	@Override
	public ArrayList<AccountPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialFile() {
		// TODO Auto-generated method stub
		
	}

}
