package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.UserBLService;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;

public class User implements UserBLService{
	private UserDataService<UserPO> userData;

	@SuppressWarnings("unchecked")
	public User() {
		try {
			userData = (UserDataService<UserPO>) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + UserDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addUser(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		return null;
	}
}
