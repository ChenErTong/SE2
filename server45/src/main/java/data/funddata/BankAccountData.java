package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.funddataservice.BankAccountDataService;
import po.BankPO;
import state.FindTypeAccount;
import state.ResultMessage;

public class BankAccountData extends Data implements BankAccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(BankPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BankPO PO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankPO> find(String keywords, FindTypeAccount bankAccoutType) {
		// TODO Auto-generated method stub
		return null;
	}

}
