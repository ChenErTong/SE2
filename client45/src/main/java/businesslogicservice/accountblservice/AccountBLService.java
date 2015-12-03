package businesslogicservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import vo.accountvo.AccountVO;



/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:39:54
 */
public interface AccountBLService {
	/**
	 * 负责实现总经理需要查看公司各类员工的帐户信息所需要的服务
	 
	 */
	/**
	 * 账户查询（账户指的是此家公司各类员工的账户信息）
	 * 账号的属性有：员工编号、职务权限、姓名、出生日期、身份证号、手机号、工资情况、任职时间、每日订单完成数目。
	 * 
	 
	 */
	/**
	 * 显示当前公司的全部员工账户
	 * @return 全部员工账户的ArrayList
	 * @throws RemoteException 
	 */
	public ArrayList<AccountVO> show() ;
	public ArrayList<AccountVO> show(String duty);
	public String getID();
	public ResultMessage addBase(AccountVO vo);
	public ResultMessage deleteBase(String ID);
	public ResultMessage updateBase(AccountVO vo);
	public AccountVO find(String id);
}

