package dataservice.userdataservice;

import java.util.ArrayList;

import dataservice.DataService;
import po.PersistentObject;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

/**
 *@author zsq
 *@version Oct 22,2015 
 */
public interface  UserDataService<UserPO extends PersistentObject>extends DataService<UserPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "UserData";
	
	/**
	 * @param po
	 */
	public ResultMessage insert(UserPO po);
	/**
	 * @param ID
	 */
	public ResultMessage delete(String ID);
	/**
	 * @param PO
	 */
	public ResultMessage update(UserPO PO);
	/**
	 */
	public ArrayList<UserPO> find();
	/**
	 * @param loginInfo
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo);
	
	/**
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateAdmin(String oldPassword,String newPassword);
}
