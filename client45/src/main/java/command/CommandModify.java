package command;

import java.rmi.RemoteException;

import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;

public class CommandModify<PO extends PersistentObject> extends Command<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandModify(CommonBusinessLogic<PO> businessLogic, PO po) {
		super(businessLogic, po);
	}

	@Override
	public ResultMessage execute() throws RemoteException {
		PO res = businessLogic.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			po=res;
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		PO res = businessLogic.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			po=res;
			return ResultMessage.SUCCESS;
		}
	}

}
