package businesslogic.organizationbl.transferbl;

import java.rmi.RemoteException;

import businesslogic.organizationbl.InventoryInfo_Branch_Transfer;
import vo.InventoryVO;

/**
 * 程序的简单说明
 * 
 * @author Ann
 * @version 创建时间：2015年12月5日 下午7:36:59
 */
public interface InventoryInfo_Transfer extends InventoryInfo_Branch_Transfer {
	/**
	 * 根据中转中心中心编号获取该中转中心初始仓库
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return InventoryVO型，默认仓库
	 * @throws RemoteException
	 *             远程异常
	 */
	public InventoryVO getTransferInitialInventory(String transferID) throws RemoteException;
}
