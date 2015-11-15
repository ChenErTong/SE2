package businesslogic.userbl;

import java.util.ArrayList;

import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;
import dataservice.userdataservice.LoginInfo;
import businesslogicservice.userblservice.UserBLService;

public class UserController implements UserBLService{

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
