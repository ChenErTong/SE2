package data.userdata;

import java.rmi.RemoteException;

import config.XMLReader;
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
	}

	
	@Override
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		for (UserPO po : poList.getInList()) {
			if (po.getUsername().equals(loginInfo.username)){
				if (po.getPassword().equals(loginInfo.password)) {
					return UserIdentity.valueOf(po.getIden());
				}else {
					//密码不正确
					return null;
				}
			}
		}
		//无用户
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
	public void initialFile() {
		poList=new SerSaveAndLoad<UserPO>("data/"+NAME+".ser");
		configReader=new XMLReader("config/"+NAME+".xml");
	}

}
