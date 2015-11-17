package dataservice.transferdataservice;

import java.rmi.RemoteException;

import po.TransferPO;
import state.ResultMessage;

public interface TransferDataService {
	public ResultMessage insert(TransferPO po) throws RemoteException;
	public TransferPO find(String id) throws RemoteException;
	public ResultMessage update(TransferPO po) throws RemoteException;
}
