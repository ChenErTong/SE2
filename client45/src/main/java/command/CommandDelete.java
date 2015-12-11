package command;

import java.rmi.RemoteException;

import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;

public class CommandDelete<PO extends PersistentObject> extends Command<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandDelete(CommonBusinessLogic<PO> businessLogic, PO po) {
		super(businessLogic, po);
	}

	@Override
	public ResultMessage execute() throws RemoteException {
		PO res = businessLogic.delete(po.getID());
		if (res == null) {
			return ResultMessage.FAIL;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		return businessLogic.add(po);
	}

}
