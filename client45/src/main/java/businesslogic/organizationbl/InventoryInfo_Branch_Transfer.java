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
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException;
}
