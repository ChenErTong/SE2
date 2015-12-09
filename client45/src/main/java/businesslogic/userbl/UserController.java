package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;
import dataservice.userdataservice.LoginInfo;
import businesslogicservice.userblservice.UserBLService;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:58
 */
public class UserController implements UserBLService{

	User userBL;
	public UserController() throws MalformedURLException, RemoteException, NotBoundException {
		userBL = new User();
	}
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
			return userBL.deleteUser(vo.id);
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

	@Override
	public ResultMessage updateAdmin(String oldPassword, String newPassword) {
		try {
			return userBL.updateAdmin(oldPassword, newPassword);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<UserVO> showUser(UserIdentity userIdentity) {
		try {
			return userBL.showUser(userIdentity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
