package command;

import java.rmi.RemoteException;

import businesslogic.BLFactory;
import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;
@SuppressWarnings("unchecked")
public class CommandDelete<PO extends PersistentObject> extends Command<PO> {
	private static final long serialVersionUID = 1L;

	public CommandDelete(String BLName, PO po) {
		super(BLName, po);
	}

	@Override
	public ResultMessage execute() throws RemoteException {
		CommonBusinessLogic<PO> businessLogic = (CommonBusinessLogic<PO>) BLFactory.getBLByName(BLName);
		PO res = businessLogic.delete(po.getID());
		if (res == null) {
			return ResultMessage.FAIL;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		CommonBusinessLogic<PO> businessLogic = (CommonBusinessLogic<PO>) BLFactory.getBLByName(BLName);
		return businessLogic.add(po);
	}

}
