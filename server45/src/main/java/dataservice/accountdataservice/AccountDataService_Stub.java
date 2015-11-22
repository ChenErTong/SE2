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
	public ArrayList<AccountPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
