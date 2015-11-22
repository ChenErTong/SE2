package businesslogicservice.fundblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ExpenseVO;
import state.ResultMessage;

import businesslogicservice.BLService;

public interface ExpenseBLService extends BLService{
	/**
	 * 提出创建/新增收款记录时返回该条记录的ID
	 * @return ID
	 * @author zsq
	 * @version Oct 23,2015
	 * @throws RemoteException 
	 */
	public String getID() throws RemoteException;
	/**
	 * 显示要全部收款记录
	 * @return 全部收款记录的ArrayList
	 * @throws RemoteException 
	 */
	public ArrayList<ExpenseVO> show() throws RemoteException;
	/**
	 * 添加收款记录
	 * @param vo ExpenseVO
	 * @return  处理结果
	 */
	public ResultMessage add(ExpenseVO vo);
	/**
	 * 根据收款记录的ID删除收款记录
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);
	/**
	 * 更新账户信息
	 * @param vo ExpenseVO
	 * @return 处理信息
	 */
	public ResultMessage update(ExpenseVO vo);
}
