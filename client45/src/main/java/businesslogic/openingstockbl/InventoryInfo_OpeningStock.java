package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;

public interface InventoryInfo_OpeningStock {
	public ArrayList<InventoryPO> find() throws RemoteException;
}
