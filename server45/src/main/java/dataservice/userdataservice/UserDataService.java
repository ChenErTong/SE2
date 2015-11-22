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
	 * @param po
	 */
//	public ResultMessage insert(UserPO po) throws RemoteException;
	/**
	 * @param ID
	 */
//	public ResultMessage delete(String ID) throws RemoteException;
	/**
	 * @param PO
	 */
//	public ResultMessage update(UserPO PO) throws RemoteException;
	/**
	 */
//	public ArrayList<UserPO> find() throws RemoteException;
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
