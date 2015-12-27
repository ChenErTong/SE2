package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
import businesslogicservice.userblservice.UserBLService;
import command.Command;
import command.CommandAdd;
import command.CommandController;
import command.CommandDelete;
import command.CommandModify;
import dataservice.userdataservice.LoginInfo;
import po.UserPO;
import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:58
 */
public class UserController implements UserBLService {

	User userBL;
	private CommandController<UserPO> commandController;

	public UserController() throws MalformedURLException, RemoteException, NotBoundException {
		userBL = new User();
		commandController = new CommandController<UserPO>("user");
	}

	@Override
	public ConfirmState confirmOperation() {
		return userBL.confirmOperation();
	}

	/**
	 * @see UserBLService#show()
	 */
	public ArrayList<UserVO> show() throws RemoteException {
		return userBL.show();
	}

	/**
	 * @see UserBLService#getID()
	 */
	public String getID(String organizationID,UserIdentity userIden) throws RemoteException {
		return userBL.getID(organizationID,userIden);
	}

	/**
	 * @see UserBLService#addUser(UserVO)
	 */
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		LogController.getInstance().addLog("添加用户");
		UserPO po = UserTrans.transVOtoPO(vo);
		Command<UserPO> addCommand = new CommandAdd<UserPO>(User.BLNAME, po);
		commandController.addCommand(addCommand);
		return addCommand.execute();
	}

	/**
	 * @see UserBLService#deleteUser(UserVO)
	 */
	public ResultMessage deleteUser(UserVO vo) throws RemoteException {
		LogController.getInstance().addLog("删除用户");
		UserPO userPO = userBL.delete(vo.id);
		if (userPO == null) {
			return ResultMessage.FAIL;
		} else {
			Command<UserPO> command = new CommandDelete<UserPO>(User.BLNAME, userPO);
			commandController.addCommand(command);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see UserBLService#updateUser(UserVO)
	 */
	public ResultMessage updateUser(UserVO vo) throws RemoteException {
		LogController.getInstance().addLog("修改用户信息");
		UserPO po = UserTrans.transVOtoPO(vo);
		UserPO res = userBL.modify(po);
		if (res == null) {
			return ResultMessage.FAIL;
		} else {
			Command<UserPO> modifyCommand = new CommandModify<UserPO>(User.BLNAME, res);
			commandController.addCommand(modifyCommand);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see UserBLService#login(LoginInfo)
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		return userBL.login(loginInfo);
	}

	/**
	 * @see UserBLService#updateAdmin(String, String)
	 */
	@SuppressWarnings("deprecation")
	public ResultMessage updateAdmin(String oldPassword, String newPassword) throws RemoteException {
		return userBL.updateAdmin(oldPassword, newPassword);
	}

	/**
	 * @see UserBLService#showUser(UserIdentity)
	 */
	public ArrayList<UserVO> showUser(UserIdentity userIdentity) throws RemoteException {
		return userBL.showUser(userIdentity);
	}

	public ArrayList<String> getUserIDCanBeUsedByAccounts() throws RemoteException{
		return userBL.getUserIDCanBeUsedByAccounts();
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
