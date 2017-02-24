package businesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.BLService;
import dataservice.userdataservice.LoginInfo;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;

/**
 * 负责实现用户管理界面所需要的服务
 * 
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface UserBLService extends BLService {
	/**
	 * @return 全部的系统用户
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<UserVO> show() throws RemoteException;

	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * organizationID是机构的编号,可能是transfer的，也可能是branch的
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getID(String organizationID,UserIdentity userIden) throws RemoteException;

	/**
	 * 添加一位用户
	 * 
	 * @param vo
	 *            UserVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addUser(UserVO vo) throws RemoteException;

	/**
	 * 删除一位用户
	 * 
	 * @param vo
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteUser(UserVO vo) throws RemoteException;

	/**
	 * 更新一位用户信息
	 * 
	 * @param vo
	 *            UserVo
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateUser(UserVO vo) throws RemoteException;

	/**
	 * 验证用户登录
	 * 
	 * @param loginInfo
	 * @return 返回登录的用户身份，登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException;

	public ResultMessage updateAdmin(String oldPassword, String newPassword) throws RemoteException;

	public ArrayList<UserVO> showUser(UserIdentity userIdentity) throws RemoteException;
	/**
	 * 获得account可用的userID列表
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getUserIDCanBeUsedByAccounts() throws RemoteException;
	/**
	 * 是否可以进行撤销操作
	 * 
	 * @return boolean型，返回true，表示可以进行撤销操作，此时撤销按钮应设为可以按下
	 *         返回false，表示不可以进行撤销操作，此时撤销按钮应设为不可以按下
	 */
	public boolean canUndo();
	/**
	 * 是否可以进行回撤操作
	 * 
	 * @return boolean型，返回true，表示可以进行回撤操作，此时回撤按钮应设为可以按下
	 *         返回false，表示不可以进行回撤操作，此时回撤按钮应设为不可以按下
	 */
	public boolean canRedo();
	/**
	 * 执行撤销操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage undo() throws RemoteException;
	/**
	 * 执行回撤操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage redo() throws RemoteException;
}
