package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.FindTypeAccount;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class BankAccountData extends ManageData<BankAccountPO> implements BankAccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public BankAccountData() throws RemoteException {
		poList=new SerSaveAndLoad<BankAccountPO>("data/"+NAME+".ser");
	}


	@Override
	public ArrayList<BankAccountPO> find(String keywords, FindTypeAccount bankAccoutType)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
