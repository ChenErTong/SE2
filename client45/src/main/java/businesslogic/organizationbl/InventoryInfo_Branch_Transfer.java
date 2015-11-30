package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryVO;

public interface InventoryInfo_Branch_Transfer {
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) throws RemoteException;
}
