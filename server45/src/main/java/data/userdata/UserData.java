package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

public class UserData extends ManageData<UserPO> implements UserDataService<UserPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(UserPO PO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> find() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateAdmin(String oldPassword, String newPassword) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
