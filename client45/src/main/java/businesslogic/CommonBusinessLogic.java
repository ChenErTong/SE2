package businesslogic;

import java.rmi.RemoteException;

import po.PersistentObject;
import state.ResultMessage;

public interface CommonBusinessLogic<PO extends PersistentObject> {
	public ResultMessage add(PO po) throws RemoteException;
	public PO delete(String ID) throws RemoteException;
	public PO modify(PO po) throws RemoteException;
}
