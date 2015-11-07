package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

public class UserData extends Data implements UserDataService<UserPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(UserPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(UserPO PO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateAdmin(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
