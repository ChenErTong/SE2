package businesslogicservice.fundblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ReceiptState;
import state.ReceiptType;
import vo.receiptvo.DebitAndPayBillVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:42:34
 */
public interface DebitAndPayBillShowService {
	/**
	 * 返回给界面层显示全部的付款／收款单
	 * 
	 * @return 全部的付款／收款单的ArrayList
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ArrayList<DebitAndPayBillVO> showPay() throws RemoteException;

	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException;

	/**
	 * 返回给界面层显示全部在审核的付款／收款单
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException;

	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException;

	/**
	 * 返回给界面层显示全部通过审核的付款／收款单
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException;

	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException;

	/**
	 * 返回给界面层显示全部没有通过审批的付款／收款单
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException;

	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException;

	/**
	 * 返回给界面层显示全部草稿状态的付款／收款单
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException;

	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException;
	
	public ArrayList<DebitAndPayBillVO> showList(String end) throws RemoteException;
	/**
	 * 根据类型
	 * 返回付款单列表或收款单列表（不能全部返回）
	 * 要是要全部的就调用两次
	 * type不能为null
	 * @param type
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public <T extends DebitAndPayBillVO> ArrayList<T> show(ReceiptType type,ReceiptState state) throws RemoteException;
}
