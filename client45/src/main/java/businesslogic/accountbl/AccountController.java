package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.accountblservice.AccountBLService;
import command.Command;
import command.CommandAdd;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
import config.RMIConfig;
import dataservice.userdataservice.UserDataService;
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
	private UserDataService userData;
	private CommandController<AccountPO> commandController;

	public AccountController() throws MalformedURLException, RemoteException, NotBoundException {
		AccountBL = new Account();
		commandController = new CommandController<AccountPO>("account");
		userData = (UserDataService) Naming.lookup(RMIConfig.PREFIX + UserDataService.NAME);
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
		LogController.getInstance().addLog("添加公司职员");
		userData.find(vo.userID).setAllocated(true);
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		Command<AccountPO> addCommand=new CommandAdd<AccountPO>(Account.BLNAME, po);
		commandController.addCommand(addCommand);
		return addCommand.execute();
	}

	/**
	 * @see AccountBLService#deleteAccount(String)
	 */
	public ResultMessage deleteAccount(String ID) throws RemoteException {
		LogController.getInstance().addLog("删除公司职员");
		AccountPO account = AccountBL.delete(ID);
		if (account == null) {
			return ResultMessage.FAIL;
		} else {
			commandController.addCommand(new CommandDelete<AccountPO>(Account.BLNAME, account));
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
		LogController.getInstance().addLog("修改公司职员信息");
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		AccountPO res =  AccountBL.modify(po);
		if(res==null){
			return ResultMessage.FAIL;
		}else{
			Command<AccountPO> modifyCommand = new CommandModify<AccountPO>(Account.BLNAME, res);
			commandController.addCommand(modifyCommand);
			return ResultMessage.SUCCESS;
		}
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
