package vo;

import state.UserAuthority;
import state.UserIdentity;

public class UserVO {
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	private String id;
	/**用户名*/
	private String userName;

	/**密码*/
	private String password;
	/**用户身份*/
	private String iden;
	/**联系电话*/
	private String phoneNumber;

	/**用户权限*/
	private String  authority;
	/**地址*/
	private String address;


	/**
	 * 
	 * @param id 用户id
	 * @param password 用户密码
 	 * @param userName 用户名字
	 * @param phoneNumber 联系电话
	 * @param iden 用户身份
	 * @param authority 用户权限
	 * @param address 用户地址
	 */
	public UserVO(String id,String password,String userName,String phoneNumber,String iden,String authority,String address){
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.iden = iden;
		this.authority = authority;
		this.address = address;
		
	}

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getIden() {
		return iden;
	}



	public void setIden(String iden) {
		this.iden = iden;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	
	public String toString(){
		return id+","+password+","+"userName"+","+phoneNumber+","+iden+","+authority+","+address;
		
	}
	
}
