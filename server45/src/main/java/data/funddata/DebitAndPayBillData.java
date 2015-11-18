package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.DebitAndPayBillPO;
import po.PersistentObject;
import state.ReceiptType;
import state.ResultMessage;
import util.SerSaveAndLoad;

public class DebitAndPayBillData extends ManageData implements DebitAndPayBillDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public DebitAndPayBillData() throws RemoteException {
		poList=new SerSaveAndLoad<DebitAndPayBillPO>("data/"+NAME+".ser");
	}

	@Override
	public ResultMessage insert(DebitAndPayBillPO po)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(DebitAndPayBillPO PO)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExpenseID()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPayID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
