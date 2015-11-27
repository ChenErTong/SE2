package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;
import dataservice.userdataservice.LoginInfo;
import businesslogicservice.userblservice.UserBLService;

public class UserController implements UserBLService{

	User userBL = new User();
	@Override
	public ConfirmState confirmOperation() {
		return userBL.confirmOperation();
	}

	@Override
	public ArrayList<UserVO> show() {
		try {
			return userBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getID() {
		try {
			return userBL.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addUser(UserVO vo) {
		try {
			return userBL.addUser(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage deleteUser(UserVO vo) {
		try {
			return userBL.deleteUser(vo.userName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateUser(UserVO vo) {
		try {
			return userBL.updateUser(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		try {
			return userBL.login(loginInfo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
