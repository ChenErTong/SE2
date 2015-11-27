package dataservice.userdataservice;

import java.io.Serializable;
/**
 * 登录信息
 * @author zsq
 * @version Oct 24,2015
 */
//TODO Info最好换个名字，容易和bl的产生误解
public class LoginInfo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = -4873849122405059189L;
	
	/** 登陆用户名 */
	public String username;
	/** 密码 */
	public String password;
	/** 是否记住密码 */
	public boolean isRemembered;

	public LoginInfo(String username, String password, boolean isRemembered) {
		this.username = username;
		this.password = password;
		this.isRemembered = isRemembered;
	}
}
