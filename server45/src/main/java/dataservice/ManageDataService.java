package dataservice;

import java.rmi.RemoteException;

import po.PersistentObject;
import state.ResultMessage;

public interface ManageDataService<PO extends PersistentObject> extends DataService<PO>{
	public PO find(String id)throws RemoteException;
	public ResultMessage add(PO po)throws RemoteException;
	public ResultMessage delete(String id) throws RemoteException;
	public ResultMessage modify(PO po)throws RemoteException;
}
