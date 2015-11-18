package data.receiptdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.ReceiptPO;
import state.ResultMessage;

public class ReceiptData extends ManageData<ReceiptPO> implements ReceiptDataService<ReceiptPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReceiptData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage update(ReceiptPO PO) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
