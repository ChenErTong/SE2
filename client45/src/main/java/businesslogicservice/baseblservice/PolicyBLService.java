package businesslogicservice.baseblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import vo.PolicyVO;

public interface PolicyBLService {
	/**
	 * 显示被查询的成本常量
	 * @param baseType 查看的常量类型：薪水策略、距离、单价
	 * @param accountID 公司员工账户ID[ACCOUNT类]
	 * @return BaseVO vo
	 * @author zsq 
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public String getID();
	/**
	 * 添加一个常量
	 * @param vo BaseVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage addBase(PolicyVO vo);
	/**
	 * 删除一个常量
	 * @param ID
	 * @return 处理信息
	 * @author zsq
	 * @throws RemoteException 
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteBase(String ID);
	/**
	 * 更新一条成本常量信息
	 * @param vo BaseVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage updateBase(PolicyVO vo);
	/**
	 * 返回base城市距离，价格常量
	 * @return
	 * @author Ann
	 */
	public ArrayList<PolicyVO> show();
	/**
	 * 根据ID返回相应城市价格常量
	 * @param id
	 * @return
	 * @author Ann
	 */
	public PolicyVO find(String id);
}
