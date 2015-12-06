package businesslogic.userbl;

import po.UserPO;
import state.UserIdentity;
import util.SerSaveAndLoad;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月4日 下午8:14:20 
*/
public class UserInfomation {
	private UserPO currentUser;
	private static UserInfomation currentUserInfomation;
	private UserInfomation(){
		SerSaveAndLoad<UserPO> currentUserFile = new SerSaveAndLoad<>("user",User.currentUserFileName);
		this.currentUser=currentUserFile.get(0);
	}
	
	public static UserInfomation getInstance(){
		if(currentUserInfomation==null){
			currentUserInfomation=new UserInfomation();
		}
		return currentUserInfomation;
	}
	
	public UserIdentity getIden(){
		return this.currentUser.getIden();
	}
	
	public String getAuthority(){
		return this.currentUser.getAuthority();
	}
	
	public String getUserName(){
		return this.currentUser.getUserName();
	}
}
