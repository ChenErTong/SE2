package data.transferdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.transferdataservice.TransferDataService;
import po.TransferPO;
import state.ResultMessage;

public class TransferData extends ManageData implements TransferDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransferData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
