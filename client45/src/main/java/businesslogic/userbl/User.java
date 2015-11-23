package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;

public class User {
	private UserDataService userData;

	public User() {
		try {
			userData = (UserDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + UserDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ArrayList<UserVO> show() throws RemoteException {
		ArrayList<UserPO> pos = userData.find();
		ArrayList<UserVO> vos = UserTrans.transPOstoVOs(pos);
		return vos;
	}

	public String getID() throws RemoteException {
		return userData.getID();
	}

	public ResultMessage addUser(UserVO vo) throws RemoteException {
		UserPO userPO = UserTrans.transVOtoPO(vo);
		return userData.add(userPO);
	}

	public ResultMessage deleteUser(String username) throws RemoteException {
		return userData.delete(username);
	}

	public ResultMessage updateUser(UserVO vo) throws RemoteException {
		UserPO userPO = UserTrans.transVOtoPO(vo);
		return userData.modify(userPO);
	}

	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		return userData.login(loginInfo);
	}
}
