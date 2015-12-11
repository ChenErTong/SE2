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

	public CommandAdd(String command, PO po) {
		super(command, po);
	}

	@Override
	public ResultMessage execute(CommonBusinessLogic<PO> businessLogic) throws RemoteException {
		return businessLogic.add(po);
	}

	@Override
	public ResultMessage undo(CommonBusinessLogic<PO> businessLogic) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
