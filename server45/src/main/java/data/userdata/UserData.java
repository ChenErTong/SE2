package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.ManageData;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;
import util.SerSaveAndLoad;

public class UserData extends ManageData<UserPO> implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public UserData() throws RemoteException {
		poList=new SerSaveAndLoad<UserPO>("data/"+NAME+".ser");
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
