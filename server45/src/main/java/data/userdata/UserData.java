package data.userdata;

import java.util.ArrayList;

import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

public class UserData implements UserDataService<UserPO> {

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
