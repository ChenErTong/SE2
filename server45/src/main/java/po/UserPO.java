package po;

import java.util.ArrayList;

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
	 * @param ID
	 * @param username
	 * @param iden
	 * @param password
	 * @param iden
	 */
	public UserPO(String ID,String username,String name,UserIdentity iden,String password,UserAuthority authority){
		super(ID);
		this.username = username;
		this.name  = name;
		this.iden = iden;
		this.password = password;
		this.authority = authority;
		
	}

	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return this.name;
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

	
	public ArrayList getOperationRecords() {
		return operationRecords;
	}

	

	
}
