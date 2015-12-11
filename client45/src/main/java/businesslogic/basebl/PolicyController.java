package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.baseblservice.PolicyBLService;
import command.Command;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
import po.PolicyPO;
import state.ResultMessage;
import vo.PolicyVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:59
 */
public class PolicyController implements PolicyBLService {

	Policy policyBL;
	private CommandController<PolicyPO> commandController;

	public PolicyController() throws MalformedURLException, RemoteException, NotBoundException {
		policyBL = new Policy();
		commandController = new CommandController<PolicyPO>("policy");
	}

	/**
	 * @see PolicyBLService#getID()
	 */
	public String getID() throws RemoteException {
		return policyBL.getID();
	}

	/**
	 * @see PolicyBLService#addPolicy(PolicyVO)
	 */
	public ResultMessage addPolicy(PolicyVO vo) throws RemoteException {
		PolicyPO po = BaseTrans.convertVOtoPO(vo);
		return policyBL.add(po);
	}

	/**
	 * @see PolicyBLService#deletePolicy(String)
	 */
	public ResultMessage deletePolicy(String ID) throws RemoteException {
		PolicyPO po = policyBL.delete(ID);
		if (po == null) {
			return ResultMessage.FAIL;
		} else {
			commandController.addCommand(new CommandDelete<PolicyPO>(policyBL, po));
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see PolicyBLService#updatePolicy(PolicyVO)
	 */
	public ResultMessage updatePolicy(PolicyVO vo) throws RemoteException {
		PolicyPO po = BaseTrans.convertVOtoPO(vo);
		PolicyPO res =  policyBL.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<PolicyPO> modifyCommand = new CommandModify<PolicyPO>(policyBL, res);
			commandController.addCommand(modifyCommand);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see PolicyBLService#show()
	 */
	public ArrayList<PolicyVO> show() throws RemoteException {
		return policyBL.show();
	}

	/**
	 * @see PolicyBLService#find(String)
	 */
	public PolicyVO find(String id) throws RemoteException {
		return policyBL.find(id);
	}

	@Override
	public boolean canUndo() {
		return commandController.canUndo();
	}

	@Override
	public boolean canRedo() {
		return commandController.canRedo();
	}

	@Override
	public ResultMessage undo() throws RemoteException {
		return commandController.undoCommand();
	}

	@Override
	public ResultMessage redo() throws RemoteException {
		return commandController.redoCommand();
	}

}
