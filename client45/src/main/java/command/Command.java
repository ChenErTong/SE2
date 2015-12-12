package command;

import java.io.Serializable;
import java.rmi.RemoteException;

import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;

public abstract class Command<PO extends PersistentObject> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CommonBusinessLogic<PO> businessLogic;
	public PO po;

	public Command(CommonBusinessLogic<PO> businessLogic, PO po) {
		this.businessLogic = businessLogic;
		this.po = po;
	}

	public abstract ResultMessage execute() throws RemoteException;

	public abstract ResultMessage undo() throws RemoteException;
}
