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
	ArrayList<String> operationRecords;
	UserAuthority  authority;
	
/*	public MockUser(String username,String password,String ID,String name,UserIdentity iden,UserAuthority authority){
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.iden = iden;
		this.name = name;
		this.authority = authority;

	}*/
	
	
	public ArrayList<String> show(){
		return operationRecords;
		
	}
	
	public String getID() {
		return ID;
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
