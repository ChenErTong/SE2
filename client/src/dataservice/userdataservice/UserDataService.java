package dataservice.userdataservice;

import java.util.ArrayList;

import dataservice.DataService;
import po.PersistentObject;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

/**
 *提供系统用户集体载入、增删改查的服务
 *@author zsq
 *@version Oct 22,2015 
 */
public interface  UserDataService<UserPO extends PersistentObject>extends DataService<UserPO> {

	/**
	 * 增加一名系统用户
	 * @param po
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015 
	 */
	public ResultMessage insert(UserPO po);
	/**
	 * 删除一名系统用户
	 * @param ID
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015 
	 */
	public ResultMessage delete(String ID);
	/**
	 * 更新UserPO
	 * @param PO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015 
	 */
	public ResultMessage update(UserPO PO);
	/**
	 *显示UserPO
	 * @return 返回所有的UserPO的集合
	 * @author zsq
	 * @version
	 */
	public ArrayList<UserPO> find();
	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 返回登录的用户的身份，登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo);
	
	/**
	 * @param oldPassword，旧密码
	 * @param newPassword，新密码
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateAdmin(String oldPassword,String newPassword);
}