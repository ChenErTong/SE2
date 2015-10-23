package businesslogicservice.userblservice;

import java.util.ArrayList;
import dataservice.userdataservice.LoginInfo;
import state.ResultMessage;
import po.UserIdentity;
import vo.UserVO;

/**
 * 实现用户管理界面所需要的服务
 * @author zsq
 * @version Oct 22,2015
 *
 */
public interface UserBLService {
	/**
	 * @return 全部的系统用户
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<UserVO> show();
	/**
	 * 界面创建新用户时得到一个新的用户ID
	 * @return 新用户的ID
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getID();
	/**
	 * 添加一位新用户
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
	 * 更新一位用户的信息
	 * @param vo UserVo
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateUser(UserVO vo);
	/**
	 * 验证用户登录系统
	 * @param loginInfo
	 * @return 返回登录用户的身份，登录失败则返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo);
}
