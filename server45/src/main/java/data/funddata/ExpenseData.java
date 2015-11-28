package data.funddata;

import java.rmi.RemoteException;

import config.XMLReader;
import data.ManageData;
import dataservice.funddataservice.ExpenseDataService;
import po.ExpensePO;
import util.SerSaveAndLoad;
@Deprecated
public class ExpenseData extends ManageData<ExpensePO> implements ExpenseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public ExpenseData() throws RemoteException {
	}
	@Override
	public void initialFile() {
		poList=new SerSaveAndLoad<ExpensePO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
		
	}
	


}
