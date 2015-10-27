package dataservice.userdataservice;

public class LoginInfo {
	/** 登陆用户名 */
	private String username;
	/** 密码 */
	private  String password;
	/** 是否记住密码 */
	private boolean isRemembered;

	public LoginInfo(String username, String password, boolean isRemembered) {
		this.username = username;
		this.password = password;
		this.isRemembered = isRemembered;
	}
}
