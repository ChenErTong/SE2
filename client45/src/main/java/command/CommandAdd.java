package command;

import java.rmi.RemoteException;

import businesslogic.BLFactory;
import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;

public class CommandAdd<PO extends PersistentObject> extends Command<PO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandAdd(String BLName, PO po) {
		super(BLName, po);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage execute() throws RemoteException {
		CommonBusinessLogic<PO> businessLogic = (CommonBusinessLogic<PO>) BLFactory.getBLByName(BLName);
		return businessLogic.add(po);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage undo() throws RemoteException {
		CommonBusinessLogic<PO> businessLogic = (CommonBusinessLogic<PO>) BLFactory.getBLByName(BLName);
		PO res = businessLogic.delete(po.getID());
		if (res == null) {
			return ResultMessage.FAIL;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

}
