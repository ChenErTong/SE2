package businesslogic;

import java.rmi.RemoteException;

import po.PersistentObject;
import state.ResultMessage;

public interface CommonBusinessLogic<PO extends PersistentObject> {
	/**
	 * 添加命令
	 * @param po 持久化数据
	 * @return 添加结果
	 * @throws RemoteException 网络异常
	 */
	public ResultMessage add(PO po) throws RemoteException;
	/**
	 * 删除命令
	 * @param ID 要删除的持久化数据ID
	 * @return 被删除的持久化数据
	 * @throws RemoteException 网络异常
	 */
	public PO delete(String ID) throws RemoteException;
	/**
	 * 修改命令
	 * @param po 要修改的持久化数据
	 * @return 修改前的持久化数据
	 * @throws RemoteException 网络异常
	 */
	public PO modify(PO po) throws RemoteException;
}
