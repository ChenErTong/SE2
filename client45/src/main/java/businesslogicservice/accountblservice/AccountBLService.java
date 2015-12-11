package businesslogicservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import vo.accountvo.AccountVO;

/**
 * 公司员工的逻辑操作
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:39:54
 */
public interface AccountBLService {
	/**
	 * 显示当前公司的全部员工账户
	 * 
	 * @return 全部员工账户的ArrayList
	 */
	public ArrayList<AccountVO> show() throws RemoteException;

	/**
	 * 显示当前公司的给定职务的全部员工账户
	 * 
	 * @param duty
	 *            String型，给定的职务
	 * @return ArrayList<AccountVO>型，给定职务的全部员工列表
	 */
	public ArrayList<AccountVO> show(String duty) throws RemoteException;

	/**
	 * 获取新增员工的ID编号
	 * 
	 * @return 新编号
	 */
	public String getID() throws RemoteException;

	/**
	 * 添加新员工
	 * 
	 * @param vo
	 *            新员工信息
	 * @return 是否添加成功
	 */
	public ResultMessage addAccount(AccountVO vo) throws RemoteException;

	/**
	 * 删除员工
	 * 
	 * @param ID
	 *            要删除的员工编号
	 * @return 是否删除成功
	 */
	public ResultMessage deleteAccount(String ID) throws RemoteException;

	/**
	 * 修改员工信息
	 * 
	 * @param vo
	 *            员工新信息
	 * @return 是否修改成功
	 */
	public ResultMessage updateAccount(AccountVO vo) throws RemoteException;

	/**
	 * 根据编号查找一给定员工
	 * 
	 * @param id
	 *            员工编号
	 * @return AccountVO型，查找到的员工信息
	 */
	public AccountVO find(String id) throws RemoteException;
	
	public boolean canUndo();
	public boolean canRedo();
	public ResultMessage undo() throws RemoteException;
	public ResultMessage redo() throws RemoteException;
}
