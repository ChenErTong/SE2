package businesslogicservice.baseblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.BLService;
import state.ResultMessage;
import vo.BaseVO;
/**
 * 负责实现公司基础运营常量管理界面提供的服务
 * @author zsq
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:40:04
 */
public interface BaseBLService extends BLService{
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
	public ResultMessage addBase(BaseVO vo) throws RemoteException;
	/**
	 * 删除一个常量
	 * @param ID
	 * @return 处理信息
	 * @author zsq
	 * @throws RemoteException 
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteBase(String ID) throws RemoteException;
	/**
	 * 更新一条成本常量信息
	 * @param vo BaseVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage updateBase(BaseVO vo) throws RemoteException;
	/**
	 * 返回base城市距离，价格常量
	 * @return
	 * @author Ann
	 */
	public ArrayList<BaseVO> show() throws RemoteException;
	/**
	 * 根据ID返回相应城市价格常量
	 * @param id
	 * @return
	 * @author Ann
	 */
	public BaseVO find(String id) throws RemoteException;
	public boolean canUndo();
	public boolean canRedo();
	public ResultMessage undo() throws RemoteException;
	public ResultMessage redo() throws RemoteException;
}
