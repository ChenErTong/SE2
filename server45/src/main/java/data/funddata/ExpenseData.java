package data.funddata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.funddataservice.ExpenseDataService;
import po.ExpensePO;
import util.SerSaveAndLoad;
import util.Util;

public class ExpenseData extends ManageData<ExpensePO> implements ExpenseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public ExpenseData() throws RemoteException {
		poList=new SerSaveAndLoad<ExpensePO>("data/"+NAME+".ser");
	}
	@Override
	public void initialFile() {
		// TODO Auto-generated method stub
		
	}
	


}
