package dataservice.userdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

/**
 *提供系统用户集体载入、增删改查的服务
 *@author zsq
 *@version Oct 22,2015 
 */
public interface  UserDataService extends ManageDataService<UserPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "UserData";
	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 返回登录的用户的身份，登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException;
	
	/**
	 * @param oldPassword，旧密码
	 * @param newPassword，新密码
	 * @return 处理信息
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