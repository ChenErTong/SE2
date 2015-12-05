package businesslogic.fundbl;

import java.rmi.RemoteException;

import po.receiptpo.DebitAndPayBillPO;
import state.ResultMessage;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月5日 下午11:09:15 
*/
public interface ReceiptInfo_DebitAndPayBill {
	public ResultMessage add(DebitAndPayBillPO po) throws RemoteException;
}
