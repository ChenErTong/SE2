package command;

import java.io.Serializable;
import java.rmi.RemoteException;

import po.PersistentObject;
import state.ResultMessage;

public abstract class Command<PO extends PersistentObject> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String BLName;
	public PO po;

	public Command(String BLName, PO po) {
		this.BLName = BLName;
		this.po = po;
	}

	public abstract ResultMessage execute() throws RemoteException;

	public abstract ResultMessage undo() throws RemoteException;
}
