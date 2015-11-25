package vo;

public class LoginInfoVO {
	/** 登陆用户名 */
	public String username;
	/** 密码 */
	public  String password;
	/** 是否记住密码 */
	public boolean isRemembered;

	public LoginInfoVO(String username, String password, boolean isRemembered) {
		this.username = username;
		this.password = password;
		this.isRemembered = isRemembered;
	}

	

	public String getPassword() {
		return password;
	}

	

	public boolean isRemembered() {
		return isRemembered;
	}

	

	
	
}
