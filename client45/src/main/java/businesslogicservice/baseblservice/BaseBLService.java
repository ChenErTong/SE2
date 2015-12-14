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
	 * 获得新常量编号
	 * @author Ann
	 * @return String型，新常量编号
	 * @throws RemoteException 远程异常
	 */
	public String getID() throws RemoteException;
	/**
	 * 添加一个常量
	 * @param vo BaseVO型，新增常量
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage addBase(BaseVO vo) throws RemoteException;
	/**
	 * 删除一个常量
	 * @param ID String型，常量编号
	 * @return 处理信息
	 * @author zsq
	 * @throws RemoteException 远程异常
	 * @version Oct 22,2015
	 */
	public ResultMessage deleteBase(String ID) throws RemoteException;
	/**
	 * 更新一条成本常量信息
	 * @param vo BaseVO型，成本常量信息
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage updateBase(BaseVO vo) throws RemoteException;
	/**
	 * 返回base城市距离，价格常量
	 * @return ArrayList<BaseVO>型，价格常量列表
	 * @author Ann
	 */
	public ArrayList<BaseVO> show() throws RemoteException;
	/**
	 * 根据ID返回相应城市价格常量
	 * @param id String型，常量编号
	 * @return BaseVO型，编号为id的常量信息
	 * @author Ann
	 */
	public BaseVO find(String id) throws RemoteException;

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
