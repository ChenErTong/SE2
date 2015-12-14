package dataservice.userdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.UserPO;
import state.UserIdentity;

/**
 *提供系统用户集体载入、增删改查的服务
 *@author zsq
 *@author Ann
 *@version Oct 22,2015 
 */
public interface  UserDataService extends ManageDataService<UserPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "UserData";
	
	/**
	 * @author Ann
	 * @return
	 * @throws RemoteException
	 */
	public String getUserID(String organizationID,UserIdentity userIden) throws RemoteException;
	public UserPO find(String id) throws RemoteException;
}