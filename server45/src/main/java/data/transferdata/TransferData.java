package data.transferdata;

import java.rmi.RemoteException;

import data.Data;
import dataservice.transferdataservice.TransferDataService;
import po.TransferPO;
import state.ResultMessage;

public class TransferData extends Data implements TransferDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransferData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(TransferPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(TransferPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
