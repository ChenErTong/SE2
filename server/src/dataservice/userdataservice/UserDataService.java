package dataservice.userdataservice;

import java.util.ArrayList;

import dataservice.DataService;
import po.PersistentObject;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

/**
 *提供系统用户的登录、集体导入、保存以及增删改查的服务
 *@author zsq
 *@version Oct 22,2015 
 */
public interface  UserDataService<UserPO extends PersistentObject>extends DataService<UserPO> {

	/**
	 * 向序列化文件中增加一个UserPO
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(UserPO po);
	/**
	 * 根据ID删除序列化文件中的一个UserPO
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);
	/**
	 * 更新UserPO
	 * @param PO
	 * @return 处理结果
	 */
	public ResultMessage update(UserPO PO);
	/**
	 * 显示所有的UserPO
	 * @return 返回所有的UserPO集合
	 */
	public ArrayList<UserPO> find();
	/**
	 * 验证用户的登录
	 * @param loginInfo
	 * @return 返回登录的用户身份 ,登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo);
	
	/**
	 * 管理员修改自身密码
	 * @param oldPassword，旧密码
	 * @param newPassword，新密码
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateAdmin(String oldPassword,String newPassword);
}
