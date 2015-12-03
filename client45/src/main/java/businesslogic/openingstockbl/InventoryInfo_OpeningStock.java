package businesslogic.openingstockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:06
 */
public interface InventoryInfo_OpeningStock {
	public ArrayList<InventoryPO> find() throws RemoteException;
}
