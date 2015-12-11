package command;

import java.io.Serializable;
import java.rmi.RemoteException;

import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;

public abstract class Command<PO extends PersistentObject> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String command;
	public PO po;
	public Command(String command, PO po) {
		this.command = command;
		this.po = po;
	}
	
	
	public abstract ResultMessage execute(CommonBusinessLogic<PO> businessLogic) throws RemoteException;
	public abstract ResultMessage undo(CommonBusinessLogic<PO> businessLogic) throws RemoteException;
}
