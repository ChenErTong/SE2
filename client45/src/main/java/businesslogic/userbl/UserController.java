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
	public ArrayList<UserVO> show() throws RemoteException {
		try {
			return userBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getID() throws RemoteException {
			return userBL.getID();
	}

	@Override
	public ResultMessage addUser(UserVO vo) throws RemoteException {
			return userBL.addUser(vo);
	}

	@Override
	public ResultMessage deleteUser(UserVO vo) throws RemoteException {
			return userBL.deleteUser(vo.id);
	}

	@Override
	public ResultMessage updateUser(UserVO vo) throws RemoteException {
			return userBL.updateUser(vo);
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
			return userBL.login(loginInfo);
	}

	@Override
	public ResultMessage updateAdmin(String oldPassword, String newPassword) throws RemoteException {
			return userBL.updateAdmin(oldPassword, newPassword);
	}

	@Override
	public ArrayList<UserVO> showUser(UserIdentity userIdentity) throws RemoteException {
			return userBL.showUser(userIdentity);
	}
	
	

}
