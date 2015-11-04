package businesslogicservice.accountblservice;

import java.util.ArrayList;

import vo.accountvo.AccountVO;




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
	 */
	public ArrayList<AccountVO> show();
	/**
	 * 进行一条信息的查看
	 */
	
}

