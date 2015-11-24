package po;

import state.ReceiptType;

/**
 * 用户持久化对象
 * @author zsq
 * @version Oct 22,2015
 */
public class UserPO extends PersistentObject{
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
	 * @return 
	 */
	public UserPO(String id,ReceiptType type,String password,String userName,String phoneNumber,String iden,String authority,String address){
		super(id, type);
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.phoneNumber =phoneNumber;
		this.iden = iden;
		this.authority = authority;
		this.address = address;
		
	}


	public String getId() {
		return id;
	}



	public String getUsername() {
		return this.userName;
	}

	
	public String getPassword() {
		return this.password;
	}

	public String getIden() {
		return this.iden;
	}

	public String getAuthority() {
		return authority;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}


	

	
}
