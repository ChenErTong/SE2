package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import command.CommandController;
import command.CommandDelete;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.accountvo.AccountVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:31:56
 */
public class AccountController implements AccountBLService {
	private Account AccountBL;
	private CommandController<AccountPO> commandController;

	public AccountController() throws MalformedURLException, RemoteException, NotBoundException {
		AccountBL = new Account();
		commandController = new CommandController<AccountPO>("account");
	}

	/**
	 * @see AccountBLService#show()
	 */
	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountBL.show();
	}

	/**
	 * @see AccountBLService#show(String)
	 */
	public ArrayList<AccountVO> show(String duty) throws RemoteException {
		return AccountBL.show(duty);
	}

	/**
	 * @see AccountBLService#getID()
	 */
	public String getID() throws RemoteException {
		return AccountBL.getID();
	}

	/**
	 * @see AccountBLService#addAccount(AccountVO)
	 */
	public ResultMessage addAccount(AccountVO vo) throws RemoteException {
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		return AccountBL.add(po);
	}

	/**
	 * @see AccountBLService#deleteAccount(String)
	 */
	public ResultMessage deleteAccount(String ID) throws RemoteException {
		AccountPO account = AccountBL.delete(ID);
		if (account == null) {
			return ResultMessage.FAIL;
		} else {
			commandController.addCommand(new CommandDelete<AccountPO>(AccountBL, account));
			return ResultMessage.SUCCESS;
		}
		// Command<AccountPO> command = new CommandDelete<AccountPO>("delete",
		// account);
		// commandController.addCommand(command);
		// return account == null ? ResultMessage.FAIL : ResultMessage.SUCCESS;
		// }
	}

	/**
	 * @see AccountBLService#updateAccount(AccountVO)
	 */
	public ResultMessage updateAccount(AccountVO vo) throws RemoteException {
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		return AccountBL.modify(po);
	}

	/**
	 * @see AccountBLService#find(String)
	 */
	public AccountVO find(String id) throws RemoteException {
		return AccountBL.find(id);
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
