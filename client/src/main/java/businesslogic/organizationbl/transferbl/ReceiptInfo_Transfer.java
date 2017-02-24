package businesslogic.organizationbl.transferbl;

import java.rmi.RemoteException;

import businesslogic.organizationbl.ReceiptInfo_Branch_Transfer;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月5日 上午11:58:34
 */
public interface ReceiptInfo_Transfer extends ReceiptInfo_Branch_Transfer {
	/**
	 * 获取中转中心转运单编号
	 * 
	 * @return String型，中转中心转运单编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getTransferDeliverID() throws RemoteException;

	/**
	 * 获取中转中心到达单编号
	 * 
	 * @return String型，中转中心到达单编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getTransferArrialID() throws RemoteException;
}
