package businesslogic.organizationbl.branchbl;

import java.rmi.RemoteException;

import businesslogic.organizationbl.ReceiptInfo_Branch_Transfer;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月5日 下午12:01:26
 */
public interface ReceiptInfo_Branch extends ReceiptInfo_Branch_Transfer {
	/**
	 * 获得营业厅装车单编号
	 * 
	 * @return String型，营业厅装车单编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getBranchTruckID() throws RemoteException;
}
