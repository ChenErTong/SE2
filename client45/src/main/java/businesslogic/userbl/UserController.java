package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.UserBLService;
import command.Command;
import command.CommandController;
import command.CommandDelete;
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
	private CommandController<UserPO> commandManager;

	public UserController() throws MalformedURLException, RemoteException, NotBoundException {
		userBL = new User();
		commandManager = new CommandController<UserPO>("user");
	}

	@Override
	public ConfirmState confirmOperation() {
		return userBL.confirmOperation();
	}

	/**
	 * @see UserBLService#show()
	 */
	public ArrayList<UserVO> show() throws RemoteException {
		try {
			return userBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see UserBLService#getID()
	 */
	public String getID() throws RemoteException {
		return userBL.getID();
	}

	/**
	 * @see UserBLService#addUser(UserVO)
	 */
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		UserPO po = UserTrans.transVOtoPO(vo);
		return userBL.add(po);
	}

	/**
	 * @see UserBLService#deleteUser(UserVO)
	 */
	public ResultMessage deleteUser(UserVO vo) throws RemoteException {
		UserPO userPO = userBL.delete(vo.id);
		if (userPO == null) {
			return ResultMessage.FAIL;
		} else {
			Command<UserPO> command = new CommandDelete<UserPO>(userBL, userPO);
			commandManager.addCommand(command);
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see UserBLService#updateUser(UserVO)
	 */
	public ResultMessage updateUser(UserVO vo) throws RemoteException {
		UserPO po = UserTrans.transVOtoPO(vo);
		return userBL.modify(po);
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
	public ResultMessage updateAdmin(String oldPassword, String newPassword) throws RemoteException {
		return userBL.updateAdmin(oldPassword, newPassword);
	}

	/**
	 * @see UserBLService#showUser(UserIdentity)
	 */
	public ArrayList<UserVO> showUser(UserIdentity userIdentity) throws RemoteException {
		return userBL.showUser(userIdentity);
	}

}
