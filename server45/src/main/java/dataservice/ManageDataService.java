package dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PersistentObject;
import state.ResultMessage;

public interface ManageDataService<PO extends PersistentObject> extends DataService<PO>{
	public String getID() throws RemoteException;
	public ArrayList<PO> find()throws RemoteException;
	public ResultMessage add(PO po)throws RemoteException;
	public ResultMessage delete(String id) throws RemoteException;
	public ResultMessage modify(PO po)throws RemoteException;
}
