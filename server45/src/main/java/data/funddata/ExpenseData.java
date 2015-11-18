package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.funddataservice.ExpenseDataService;
import po.ExpensePO;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class ExpenseData extends ManageData<ExpensePO> implements ExpenseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ExpenseData() throws RemoteException {
		poList=new SerSaveAndLoad<ExpensePO>("data/"+NAME+".ser");
	}
	

	@Override
	public ResultMessage add(ExpensePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ExpensePO PO)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ExpensePO> show(String ID)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
