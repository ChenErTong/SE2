package dataservice.userdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

/**
 *@author zsq
 *@version Oct 22,2015 
 */
public interface  UserDataService extends ManageDataService<UserPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "UserData";
	/**
	 * @param loginInfo
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException;
	
	/**
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateAdmin(String oldPassword,String newPassword) throws RemoteException;
	/**
	 * @author Ann
	 * @return
	 * @throws RemoteException
	 */
	public String getID() throws RemoteException;
}
