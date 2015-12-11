package command;

import java.rmi.RemoteException;

import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;

public class CommandAdd<PO extends PersistentObject> extends Command<PO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandAdd(CommonBusinessLogic<PO> businessLogic, PO po) {
		super(businessLogic, po);
	}

	@Override
	public ResultMessage execute() throws RemoteException {
		return businessLogic.add(po);
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
