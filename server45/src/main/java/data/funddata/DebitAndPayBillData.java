package data.funddata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.DebitAndPayBillPO;
import state.ReceiptType;
import state.ResultMessage;

public class DebitAndPayBillData extends Data implements DebitAndPayBillDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DebitAndPayBillData() throws RemoteException {
		// TODO Auto-generated constructor stub
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
