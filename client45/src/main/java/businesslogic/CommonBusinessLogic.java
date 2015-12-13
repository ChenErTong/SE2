package businesslogic;

import java.io.Serializable;
import java.rmi.RemoteException;

import po.PersistentObject;
import state.ResultMessage;

public interface CommonBusinessLogic<PO extends PersistentObject> extends Serializable{
	public ResultMessage add(PO po) throws RemoteException;
	public PO delete(String ID) throws RemoteException;
	public PO modify(PO po) throws RemoteException;
}
