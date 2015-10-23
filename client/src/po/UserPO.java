package po;

import java.util.ArrayList;

/**
 * �û��־û�����
 * @author zsq
 * @version Oct 22,2015
 */
public class UserPO extends PersistentObject{
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**�û����˺�*/
	private String username;
	/**�û���ʵ����*/
	private String name;

	/**����*/
	private String password;
	/**�û����Ȩ��*/
	private UserIdentity iden;
	/**������¼*/
	private ArrayList operationRecords;
	/**
	 * ���캯��
	 * @param ID
	 * @param username
	 * @param name
	 * @param password
	 * @param iden
	 */
	public UserPO(String ID,String username,String name,String password,UserIdentity iden){
		//super(ID);
		this.username = username;
		this.name = name;
		this.password = password;
		this.iden = iden;
		
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

	
}
