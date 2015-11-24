package data.userdata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;
import util.SerSaveAndLoad;
import util.Util;

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
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Admin 默认为编号0000的用户
	 * @author Ann
	 */
	@Override
	public ResultMessage updateAdmin(String oldPassword, String newPassword) throws RemoteException {
		UserPO admin = poList.get(0);
		if(!admin.getPassword().equals(oldPassword))
			//旧密码不正确
			return ResultMessage.FAIL;
		else {
			admin.setPassword(newPassword);
			return ResultMessage.SUCCESS;
		}
	}
	@Override
	public String getID() throws RemoteException {
		int newID = poList.size();
		return Util.transIntToString(newID, 4);
	}

}
