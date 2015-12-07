package businesslogic.userbl;

import po.UserPO;
import state.UserAuthority;
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
		try {
			this.currentUser=currentUserFile.get(0);
		} catch (Exception e) {
			this.currentUser=new UserPO("7777", "测试员", "7777", UserIdentity.ADMIN, null, null, null);
		}
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
	
	public UserAuthority getAuthority(){
		return this.currentUser.getAuthority();
	}
	
	public String getUserName(){
		return this.currentUser.getUserName();
	}
}
