package businesslogicservice.baseblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import vo.PolicyVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:40:26
 */
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
	public String getID() throws RemoteException;
	/**
	 * 添加一个常量
	 * @param vo BaseVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage addPolicy(PolicyVO vo) throws RemoteException;
	/**
	 * 删除一个常量
	 * @param ID
	 * @return 处理信息
	 * @author zsq
	 * @throws RemoteException 
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deletePolicy(String ID) throws RemoteException;
	/**
	 * 更新一条成本常量信息
	 * @param vo BaseVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage updatePolicy(PolicyVO vo) throws RemoteException;
	/**
	 * 返回base城市距离，价格常量
	 * @return
	 * @author Ann
	 */
	public ArrayList<PolicyVO> show() throws RemoteException;
	/**
	 * 根据ID返回相应城市价格常量
	 * @param id
	 * @return
	 * @author Ann
	 */
	public PolicyVO find(String id) throws RemoteException;
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
