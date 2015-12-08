package businesslogic.inventorybl;

import java.rmi.RemoteException;

import po.TransferPO;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月5日 下午3:50:38
 */
public interface TransferInfo_Inventory {
	/**
	 * 根据中转中心编号获得中转中心持久化对象
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return TransferPO型，中转中心持久化对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public TransferPO getTransfer(String transferID) throws RemoteException;
}
