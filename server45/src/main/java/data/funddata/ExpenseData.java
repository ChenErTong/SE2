package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.funddataservice.ExpenseDataService;
import po.ExpensePO;
import state.ResultMessage;

public class ExpenseData extends Data implements ExpenseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpenseData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(ExpensePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ExpensePO PO)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ExpensePO> show(String ID)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
