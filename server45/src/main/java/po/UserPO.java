package po;

import state.UserAuthority;
import state.UserIdentity;

/**
 * 用户持久化对象
 * @author zsq
 * @version Oct 22,2015
 */
public class UserPO extends PersistentObject{
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**用户名*/
	private String userName;

	/**密码*/
	private String password;
	/**用户身份*/
	private UserIdentity iden;
	/**联系电话*/
	private String phoneNumber;

	/**用户权限*/
	private UserAuthority  authority;
	/**地址*/
	private String address;
	
	private boolean isAllocated;
	public UserPO(String id, String userName, String password, UserIdentity iden, String phoneNumber, UserAuthority authority,
			String address) {
		super(id);
		this.userName = userName;
		this.password = password;
		this.iden = iden;
		this.phoneNumber = phoneNumber;
		this.authority = authority;
		this.address = address;
	}
	
	public boolean isAllocated() {
		return isAllocated;
	}

	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}

	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public UserIdentity getIden() {
		return iden;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public UserAuthority getAuthority() {
		return authority;
	}
	public String getAddress() {
		return address;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
