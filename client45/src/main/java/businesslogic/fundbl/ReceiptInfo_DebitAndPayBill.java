package businesslogic.fundbl;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月5日 下午11:09:15
 */
public interface ReceiptInfo_DebitAndPayBill {
	/**
	 * 添加入款单或收款单
	 * 
	 * @param vo
	 *            ReceiptVO型，入款单或收款单
	 * @return ResultMessage型，添加结果
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage add(ReceiptVO vo) throws RemoteException;

	/**
	 * 修改入款单或收款单
	 * 
	 * @param vo
	 *            ReceiptVO型，入款单或收款单
	 * @return ResultMessage型，修改结果
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage modify(ReceiptVO vo) throws RemoteException;
}
