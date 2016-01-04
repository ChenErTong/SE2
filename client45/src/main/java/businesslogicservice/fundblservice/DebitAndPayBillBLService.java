package businesslogicservice.fundblservice;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

/**
 * 负责实现资金管理界面所需要的服务
 * @author Ann
 * @author zsq
 * @version Oct 22,2015
 */
public interface DebitAndPayBillBLService {
	/**
	 * 得到付款单的ID
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public String getPayID() throws RemoteException;

	/**
	 * 得到收款单的ID
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public String getExpenseID() throws RemoteException;

	/**
	 * 根据ID精确查找账单
	 * 
	 * @param ID
	 *            账单ID
	 * @return DebitAndPayBillVO
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public DebitAndPayBillVO find(String ID) throws RemoteException;

	/**
	 * 建立新的收款单（付款单），单据类型在前面的getID方法已经得到
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */

	// 建立收款单
	public ResultMessage addDebitBill(DebitBillVO vo) throws RemoteException;
	
	// 建立付款单
	public ResultMessage addPayBill(PaymentBillVO vo) throws RemoteException;

//	/**
//	 * 提交单据进行审批
//	 * 
//	 * @return 是否成功
//	 * @throws RemoteException
//	 */
//	public ResultMessage submit(DebitAndPayBillVO vo) throws RemoteException;
//
//	/**
//	 * 保存成草稿状态
//	 * 
//	 * @return 处理结果
//	 * @author zsq
//	 * @version Oct 22,2015
//	 * @throws RemoteException
//	 */
//	public ResultMessage save(DebitAndPayBillVO vo) throws RemoteException;

	/**
	 * 修改草稿状态
	 * 
	 * @param vo
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ResultMessage updateDraft(DebitAndPayBillVO vo) throws RemoteException;
	
//	public ResultMessage delete(String ID);


}
