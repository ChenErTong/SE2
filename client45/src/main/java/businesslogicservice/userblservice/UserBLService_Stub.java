package businesslogicservice.userblservice;

import java.util.ArrayList;

import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;
import dataservice.userdataservice.LoginInfo;

public class UserBLService_Stub implements UserBLService{

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("Please confirm your operation!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ArrayList<UserVO> show() {
		System.out.println("show all users' information!");
		return new ArrayList<UserVO>(){};
	}

	@Override
	public String getID() {
		String id = "defaultID";
		return id;
	}

	@Override
	public ResultMessage addUser(UserVO vo) {
		System.out.println("Add a  user to the system!");
		return  ResultMessage.SUCCESS;
		
	}

	@Override
	public ResultMessage deleteUser(String username) {
		System.out.println("Delete a user of the system! ");
		return  ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateUser(UserVO vo) {
		System.out.println("Modify a user's information successfully!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		System.out.println("ADMIN  is loging in the system!");
		return UserIdentity.ADMIN;
	}

}
