package businesslogic.fundbl;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月5日 下午11:09:15 
*/
public interface ReceiptInfo_DebitAndPayBill {
	public ResultMessage add(ReceiptVO vo) throws RemoteException;
	public ResultMessage modify(ReceiptVO vo) throws RemoteException;
}
