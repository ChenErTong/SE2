package user;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import state.UserAuthority;
import state.UserIdentity;
import vo.UserVO;
import businesslogic.userbl.User;

public class MockUser extends User {
	public MockUser() throws MalformedURLException, RemoteException, NotBoundException {
		super();
	}

	String ID;
	String username;
	String password;
	String name;
	UserIdentity iden;
	ArrayList<UserVO> operationRecords;
	UserAuthority  authority;
	
/*	public MockUser(String username,String password,String ID,String name,UserIdentity iden,UserAuthority authority){
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.iden = iden;
		this.name = name;
		this.authority = authority;

	}*/
	
	
	public ArrayList<UserVO> show(){
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
