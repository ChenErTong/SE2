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

	public CommandDelete(String command, PO po) {
		super(command, po);
	}

	@Override
	public ResultMessage execute(CommonBusinessLogic<PO> businessLogic) throws RemoteException {
		PO res = businessLogic.delete(po.getID());
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage undo(CommonBusinessLogic<PO> businessLogic) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
