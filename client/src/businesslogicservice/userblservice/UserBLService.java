package businesslogicservice.userblservice;

import java.util.ArrayList;
import dataservice.userdataservice.LoginInfo;
import state.ResultMessage;
import po.UserIdentity;
import vo.UserVO;

/**
 * ʵ���û������������Ҫ�ķ���
 * @author zsq
 * @version Oct 22,2015
 *
 */
public interface UserBLService {
	/**
	 * @return ȫ����ϵͳ�û�
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<UserVO> show();
	/**
	 * ���洴�����û�ʱ�õ�һ���µ��û�ID
	 * @return ���û���ID
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getID();
	/**
	 * ���һλ���û�
	 * @param vo UserVO
	 * @return ������Ϣ
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addUser(UserVO vo);
	/**
	 * ɾ��һλ�û�
	 * @param username
	 * @return ������Ϣ
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteUser(String username);
	/**
	 * ����һλ�û�����Ϣ
	 * @param vo UserVo
	 * @return ������
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateUser(UserVO vo);
	/**
	 * ��֤�û���¼ϵͳ
	 * @param loginInfo
	 * @return ���ص�¼�û�����ݣ���¼ʧ���򷵻�NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo);
}
