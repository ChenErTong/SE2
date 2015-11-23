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
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public ExpenseData() throws RemoteException {
		//TODO 什么Name待考虑
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
	public ArrayList<ExpensePO> find()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
