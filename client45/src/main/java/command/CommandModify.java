package command;

import java.rmi.RemoteException;

import businesslogic.BLFactory;
import businesslogic.CommonBusinessLogic;
import po.PersistentObject;
import state.ResultMessage;
@SuppressWarnings("unchecked")
public class CommandModify<PO extends PersistentObject> extends Command<PO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandModify(String BLName, PO po) {
		super(BLName, po);
	}

	@Override
	public ResultMessage execute() throws RemoteException {
		CommonBusinessLogic<PO> businessLogic = (CommonBusinessLogic<PO>) BLFactory.getBLByName(BLName);
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
		CommonBusinessLogic<PO> businessLogic = (CommonBusinessLogic<PO>) BLFactory.getBLByName(BLName);
		PO res = businessLogic.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			po=res;
			return ResultMessage.SUCCESS;
		}
	}

}
