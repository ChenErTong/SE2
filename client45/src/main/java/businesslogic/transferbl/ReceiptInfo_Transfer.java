package businesslogic.transferbl;

import java.rmi.RemoteException;

import businesslogic.organizationbl.ReceiptInfo_Branch_Transfer;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月5日 上午11:58:34 
*/
public interface ReceiptInfo_Transfer extends ReceiptInfo_Branch_Transfer {
	public String getTransferDeliverID() throws RemoteException;
	public String getTransferArrialID() throws RemoteException;
}
