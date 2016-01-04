package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:04
 */
public interface InventoryInfo_Branch_Transfer {
	/**
	 * 根据中转中心编号获取该中转中心的仓库
	 * 
	 * @param transferID
	 *            String型，中转中心编号
	 * @return ArrayList<InventoryVO>型，仓库列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException;
}
