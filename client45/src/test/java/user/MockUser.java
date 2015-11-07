package user;

import java.util.ArrayList;

import state.ResultMessage;
import state.UserAuthority;
import state.UserIdentity;
import vo.UserVO;
import businesslogic.userbl.User;

public class MockUser extends User {
	String ID;
	String username;
	String password;
	String name;
	UserIdentity iden;
	ArrayList operationRecords;
	UserAuthority  authority;
	
	public MockUser(String username,String password,String ID,String name,UserIdentity iden,UserAuthority authority){
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.iden = iden;
		this.name = name;
		this.authority = authority;

	}
	
	
	public ArrayList<UserVO> show(){
		return operationRecords;
		
	}
	
	public String getID() {
		return "123";
	}
	
	public ResultMessage addUser(UserVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage deleteUser(String username) {
		return ResultMessage.FAIL;
	}
	
	public ResultMessage updateUser(UserVO vo) {
		return ResultMessage.WAIT;
	}
}
