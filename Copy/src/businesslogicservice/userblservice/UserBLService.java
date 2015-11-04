package businesslogicservice.userblservice;

import java.util.ArrayList;

import businesslogicservice.BLService;
import dataservice.userdataservice.LoginInfo;
import state.ResultMessage;
import state.UserIdentity;
import vo.UserVO;

/**
 * 负责实现用户管理界面所需要的服务
 * @author zsq
 * @version Oct 22,2015
 */
public interface UserBLService extends BLService{
	/**
	 * @return 全部的系统用户
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<UserVO> show();
	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * @return 
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getID();
	/**
	 * 添加一位用户
	 * @param vo UserVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addUser(UserVO vo);
	/**
	 * 删除一位用户
	 * @param username
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteUser(String username);
	/**
	 * 更新一位用户信息
	 * @param vo UserVo
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateUser(UserVO vo);
	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 返回登录的用户身份，登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo);
}
