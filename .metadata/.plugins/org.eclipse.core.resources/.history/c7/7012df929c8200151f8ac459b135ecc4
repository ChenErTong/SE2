package vo;

import java.util.ArrayList;

import state.UserAuthority;
import state.UserIdentity;

public class UserVO {
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**用户名*/
	private String username;
	/**用户真实姓名*/
	private String name;

	/**密码*/
	private String password;
	/**用户身份*/
	private UserIdentity iden;
	/**用户操作*/
	private ArrayList operationRecords;
	/**用户权限*/
	private UserAuthority  authority;
	/**
	 * 构造函数
	 * @param username
	 * @param name
	 * @param password
	 * @param iden
	 */
	public UserVO(String username,String name,String password,UserIdentity iden){

		this.username = username;
		this.name = name;
		this.password = password;
		this.iden = iden;
		
	}
	public String getName() {
		return this.name;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public UserIdentity getIden() {
		return this.iden;
	}
	public UserAuthority getAuthority() {
		return authority;
	}
	
}
